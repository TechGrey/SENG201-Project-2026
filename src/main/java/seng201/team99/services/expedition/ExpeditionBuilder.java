/**
 * @author Elliott Grey
 */

package seng201.team99.services.expedition;

import seng201.team99.services.Difficulty;
import seng201.team99.services.eventsLogic.Event;
import seng201.team99.services.eventsLogic.EventBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Import JSON list here

public class ExpeditionBuilder implements Expedition {

    // Setting functions and modifiers.
    private String name;
    private double lootMultiplier;
    private double eventsMultiplier;
    private ArrayList<Event> eventList = new ArrayList<Event>();
    private Difficulty eventDifficulty = Difficulty.EASY;
    public Random random = new Random();

    public ExpeditionBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ExpeditionBuilder setEventDifficulty(Difficulty difficulty) {
        this.eventDifficulty = difficulty;
        return this;
    }

    public Difficulty getEventDifficulty() {
        return this.eventDifficulty;
    }
    public ExpeditionBuilder setLootMultiplier(double lootMultiplier) {
        this.lootMultiplier = lootMultiplier;
        return this;
    }

    public ExpeditionBuilder setEventsMultiplier(double eventsMultiplier) {
        this.eventsMultiplier = eventsMultiplier;
        return this;
    }

    // Now with all of the building blocks set-up, the game can now build, on request, a set expedition.

    public static ExpeditionBuilder intrepidMountains(Difficulty difficulty) {
        ExpeditionBuilder expeditionBuilder = new ExpeditionBuilder();
        expeditionBuilder
                .setName("Intrepid Mountains")
                .setEventsMultiplier(difficulty.getStatModifier())
                .setLootMultiplier(difficulty.getStatModifier())
                .setEventDifficulty(difficulty)
                .buildEventList();
        return expeditionBuilder;
    }

    public static ExpeditionBuilder forestAmble(Difficulty difficulty) {
        ExpeditionBuilder expeditionBuilder = new ExpeditionBuilder();
        expeditionBuilder
                .setName("Forest Amble... or is it?")
                .setEventsMultiplier(difficulty.getStatModifier())
                .setLootMultiplier(difficulty.getStatModifier())
                .setEventDifficulty(difficulty)
                .buildEventList();
        return expeditionBuilder;
    }

    public static ExpeditionBuilder dragonsCastle(Difficulty difficulty) {
        ExpeditionBuilder expeditionBuilder = new ExpeditionBuilder();
        expeditionBuilder
                .setName("Dragon's Castle")
                .setEventsMultiplier(difficulty.getStatModifier())
                .setLootMultiplier(difficulty.getStatModifier())
                .setEventDifficulty(difficulty)
                .buildEventList();
        return expeditionBuilder;
    }

    public static ExpeditionBuilder ancientRuinRun(Difficulty difficulty) {
        ExpeditionBuilder expeditionBuilder = new ExpeditionBuilder();
        expeditionBuilder
                .setName("Ancient Ruin Run")
                .setEventsMultiplier(difficulty.getStatModifier())
                .setLootMultiplier(1.5*difficulty.getStatModifier())
                .setEventDifficulty(difficulty)
                .buildEventList();
        return expeditionBuilder;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getLootMultiplier() {
        return lootMultiplier;
    }

    @Override
    public double getEventMultiplier() {
        return eventsMultiplier;
    }

    @Override
    public ArrayList<Event> getEvents() {
        return eventList;
    }

    public ArrayList<Event> buildEventList() {

        // Builds the event list for the Expedition.
        // Before the start of the Expedition, the eventList should be cleared from the previous expedition.
        this.eventList.clear();
        int numberOfEvents = (int) Math.max(5, 5 * eventsMultiplier);


        /* Now, the function will loop through and add the number of events
        required to build the expedition at the expected difficulty level.
         */

        for (int i = 0; i < numberOfEvents; i++) {
            int roll = random.nextInt(100);
            Event generatedEvents = EventBuilder.create(eventDifficulty, roll);
            eventList.add(generatedEvents);
        }

        return eventList;
    }

    @Override
    public void startExpedition() {
        System.out.println("Starting expedition: " + name);
        for (Event event : eventList) {
//            event.triggerEventActivation();
        }
    }

    @Override
    public String toString() {
        return name + " (Events: x" + eventsMultiplier + ", Loot: x" + lootMultiplier + ")";

    }
}