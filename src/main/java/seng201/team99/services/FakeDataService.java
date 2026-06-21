package seng201.team99.services;

import seng201.team99.items.*;
import seng201.team99.stores.Stat;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * A Service to create a range of fake data to populate custom
 * gui code. This should only be used in testing.
 *
 * @author Jonathan Voss
 */
public class FakeDataService {
    private final Random random = new Random();
    private final String[] ADJECTIVES = {"Ancient", "Mystic", "Rusty", "Glimmering", "Heavy", "Quick"};
    private final String[] NOUNS = {"Blade", "Amulet", "Scroll", "Boots", "Ring", "Shield"};

    private String generateName() {
        return ADJECTIVES[random.nextInt(ADJECTIVES.length)] + " " + NOUNS[random.nextInt(NOUNS.length)];
    }

    private Stat generateStats() {
        return new Stat(random.nextInt(20), random.nextInt(20),random.nextInt(20));
    }

    /**
     * Generates a list of random SkillItems.
     */
    public List<SkillItem> getFakeSkillItems(int count) {
        List<SkillItem> items = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            items.add(new SkillItem(generateName(), "A mysterious skill.", random.nextDouble() * 50, ItemType.TIMED, generateStats()));
        }
        return items;
    }

    /**
     * Generates a list of random UpgradeItems.
     */
    public List<UpgradeItem> getFakeUpgradeItems(int count) {
        List<UpgradeItem> items = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            items.add(new UpgradeItem(generateName(), "Increases your power.", random.nextDouble() * 100, ItemType.PERMANENT, generateStats()));
        }
        return items;
    }

    /**
     * Generates a list of random EquipmentItems.
     */
    public List<EquipmentItem> getFakeEquipmentItems(int count) {
        List<EquipmentItem> items = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            items.add(new EquipmentItem(generateName(), "Standard issue gear.", random.nextDouble() * 150, ItemType.EQUIPMENT, generateStats()));
        }
        return items;
    }
}
