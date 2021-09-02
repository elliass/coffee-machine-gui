package coffeemachine.model;

import coffeemachine.model.container.CoffeeContainer;
import coffeemachine.model.container.MilkContainer;
import coffeemachine.model.container.TrashContainer;
import coffeemachine.model.container.WaterContainer;
import coffeemachine.model.drink.Drink;
import coffeemachine.model.issue.Issue;


public class PreparationSession {

    public CoffeeContainer coffeeContainer;
    public WaterContainer waterContainer;
    public MilkContainer milkContainer;
    public TrashContainer trashContainer;
    public int cupsLeft = 2;

    private static PreparationSession instance = null;

    private PreparationSession() {
        this.coffeeContainer = new CoffeeContainer();
        this.waterContainer = new WaterContainer();
        this.milkContainer = new MilkContainer();
        this.trashContainer = new TrashContainer();
    }

    public static PreparationSession getInstance(){
        if (instance == null) {
            instance = new PreparationSession();
        }
        return instance;
    }

    public boolean checkIngredients() {
        coffeeContainer.check();
        waterContainer.check();
        milkContainer.check();
        trashContainer.check();
        return Issue.getIssuesList().isEmpty();
    }

    public void makeCoffee() {
        updateContainers();
        setCupsLeft(this.cupsLeft - 1);
    }

    public void startPreparation(Drink drinkSelected) {
        if (checkIngredients()) {
            if (cupsLeft > 0) {
                makeCoffee();
                endSession();
            } else {
                setCupsLeft(this.cupsLeft - 1);
            }
        }
    }

    public void stopPreparation() {
        setCupsLeft(this.cupsLeft + 1);
        coffeeContainer.resetQuantity();
        waterContainer.resetQuantity();
        milkContainer.resetQuantity();
        trashContainer.resetQuantity();
    }

    public void endSession() {
    }

    public void updateContainers() {
        coffeeContainer.updateQuantity();
        waterContainer.updateQuantity();
        milkContainer.updateQuantity();
        trashContainer.updateQuantity();
    }

    public int getCupsLeft() {
        return this.cupsLeft;
    }

    public void setCupsLeft(int cupsLeft) {
        this.cupsLeft = cupsLeft;
    }
}
