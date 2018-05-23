/**
 * Copyright 2018 Orenes Grupo.
 */

package com.natslash.entities;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
/**
 * 
 */
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 * @author Shashidhar Subrmanyam
 *
 */
@Entity
@Table(
    name = "users")
public class User {
  @Id
  @GeneratedValue(
      strategy = GenerationType.AUTO)
  private Integer id;
  @Column(
      nullable = false)
  @NotEmpty()
  private String name;
  @Column(
      nullable = false,
      unique = true)
  @NotEmpty
  @Email(
      message = "{errors.invalid_email}")
  private String email;
  @Column(
      nullable = false)
  @NotEmpty
  @Size(
      min = 4)
  private String password;
  private String passwordResetToken;

  @ManyToMany(
      cascade = CascadeType.MERGE)
  @JoinTable(
      name = "user_role",
      joinColumns = {@JoinColumn(
          name = "USER_ID",
          referencedColumnName = "ID")},
      inverseJoinColumns = {@JoinColumn(
          name = "ROLE_ID",
          referencedColumnName = "ID")})
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

  public String getEmail() {
    return email;
  }

  public void setEmail(final String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(final String password) {
    this.password = password;
  }

  public List<Role> getRoles() {
    return roles;
  }

  public void setRoles(final List<Role> roles) {
    this.roles = roles;
  }

  public String getPasswordResetToken() {
    return passwordResetToken;
  }

  public void setPasswordResetToken(final String passwordResetToken) {
    this.passwordResetToken = passwordResetToken;
  }
}

