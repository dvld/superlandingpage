package com.nikommerce.superaffiliatesystem.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Lead {

  // Properties //
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Email(message = "Please provide a valid email")
  @NotEmpty(message = "Please enter an email")
  private String email;

  // getters //

  public Long getId() {
    return id;
  }

  public String getEmail() {
    return email;
  }

  // setters //

  public void setEmail(String email) {
    this.email = email;
  }

}