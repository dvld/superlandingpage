package com.nikommerce.superaffiliatesystem.controllers;

import javax.validation.Valid;

import com.nikommerce.superaffiliatesystem.models.Lead;
import com.nikommerce.superaffiliatesystem.services.LeadService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

  @Autowired
  private LeadService leadService;

  @GetMapping("/")
  public String squeezePage(Lead lead) {
    return "index";
  }

  @PostMapping("/thankyou")
  public String thankYouPage(@Valid Lead lead, BindingResult result, Model model) {
    Lead leadExists = leadService.findByEmail(lead.getEmail());

    if (leadExists != null) {
      result.rejectValue("email", "error.lead", "email already exists");
    }

    if (result.hasErrors()) {
      return "index";
    }

    if (!result.hasErrors()) {
      leadService.save(lead);
      model.addAttribute("email", lead.getEmail());
    }

    String affUrl = "https://86a7f7q4zlu9vbmd3mc99qfk47.hop.clickbank.net/?cbpage=sp&tid=NIKOMMERCE";
    return "redirect:" + affUrl;

  }

}