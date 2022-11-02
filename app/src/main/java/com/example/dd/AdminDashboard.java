package com.example.dd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class AdminDashboard extends AppCompatActivity {

    Button btnOrders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);

        this.setTitle("Dashboard");

        btnOrders = findViewById(R.id.btnOrder);

        //Order Button
        btnOrders.setOnClickListener(view -> {
            Intent i = new Intent(AdminDashboard.this, ViewPurchaseOrder.class);
            startActivity(i);
        });
    }
}