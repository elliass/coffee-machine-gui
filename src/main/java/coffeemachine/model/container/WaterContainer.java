package coffeemachine.model.container;

import coffeemachine.model.CoffeeMachine;
import coffeemachine.model.issue.Issue;
import coffeemachine.model.issue.WaterIssue;

public class WaterContainer extends Container {

    private int maxCapacity = 1000;       // in ml
    private int quantity;

    public WaterContainer() {
        quantity = maxCapacity;
    }

    @Override
    public int getQuantity() {
        return this.quantity;
    }

    @Override
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public void updateQuantity() {
        cm = CoffeeMachine.getInstance();
        int qty = cm.getState().getDrinkSelected().getWaterQuantity();
        this.quantity = this.quantity - qty;
    }

    @Override
    public void resetQuantity() {
        cm = CoffeeMachine.getInstance();
        int qty = cm.getIdleState().getDrinkSelected().getWaterQuantity();
        this.quantity = this.quantity + qty;
    }

    @Override
    public boolean isEmpty() { return this.quantity == 0; }

    @Override
    public void fill() {
        this.quantity = maxCapacity;
    }

    @Override
    public boolean check(){
        cm = CoffeeMachine.getInstance();
        if (quantity < cm.getState().getDrinkSelected().getWaterQuantity()) {
            Issue.getIssuesList().add(new WaterIssue());
            return false;
        } else {
            return true;
        }
    }
}
