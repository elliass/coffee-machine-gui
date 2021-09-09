package coffeemachine.controller;

import coffeemachine.model.CoffeeMachine;
import coffeemachine.model.Maintenance;
import coffeemachine.model.PreparationSession;
import coffeemachine.model.drink.Drink;
import coffeemachine.view.maintenance.MaintenanceScreenPane;
import coffeemachine.view.overview.OverviewScreenPane;

public class MaintenanceState extends CoffeeMachineState {

    private CoffeeMachine context;
    private Maintenance m;
    private int pointer;
    private int maxCupsLeft = 5;

    public PreparationSession ps = PreparationSession.getInstance();
    public MaintenanceScreenPane msp;
    public OverviewScreenPane osp;


    public MaintenanceState(CoffeeMachine newContext) {
        this.context = newContext;
        m = new Maintenance();
    }

    @Override
    public void btn0Pressed(CoffeeMachine context) {
        context.currentState.start();
    }

    @Override
    public void btn1Pressed(CoffeeMachine context) {
    }

    @Override
    public void btn2Pressed(CoffeeMachine context) {
        // update maintenance screen when leaving current state
        msp = MaintenanceScreenPane.getInstance();
        msp.setMessageTxt("Please perform service operation first");

        // update containers details
        osp = OverviewScreenPane.getInstance();
        osp.resetQuantity();
        context.currentState.back();
    }

    @Override
    public void btn3Pressed(CoffeeMachine context) {
        context.currentState.setDoubleCup();
    }

    @Override
    public void btn4Pressed(CoffeeMachine context) {
        context.currentState.setSt();
    }

    @Override
    public void btn5Pressed(CoffeeMachine context) {
        // update maintenance screen when executing operation
        msp = MaintenanceScreenPane.getInstance();
        msp.setMessageTxt("Press BACK to prepare new drink");
        msp.setOperationSelectedLabel(operationSelected + " Performed");
        context.currentState.ok();
    }

    @Override
    public void btn6Pressed(CoffeeMachine context) {
        // update maintenance screen when selecting operation
        context.currentState.openMenu();
        msp = MaintenanceScreenPane.getInstance();
        msp.setOperationSelectedLabel(operationSelected);
        msp.setMessageTxt("Press OK to start service operation");
    }

    @Override
    public void btn7Pressed(CoffeeMachine context) {
        context.currentState.setMl();
    }

    @Override
    public void btn8Pressed(CoffeeMachine context) {
        context.currentState.callFavorite();
    }

    @Override
    public void btn9Pressed(CoffeeMachine context) {
        context.currentState.refillWater();
    }

    @Override
    public void btn10Pressed(CoffeeMachine context) {
        context.currentState.refillCoffee();
    }

    @Override
    public void btn11Pressed(CoffeeMachine context) {
        context.currentState.refillMilk();
    }

    @Override
    public void btn12Pressed(CoffeeMachine context) {
        context.currentState.emptyTrash();
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
