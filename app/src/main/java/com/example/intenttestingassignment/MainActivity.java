package com.example.intenttestingassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView cityList;
    EditText newName;
    LinearLayout nameField;
    ArrayAdapter<String> cityAdapter;
    ArrayList<String> dataList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameField = findViewById(R.id.field_nameEntry);
        newName  = findViewById(R.id.editText_name);

        cityList = findViewById(R.id.city_list);



        dataList = new ArrayList<>();



        cityAdapter = new ArrayAdapter<>(this, R.layout.content, dataList);


        cityList.setAdapter(cityAdapter);
        cityList.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3)
            {

                Intent send = new Intent(MainActivity.this, ShowActivity.class);
                String val =  cityList.getItemAtPosition(0).toString();
                send.putExtra("value", val);
                MainActivity.this.startActivity(send);
            }
        });

        final Button addButton = findViewById(R.id.button_add);
        addButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                nameField.setVisibility(View.VISIBLE);
            }
        });


        final Button confirmButton = findViewById(R.id.button_confirm);
        confirmButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String cityName = newName.getText().toString();
                cityAdapter.add(cityName);
                newName.getText().clear();
                nameField.setVisibility(View.INVISIBLE);
            }
        });

        final Button deleteButton = findViewById(R.id.button_clear);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                cityAdapter.clear();
            }
        });
    }
}