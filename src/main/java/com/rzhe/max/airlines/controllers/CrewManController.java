package com.rzhe.max.airlines.controllers;

import com.rzhe.max.airlines.entities.CrewMan;
import com.rzhe.max.airlines.entities.Profession;
import com.rzhe.max.airlines.service.CrewManService;
import com.rzhe.max.airlines.service.ProfessionService;
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
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/crewman")
public class CrewManController {
    private static Logger logger = LoggerFactory.getLogger(AirportController.class);

    private CrewManService crewManService;
    private ProfessionService professionService;
    private MessageSource messageSource;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        binder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

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
        return "crewman/edit";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("crewman") CrewMan crewMan, BindingResult bindingResult,
                       Model model, Locale locale, RedirectAttributes redirectAttributes) {
        logger.info("-----Saving of crewman-----");
        if (bindingResult.hasErrors()) {
            model.addAttribute("message", new Message("error",
                    messageSource.getMessage("crewman.save.fail",
                    new Object[]{}, locale)));
            model.addAttribute("crewman", crewMan);
            return "crewman/edit";
        }
        model.asMap().clear();
        redirectAttributes.addFlashAttribute("message", new Message("success",
                messageSource.getMessage("crewman.save.success",
                new Object[]{crewMan.getFirstName(), crewMan.getLastName()},
                locale)));
        crewManService.save(crewMan);
        logger.info("Saved crewman: " + crewMan.toString());
        return "redirect:list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id, Model model,
                         RedirectAttributes redirectAttributes, Locale locale) {
        logger.info("-----Deleting crewman-----");
        CrewMan crewMan = crewManService.findById(id);
        crewManService.delete(crewMan);
        model.asMap().clear();
        redirectAttributes.addFlashAttribute("message", new Message("success",
                messageSource.getMessage("crewman.delete.success",
                new Object[]{crewMan.getFirstName(), crewMan.getLastName()},
                locale)));
        logger.info("Deleted crewman: " + crewMan.toString());
        return "redirect:/crewman/list";
    }

    @ModelAttribute
    public void addAttributes(Model model) {
        List<Profession> professions = professionService.findAll();
        model.addAttribute("professions", professions);
    }

    @Autowired
    public void setCrewManService(CrewManService crewManService) {
        this.crewManService = crewManService;
    }

    @Autowired
    public void setProfessionService(ProfessionService professionService) {
        this.professionService = professionService;
    }

    @Autowired
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

}
