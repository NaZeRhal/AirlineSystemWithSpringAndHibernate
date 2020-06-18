package com.rzhe.max.airlines.controllers;

import com.rzhe.max.airlines.entities.Airport;
import com.rzhe.max.airlines.service.AirportService;
import com.rzhe.max.airlines.utils.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.text.MessageFormat;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/airports")
public class AirportController {
    private static Logger logger = LoggerFactory.getLogger(AirportController.class);

    private AirportService airportService;
    private MessageSource messageSource;


    @InitBinder
    public void initBinder(WebDataBinder binder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        binder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/list")
    public String list(Model model) {
        logger.info("-----Listing airports-----");
        List<Airport> airports = airportService.findAll();
        model.addAttribute("airports", airports);
        logger.info("Amount of airports: " + airports.size());
        return "airports/list";
    }

    @GetMapping("/createForm")
    public String createForm(Model model) {
        model.addAttribute("airport", new Airport());
        return "airports/edit";
    }

    @GetMapping("/updateForm/{id}")
    public String updateForm(@PathVariable("id") Long id, Model model) {
        Airport airport = airportService.findById(id);
        model.addAttribute("airport", airport);
        return "airports/edit";
    }

    @PostMapping("/save")
    public String create(@Valid @ModelAttribute("airport") Airport airport, BindingResult bindingResult,
                         Model model, Locale locale, RedirectAttributes redirectAttributes) {
        logger.info("-----Saving of airport-----");
        if (bindingResult.hasErrors()) {
            model.addAttribute("message", new Message("error",
                    messageSource.getMessage("airport.save.fail",
                            new Object[]{airport.getCity(), airport.getAirportCode()}, locale)));
            model.addAttribute("airport", airport);
            logger.info("Binding failed: " + bindingResult);
            return "airports/edit";
        }
        model.asMap().clear();
        redirectAttributes.addFlashAttribute("message", new Message("success",
                messageSource.getMessage("airport.save.success",
                        new Object[]{airport.getCity(), airport.getAirportCode()}, locale)));
        airportService.save(airport);
        logger.info("Saved airport: " + airport.toString());
        return "redirect:list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id, Model model, RedirectAttributes redirectAttributes, Locale locale) {
        logger.info("-----Deleting airport-----");
        Airport airport = airportService.findById(id);
        airportService.delete(airport);
        model.asMap().clear();
        redirectAttributes.addFlashAttribute("message", new Message("success",
                messageSource.getMessage("airport.delete.success",
                        new Object[]{airport.getCity(), airport.getAirportCode()}, locale)));
        logger.info("Deleted airport: " + airport.toString());
        return "redirect:/airports/list";
    }


    @Autowired
    public void setAirportService(AirportService airportService) {
        this.airportService = airportService;
    }

    @Autowired
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }
}
