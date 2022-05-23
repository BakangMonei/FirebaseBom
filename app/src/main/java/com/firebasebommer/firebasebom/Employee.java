package com.firebasebommer.firebasebom;

public class Employee {
    // Attributes
    private String name, position;

    // Empty constructor
    public Employee(){

    }

    // Constructor
    public Employee(String name, String position) {
        this.name = name;
        this.position = position;
    }

    // Getters

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    // Setters

    public void setName(String name) {
        this.name = name;
    }
    public void setPosition(String position) {
        this.position = position;
    }
}
