package com.example.dd.model;

public class Order {

    private String orderID;
    private String siteName;
    private String itemList;
    private String purchaseDate;
    private String deliveryDate;
    private String deliveryAddress;
    private String totalAmount;
    private String orderStatus;
    private String qty;
    private String deliveryNote;
    private String deliveredQty;

    public Order() {
    }

    public Order(String orderID, String siteName, String itemList, String purchaseDate, String deliveryDate, String deliveryAddress, String totalAmount, String orderStatus, String qty, String deliveryNote, String deliveredQty) {
        this.orderID = orderID;
        this.siteName = siteName;
        this.itemList = itemList;
        this.purchaseDate = purchaseDate;
        this.deliveryDate = deliveryDate;
        this.deliveryAddress = deliveryAddress;
        this.totalAmount = totalAmount;
        this.orderStatus = orderStatus;
        this.qty = qty;
        this.deliveryNote = deliveryNote;
        this.deliveredQty = deliveredQty;
    }

    public String getDeliveredQty() {
        return deliveredQty;
    }

    public void setDeliveredQty(String deliveredQty) {
        this.deliveredQty = deliveredQty;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getItemList() {
        return itemList;
    }

    public void setItemList(String itemList) {
        this.itemList = itemList;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getDeliveryNote() {
        return deliveryNote;
    }

    public void setDeliveryNote(String deliveryNote) {
        this.deliveryNote = deliveryNote;
    }
}
