package seng201.team99.items;

import seng201.team99.consumables.Adventurer;
import seng201.team99.stores.Stat;

public class UpgradeItem extends Item {
    public UpgradeItem(String name, String description, double cost, ItemType type, Stat stats) {
        super(name, description, cost, type, stats);
    }

    @Override
    public void useItem() {
        // It was angry
    }

    public void useItem(Adventurer adventurer) {
        // Uses applyStats in Adventurer.java to apply statistics modifiers.

        adventurer.applyStats(this.stats);
        System.out.println(adventurer.name + "used" + this.name + " and gained a stat bonus.");
    }
}
