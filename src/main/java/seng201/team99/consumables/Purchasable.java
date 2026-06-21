package seng201.team99.consumables;

public abstract class Purchasable {
    private double cost;
    private final String description;

    public Purchasable(double cost, String description) {
        this.cost = cost;
        this.description = description;
    }

    public double getCost() {return cost;}
    public void setCost(double cost) { this.cost = cost; }

    public String getDescription() { return description; }
}
