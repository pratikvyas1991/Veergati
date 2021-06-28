package com.veergati.veergati.data;

public class TicketItem {
    String itemId;
    String itemName;
    String itemQty;
    String itemPrice;
    String itemUnit;

    public String getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemQty() {
        return itemQty;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public String getItemUnit() {
        return itemUnit;
    }

    public TicketItem(String itemId, String itemName, String itemQty, String itemPrice, String itemUnit) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemQty = itemQty;
        this.itemPrice = itemPrice;
        this.itemUnit = itemUnit;
    }
}
