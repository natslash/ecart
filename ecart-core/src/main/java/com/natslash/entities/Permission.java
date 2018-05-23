/**
 * Copyright 2018 Orenes Grupo.
 */

package com.natslash.entities;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * 
 */

@Entity
@Table(
    name = "permissions")
public class Permission {
  @Id
  @GeneratedValue(
      strategy = GenerationType.AUTO)
  private Integer id;
  @Column(
      nullable = false,
      unique = true)
  private String name;
  @Column(
      length = 1024)
  private String description;
  @ManyToMany(
      mappedBy = "permissions")
  private List<Role> roles;

  public Integer getId() {
    return id;
  }

  public void setId(final Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(final String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(final String description) {
    this.description = description;
  }

  public List<Role> getRoles() {
    return roles;
  }

  public void setRoles(final List<Role> roles) {
    this.roles = roles;
  }


}
