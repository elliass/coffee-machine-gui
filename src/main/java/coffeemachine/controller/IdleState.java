package coffeemachine.controller;

import coffeemachine.model.*;
import coffeemachine.model.drink.BlackCoffee;
import coffeemachine.model.drink.Drink;
import coffeemachine.model.issue.Issue;

import static coffeemachine.model.Quantity.getQtyFromInt;
import static coffeemachine.model.Strength.getStrFromInt;

public class IdleState extends CoffeeMachineState {

    private CoffeeMachine context;

    public PreparationSession ps = PreparationSession.getInstance();
    public FavoriteManager fm = FavoriteManager.getInstance();





    public IdleState(CoffeeMachine newContext) {
        this.context = newContext;
        this.drinkSelected = new BlackCoffee();

    }

    @Override
    public void btn0Pressed(CoffeeMachine context) {

    }

    @Override
    public void btn1Pressed(CoffeeMachine context) {

    }

    @Override
    public void btn2Pressed(CoffeeMachine context) {

    }

    @Override
    public void btn3Pressed(CoffeeMachine context) {

    }

    @Override
    public void btn4Pressed(CoffeeMachine context) {

    }

    @Override
    public void btn5Pressed(CoffeeMachine context) {

    }

    @Override
    public void btn6Pressed(CoffeeMachine context) {

    }

    @Override
    public void btn7Pressed(CoffeeMachine context) {

    }

    @Override
    public void btn8Pressed(CoffeeMachine context) {

    }

    @Override
    public void btn9Pressed(CoffeeMachine context) {

    }

    @Override
    public void btn10Pressed(CoffeeMachine context) {

    }

    @Override
    public void btn11Pressed(CoffeeMachine context) {

    }

    @Override
    public void btn12Pressed(CoffeeMachine context) {

    }

    @Override
    public void selectDrink(Drink drink) {
        this.drinkSelected = drink;
    }

    @Override
    public void back() {}

    @Override
    public void ok() {}

    @Override
    public void openMenu() {
        context.setState(context.getMaintenanceState());
    }

    @Override
    public void callFavorite() {
        if (pointer == FavoriteManager.getFavoriteList().size()) { pointer = 0;}
        this.favoriteDrink = FavoriteManager.getFavoriteDrink(pointer);
        this.favoriteDrinkByName = FavoriteManager.getFavoriteDrinkByName(pointer);
        context.currentState.setDrinkSelected(this.favoriteDrink);
        pointer++;
    }

    @Override
    public void setMl() {
        Quantity currentQty = this.drinkSelected.getQuantity();
        int value = currentQty.ordinal() + 1;
        Quantity newQty = getQtyFromInt(value);
        this.drinkSelected.setQuantity(newQty);
    }

    @Override
    public void setSt() {
        Strength currentStr = this.drinkSelected.getStrength();
        int value = currentStr.ordinal() + 1;
        Strength newStr = getStrFromInt(value);
        this.drinkSelected.setStrength(newStr);
    }

    @Override
    public void setDoubleCup() {
        this.drinkSelected.setDoubleCupStatus();
        System.out.println("> Double cups activated: " + drinkSelected.getDoubleCupStatus());
    }

    @Override
    public void refillWater() {
        ps.waterContainer.fill();
    }

    @Override
    public void refillCoffee() {
        ps.coffeeContainer.fill();
    }

    @Override
    public void refillMilk() {
        ps.milkContainer.fill();
    }

    @Override
    public void emptyTrash() {
        ps.trashContainer.fill();
    }

    @Override
    public void start(){
        PreparationSession ps = PreparationSession.getInstance();
        ps.startPreparation(drinkSelected);
        if (!Issue.getIssuesList().isEmpty()) {
            context.setState(context.getIssueState());
            System.out.println("> Current state (from idle) : " + context.currentState.getClass().getSimpleName());
        } else if (ps.getCupsLeft() < 0) {
            context.setState(context.getMaintenanceState());
            System.out.println("> Current state (from idle) : " + context.currentState.getClass().getSimpleName());
        } else {
            context.setState(context.getPreparationState());
            System.out.println("> Current state (from idle) : " + context.currentState.getClass().getSimpleName());
        }
    }
}
