package com.example.a00844172_assignment2;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "cust_sched")
public class CustSched {

    @PrimaryKey(autoGenerate = true)
    public int custSchedID;

    @ColumnInfo(name = "customerNameCS")
    public String customerNameCS;

    @ColumnInfo(name = "customerStreetCS")
    public String customerStreetCS;

    @ColumnInfo(name = "customerCityCS")
    public String customerCityCS;

    @ColumnInfo(name = "customerBdayCS")
    public String customerBdayCS;

    @ColumnInfo(name = "customerGenderCS")
    public String customerGenderCS;

    @ColumnInfo(name = "serviceTypeNameCS")
    public String serviceTypeNameCS;

    @ColumnInfo(name = "startDateTimeCS")
    public String startDateTimeCS;

    @ColumnInfo(name = "actualDurationCS")
    public String actualDurationCS;

    @ColumnInfo(name = "statusCS")
    public String statusCS;

    public CustSched(String customerNameCS, String customerStreetCS, String customerCityCS, String customerBdayCS, String customerGenderCS, String serviceTypeNameCS, String startDateTimeCS, String actualDurationCS, String statusCS) {
        this.customerNameCS = customerNameCS;
        this.customerStreetCS = customerStreetCS;
        this.customerCityCS = customerCityCS;
        this.customerBdayCS = customerBdayCS;
        this.customerGenderCS = customerGenderCS;
        this.serviceTypeNameCS = serviceTypeNameCS;
        this.startDateTimeCS = startDateTimeCS;
        this.actualDurationCS = actualDurationCS;
        this.statusCS = statusCS;
    }

    public int getCustSchedID() {
        return custSchedID;
    }

    public String getCustomerNameCS() {
        return customerNameCS;
    }

    public String getCustomerStreetCS() {
        return customerStreetCS;
    }

    public String getCustomerCityCS() {
        return customerCityCS;
    }

    public String getCustomerBdayCS() {
        return customerBdayCS;
    }

    public String getCustomerGenderCS() {
        return customerGenderCS;
    }

    public String getServiceTypeNameCS() {
        return serviceTypeNameCS;
    }

    public String getStartDateTimeCS() {
        return startDateTimeCS;
    }

    public String getActualDurationCS() {
        return actualDurationCS;
    }

    public String getStatusCS() {
        return statusCS;
    }

    public void setCustSchedID(int custSchedID) {
        this.custSchedID = custSchedID;
    }



    public void setCustomerNameCS(String customerNameCS) {
        this.customerNameCS = customerNameCS;
    }

    public void setCustomerStreetCS(String customerStreetCS) {
        this.customerStreetCS = customerStreetCS;
    }

    public void setCustomerCityCS(String customerCityCS) {
        this.customerCityCS = customerCityCS;
    }

    public void setCustomerBdayCS(String customerBdayCS) {
        this.customerBdayCS = customerBdayCS;
    }

    public void setCustomerGenderCS(String customerGenderCS) {
        this.customerGenderCS = customerGenderCS;
    }

    public void setServiceTypeNameCS(String serviceTypeNameCS) {
        this.serviceTypeNameCS = serviceTypeNameCS;
    }

    public void setStartDateTimeCS(String startDateTimeCS) {
        this.startDateTimeCS = startDateTimeCS;
    }

    public void setActualDurationCS(String actualDurationCS) {
        this.actualDurationCS = actualDurationCS;
    }

    public void setStatusCS(String statusCS) {
        this.statusCS = statusCS;
    }
}
