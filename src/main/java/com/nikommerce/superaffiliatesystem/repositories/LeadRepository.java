package com.nikommerce.superaffiliatesystem.repositories;

import com.nikommerce.superaffiliatesystem.models.Lead;

import org.springframework.data.repository.CrudRepository;

public interface LeadRepository extends CrudRepository<Lead, Long> {

  Lead findByEmail(String email);

}