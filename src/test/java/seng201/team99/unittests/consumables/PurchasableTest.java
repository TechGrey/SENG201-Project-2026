package seng201.team99.unittests.consumables;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import seng201.team99.consumables.Adventurer;
import seng201.team99.consumables.Purchasable;
import seng201.team99.items.EquipmentItem;
import seng201.team99.items.ItemType;
import seng201.team99.items.SkillItem;
import seng201.team99.items.UpgradeItem;
import seng201.team99.stores.Stat;


/**
 * Test Purchasable implementation
 * @author Jonathan Voss
 */
class PurchasableTest {
    private Adventurer baseAdventurer;
    private UpgradeItem baseUpgradeItem;

    @BeforeEach
    public void setupTest() {
        this.baseAdventurer = new Adventurer(
                "Crash Dummy",
                "He yearns to be thrown at movable objects",
                20,
                10,
                new Stat(7,1)
        );

        this.baseUpgradeItem = new UpgradeItem(
                "Laser Eye Surgery",
                "Increases the perception to your adventurer",
                6,
                ItemType.PERMANENT,
                new Stat(0,4)
        );
    }

    /**
     * Tests that both Adventurer and Item Types comply
     * with the purchasable type.
     */
    @ParameterizedTest
    @ValueSource(classes = {
            Purchasable.class,
            Adventurer.class,
            EquipmentItem.class,
            SkillItem.class,
            UpgradeItem.class,
    })
    public void testPurchasableType(Class<Purchasable> purchasable) {

    }
}
