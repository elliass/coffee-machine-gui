package coffeemachine.controller;

import coffeemachine.model.CoffeeMachine;
import coffeemachine.model.PreparationSession;
import coffeemachine.model.drink.Drink;
import coffeemachine.model.issue.Issue;


public class IssueState extends CoffeeMachineState {

    private CoffeeMachine context;
    public PreparationSession ps = PreparationSession.getInstance();



    public IssueState(CoffeeMachine newContext) {
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
        if (Issue.getIssuesList().isEmpty()) {
            context.setState(context.getIdleState());
            System.out.println("> Current state (from idle) : " + context.currentState.getClass().getSimpleName());
        }
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

    public void solveIssueTest(String issueName) {
        PreparationSession ps = PreparationSession.getInstance();
        Issue.getIssuesList().forEach(i -> {
            if (i.getName().equals("WaterIssue")){
                ps.waterContainer.fill();
                i.setStatus(true);
            }
            if (i.getName().equals("CoffeeIssue")){
                ps.coffeeContainer.fill();
                i.setStatus(true);
            }
            if (i.getName().equals("MilkIssue")){
                ps.milkContainer.fill();
                i.setStatus(true);
            }
            if (i.getName().equals("TrashIssue")){
                ps.trashContainer.fill();
                i.setStatus(true);
            }
        });
        Issue.removeIssue(issueName);
    }

    @Override
    public void refillWater() {
        solveIssueTest("WaterIssue");
    }

    @Override
    public void refillCoffee() {
        solveIssueTest("CoffeeIssue");
    }

    @Override
    public void refillMilk() {
        solveIssueTest("MilkIssue");
    }

    @Override
    public void emptyTrash() {
        solveIssueTest("TrashIssue");
    }

    @Override
    public void start() {}

}
