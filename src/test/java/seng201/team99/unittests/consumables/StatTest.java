package seng201.team99.unittests.consumables;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seng201.team99.stores.Stat;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test Stat implementation
 * @author Jonathan Voss
 */
class StatTest {
    private Stat baseStats;
    private Stat otherStats;

    /**
     * Setup before each test, we create two Objects; baseStats and
     * otherStats. Purposely given different stats to test the Stat
     * classes adding functions.
     */
    @BeforeEach
    public void setupTest() {
        this.baseStats = new Stat(
                1,3
        );

        this.otherStats = new Stat(
                2,4
        );
    }

    /**
     * Test adding stats together.
     */
    @Test
    public void testAdd() {
        assertEquals(1, baseStats.getStamina());
        assertEquals(3, baseStats.getPerception());

        Stat newStats = baseStats.add(otherStats);

        assertEquals(3, newStats.getStamina());
        assertEquals(7, newStats.getPerception());
    }

}
