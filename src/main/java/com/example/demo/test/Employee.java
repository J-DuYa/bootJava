package com.example.demo.test;

public class Employee extends AbstractResult {

    private double salary;

    public Employee(String name, String address, int number) {
        super(name, address, number);
    }

    public void mailCheck() {
        System.out.println("Mail check Employee");
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double newSalary) {
        salary = newSalary;
    }

    public double computePay() {
        System.out.println("Computing salary pay for " + getName());
        return salary / 52;
    }
}
