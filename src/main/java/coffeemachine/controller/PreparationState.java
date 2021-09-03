package coffeemachine.controller;

import coffeemachine.model.CoffeeMachine;
import coffeemachine.model.PreparationSession;
import coffeemachine.model.drink.Drink;

public class PreparationState extends CoffeeMachineState {

    private CoffeeMachine context;



    public PreparationState(CoffeeMachine newContext) {
        this.context = newContext;
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
    public void selectDrink(Drink drink) {}

    @Override
    public void back() {
        context.setState(context.getIdleState());
        System.out.println("> Current context (from preparation) : " + context.currentState.getClass().getSimpleName());
    }

    @Override
    public void ok() {}

    @Override
    public void openMenu() {}

    @Override
    public void callFavorite() {}

    @Override
    public void setMl() {}

    @Override
    public void setSt() {}

    @Override
    public void setDoubleCup() {}

    @Override
    public void refillWater() {}

    @Override
    public void refillCoffee() {}

    @Override
    public void refillMilk() {}

    @Override
    public void emptyTrash() {}

    @Override
    public void start() { // = Stop
        PreparationSession ps = PreparationSession.getInstance();
        ps.stopPreparation();
        context.setState(context.getIdleState());
    }
}
