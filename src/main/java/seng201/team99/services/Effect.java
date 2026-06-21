package seng201.team99.services;

// A class that allows players to have an effect added to them when they complete quests.

import seng201.team99.stores.Stat;

import java.util.List;

public abstract class Effect {

    private final String name;
    private final String description;
    private final Stat newStatModifier;

    public Effect(String name, String description, Stat newStatModifier) {
        this.name = name;
        this.description = description;
        this.newStatModifier = newStatModifier;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Stat getNewStatModifier() {
        return newStatModifier;
    }

    public Stat setNewStatModifiers(int stamina, int perception, int dexterity) {
        return new Stat(stamina, perception, dexterity);
    }
}
