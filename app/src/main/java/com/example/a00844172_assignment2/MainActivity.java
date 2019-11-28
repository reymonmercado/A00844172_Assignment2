package com.example.a00844172_assignment2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final int ADD_CUST_SCHED_REQUEST = 1;
    public static final int EDIT_CUST_SCHED_REQUEST = 2;

    private ViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton buttonAddCustSched = findViewById(R.id.button_add);
        buttonAddCustSched.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddEditCustSchedActivity.class);
                startActivityForResult(intent, ADD_CUST_SCHED_REQUEST);
            }
        });

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        final Adapter adapter = new Adapter();
        recyclerView.setAdapter(adapter);

        viewModel = ViewModelProviders.of(this).get(ViewModel.class);
        viewModel.getAllCustSched().observe(this, new Observer<List<CustSched>>() {
            @Override
            public void onChanged(@Nullable List<CustSched> custScheds) {
                // update RecyclerView
                adapter.setCustScheds(custScheds);
            }
        });

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

                viewModel.delete(adapter.getCustSchedAt(viewHolder.getAdapterPosition()));
                Toast.makeText(MainActivity.this,"Customer schedule deleted", Toast.LENGTH_SHORT).show();

            }
        }).attachToRecyclerView(recyclerView);

        adapter.setOnItemClickListener(new Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(CustSched custSched) {
                Intent intent = new Intent(MainActivity.this, AddEditCustSchedActivity.class);
                intent.putExtra(AddEditCustSchedActivity.EXTRA_ID, custSched.getCustSchedID());
                intent.putExtra(AddEditCustSchedActivity.EXTRA_NAME, custSched.getCustomerNameCS());
                intent.putExtra(AddEditCustSchedActivity.EXTRA_STREET, custSched.getCustomerStreetCS());
                intent.putExtra(AddEditCustSchedActivity.EXTRA_CITY, custSched.getCustomerCityCS());
                intent.putExtra(AddEditCustSchedActivity.EXTRA_BDAY, custSched.getCustomerBdayCS());
                intent.putExtra(AddEditCustSchedActivity.EXTRA_GENDER, custSched.getCustomerGenderCS());
                intent.putExtra(AddEditCustSchedActivity.EXTRA_SERVICE_TYPE, custSched.getServiceTypeNameCS());
                intent.putExtra(AddEditCustSchedActivity.EXTRA_START_DATE_TIME, custSched.getStartDateTimeCS());
                intent.putExtra(AddEditCustSchedActivity.EXTRA_DURATION, custSched.getActualDurationCS());
                intent.putExtra(AddEditCustSchedActivity.EXTRA_STATUS, custSched.getStatusCS());

                startActivityForResult(intent, EDIT_CUST_SCHED_REQUEST);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == ADD_CUST_SCHED_REQUEST && resultCode == RESULT_OK) {
            String name = data.getStringExtra(AddEditCustSchedActivity.EXTRA_NAME);
            String street = data.getStringExtra(AddEditCustSchedActivity.EXTRA_STREET);
            String city = data.getStringExtra(AddEditCustSchedActivity.EXTRA_CITY);
            String bday = data.getStringExtra(AddEditCustSchedActivity.EXTRA_BDAY);
            String gender = data.getStringExtra(AddEditCustSchedActivity.EXTRA_GENDER);
            String serviceType = data.getStringExtra(AddEditCustSchedActivity.EXTRA_SERVICE_TYPE);
            String startDateTime = data.getStringExtra(AddEditCustSchedActivity.EXTRA_START_DATE_TIME);
            String duration = data.getStringExtra(AddEditCustSchedActivity.EXTRA_DURATION);
            String status = data.getStringExtra(AddEditCustSchedActivity.EXTRA_STATUS);

            CustSched custSched = new CustSched(name, street, city, bday, gender, serviceType, startDateTime, duration, status);
            viewModel.insert(custSched);

            Toast.makeText(this,"Customer schedule saved", Toast.LENGTH_SHORT).show();

        } else if(requestCode == EDIT_CUST_SCHED_REQUEST && resultCode == RESULT_OK) {

            int id = data.getIntExtra(AddEditCustSchedActivity.EXTRA_ID, -1);

            if (id == -1){
                Toast.makeText(this,"Customer schedule can't be updated", Toast.LENGTH_SHORT).show();
                return;
            }

            String name = data.getStringExtra(AddEditCustSchedActivity.EXTRA_NAME);
            String street = data.getStringExtra(AddEditCustSchedActivity.EXTRA_STREET);
            String city = data.getStringExtra(AddEditCustSchedActivity.EXTRA_CITY);
            String bday = data.getStringExtra(AddEditCustSchedActivity.EXTRA_BDAY);
            String gender = data.getStringExtra(AddEditCustSchedActivity.EXTRA_GENDER);
            String serviceType = data.getStringExtra(AddEditCustSchedActivity.EXTRA_SERVICE_TYPE);
            String startDateTime = data.getStringExtra(AddEditCustSchedActivity.EXTRA_START_DATE_TIME);
            String duration = data.getStringExtra(AddEditCustSchedActivity.EXTRA_DURATION);
            String status = data.getStringExtra(AddEditCustSchedActivity.EXTRA_STATUS);

            CustSched custSched = new CustSched(name, street, city, bday, gender, serviceType, startDateTime, duration, status);
            custSched.setCustSchedID(id);
            viewModel.update(custSched);
            Toast.makeText(this,"Customer schedule updated", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Customer schedule not saved", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.delete_all_cust_sched:
                viewModel.deleteAllNotes();
                Toast.makeText(this, "All customer schedules deleted", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.get_data:
                viewModel.populateDBAsyncTask();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
