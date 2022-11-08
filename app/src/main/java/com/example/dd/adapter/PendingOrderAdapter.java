package com.example.dd.adapter;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
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

import com.example.dd.R;
import com.example.dd.model.Order;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;

import java.util.HashMap;
import java.util.Map;

public class PendingOrderAdapter extends FirebaseRecyclerAdapter<Order,PendingOrderAdapter.ViewHolder6> {
    private Context context;
    public PendingOrderAdapter(@NonNull FirebaseRecyclerOptions<Order> options, Context context) {
        super(options);
        this.context = context;
    }

    @Override
    protected void onBindViewHolder(@NonNull PendingOrderAdapter.ViewHolder6 holder, @SuppressLint("RecyclerView") int position, @NonNull Order model) {
        if(model.getOrderStatus().equals("Pending")){
            holder.tvOrderId.setText("Order ID : " +model.getOrderID());
            holder.tvsiteName.setText("Site Name : " +model.getSiteName());
            holder.tvitemList.setText("Item List : " +model.getItemList());
            holder.tvpurchaseDate.setText("Purchase Date : " +model.getPurchaseDate());
            holder.tvdeliveryDate.setText("Delivery Date : " +model.getDeliveryDate());
            holder.tvdeliveryAddr.setText("Delivery Address : " +model.getDeliveryAddress());
            holder.tvtotAmount .setText("Total Amount : " +model.getTotalAmount());
            holder.tvstatus.setText("Order Status : " +model.getOrderStatus());
            holder.tvqty.setText("Requested Quantity : " +model.getQty());
            holder.tvdeliveryNote.setText("Delivery Note : " +model.getDeliveryNote());
            holder.tvdeliveredqty.setText("Received Quantity : " +model.getDeliveredQty());
        }


        //delete
        holder.btnReject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DialogPlus dialog= DialogPlus.newDialog(context)
                        .setGravity(Gravity.CENTER)
                        .setMargin(50,0,50,0)
                        .setContentHolder(new com.orhanobut.dialogplus.ViewHolder(R.layout.content_approved_order))
                        .setExpanded(false)
                        .create();

                View holderView=dialog.getHolderView();

                EditText upOrderId= holderView.findViewById(R.id.update_orderId);
                EditText upSiteName = holderView.findViewById(R.id.update_siteName);
                EditText itemList = holderView.findViewById(R.id.update_itemList);
                EditText upPurchaseDate = holderView.findViewById(R.id.update_purchaseDate);
                EditText upDeliveryDate = holderView.findViewById(R.id.update_deliveryDate);
                EditText upDeliveryAddr = holderView.findViewById(R.id.update_deliveryAdd);
                EditText upTotAmount = holderView.findViewById(R.id.update_totalAmount);
                EditText upStatus = holderView.findViewById(R.id.update_orderStatus);
                EditText upQty = holderView.findViewById(R.id.update_orderQty);
                EditText upDeliveryNote = holderView.findViewById(R.id.update_orderdelNote);
                EditText upDeliveredQty = holderView.findViewById(R.id.update_orderdeliveredQty);
                Button btnOrderUpdate = holderView.findViewById(R.id.btn_OrderUpdate);

                //set text to update dialog box
                upOrderId.setText(model.getOrderID());
                upSiteName.setText(model.getSiteName());
                itemList.setText(model.getItemList());
                upPurchaseDate.setText(model.getPurchaseDate());
                upDeliveryDate.setText(model.getDeliveryDate());
                upDeliveryAddr.setText(model.getDeliveryAddress());
                upTotAmount.setText(model.getTotalAmount());
                upStatus.setText("Reject");
                upQty.setText(model.getQty());
                upDeliveryNote.setText(model.getDeliveryNote());
                upDeliveredQty.setText(model.getDeliveredQty());


                //update donation
                btnOrderUpdate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Map<String,Object> map = new HashMap<>();
                        map.put("orderID", upOrderId.getText().toString());
                        map.put("siteName", upSiteName.getText().toString());
                        map.put("itemList", itemList.getText().toString());
                        map.put("purchaseDate", upPurchaseDate.getText().toString());
                        map.put("deliveryDate", upDeliveryDate.getText().toString());
                        map.put("deliveryAddress", upDeliveryAddr.getText().toString());
                        map.put("totalAmount", upTotAmount.getText().toString());
                        map.put("orderStatus", upStatus.getText().toString());
                        map.put("qty", upQty.getText().toString());
                        map.put("deliveryNote", upDeliveryNote.getText().toString());
                        map.put("deliveredQty", upDeliveredQty.getText().toString());

                        FirebaseDatabase.getInstance().getReference().child("Order")
                                .child(getRef(position).getKey())
                                .updateChildren(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        dialog.dismiss();
                                        Toast.makeText(context, "Updated Successfully", Toast.LENGTH_SHORT).show();
                                    }
                                });
                    }
                });

                dialog.show();
            }
        });


        //update
        holder.btnAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DialogPlus dialog= DialogPlus.newDialog(context)
                        .setGravity(Gravity.CENTER)
                        .setMargin(50,0,50,0)
                        .setContentHolder(new com.orhanobut.dialogplus.ViewHolder(R.layout.content_approved_order))
                        .setExpanded(false)
                        .create();

                View holderView=dialog.getHolderView();

                EditText upOrderId= holderView.findViewById(R.id.update_orderId);
                EditText upSiteName = holderView.findViewById(R.id.update_siteName);
                EditText itemList = holderView.findViewById(R.id.update_itemList);
                EditText upPurchaseDate = holderView.findViewById(R.id.update_purchaseDate);
                EditText upDeliveryDate = holderView.findViewById(R.id.update_deliveryDate);
                EditText upDeliveryAddr = holderView.findViewById(R.id.update_deliveryAdd);
                EditText upTotAmount = holderView.findViewById(R.id.update_totalAmount);
                EditText upStatus = holderView.findViewById(R.id.update_orderStatus);
                EditText upQty = holderView.findViewById(R.id.update_orderQty);
                EditText upDeliveryNote = holderView.findViewById(R.id.update_orderdelNote);
                EditText upDeliveredQty = holderView.findViewById(R.id.update_orderdeliveredQty);
                Button btnOrderUpdate = holderView.findViewById(R.id.btn_OrderUpdate);

                //set text to update dialog box
                upOrderId.setText(model.getOrderID());
                upSiteName.setText(model.getSiteName());
                itemList.setText(model.getItemList());
                upPurchaseDate.setText(model.getPurchaseDate());
                upDeliveryDate.setText(model.getDeliveryDate());
                upDeliveryAddr.setText(model.getDeliveryAddress());
                upTotAmount.setText(model.getTotalAmount());
                upStatus.setText("Accept");
                upQty.setText(model.getQty());
                upDeliveryNote.setText(model.getDeliveryNote());
                upDeliveredQty.setText(model.getDeliveredQty());


                //update donation
                btnOrderUpdate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Map<String,Object> map = new HashMap<>();
                        map.put("orderID", upOrderId.getText().toString());
                        map.put("siteName", upSiteName.getText().toString());
                        map.put("itemList", itemList.getText().toString());
                        map.put("purchaseDate", upPurchaseDate.getText().toString());
                        map.put("deliveryDate", upDeliveryDate.getText().toString());
                        map.put("deliveryAddress", upDeliveryAddr.getText().toString());
                        map.put("totalAmount", upTotAmount.getText().toString());
                        map.put("orderStatus", upStatus.getText().toString());
                        map.put("qty", upQty.getText().toString());
                        map.put("deliveryNote", upDeliveryNote.getText().toString());
                        map.put("deliveredQty", upDeliveredQty.getText().toString());

                        FirebaseDatabase.getInstance().getReference().child("Order")
                                .child(getRef(position).getKey())
                                .updateChildren(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        dialog.dismiss();
                                        Toast.makeText(context, "Updated Successfully", Toast.LENGTH_SHORT).show();
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
    public PendingOrderAdapter.ViewHolder6 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_for_pending_order,parent,false);

        return new PendingOrderAdapter.ViewHolder6(view);
    }

    public class ViewHolder6 extends RecyclerView.ViewHolder {

        TextView tvOrderId, tvsiteName, tvitemList,tvpurchaseDate, tvdeliveryDate, tvdeliveryAddr, tvtotAmount, tvstatus, tvqty, tvdeliveryNote, tvdeliveredqty;
        Button btnAccept, btnReject;
        public ViewHolder6(@NonNull View itemView) {
            super(itemView);
            tvOrderId = itemView.findViewById(R.id.tv_orderIdPending);
            tvsiteName = itemView.findViewById(R.id.tv_siteNamePending);
            tvitemList = itemView.findViewById(R.id.tv_itemListPending);
            tvpurchaseDate = itemView.findViewById(R.id.tv_purchaseDatePending);
            tvdeliveryDate = itemView.findViewById(R.id.tv_deliveryDatePending);
            tvdeliveryAddr = itemView.findViewById(R.id.tv_deliveryAddPending);
            tvtotAmount = itemView.findViewById(R.id.tv_totalAmountPending);
            tvstatus = itemView.findViewById(R.id.tv_orderStatusPending);
            tvqty = itemView.findViewById(R.id.tv_orderQtyPending);
            tvdeliveryNote = itemView.findViewById(R.id.tv_orderdelNotePending);
            tvdeliveredqty = itemView.findViewById(R.id.tv_orderdeliveredQtyPending);
            btnAccept = itemView.findViewById(R.id.btn_Accept_pending);
            btnReject = itemView.findViewById(R.id.btn_reject_pending);

        }
    }
}
