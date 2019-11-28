package com.example.a00844172_assignment2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class AddEditCustSchedActivity extends AppCompatActivity {

    public static final String EXTRA_ID = "com.example.a00844172_assignment2.EXTRA_ID";
    public static final String EXTRA_NAME = "com.example.a00844172_assignment2.EXTRA_NAME";
    public static final String EXTRA_STREET = "com.example.a00844172_assignment2.EXTRA_STREET";
    public static final String EXTRA_CITY = "com.example.a00844172_assignment2.EXTRA_CITY";
    public static final String EXTRA_BDAY = "com.example.a00844172_assignment2.EXTRA_BDAY";
    public static final String EXTRA_GENDER = "com.example.a00844172_assignment2.EXTRA_GENDER";
    public static final String EXTRA_SERVICE_TYPE = "com.example.a00844172_assignment2.EXTRA_SERVICE_TYPE";
    public static final String EXTRA_START_DATE_TIME = "com.example.a00844172_assignment2.EXTRA_START_DATE_TIME";
    public static final String EXTRA_DURATION = "com.example.a00844172_assignment2.EXTRA_DURATION";
    public static final String EXTRA_STATUS = "com.example.a00844172_assignment2.EXTRA_STATUS";

    private EditText editTextName;
    private EditText editTextStreet;
    private EditText editTextCity;
    private EditText editTextBday;
    private EditText editTextGender;
    private EditText editTextServiceType;
    private EditText editTextStartDateTime;
    private EditText editTextDuration;
    private EditText editTextStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_cust_sched);

        editTextName = findViewById(R.id.edit_text_name);
        editTextStreet = findViewById(R.id.edit_text_street);
        editTextCity = findViewById(R.id.edit_text_city);
        editTextBday = findViewById(R.id.edit_text_bday);
        editTextGender = findViewById(R.id.edit_text_gender);
        editTextServiceType = findViewById(R.id.edit_text_service_type);
        editTextStartDateTime = findViewById(R.id.edit_text_start_date_time);
        editTextDuration = findViewById(R.id.edit_text_duration);
        editTextStatus = findViewById(R.id.edit_text_status);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);

        Intent intent = getIntent();

        if(intent.hasExtra(EXTRA_ID)) {
            setTitle("Edit Customer Schedule");
            editTextName.setText(intent.getStringExtra(EXTRA_NAME));
            editTextStreet.setText(intent.getStringExtra(EXTRA_STREET));
            editTextCity.setText(intent.getStringExtra(EXTRA_CITY));
            editTextBday.setText(intent.getStringExtra(EXTRA_BDAY));
            editTextGender.setText(intent.getStringExtra(EXTRA_GENDER));
            editTextServiceType.setText(intent.getStringExtra(EXTRA_SERVICE_TYPE));
            editTextStartDateTime.setText(intent.getStringExtra(EXTRA_START_DATE_TIME));
            editTextDuration.setText(intent.getStringExtra(EXTRA_DURATION));
            editTextStatus.setText(intent.getStringExtra(EXTRA_STATUS));
        } else {
            setTitle("Add Customer Schedule");
        }
    }

    private void saveCustSched(){
        String name = editTextName.getText().toString();
        String street = editTextStreet.getText().toString();
        String city = editTextCity.getText().toString();
        String bday = editTextBday.getText().toString();
        String gender = editTextGender.getText().toString();
        String serviceType = editTextServiceType.getText().toString();
        String startDateTime = editTextStartDateTime.getText().toString();
        String duration = editTextDuration.getText().toString();
        String status = editTextStatus.getText().toString();

        if(name.trim().isEmpty() || street.isEmpty() || city.isEmpty() || bday.isEmpty() || gender.isEmpty() ||
        serviceType.isEmpty() || startDateTime.isEmpty() || duration.isEmpty() || status.isEmpty()){
            Toast.makeText(this,"Please insert fields", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent data = new Intent();
        data.putExtra(EXTRA_NAME, name);
        data.putExtra(EXTRA_STREET, street);
        data.putExtra(EXTRA_CITY, city);
        data.putExtra(EXTRA_BDAY, bday);
        data.putExtra(EXTRA_GENDER, gender);
        data.putExtra(EXTRA_SERVICE_TYPE, serviceType);
        data.putExtra(EXTRA_START_DATE_TIME, startDateTime);
        data.putExtra(EXTRA_DURATION, duration);
        data.putExtra(EXTRA_STATUS, status);

        int id = getIntent().getIntExtra(EXTRA_ID, -1);
        if(id != -1){
            data.putExtra(EXTRA_ID, id);
        }

        setResult(RESULT_OK, data);
        finish();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_custsched_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save_custsched:
                saveCustSched();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
