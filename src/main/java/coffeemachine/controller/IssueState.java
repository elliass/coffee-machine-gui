package coffeemachine.controller;

import coffeemachine.model.CoffeeMachine;
import coffeemachine.model.PreparationSession;
import coffeemachine.model.drink.Drink;
import coffeemachine.model.issue.*;
import coffeemachine.view.issue.IssueScreenPane;
import coffeemachine.view.overview.OverviewScreenPane;


public class IssueState extends CoffeeMachineState {

    private CoffeeMachine context;
    public PreparationSession ps = PreparationSession.getInstance();
    public OverviewScreenPane os;
    public IssueScreenPane is;

    public IssueState(CoffeeMachine newContext) {
        this.context = newContext;
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
        context.currentState.back();
        // update screen info when leaving issue state
        if (!Issue.getIssuesList().isEmpty()) {
            is = IssueScreenPane.getInstance();
            is.setIssueSelectedLabel(is.getIssueSelectedTxt());
            is.setMessageTxt("Please solve all issues first");
        }
        // reset containers details
        os = OverviewScreenPane.getInstance();
        os.resetQuantity();
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

    public void updateScreen(Issue issue) {
        is = IssueScreenPane.getInstance();
        // update screen info when external event happens
        is.setIssueSelectedLabel(issue.getName() + " Solved");
        if (is.getIssueSelectedTxt().equals(issue.getName())) {
            is.setMessageTxt("Press BACK to prepare new drink");
        } else {
            is.setMessageTxt("Please solve " + is.getIssueSelectedTxt());
        }
    }

    @Override
    public void btn9Pressed(CoffeeMachine context) {
        updateScreen(new WaterIssue());
        context.currentState.refillWater();
        System.out.println("> Water Refilled");
    }

    @Override
    public void btn10Pressed(CoffeeMachine context) {
        updateScreen(new CoffeeIssue());
        context.currentState.refillCoffee();
        System.out.println("> Coffee Refilled");
    }

    @Override
    public void btn11Pressed(CoffeeMachine context) {
        updateScreen(new MilkIssue());
        context.currentState.refillMilk();
        System.out.println("> Milk Refilled");
    }

    @Override
    public void btn12Pressed(CoffeeMachine context) {
        updateScreen(new TrashIssue());
        context.currentState.emptyTrash();
        System.out.println("> Trash Emptied");
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
