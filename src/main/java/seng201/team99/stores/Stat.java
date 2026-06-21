package seng201.team99.stores;

public class Stat {
    private final Integer stamina;
    private final Integer perception;
    private final Integer dexterity;

    public Integer getStamina() { return stamina; }
    public Integer getPerception() { return perception; }
    public Integer getDexterity() { return dexterity; }

    public Stat() {
        this.stamina = 0;
        this.perception = 0;
        this.dexterity = 0;
    }

    public Stat(Integer stamina, Integer perception, Integer dexterity) {
        this.stamina = stamina;
        this.perception = perception;
        this.dexterity = dexterity;
    }

    public Stat add(Stat other) {
        return new Stat(
                this.stamina+other.getStamina(),
                this.perception+other.getPerception(),
                this.dexterity+other.getDexterity()
        );
    }

    @Override
    public String toString() {
        // Return a human-readable representation of the object's data
        return "Stamina: " + stamina + " Perception: " + perception + " Dexterity: " + dexterity;
    }
}