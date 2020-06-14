package com.rzhe.max.airlines.controllers;

import com.rzhe.max.airlines.entities.CrewMan;
import com.rzhe.max.airlines.service.CrewManService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/crewman")
public class CrewManController {
    private static Logger logger = LoggerFactory.getLogger(AirportController.class);

    private CrewManService crewManService;

    @GetMapping("/list")
    public String list(Model model) {
        logger.info("-----Listing crewmen-----");
        List<CrewMan> crewmanList = crewManService.findAll();
        model.addAttribute("crewmanList", crewmanList);
        logger.info("Amount of crewmen: " + crewmanList.size());
        return "crewman/list";
    }

    @GetMapping("/createForm")
    public String createForm(Model model) {
        model.addAttribute("crewman", new CrewMan());
        return "crewman/edit";
    }

    @GetMapping("/updateForm/{id}")
    public String updateForm(@PathVariable("id") Long id, Model model) {
        CrewMan crewman = crewManService.findById(id);
        model.addAttribute("crewman", crewman);
        return "crewman/edit";
    }



    @Autowired
    public void setCrewManService(CrewManService crewManService) {
        this.crewManService = crewManService;
    }
}
