package seng201.team99.consumables;

import seng201.team99.stores.Inventory;
import seng201.team99.stores.Party;

public class Guild {
    public final String name;
    public Party mainParty;
    public Party reserveParty;
    public Inventory inventory;

    private double gold;

    public Guild(String name) {
        this.name = name;

        this.mainParty = new Party(5);
        this.reserveParty = new Party(5);

        this.inventory = new Inventory();

        // Haha poor
        this.gold = 0;
    }

    public double getGold() {
        return gold;
    }

    public void addGold(double gold) {
        this.gold += gold;
    }
}
