/**
 * @author Elliott Grey
 */

package seng201.team99.services.itemsLogic;

import seng201.team99.items.Item;
import seng201.team99.items.ItemType;
import seng201.team99.services.Difficulty;

public class ItemManagerService {
    public Item createWeapon(Difficulty difficulty) {
        return new ItemBuilder().createItem(ItemType.EQUIPMENT, difficulty);
    }

    public Item createPotion(Difficulty difficulty) {
        return new ItemBuilder().createItem(ItemType.UPGRADE, difficulty);
    }
}
