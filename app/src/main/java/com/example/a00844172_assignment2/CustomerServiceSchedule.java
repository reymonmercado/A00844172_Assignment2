package com.example.a00844172_assignment2;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "customerServiceSchedule",foreignKeys = {
        @ForeignKey(entity = Customer.class, parentColumns = "customer_ID", childColumns = "CSS_customer_ID"),
        @ForeignKey(entity = Employee.class, parentColumns = "employee_ID", childColumns = "CSS_employee_ID"),
        @ForeignKey(entity = ServiceType.class, parentColumns = "service_type_ID", childColumns = "CSS_service_type_ID")})
public class CustomerServiceSchedule {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "customer_service_schedule_ID")
    private int customerServiceScheduleID;

    @ColumnInfo(name = "CSS_customer_ID")
    private int customerID;

    @ColumnInfo(name = "CSS_service_type_ID")
    private int serviceTypeID;

    @ColumnInfo(name = "CSS_employee_ID")
    private int employeeID;

    @ColumnInfo(name = "start_date_time")
    private int startDateTime;

    @ColumnInfo(name = "actual_duration")
    private int actualDuration;

    @ColumnInfo(name = "status")
    private String status;

    public int getCustomerServiceScheduleID() {
        return customerServiceScheduleID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public int getServiceTypeID() {
        return serviceTypeID;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public int getStartDateTime() {
        return startDateTime;
    }

    public int getActualDuration() {
        return actualDuration;
    }

    public String getStatus() {
        return status;
    }

    public void setCustomerServiceScheduleID(int customerServiceScheduleID) {
        this.customerServiceScheduleID = customerServiceScheduleID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public void setServiceTypeID(int serviceTypeID) {
        this.serviceTypeID = serviceTypeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public void setStartDateTime(int startDateTime) {
        this.startDateTime = startDateTime;
    }

    public void setActualDuration(int actualDuration) {
        this.actualDuration = actualDuration;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
