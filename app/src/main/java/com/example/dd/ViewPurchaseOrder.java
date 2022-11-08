package com.example.dd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.dd.model.Order;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Display purchase Orders
 */
public class ViewPurchaseOrder extends AppCompatActivity {

    RecyclerView recyclerViewO;
    OrderAdapter orderAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_purchase_order);

        this.setTitle("Orders");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerViewO = findViewById(R.id.OrderView);
        //database = FirebaseDatabase.getInstance().getReference("Vacancy");
        //recyclerView.setHasFixedSize(true);
        recyclerViewO.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<Order> options=
                new FirebaseRecyclerOptions.Builder<Order>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Order"),Order.class)
                        .build();

        //list = new ArrayList<>();
        orderAdapter = new OrderAdapter(options,this);
        recyclerViewO.setAdapter(orderAdapter);
    }

    protected void onStart() {
        super.onStart();
        orderAdapter.startListening();
    }

    protected void onStop() {
        super.onStop();
        orderAdapter.startListening();
    }

}