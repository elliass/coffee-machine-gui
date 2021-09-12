package coffeemachine.controller;

import coffeemachine.model.*;
import coffeemachine.model.drink.BlackCoffee;
import coffeemachine.model.drink.Drink;
import coffeemachine.model.issue.Issue;
import coffeemachine.view.issue.IssueScreenPane;
import coffeemachine.view.maintenance.MaintenanceScreenPane;
import coffeemachine.view.overview.OverviewScreenPane;
import coffeemachine.view.preparation.PreparationScreenPane;

import static coffeemachine.model.Quantity.getQtyFromInt;
import static coffeemachine.model.Strength.getStrFromInt;

public class IdleState extends CoffeeMachineState {

    private CoffeeMachine context;
    private boolean hideContainersLabels;
    public PreparationSession ps = PreparationSession.getInstance();
    public FavoriteManager fm = FavoriteManager.getInstance();
    public MaintenanceScreenPane msp;
    public OverviewScreenPane osp;
    public PreparationScreenPane psp;
    public IssueScreenPane isp;

    public IdleState(CoffeeMachine newContext) {
        this.context = newContext;
        this.drinkSelected = new BlackCoffee();
        this.hideContainersLabels = true;
    }

    @Override
    public void btn0Pressed(CoffeeMachine context) {
        context.currentState.start();
        // update maintenance screen
        msp = MaintenanceScreenPane.getInstance();
        msp.resetScreen();
        // update issue screen
        if (context.currentState.getClass().getSimpleName().equals("IssueState")){
            isp = IssueScreenPane.getInstance();
            isp.resetScreen();
        }
        // update preparation screen
        psp = PreparationScreenPane.getInstance();
        psp.resetProgressBar();
    }

    @Override
    public void btn1Pressed(CoffeeMachine context) {
        osp = OverviewScreenPane.getInstance();
        if (hideContainersLabels) {
            osp.hideContainerDetails();
        } else {
            osp.showContainerDetails();
        }
        hideContainersLabels = !hideContainersLabels;
    }

    @Override
    public void btn2Pressed(CoffeeMachine context) {
        context.currentState.back();
    }

    @Override
    public void btn3Pressed(CoffeeMachine context) {
        context.currentState.setDoubleCup();
        osp = OverviewScreenPane.getInstance();
        psp = PreparationScreenPane.getInstance();
        drinkSelected = context.currentState.getDrinkSelected();
        if (drinkSelected.getDoubleCupStatus()) {
            osp.setDrinkSelectedLabel("2 " + drinkSelected.getName());
            psp.setDrinkSelectedLabel("2 " + drinkSelected.getName());
        } else {
            osp.setDrinkSelectedLabel(drinkSelected.getName());
            psp.setDrinkSelectedLabel(drinkSelected.getName());
        }
    }

    @Override
    public void btn4Pressed(CoffeeMachine context) {
        context.currentState.setSt();
        osp = OverviewScreenPane.getInstance();
        osp.setStrengthLabel(drinkSelected.getStrength().toString());
    }

    @Override
    public void btn5Pressed(CoffeeMachine context) {
        context.currentState.ok();
    }

    @Override
    public void btn6Pressed(CoffeeMachine context) {
        context.currentState.openMenu();
        msp = MaintenanceScreenPane.getInstance();
        msp.resetScreen();
    }

    @Override
    public void btn7Pressed(CoffeeMachine context) {
        context.currentState.setMl();
        osp = OverviewScreenPane.getInstance();
        osp.setQuantityLabel(drinkSelected.getQuantity().toString());
    }

    @Override
    public void btn8Pressed(CoffeeMachine context) {
        osp = OverviewScreenPane.getInstance();
        psp = PreparationScreenPane.getInstance();
        if (FavoriteManager.getFavoriteList().isEmpty()){
            osp.setDrinkSelectedLabel("No Drinks Found");
        } else {
            context.currentState.callFavorite();
            osp.setDrinkSelectedLabel(this.favoriteDrink.getName());
            psp.setDrinkSelectedLabel(this.favoriteDrink.getName());
        }
    }

    @Override
    public void btn9Pressed(CoffeeMachine context) {
        context.currentState.refillWater();
        osp = OverviewScreenPane.getInstance();
        int newQuantity = ps.waterContainer.getQuantity();
        osp.setWaterLabel(newQuantity);
    }

    @Override
    public void btn10Pressed(CoffeeMachine context) {
        context.currentState.refillCoffee();
        osp = OverviewScreenPane.getInstance();
        int newQuantity = ps.coffeeContainer.getQuantity();
        osp.setCoffeeLabel(newQuantity);
    }

    @Override
    public void btn11Pressed(CoffeeMachine context) {
        context.currentState.refillMilk();
        osp = OverviewScreenPane.getInstance();
        int newQuantity = ps.milkContainer.getQuantity();
        osp.setMilkLabel(newQuantity);
    }

    @Override
    public void btn12Pressed(CoffeeMachine context) {
        context.currentState.emptyTrash();
        osp = OverviewScreenPane.getInstance();
        int newQuantity = ps.trashContainer.getQuantity();
        osp.setTrashLabel(newQuantity);
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
