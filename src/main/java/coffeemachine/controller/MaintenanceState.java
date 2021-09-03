package coffeemachine.controller;

import coffeemachine.model.CoffeeMachine;
import coffeemachine.model.Maintenance;
import coffeemachine.model.PreparationSession;
import coffeemachine.model.drink.Drink;

public class MaintenanceState extends CoffeeMachineState {

    private CoffeeMachine context;
    private Maintenance m;
    private int pointer;
    private int maxCupsLeft = 5;

    public PreparationSession ps = PreparationSession.getInstance();



    public MaintenanceState(CoffeeMachine newContext) {
        this.context = newContext;
        m = new Maintenance();
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
        if (ps.getCupsLeft() > 0) {
            context.setState(context.getIdleState());
            System.out.println("> Current state (from maintenance) : " + context.currentState.getClass().getSimpleName());
        }
    }

    @Override
    public void ok() {
        m.startOperation();
        ps.setCupsLeft(maxCupsLeft);
    }

    @Override
    public void openMenu() {
        if (pointer == m.getOperations().length) { pointer = 0;}
        this.operationSelected = m.getOperation(pointer);
        m.setSelectedOperation(operationSelected);
        pointer++;
    }

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
    public void start() {}

}
