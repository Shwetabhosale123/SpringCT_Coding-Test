package com.example.springct_coding;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {

    private static final String BASE_URL = "https://reqres.in/api/login";
    private EditText usernameEditText, passwordEditText;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameEditText = findViewById(R.id.username);
        passwordEditText = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginButton);


        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

        ApiService apiService = retrofit.create(ApiService.class);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                Call<JSONObject> call = apiService.login(username, password);
                call.enqueue(new Callback<JSONObject>() {
                    @Override
                    public void onResponse(Call<JSONObject> call, Response<JSONObject> response) {
                        if (response.isSuccessful()) {
                            JSONObject responseObject = response.body();
                            if (responseObject != null && responseObject.has("token")) {
                                String token = null;
                                try {
                                    token = responseObject.get("token").toString();
                                } catch (JSONException e) {
                                    throw new RuntimeException(e);
                                }

                                Log.d("Login Successful.Token: " + token, "");

                                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                                startActivity(intent);
                                finish();
                            } else {
                                Log.e("Invalid respose from server", "");
                                Toast.makeText(LoginActivity.this, "Invalid response from server", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Log.e("Error respose from server. code: " + response.code(), "");

                            Toast.makeText(LoginActivity.this, "Error response from server", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<JSONObject> call, Throwable t) {
                        Log.e("Network Error: " + t.getMessage(), "");

                        Toast.makeText(LoginActivity.this, "Network Error, Please Try again", Toast.LENGTH_SHORT).show();

                    }
                });
//             if (username.isEmpty() || password.isEmpty()) {
////                    Toast.makeText(LoginActivity.this, "Please Enter Username and Password", Toast.LENGTH_SHORT).show();
////                    return;
//                }

                Intent intent=new Intent(LoginActivity.this,HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

}
