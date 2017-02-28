package com.example.gulshan.genericlistviewadapter;

/**
 * Created by gulshan on 27/02/17.
 */
public class Item {

    private String itemName;
    private String itemDescription;

    public Item(String name, String description) {
        this.itemName = name;
        this.itemDescription = description;
    }

    public String getItemName() {
        return this.itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }
}
