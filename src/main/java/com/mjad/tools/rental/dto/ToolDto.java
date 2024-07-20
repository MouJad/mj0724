package com.mjad.tools.rental.dto;

/**
 * @author MJad
 **/

// No setter methods, only getters. Any setting should be done through the constructor.
public class ToolDto {
  private String code;
  private String type;
  private String brand;

  public ToolDto() {}
  public ToolDto(String code, String type, String brand) {
    this.code = code;
    this.type = type;
    this.brand = brand;
  }
  public String getCode() {
    return code;
  }
  public String getType() {
    return type;
  }
  public String getBrand() {
    return brand;
  }

}
