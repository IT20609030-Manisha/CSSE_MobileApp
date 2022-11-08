package com.example.dd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.dd.adapter.ApprovedOrderAdapter;
import com.example.dd.adapter.PendingOrderAdapter;
import com.example.dd.model.Order;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class RecyclerviewPendingOrdList extends AppCompatActivity {
    RecyclerView recyclerViewPendingOrd;
    PendingOrderAdapter adapterPending;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview_pending_ord_list);

        this.setTitle("Pending Orders");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerViewPendingOrd = findViewById(R.id.recyclerPendingOrd_id);
        recyclerViewPendingOrd.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<Order> options=
                new FirebaseRecyclerOptions.Builder<Order>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Order").orderByChild("orderStatus").equalTo("Pending"),Order.class)
                        .build();

        adapterPending = new PendingOrderAdapter(options, this);
        recyclerViewPendingOrd.setAdapter(adapterPending);
    }
    @Override
    protected void onStart() {
        super.onStart();
        adapterPending.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapterPending.stopListening();
    }
}