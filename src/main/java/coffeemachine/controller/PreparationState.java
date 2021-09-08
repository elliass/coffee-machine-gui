package coffeemachine.controller;

import coffeemachine.model.CoffeeMachine;
import coffeemachine.model.PreparationSession;
import coffeemachine.model.drink.Drink;
import coffeemachine.view.overview.OverviewScreenPane;
import coffeemachine.view.preparation.PreparationScreenPane;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class PreparationState extends CoffeeMachineState {

    private CoffeeMachine context;
    public PreparationSession ps = PreparationSession.getInstance();
    public OverviewScreenPane os;

    public PreparationState(CoffeeMachine newContext) {
        this.context = newContext;
    }

    @Override
    public void btn0Pressed(CoffeeMachine context) {
        context.currentState.start();
    }

    @Override
    public void btn1Pressed(CoffeeMachine context) {
        // update progress bar to show progression
        PreparationScreenPane psp = PreparationScreenPane.getInstance();
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.millis(300),
                        event -> psp.increaseProgressBar()));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    @Override
    public void btn2Pressed(CoffeeMachine context) {
        // update containers details (quantity)
        os = OverviewScreenPane.getInstance();
        os.resetQuantity();
        context.currentState.back();
    }

    @Override
    public void btn3Pressed(CoffeeMachine context) { context.currentState.setDoubleCup(); }

    @Override
    public void btn4Pressed(CoffeeMachine context) { context.currentState.setSt(); }

    @Override
    public void btn5Pressed(CoffeeMachine context) {
        context.currentState.ok();
    }

    @Override
    public void btn6Pressed(CoffeeMachine context) {
        context.currentState.openMenu();
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
