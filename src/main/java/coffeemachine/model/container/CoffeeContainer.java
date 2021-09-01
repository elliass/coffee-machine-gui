package coffeemachine.model.container;

import coffeemachine.model.CoffeeMachine;
import coffeemachine.model.issue.CoffeeIssue;
import coffeemachine.model.issue.Issue;


public class CoffeeContainer extends Container {

    private int maxCapacity = 20;
    private int quantity;

    public CoffeeContainer() {
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
        int qty = cm.getState().getDrinkSelected().getCoffeeQuantity();
        this.quantity = this.quantity - qty;
    }

    @Override
    public void resetQuantity() {
        cm = CoffeeMachine.getInstance();
        int qty = cm.getIdleState().getDrinkSelected().getCoffeeQuantity();
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
        if (quantity < cm.getState().getDrinkSelected().getCoffeeQuantity()) {
            Issue.getIssuesList().add(new CoffeeIssue());
            return false;
        } else {
            return true;
        }
    }
}
