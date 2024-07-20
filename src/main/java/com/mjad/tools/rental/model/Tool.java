package com.mjad.tools.rental.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @author MJad
 **/
@Entity
@Table(name="TOOL")
public class Tool {

  @Id
  @GeneratedValue
  private Long id;
  private String code;
  private String type;
  private String brand;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  @Override
  public String toString() {
    return "Id: '" + this.id + "', Code: '" + this.code + "', Type: '" + this.type + "', brand: '" + this.brand;
  }
}
