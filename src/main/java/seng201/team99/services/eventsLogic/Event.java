package seng201.team99.services.eventsLogic;

import seng201.team99.consumables.Adventurer;
import seng201.team99.consumables.Guild;
import seng201.team99.items.Item;
import seng201.team99.stores.Stat;
import seng201.team99.services.eventsLogic.*;

import java.util.List;
import java.util.Random;

public abstract class Event {
    private final String name;
    private final String description;
    protected Random randomChance = new Random();
    private List<Item> loot;

    public Event(String name, String description, List<Item> loot) {
        this.name = name;
        this.description = description;
        this.loot = loot;
    }

    // The next section of code triggers the Event logic and decreases stamina, etc.
    // This accepts a Guild type to then parse through rewards.
    // Further, this also takes in a list of party members as a List of Adventurers.

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<Item> getLoot() {
        return loot;
    }

    public void triggerEventActivation(Guild guild, List<Adventurer> party, double lootMultiplier) {

    }
}
