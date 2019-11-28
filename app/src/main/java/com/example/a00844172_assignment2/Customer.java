package com.example.a00844172_assignment2;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "customer")
public class Customer {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "customer_ID")
    private int customerID;

    @ColumnInfo(name = "customer_name")
    private String customerName;

    @ColumnInfo(name = "customer_street")
    private String customerStreet;

    @ColumnInfo(name = "customer_city")
    private String customerCity;

    @ColumnInfo(name = "customer_bday")
    private String custommerBday;

    @ColumnInfo(name = "customer_gender")
    private String customerGender;

    public int getCustomerID() {
        return customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerStreet() {
        return customerStreet;
    }

    public String getCustomerCity() {
        return customerCity;
    }

    public String getCustommerBday() {
        return custommerBday;
    }

    public String getCustomerGender() {
        return customerGender;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCustomerStreet(String customerStreet) {
        this.customerStreet = customerStreet;
    }

    public void setCustomerCity(String customerCity) {
        this.customerCity = customerCity;
    }

    public void setCustommerBday(String custommerBday) {
        this.custommerBday = custommerBday;
    }

    public void setCustomerGender(String customerGender) {
        this.customerGender = customerGender;
    }
}
