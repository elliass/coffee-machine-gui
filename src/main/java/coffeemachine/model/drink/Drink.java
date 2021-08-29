package coffeemachine.model.drink;

import coffeemachine.model.Quantity;
import coffeemachine.model.Strength;

public abstract class Drink {

    protected Quantity quantity = Quantity.MEDIUM;
    protected Strength strength = Strength.REGULAR;
    protected boolean doubleCup;

    public Quantity getQuantity() {
        return this.quantity;
    }
    public void setQuantity(Quantity quantity) {
        this.quantity = quantity;
    }
    public Strength getStrength() {
        return this.strength;
    }
    public void setStrength(Strength strength) {
        this.strength = strength;
    }
    public boolean getDoubleCupStatus() {
        return this.doubleCup;
    }
    public void setDoubleCupStatus() {
        this.doubleCup = !doubleCup;
    }

    public abstract String getName();
    public abstract int getCoffeeQuantity();
    public abstract int getWaterQuantity();
    public abstract int getMilkQuantity();
    public abstract int getFoamQuantity();
    public abstract int getTrashQuantity();
    public abstract String getIngredients();
}
