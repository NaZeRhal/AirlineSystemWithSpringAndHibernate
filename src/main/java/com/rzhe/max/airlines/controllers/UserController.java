package com.rzhe.max.airlines.controllers;

import com.rzhe.max.airlines.entities.User;
import com.rzhe.max.airlines.entities.UserType;
import com.rzhe.max.airlines.service.UserService;
import com.rzhe.max.airlines.service.UserTypeService;
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
@RequestMapping("/users")
public class UserController {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    private UserService userService;
    private UserTypeService userTypeService;
    private MessageSource messageSource;


    @GetMapping("/list")
    public String list(Model model) {
        logger.info("-----Listing users-----");
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        logger.info("Amount of users: " + users.size());
        return "user/list";
    }

    @GetMapping("/createForm")
    public String createForm(Model model) {
        model.addAttribute("user", new User());
        return "user/edit";
    }

    @GetMapping("/updateForm/{id}")
    public String createForm(@PathVariable("id") Long id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "user/edit";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model,
                       RedirectAttributes redirectAttributes, Locale locale) {
        logger.info("-----Saving of user-----");
        if (bindingResult.hasErrors()) {
            model.addAttribute("user", user);
            model.addAttribute("message", new Message("error",
                    messageSource.getMessage("user.save.fail", new Object[]{}, locale)));
            return "user/edit";
        }
        model.asMap().clear();
        redirectAttributes.addFlashAttribute("message", new Message("success",
                messageSource.getMessage("user.save.success",
                        new Object[]{user.getFirstName(), user.getLastName()}, locale)));
        userService.save(user);
        logger.info("Saved crewman: " + user.toString());
        return "redirect:list";
    }

    @ModelAttribute
    public void addAttributes(Model model) {
        List<UserType> userTypes = userTypeService.findAll();
        model.addAttribute("userTypes", userTypes);
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setUserTypeService(UserTypeService userTypeService) {
        this.userTypeService = userTypeService;
    }

    @Autowired
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }
}
