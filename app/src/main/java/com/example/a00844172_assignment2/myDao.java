package com.example.a00844172_assignment2;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import androidx.room.Update;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

@Dao
public interface myDao {

//    @Insert
//    public void addCustomer(Customer customer);
//
//    @Query("SELECT * FROM customer")
//    public List<Customer> getCustomers();
//
//    @Delete
//    public void deleteCustomer(Customer customer);
//
//    @Update
//    public void updateCustomer(Customer customer);
//
//
//    @Query("SELECT customer_name AS customerNameCS, customer_street AS customerStreetCS, customer_city AS customerCityCS," +
//            "customer_bday AS customerBdayCS, customer_gender AS customerGenderCS, service_type_name AS serviceTypeNameCS," +
//            "start_date_time AS startDateTimeCS, actual_duration AS actualDurationCS, status AS statusCS " +
//            "FROM customer, serviceType, customerService, customerServiceSchedule ")
//    public LiveData<List<CustSched>> loadCustSched();

    @Insert
    void insert(CustSched custSched);

    @Update
    void update(CustSched custSched);

    @Delete
    void delete(CustSched custSched);

    @Query("DELETE FROM cust_sched")
    void deleteAllCustSched();

    @Query("SELECT * FROM cust_sched ORDER BY customerNameCS DESC")
    LiveData<List<CustSched>> getAllCustSched();



}
