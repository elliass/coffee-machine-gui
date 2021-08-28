package coffeemachine.controller;

import coffeemachine.model.CoffeeMachine;
import coffeemachine.model.drink.Drink;

public abstract class CoffeeMachineState {

    protected Drink drinkSelected;
    protected String operationSelected = "Cleaning";
    protected Drink favoriteDrink = null;
    protected String favoriteDrinkByName = null;
    protected int pointer = 0;

    public Drink getDrinkSelected() {
        return this.drinkSelected;
    };
    public void setDrinkSelected(Drink drinkSelected) {
        this.drinkSelected = drinkSelected;
    };
    public String getOperationSelected() {
        return this.operationSelected;
    };
    public String getStateName() {
        return this.getClass().getSimpleName();
    }

    public abstract void btn0Pressed(CoffeeMachine context);
    public abstract void btn1Pressed(CoffeeMachine context);
    public abstract void btn2Pressed(CoffeeMachine context);
    public abstract void btn3Pressed(CoffeeMachine context);
    public abstract void btn4Pressed(CoffeeMachine context);
    public abstract void btn5Pressed(CoffeeMachine context);
    public abstract void btn6Pressed(CoffeeMachine context);
    public abstract void btn7Pressed(CoffeeMachine context);
    public abstract void btn8Pressed(CoffeeMachine context);
    public abstract void btn9Pressed(CoffeeMachine context);
    public abstract void btn10Pressed(CoffeeMachine context);
    public abstract void btn11Pressed(CoffeeMachine context);
    public abstract void btn12Pressed(CoffeeMachine context);

    public abstract void selectDrink(Drink drink);
    public abstract void back();
    public abstract void ok();
    public abstract void openMenu();
    public abstract void callFavorite();
    public abstract void setMl();
    public abstract void setSt();
    public abstract void setDoubleCup();
    public abstract void refillWater();
    public abstract void refillCoffee();
    public abstract void refillMilk();
    public abstract void emptyTrash();
    public abstract void start();
}
