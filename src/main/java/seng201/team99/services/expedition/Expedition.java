package seng201.team99.services.expedition;

import seng201.team99.services.eventsLogic.Event;

import java.util.List;

public interface Expedition {
    /**
     * An interface that sets up the scenario for a Quest.
     * Requires implemented functions to have functions that set-up a quest's core elements and alters chances for players to encounter different outcomes.
     * An "outcome" will be one of the following:
     * - Death
     * - Loot
     * - No loot
     * - Death of a guild character
     * Each of these outcomes will be determined by an implementation by the interface.
     * The interface should be used to implement scenarios at the start of the game.
     *
     */

    String getName();
    double getLootMultiplier();
    double getEventMultiplier();
    List<Event> getEvents();

    void startExpedition();
}
