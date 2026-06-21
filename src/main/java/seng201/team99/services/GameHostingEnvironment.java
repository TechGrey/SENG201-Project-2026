package seng201.team99.services;

import seng201.team99.consumables.Adventurer;
import seng201.team99.consumables.Guild;
import java.util.List;

public class GameHostingEnvironment {

    // Setting up the Hosting environment with relevant variables.
    private final Guild guild;
    private final Difficulty difficulty;
    private final int totalExpeditions;
    private int currentExpeditionNumber;


    // When initialised, the hosting environment sets the environment with all of the set values by the user in setup.fxml.
    public GameHostingEnvironment(String guildName, Difficulty difficulty, int totalExpeditions, List<Adventurer> startingAdventurers) {
        this.guild = new Guild(guildName);
        this.difficulty = difficulty;
        this.totalExpeditions = totalExpeditions;
        this.currentExpeditionNumber = 1;

        // This adds the selected Adventurers 
        for (Adventurer adventurer : startingAdventurers) {
            this.guild.mainParty.addMember(adventurer);
        }
    }

    public Guild getGuild() {
        return guild;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public int getTotalExpeditions() {
        return totalExpeditions;
    }

    public int getCurrentExpeditionNumber() {
        return currentExpeditionNumber;
    }

    public void advanceExpedition() {
        currentExpeditionNumber += 1;
    }

    public boolean checkGameOver() {
        return guild.mainParty.getMembers().isEmpty() && guild.reserveParty.getMembers().isEmpty();
    }

    public boolean checkGameWon() {
        return currentExpeditionNumber > totalExpeditions;
    }
}
