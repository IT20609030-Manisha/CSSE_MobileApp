package com.example.dd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.dd.adapter.PostProductAdapter;
import com.example.dd.model.Product;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class RecyclerviewProdList extends AppCompatActivity {
    RecyclerView recyclerViewProdDisplay;
    PostProductAdapter adapterProdDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview_prod_list);

        this.setTitle("All Products");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerViewProdDisplay = findViewById(R.id.recyclerViewProd_id);
        recyclerViewProdDisplay.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<Product> options=
                new FirebaseRecyclerOptions.Builder<Product>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Product"),Product.class)
                        .build();

        adapterProdDisplay = new PostProductAdapter(options,this);
        recyclerViewProdDisplay.setAdapter(adapterProdDisplay);

    }

    @Override
    protected void onStart() {
        super.onStart();
        adapterProdDisplay.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapterProdDisplay.stopListening();
    }
}