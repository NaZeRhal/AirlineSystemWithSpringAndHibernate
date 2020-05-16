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
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/airports")
public class AirportController {
    private static Logger logger = LoggerFactory.getLogger(AirportController.class);

    private AirportService airportService;
    private MessageSource messageSource;


    @GetMapping("/list")
    public String list(Model uiModel) {
        logger.info("-----Listing airports");
        List<Airport> airports = airportService.findAll();
        uiModel.addAttribute("airports", airports);
        logger.info("No. of airports: " + airports.size());
        return "airports/list";
    }

    @Autowired
    public void setAirportService(AirportService airportService) {
        this.airportService = airportService;
    }
}
