package com.rzhe.max.airlines.controllers;

import com.rzhe.max.airlines.entities.Airport;
import com.rzhe.max.airlines.service.AirportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/airports")
public class AirportController {
    private static Logger logger = LoggerFactory.getLogger(AirportController.class);

    private AirportService airportService;
    private MessageSource messageSource;


    @GetMapping("/list")
    public ModelAndView list() {
        logger.info("-----Listing airports-----");
        List<Airport> airports = airportService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("airports", airports);
        modelAndView.setViewName("airports/list");
        logger.info("Amount of airports: " + airports.size());
        return modelAndView;
    }

    @GetMapping("/addForm")
    public ModelAndView addForm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("airport", new Airport());
        modelAndView.setViewName("airports/add");
        return modelAndView;
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("airport") Airport airport) {
        logger.info("-----Adding of airport-----");
        airportService.save(airport);
        logger.info("Added airport: " + airport.toString());
        return "redirect:list";
    }


    @Autowired
    public void setAirportService(AirportService airportService) {
        this.airportService = airportService;
    }
}
