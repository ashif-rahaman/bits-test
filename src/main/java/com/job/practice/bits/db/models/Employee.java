package com.job.practice.bits.db.models;

import java.io.Serializable;

/**
 *
 * @author ashif
 */
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;

    private String name;

    private String pin;

    private String fatherName;

    private String motherName;

    private String dob;

    private double salary;

    public Employee() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", pin=" + pin + ", fatherName=" + fatherName + ", motherName=" + motherName + ", dob=" + dob + ", salary=" + salary + '}';
    }
}
