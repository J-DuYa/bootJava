package com.example.demo.test;

public abstract class AbstractResult {
  private String name;
  private String address;
  private int number;

  public AbstractResult(String name, String address, int number) {

  }

  public double computePay() {
    return 0.0;
  }

  public void mailCheck() {
    System.out.println("Mailing a check to " + this.name + " " + this.address);
  }

  public String toString() {
      return name + " " + address + " " + number;
  }

  public String getName() {
      return name;
  }

  public String getAddress() {
      return address;
  }

  public int getNumber() {
      return number;
  }

  public void setAddress(String newAddress) {
    address = newAddress;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setNumber(int number) {
    this.number = number;
  }
}
