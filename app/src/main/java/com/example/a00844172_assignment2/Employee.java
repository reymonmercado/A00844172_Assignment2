package com.example.a00844172_assignment2;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "employee")
public class Employee {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "employee_ID")
    private int employeeID;

    @ColumnInfo(name = "employee_name")
    private String employeeName;

    @ColumnInfo(name = "employee_street")
    private String employeeStreet;

    @ColumnInfo(name = "employee_city")
    private String employeeCity;

    @ColumnInfo(name = "job_title")
    private String jobTitle;

    @ColumnInfo(name = "salary")
    private int salary;

    @ColumnInfo(name = "manager_ID")
    private int managerID;

    public int getEmployeeID() {
        return employeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getEmployeeStreet() {
        return employeeStreet;
    }

    public String getEmployeeCity() {
        return employeeCity;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public int getSalary() {
        return salary;
    }

    public int getManagerID() {
        return managerID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setEmployeeStreet(String employeeStreet) {
        this.employeeStreet = employeeStreet;
    }

    public void setEmployeeCity(String employeeCity) {
        this.employeeCity = employeeCity;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setManagerID(int managerID) {
        this.managerID = managerID;
    }
}
