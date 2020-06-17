package com.rzhe.max.airlines.controllers;

import com.rzhe.max.airlines.entities.Airport;
import com.rzhe.max.airlines.service.AirportService;
import com.rzhe.max.airlines.utils.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/airports")
public class AirportController {
    private static Logger logger = LoggerFactory.getLogger(AirportController.class);

    private AirportService airportService;
    private MessageSource messageSource;


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
                    messageSource.getMessage("airport.save.fail", new Object[]{}, locale)));
            model.addAttribute("airport", airport);
            logger.info("Validation failed for: " + airport.toString());
            return "airports/edit";
        }
        model.asMap().clear();
        redirectAttributes.addFlashAttribute("message", new Message("success",
                messageSource.getMessage("airport.save.success", new Object[]{}, locale)));
        airportService.save(airport);
        logger.info("Saved airport: " + airport.toString());
        return "redirect:list";
    }

//    @PostMapping("/update")
//    public String update(@Valid @ModelAttribute("airport") Airport airport, BindingResult bindingResult,
//                         Model model, Locale locale, RedirectAttributes redirectAttributes) {
//        logger.info("-----Updating of airport-----");
//        if (bindingResult.hasErrors()) {
//            model.addAttribute("message", new Message("error",
//                    messageSource.getMessage("airport.save.fail", new Object[]{}, locale)));
//            model.addAttribute("airport", airport);
//            return "airports/edit";
//        }
//        model.asMap().clear();
//        redirectAttributes.addFlashAttribute("message", new Message("success",
//                messageSource.getMessage("airport.save.success", new Object[]{}, locale)));
//        airportService.save(airport);
//        logger.info("Saved airport: " + airport.toString());
//        return "redirect:list";
//    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        logger.info("-----Deleting airport-----");
        Airport airport = airportService.findById(id);
        airportService.delete(airport);
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
