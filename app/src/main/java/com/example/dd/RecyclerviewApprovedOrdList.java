package com.example.dd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.dd.adapter.ApprovedOrderAdapter;
import com.example.dd.model.Order;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Displays the details of approved orders
 *
 */

public class RecyclerviewApprovedOrdList extends AppCompatActivity {
    RecyclerView recyclerViewApprOrd;
    ApprovedOrderAdapter adapterApprovedOrder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview_approved_ord_list);

        this.setTitle("Approved Orders");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerViewApprOrd = findViewById(R.id.recyclerViewApprOrd_id);
        recyclerViewApprOrd.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<Order> options=
                new FirebaseRecyclerOptions.Builder<Order>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Order").orderByChild("orderStatus").equalTo("Accept"),Order.class)
                        .build();

        adapterApprovedOrder = new ApprovedOrderAdapter(options, this);
        recyclerViewApprOrd.setAdapter(adapterApprovedOrder);
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapterApprovedOrder.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapterApprovedOrder.stopListening();
    }
}