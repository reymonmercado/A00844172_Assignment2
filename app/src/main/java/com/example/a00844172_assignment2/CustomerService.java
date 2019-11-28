package com.example.a00844172_assignment2;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "customerService", foreignKeys = {
        @ForeignKey(entity = Customer.class, parentColumns = "customer_ID", childColumns = "CS_customer_ID"),
        @ForeignKey(entity = ServiceType.class, parentColumns = "service_type_ID", childColumns = "CS_service_type_ID")})
public class CustomerService {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "customer_service_ID")
    private int customerServiceID;

    @ColumnInfo(name = "CS_customer_ID")
    private int customerID;

    @ColumnInfo(name = "CS_service_type_ID")
    private int serviceTypeID;

    @ColumnInfo(name = "specific_details")
    private String specificDetails;

    @ColumnInfo(name = "expected_duration")
    private int expectedDuration;

    public int getCustomerServiceID() {
        return customerServiceID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public int getServiceTypeID() {
        return serviceTypeID;
    }

    public String getSpecificDetails() {
        return specificDetails;
    }

    public int getExpectedDuration() {
        return expectedDuration;
    }

    public void setCustomerServiceID(int customerServiceID) {
        this.customerServiceID = customerServiceID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public void setServiceTypeID(int serviceTypeID) {
        this.serviceTypeID = serviceTypeID;
    }

    public void setSpecificDetails(String specificDetails) {
        this.specificDetails = specificDetails;
    }

    public void setExpectedDuration(int expectedDuration) {
        this.expectedDuration = expectedDuration;
    }
}
