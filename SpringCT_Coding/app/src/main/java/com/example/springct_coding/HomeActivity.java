package com.example.springct_coding;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private Button addEmployeeButton;
    private RecyclerView recyclerView;
    private EmployeeAdpater adapter;
    private List<EmployeeAdpater>employeeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        addEmployeeButton=findViewById(R.id.addEmployeeButton);

        addEmployeeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,addEmployeeActivity.class);
                startActivity(intent);
            }
        });

        //list
        employeeList =new ArrayList<>();
        adapter=new EmployeeAdpater(this,employeeList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(adapter);


    }
}
