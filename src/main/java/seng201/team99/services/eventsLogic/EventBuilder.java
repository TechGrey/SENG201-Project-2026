package seng201.team99.services.eventsLogic;

import seng201.team99.items.Item;
import seng201.team99.items.UpgradeItem;
import seng201.team99.services.*;
import seng201.team99.services.eventsLogic.eventTypes.CalmEvent;
import seng201.team99.services.eventsLogic.eventTypes.LootEvent;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;
import java.util.Random;

public class EventBuilder {
    public static Event create(Difficulty eventDifficulty, int roll) {
        double statModifier = eventDifficulty.getStatModifier();
        int level = eventDifficulty.getLevel();
        List<Event> generatedEvents = new ArrayList<Event>();

        // TODO: Update for UI before deployment
        String eventName = "Event";
        String eventDescription = "Event Description";
        List<Item> eventLoot = new ArrayList<>(new FakeDataService().getFakeUpgradeItems(5));

        int threshold = switch (eventDifficulty) {
            case EASY -> 65;
            case NORMAL -> 50;
            case HARD -> 40;
            case BRUTAL -> 30;
            case EXPERT -> 20;
        };

        if (roll < threshold) {
            System.out.println("Generating a loot event...");
            return new LootEvent(eventName, eventDescription, eventLoot);
        } else {
            System.out.println("Generating an empty event with passive loot...");
            return new CalmEvent(eventName, eventDescription, eventLoot);
        }
    }
}
