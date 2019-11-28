package com.example.a00844172_assignment2;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "serviceType")
public class ServiceType {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "service_type_ID")
    private int serviceTypeID;

    @ColumnInfo(name = "service_type_name")
    private String serviceTypeName;

    @ColumnInfo(name ="service_type_rate")
    private int serviceTypeRate;

    public int getServiceTypeID() {
        return serviceTypeID;
    }

    public String getServiceTypeName() {
        return serviceTypeName;
    }

    public int getServiceTypeRate() {
        return serviceTypeRate;
    }

    public void setServiceTypeID(int serviceTypeID) {
        this.serviceTypeID = serviceTypeID;
    }

    public void setServiceTypeName(String serviceTypeName) {
        this.serviceTypeName = serviceTypeName;
    }

    public void setServiceTypeRate(int serviceTypeRate) {
        this.serviceTypeRate = serviceTypeRate;
    }
}
