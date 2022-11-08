package com.example.dd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

/**
 * Admin Dashboard Contains the buttons to navigation the other pages
 *
 */
public class AdminDashboard extends AppCompatActivity {

    Button btnDashboard, btnOrder, btnProducts, btnSupplier, btnTransaction;
    Button btnOrders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);
        this.setTitle("Admin Dashboard");

        btnDashboard = findViewById(R.id.btnDashboard);
        btnOrder = findViewById(R.id.btnOrder);
        btnProducts = findViewById(R.id.btn_products);
        btnSupplier = findViewById(R.id.btn_supplier);
        btnTransaction = findViewById(R.id.btn_transaction);

        //Products
        btnProducts.setOnClickListener(view -> {
            Intent i = new Intent(AdminDashboard.this, AddProduct.class);
            startActivity(i);
        });

        //Purchase Order
        btnOrder.setOnClickListener(view -> {
            Intent i = new Intent(AdminDashboard.this, ViewPurchaseOrder.class);
            startActivity(i);
        });

        //suppliers
        btnSupplier.setOnClickListener(view -> {
            Intent i = new Intent(AdminDashboard.this, RecyclerviewApprovedOrdList.class);
            startActivity(i);
        });

    }
}