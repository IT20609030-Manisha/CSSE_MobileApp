package com.example.dd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.example.dd.adapter.PendingOrderAdapter;
import com.example.dd.adapter.RejectOrderAdapter;
import com.example.dd.model.Order;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class RecyclerviewRejectOrdList extends AppCompatActivity {
    RecyclerView recyclerViewRejectOrd;
    RejectOrderAdapter adapterReject;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview_reject_ord_list);

        this.setTitle("Rejected Orders");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerViewRejectOrd = findViewById(R.id.recyclerview_rejectord_id);
        recyclerViewRejectOrd.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<Order> options=
                new FirebaseRecyclerOptions.Builder<Order>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Order").orderByChild("orderStatus").equalTo("Reject"),Order.class)
                        .build();

        adapterReject = new RejectOrderAdapter(options, this);
        recyclerViewRejectOrd.setAdapter(adapterReject);
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapterReject.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapterReject.stopListening();
    }
}