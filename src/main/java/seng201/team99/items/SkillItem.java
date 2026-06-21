package seng201.team99.items;

import seng201.team99.stores.Stat;

public class SkillItem extends Item {
    public SkillItem(String name, String description, double cost, ItemType type, Stat stats) {
        super(name, description, cost, type, stats);
    }

    @Override
    public void useItem() {
    }
}
