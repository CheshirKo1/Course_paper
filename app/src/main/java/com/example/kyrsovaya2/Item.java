package com.example.kyrsovaya2;

public class Item {
    int imageId;
    String itemText;

    public Item(int imageId, String itemText) {
        super();
        this.imageId = imageId;
        this.itemText = itemText;
    }

    public void setText(String itemText) {
        this.itemText = itemText;
    }

    public String getText() {
        return itemText;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public int getImageId() {
        return imageId;
    }
}