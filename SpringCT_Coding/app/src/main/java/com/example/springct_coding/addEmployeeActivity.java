package com.example.springct_coding;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class addEmployeeActivity extends AppCompatActivity {
    private EditText nameEditText,ageEditText,addressEditText,cityEditText;
    private Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employee);

        nameEditText=findViewById(R.id.nameEditText);
        ageEditText=findViewById(R.id.ageEditText);
        addressEditText=findViewById(R.id.addressEditText);
        cityEditText=findViewById(R.id.cityEditText);
        addButton=findViewById(R.id.activity_add_employee);


        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=nameEditText.getText().toString().trim();
                String age=ageEditText.getText().toString().trim();
                String address=addressEditText.getText().toString().trim();
                String city=cityEditText.getText().toString().trim();

                if(name.isEmpty() || age.isEmpty()||address.isEmpty()||city.isEmpty()){
                    Toast.makeText(addEmployeeActivity.this, "Please fill all the details", Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent intent = new Intent(addEmployeeActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}
