package seng201.team99.services.eventsLogic.eventTypes;

import seng201.team99.consumables.Adventurer;
import seng201.team99.consumables.Guild;
import seng201.team99.items.Item;
import seng201.team99.services.Difficulty;
import seng201.team99.services.eventsLogic.Event;
import seng201.team99.stores.Stat;

import java.util.ArrayList;
import java.util.List;

public class CalmEvent extends Event {
    private Difficulty difficulty;

    public CalmEvent(String name, String description, List<Item> loot) {
        super(name,description,loot);
    }

    @Override
    public void triggerEventActivation(Guild guild, List<Adventurer> party, double lootMultiplier) {
        for (Adventurer adventurer : party) {
            adventurer.applyStats(new Stat(-5, 0, 0));
        }
    }
}
