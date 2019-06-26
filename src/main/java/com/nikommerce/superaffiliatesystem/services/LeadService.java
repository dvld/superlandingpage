package com.nikommerce.superaffiliatesystem.services;

import com.nikommerce.superaffiliatesystem.models.Lead;
import com.nikommerce.superaffiliatesystem.repositories.LeadRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeadService {

  @Autowired
  private LeadRepository leadRepo;

  public void save(Lead lead) {
    leadRepo.save(lead);
  }

  public Lead findByEmail(String email) {
    return leadRepo.findByEmail(email);
  }

}