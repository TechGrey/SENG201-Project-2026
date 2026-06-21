package seng201.team99.services.eventsLogic.eventTypes;

import seng201.team99.items.Item;
import seng201.team99.services.eventsLogic.Event;

import java.util.List;

public class GuildHaemorrhageEvent extends Event {

    public GuildHaemorrhageEvent(String name, String description, List<Item> loot) {
        super(name, description, loot);
    }

    /*
    A guild haemorrhage event is an event that consitutes something
    disastrous happening to the party. Something massive, with something
    that consitutes the death of  a party member.

    The guild haemorrhage event is a rate event that happens only
    when the player is well-versed in the world of the party. Further,
    the haemorrhage event is triggered when they have a certain number of
    gold pieces or high-value loot to incentivise keeping a low inventory.
     */
}
