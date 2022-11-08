package com.example.dd;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class OrderReport extends AppCompatActivity {

    FirebaseDatabase mDatabase;
    DatabaseReference mRef, allOrdRef, pendingdOrdRef, approvedOrdRef, rejectOrdRef;
    TextView AllOrderCount, PendingOrder, ApprovedOrder, RejectOrder;
    Button viewPending, viewApproved, viewRejected;

    //create variable to store donation count
    private int countAllOrders = 0;
    //private int countPendingOrders = 0;
   // private int countApproveOrders = 0;
   // private int countRejectOrders = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_report);

        this.setTitle("Order Report");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        AllOrderCount = findViewById(R.id.tv_allOrdCount);
        //PendingOrder = findViewById(R.id.tv_pendingOrdCount);
        //ApprovedOrder = findViewById(R.id.tv_approvedOrdCount);
        //RejectOrder = findViewById(R.id.tv_rejectedOrdCount);
        viewPending = findViewById(R.id.btn_viewPendingOrders);
        viewApproved = findViewById(R.id.btn_viewApprovedOrders);
        viewRejected = findViewById(R.id.btn_viewRejectOrders);

        mDatabase = FirebaseDatabase.getInstance();
        allOrdRef = mDatabase.getReference().child("Order");
        //pendingdOrdRef = (DatabaseReference) mDatabase.getReference().child("Order").orderByChild("orderStatus").equalTo("Pending");

        //Pending
        viewPending.setOnClickListener(view -> {
            Intent i = new Intent(OrderReport.this, RecyclerviewPendingOrdList.class);
            startActivity(i);
        });
        //Approved
        viewApproved.setOnClickListener(view -> {
            Intent i = new Intent(OrderReport.this, RecyclerviewApprovedOrdList.class);
            startActivity(i);
        });

        //Rejected
        viewRejected.setOnClickListener(view -> {
            Intent i = new Intent(OrderReport.this, RecyclerviewRejectOrdList.class);
            startActivity(i);
        });

        //get the child count of the Donation
        allOrdRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    countAllOrders = (int)dataSnapshot.getChildrenCount();
                    AllOrderCount.setText(Integer.toString(countAllOrders));

                }
                else{
                    AllOrderCount.setText("0");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
}