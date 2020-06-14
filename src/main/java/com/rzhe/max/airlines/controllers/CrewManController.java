package com.rzhe.max.airlines.controllers;

import com.rzhe.max.airlines.entities.CrewMan;
import com.rzhe.max.airlines.entities.Profession;
import com.rzhe.max.airlines.service.CrewManService;
import com.rzhe.max.airlines.service.ProfessionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/crewman")
public class CrewManController {
    private static Logger logger = LoggerFactory.getLogger(AirportController.class);

    private CrewManService crewManService;
    private ProfessionService professionService;

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
        List<Profession> professions = professionService.findAll();
        model.addAttribute("professions", professions);
        return "crewman/edit";
    }

    @GetMapping("/updateForm/{id}")
    public String updateForm(@PathVariable("id") Long id, Model model) {
        CrewMan crewman = crewManService.findById(id);
        model.addAttribute("crewman", crewman);
        List<Profession> professions = professionService.findAll();
        model.addAttribute("professions", professions);
        return "crewman/edit";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("crewman") CrewMan crewMan) {
        logger.info("-----Saving of crewman-----");
        crewManService.save(crewMan);
        logger.info("Saved crewman: " + crewMan.toString());
        return "redirect:list";
    }

    @Autowired
    public void setCrewManService(CrewManService crewManService) {
        this.crewManService = crewManService;
    }

    @Autowired
    public void setProfessionService(ProfessionService professionService) {
        this.professionService = professionService;
    }
}
