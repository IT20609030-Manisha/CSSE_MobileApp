package com.example.dd.adapter;

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

public class RejectOrderAdapter extends FirebaseRecyclerAdapter<Order,RejectOrderAdapter.ViewHolder7> {
    private Context context;
    public RejectOrderAdapter(@NonNull FirebaseRecyclerOptions<Order> options, Context context) {
        super(options);
        this.context = context;
    }

    @Override
    protected void onBindViewHolder(@NonNull RejectOrderAdapter.ViewHolder7 holder, @SuppressLint("RecyclerView") int position, @NonNull Order model) {

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

    @NonNull
    @Override
    public RejectOrderAdapter.ViewHolder7 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_for_reject_order,parent,false);

        return new RejectOrderAdapter.ViewHolder7(view);
    }

    public class ViewHolder7 extends RecyclerView.ViewHolder {

        TextView tvOrderId, tvsiteName, tvitemList,tvpurchaseDate, tvdeliveryDate, tvdeliveryAddr, tvtotAmount, tvstatus, tvqty, tvdeliveryNote, tvdeliveredqty;
        Button btnAccept, btnReject;
        public ViewHolder7(@NonNull View itemView) {
            super(itemView);
            tvOrderId = itemView.findViewById(R.id.tv_orderIdReject);
            tvsiteName = itemView.findViewById(R.id.tv_siteNameReject);
            tvitemList = itemView.findViewById(R.id.tv_itemListReject);
            tvpurchaseDate = itemView.findViewById(R.id.tv_purchaseDateReject);
            tvdeliveryDate = itemView.findViewById(R.id.tv_deliveryDateReject);
            tvdeliveryAddr = itemView.findViewById(R.id.tv_deliveryAddReject);
            tvtotAmount = itemView.findViewById(R.id.tv_totalAmountReject);
            tvstatus = itemView.findViewById(R.id.tv_orderStatusReject);
            tvqty = itemView.findViewById(R.id.tv_orderQtyReject);
            tvdeliveryNote = itemView.findViewById(R.id.tv_orderdelNoteReject);
            tvdeliveredqty = itemView.findViewById(R.id.tv_orderdeliveredQtyReject);
            //btnAccept = itemView.findViewById(R.id.btn_Accept_pending);
            //btnReject = itemView.findViewById(R.id.btn_reject_pending);

        }
    }
}
