package seng201.team99.items;

import seng201.team99.consumables.Purchasable;
import seng201.team99.stores.Stat;

public abstract class Item extends Purchasable {

    public String name;
    public ItemType type;
    public Stat stats;

    public Item(
            String name,
            String description,
            double cost,
            ItemType type,
            Stat stats
    ) {
        super(cost, description);
        this.name = name;
        this.type = type;
        this.stats = stats;
    }

    public abstract void useItem();
}
