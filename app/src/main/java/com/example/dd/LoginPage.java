package com.example.dd;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class LoginPage extends AppCompatActivity {

    private EditText etUserEmail, etUserPassword;
    private Button btnLogin;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        this.setTitle("Login");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        etUserEmail = findViewById(R.id.etLoginEmail);
        etUserPassword = findViewById(R.id.etLoginPasssword);
        btnLogin = findViewById(R.id.btnLogIn);
        mAuth = FirebaseAuth.getInstance();

        //Login function
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userEmail = etUserEmail.getText().toString();
                String userPassword = etUserPassword.getText().toString();

                if (TextUtils.isEmpty(userEmail) && TextUtils.isEmpty(userPassword)) {
                    Toast.makeText(LoginPage.this, "Please enter your credentials..", Toast.LENGTH_SHORT).show();
                    return;
                }
                else if (userEmail.equals("admin@gmail.com") && userPassword.equals("123")){
                    Toast.makeText(LoginPage.this, "Admin Login...", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(LoginPage.this, AdminDashboard.class);
                    startActivity(i);
                }
                else{
                    Toast.makeText(LoginPage.this, "Incorrect Credentials...", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}