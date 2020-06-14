package com.rzhe.max.airlines.controllers;

import com.rzhe.max.airlines.entities.Airport;
import com.rzhe.max.airlines.service.AirportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/airports")
public class AirportController {
    private static Logger logger = LoggerFactory.getLogger(AirportController.class);

    private AirportService airportService;
//    private MessageSource messageSource;


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
    public String save(@ModelAttribute("airport") Airport airport) {
        logger.info("-----Saving of airport-----");
        airportService.save(airport);
        logger.info("Saved airport: " + airport.toString());
        return "redirect:list";
    }

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
}
