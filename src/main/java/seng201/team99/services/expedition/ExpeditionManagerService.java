/**
 * @author Elliott Grey
 */

package seng201.team99.services.expedition;

import seng201.team99.consumables.Adventurer;
import seng201.team99.consumables.Guild;
import seng201.team99.services.Difficulty;
import seng201.team99.services.Effect;
import seng201.team99.services.eventsLogic.Event;
import seng201.team99.stores.Stat;

import java.util.List;
import java.util.Random;

public class ExpeditionManagerService {
    public void runExpedition(Expedition expedition, Guild guild) {
        List<Adventurer> activeParty = guild.mainParty.getMembers();
        double lootMultiplier = expedition.getLootMultiplier();

        for (Event event : expedition.getEvents()) {
            // Parse the guild and party into the Event so it can modify the values.
            event.triggerEventActivation(guild, activeParty, lootMultiplier);

            if (isPartyExhausted(activeParty)) {
                System.out.println("Expedition kaput.");
            }
        }
    }

    // This is a private bool to store the isPartyExhausted logic.
    // This will tell the ExpeditionManagerService whether to stop running an Expedition due to everyone being worn-out.
    private boolean isPartyExhausted(List<Adventurer> party) {
        /* Check stamina levels in Adventurer objects. Originally done with a for-each function,
        this can be achieved with streams instead.
         */

        return party.stream().allMatch(Adventurer::isExhausted);
    }

    // On the event that a member of the party is too tired to continue, they die.
    public List<Adventurer> cullPartyMembers(List<Adventurer> party) {

        // This is basically a for-each loop that runs over the list and determines whether they have enough health to continue.
        party.removeIf(Adventurer::isExhausted);
        return party;
    }

    // After the expedition is completed, there will be events rolled that could alter the outcome of the Guild.
    /*
    (a) An adventurer has one or more of its stats increased or decreased.
    (b) An adventurer learns a skill.
    (c) An adventurer retires from the party (the chance should increase if
    the adventurer goes on many expeditions in a row without rest).
     */

    public String rollPostExpeditionEvents(Guild guild, Difficulty difficulty) {
        Random chance = new Random();
        Adventurer randomAdventurer = guild.mainParty.getMembers().get(chance.nextInt(0, guild.mainParty.getMembers().size()));
        int eventChance = (int) (chance.nextInt(0, 100) * difficulty.getStatModifier());
        if (eventChance > 65) {
            randomAdventurer.applyStats(new Stat(-10, -10, -10));
            return "Stats applied to " + randomAdventurer + ".";
        } else if (eventChance > 30) {
            randomAdventurer.applyEffect(new Effect("Fire Hands", "Allows the Adventurer to damage other beings more.", new Stat(5, 10, 0)) {
            });
            return "Effect applied to " + randomAdventurer.name + ".";
        } else {
            guild.mainParty.removeMember(randomAdventurer);
            return "The member " + randomAdventurer + " has been removed from the Guild (they retired).";
        }
    }
}