package coffeemachine.model.container;

import coffeemachine.model.CoffeeMachine;
import coffeemachine.model.issue.Issue;
import coffeemachine.model.issue.TrashIssue;

public class TrashContainer extends Container {

    private int maxCapacity = 0;
    private int quantity;

    public TrashContainer() {
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
        int qty = cm.getState().getDrinkSelected().getTrashQuantity();
        this.quantity = this.quantity + qty;
    }

    @Override
    public void resetQuantity() {
        cm = CoffeeMachine.getInstance();
        int qty = cm.getIdleState().getDrinkSelected().getTrashQuantity();
        this.quantity = this.quantity - qty;
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
        if (quantity > 5) {
            Issue.getIssuesList().add(new TrashIssue());
            return false;
        } else {
            return true;
        }
    }
}
