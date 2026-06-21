package seng201.team99.consumables;

import seng201.team99.items.Item;
import seng201.team99.services.Effect;
import seng201.team99.stores.Stat;

public class Adventurer extends Purchasable {
    public String name;
    public double pay;
    public Effect currentEffect;

    private final Stat baseStats;
    private Stat bonusStats;
    private Stat temporaryStats;

    public Adventurer(
            String name,
            String description,
            double cost,
            double pay,
            Stat baseStats
    ) {
        super(cost, description);

        this.name = name;
        this.pay = pay;
        this.baseStats = baseStats;
        this.bonusStats = new Stat();
        this.temporaryStats = new Stat();
    }

    public Stat getStats() {
        return baseStats.add(bonusStats).add(temporaryStats);
    }

    public void applyStats(Stat stats) {
        bonusStats = bonusStats.add(stats);
    }

    public boolean ifHasEffect() {
        return currentEffect != null;
    }

    public void applyEffect(Effect effect) {
        this.currentEffect = effect;
        this.temporaryStats = temporaryStats.add(effect.getNewStatModifier());
    }

    public boolean isExhausted() {
        return this.getStats().getStamina() <= 0;
    }
}
