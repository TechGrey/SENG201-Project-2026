package seng201.team99.stores;

import seng201.team99.items.Item;

import java.util.ArrayList;

public class Inventory {
    private ArrayList<Item> items;

    public Inventory() {
        this.items = new ArrayList<Item>();
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public void removeItem(Item item) {
        if (!this.items.contains(item)) {
            //  throw new InventoryItemNotExistException
            return;
        }

        this.items.remove(item);
    }

    public ArrayList<Item> getItems() {
        return items;
    }
}
