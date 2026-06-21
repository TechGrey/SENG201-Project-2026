package seng201.team99.services.itemsLogic;
import seng201.team99.items.EquipmentItem;
import seng201.team99.items.Item;
import seng201.team99.items.ItemType;
import seng201.team99.items.UpgradeItem;
import seng201.team99.services.*;
import seng201.team99.stores.Stat;

import java.util.Map;
import java.util.Random;

public class ItemBuilder {
    // Defining a random variable for the function to see.
    Random statChance = new Random();

    // Defining three Maps to use as the foundation for Item making.
    Map<Integer, String> weaponPrefixes = Map.of(
            1, "Flaming",
            2, "Frosty",
            3, "Sharp",
            4, "Magical",
            5, "Powerful",
            6, "Sacrificial",
            7, "Intergenerational",
            8, "Single-Handed"
    );
    Map<Integer, String> weaponSuffixes = Map.of(
            1, "Warhammer",
            2, "Crossbow",
            3, "Greataxe",
            4, "Greatsword",
            5, "Longbow"
    );

    Map<String, String> weaponDescriptions = Map.of(
            "Flaming", "The item glows with the light of a fire that lasted 500 years.",
            "Frosty","Once encased with ice, the item is cold to the touch and emanates a blue glow.",
            "Sharp", "No wall is too thick for this weapon.",
            "Magical", "Handed to the humans by the Elves of Wordour in 2156 BC, this weapon is as agile in battle as it is in intelligence.",
            "Powerful", "No muscles? No worries. With this weapon, strength is no object.",
            "Sacrificial", "Used in The Great Holy War of 500 BC against the Gnomes, this weapon is sacred with the blood of a thousand slain soldiers.",
            "Intergenerational", "Family blood is a plenty in this weapon. You now have a chance to pick up where your father left off.",
            "Single-Handed", "Easy to wield and easy to holster."
    );

    Map<Integer, Potion> potions = Map.of(
            1, new Potion("Flame", "Let 'em burn.", new Stat(10, 0, 0)),
            2, new Potion("Frost", "More frozen than the alps.", new Stat(10, 0, 3))
    );

    public Item createItem(ItemType type, Difficulty difficulty) {
        if (type == ItemType.EQUIPMENT) {
            return buildEquipmentItem(difficulty);
        } else {
            return buildUpgradeItem(difficulty);
        }
    }

    public EquipmentItem buildEquipmentItem(Difficulty difficulty) {
        int prefixNumber = statChance.nextInt(1, weaponPrefixes.size() + 1);
        int suffixNumber = statChance.nextInt(1, weaponPrefixes.size() + 1);

        String equipmentPrefixString = weaponPrefixes.get(prefixNumber);
        String equipmentSuffixString = weaponSuffixes.get(suffixNumber);
        String fullEquipmentName = equipmentPrefixString + " " + equipmentSuffixString;
        String equipmentDescription = weaponDescriptions.get(equipmentPrefixString);

        double cost = difficulty.getLevel()*5.0;

        return new EquipmentItem(
                fullEquipmentName,
                equipmentDescription,
                cost,
                ItemType.EQUIPMENT,
                // TODO
                new Stat()
        );
    }

    public UpgradeItem buildUpgradeItem(Difficulty difficulty) {
        int potionNumber = statChance.nextInt(1, potions.size()+1);
        Potion potionData = potions.get(potionNumber);

        double cost = difficulty.getLevel()*3.0;
        return new UpgradeItem(potionData.name(),
                potionData.description(),
                cost,
                ItemType.UPGRADE,
                potionData.modifiers()
                );
    }
}
