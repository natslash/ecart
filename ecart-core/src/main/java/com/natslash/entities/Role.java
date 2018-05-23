/**
 * Copyright 2018 Orenes Grupo.
 */

package com.natslash.entities;

import org.hibernate.validator.constraints.NotEmpty;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * 
 */

@Entity
@Table(
    name = "roles")
public class Role {
  @Id
  @GeneratedValue(
      strategy = GenerationType.AUTO)
  private Integer id;
  @Column(
      nullable = false,
      unique = true)
  @NotEmpty
  private String name;
  @Column(
      length = 1024)
  private String description;

  @ManyToMany(
      mappedBy = "roles")
  private List<User> users;

  @ManyToMany
  @JoinTable(
      name = "role_permission",
      joinColumns = {@JoinColumn(
          name = "ROLE_ID",
          referencedColumnName = "ID")},
      inverseJoinColumns = {@JoinColumn(
          name = "PERM_ID",
          referencedColumnName = "ID")})
  private List<Permission> permissions;

  // setters & getters
}
