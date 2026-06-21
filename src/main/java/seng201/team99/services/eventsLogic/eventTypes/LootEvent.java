package seng201.team99.services.eventsLogic.eventTypes;

import seng201.team99.consumables.Adventurer;
import seng201.team99.consumables.Guild;
import seng201.team99.items.Item;
import seng201.team99.services.eventsLogic.Event;
import seng201.team99.stores.Stat;

import java.util.List;

public class LootEvent extends Event {
    public LootEvent(String name, String description, List<Item> loot) {
        super(name, description, loot);
    }

    @Override
    public void triggerEventActivation(Guild guild, List<Adventurer> party, double lootMultiplier) {
        if (randomChance.nextDouble() > 0.5) {
            guild.addGold(30*lootMultiplier);
        }
        for (
                Adventurer adventurer : party) {
            adventurer.applyStats(new Stat(-10, 0, 0));
        }
    }
}
