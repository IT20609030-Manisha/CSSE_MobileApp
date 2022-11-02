package com.example.dd;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dd.model.Order;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;

import java.util.HashMap;
import java.util.Map;

public class OrderAdapter extends FirebaseRecyclerAdapter<Order, OrderAdapter.ViewHolder5> {

    private Context context;

    public OrderAdapter(@NonNull FirebaseRecyclerOptions<Order> options,  Context context) {
        super(options);

        this.context = context;
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder5 holder, @SuppressLint("RecyclerView") int position, @NonNull Order model) {
        holder.orderID.setText(model.getOrderID());
        holder.siteName.setText(model.getSiteName());
        holder.purchaseDate.setText(model.getPurchaseDate());
        holder.deliveryDate.setText(model.getDeliveryDate());
        holder.orderItem.setText(model.getItemList());
        holder.totalAmount.setText(model.getTotalAmount());
        holder.orderStatus.setText(model.getOrderStatus());
        holder.qty.setText(model.getQty());

        holder.btnDelNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogPlus dialog = DialogPlus.newDialog(context)
                        .setGravity(Gravity.CENTER)
                        .setMargin(50, 0, 50, 0)
                        .setContentHolder(new com.orhanobut.dialogplus.ViewHolder(R.layout.delivery_note))
                        .setExpanded(false)  // This will enable the expand feature, (similar to android L share dialog)
                        .create();

                View holderView = dialog.getHolderView();

                EditText id = holderView.findViewById(R.id.U_orderID);
                EditText note = holderView.findViewById(R.id.U_delnote);

                Button btnUpdate = holderView.findViewById(R.id.delNoteSubmit);

                id.setText(model.getOrderID());
                note.setText(model.getDeliveryNote());

                btnUpdate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Map<String, Object> map = new HashMap<>();
                        map.put("orderID", id.getText().toString());
                        map.put("deliveryNote", note.getText().toString());

                        FirebaseDatabase.getInstance().getReference().child("Order")
                                .child(getRef(position).getKey())
                                .updateChildren(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                dialog.dismiss();
                                Toast.makeText(context, "Delivery Note added Successfully..", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }

                });
                dialog.show();
            }
        });
    }

    @NonNull
    @Override
    public ViewHolder5 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.order, parent, false);

        return new ViewHolder5(view);
    }

    public class ViewHolder5 extends RecyclerView.ViewHolder {
        TextView orderID, siteName, purchaseDate, deliveryDate, orderItem, totalAmount, orderStatus, qty;
        Button btnDelNote;
        public ViewHolder5(@NonNull View itemView) {
            super(itemView);

            orderID = itemView.findViewById(R.id.orderId);
            siteName = itemView.findViewById(R.id.sitename);
            purchaseDate = itemView.findViewById(R.id.purchDate);
            deliveryDate = itemView.findViewById(R.id.delDate);
            orderItem = itemView.findViewById(R.id.orderItem);
            totalAmount = itemView.findViewById(R.id.amount);
            orderStatus = itemView.findViewById(R.id.status);
            qty = itemView.findViewById(R.id.qty);

            btnDelNote = itemView.findViewById(R.id.btnDelNote);
        }
    }
}
