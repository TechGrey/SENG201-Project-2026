package seng201.team99.services;


/*
An enumeration to keep track of the Event difficulty and scale the game accordingly.
 */
public enum Difficulty {
    EASY(0.5, 1),
    NORMAL(1.0, 2),
    HARD(2, 3),
    BRUTAL(3, 4),
    EXPERT(4, 5);

    private final double statModifier;
    private final int level;

    Difficulty(double statModifier, int level) {
        this.statModifier = statModifier;
        this.level = level;
    }

    public double getStatModifier() {
        return statModifier;
    }

    public int getLevel() {
        return level;
    }

//    @Override
//    public String toString() {
//        return name().charAt(0) + name().substring(1).toLowerCase();
//    }
}

