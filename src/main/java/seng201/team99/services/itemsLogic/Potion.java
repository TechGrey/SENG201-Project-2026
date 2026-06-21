package seng201.team99.services.itemsLogic;

import seng201.team99.stores.Stat;

public record Potion(
        String name,
        String description,
        Stat modifiers
) {
    public Potion(String name, String description, Stat modifiers) {
        this.name = name;
        this.description = description;
        this.modifiers = modifiers;
    }
}