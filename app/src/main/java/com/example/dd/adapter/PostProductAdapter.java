package com.example.dd.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dd.R;
import com.example.dd.model.Product;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.squareup.picasso.Picasso;

/**
 * Display the added products
 * 
 */
public class PostProductAdapter extends FirebaseRecyclerAdapter<Product,PostProductAdapter.ViewHolder2> {
    private Context context;

    public PostProductAdapter(@NonNull FirebaseRecyclerOptions<Product> options, Context context) {
        super(options);
        this.context = context;
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder2 holder, int position, @NonNull Product model) {
        holder.tv_displayProdName.setText("Product Name : " + model.getProductName());
        holder.tv_displayProdDescription.setText("Description : " + model.getDescription());
        holder.tv_displayProdPrice.setText(model.getProductPrice());
        holder.tv_displaySupplier.setText("Supplier : " + model.getSupplier());
        holder.tv_displayStatus.setText("Donation Status : "+model.getStatus());

        String imageUri = model.getImage();
        //get image from firebase
        Picasso.get().load(imageUri).into(holder.showProduct);

        String st = model.getStatus();

        /*holder.btn_OrderFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (st.equals("Pending")){
                    Toast.makeText(context, "Sorry,Can't Order... Donation Still Pending...", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(context, "Placing Order.....", Toast.LENGTH_SHORT).show();
                }

            }
        });*/
    }

    @NonNull
    @Override
    public ViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.design_row_for_prod_recyclerview,parent,false);

        return new ViewHolder2(view);
    }

    public class ViewHolder2 extends RecyclerView.ViewHolder {
        TextView tv_displayProdName, tv_displayProdDescription, tv_displayProdPrice, tv_displaySupplier, tv_displayStatus;
        ImageView showProduct;
        public ViewHolder2(@NonNull View itemView) {
            super(itemView);
            //binding
            tv_displayProdName = itemView.findViewById(R.id.tv_prodNameDisplay);
            tv_displayProdDescription = itemView.findViewById(R.id.tv_prodDescriptionDisplay);
            tv_displayProdPrice = itemView.findViewById(R.id.tv_prodPriceDisplay);
            tv_displaySupplier = itemView.findViewById(R.id.tv_prodSupplierDisplay);
            tv_displayStatus = itemView.findViewById(R.id.tv_prodStatusDisplay);

            showProduct = itemView.findViewById(R.id.image_DisplayProduct);
            //btn_OrderFood = itemView.findViewById(R.id.btnOrderFood);
        }
    }
}
