package coffeemachine.model.container;

import coffeemachine.model.CoffeeMachine;


public abstract class Container {

    protected static CoffeeMachine cm = CoffeeMachine.getInstance();

    protected abstract int getQuantity();
    protected abstract void setQuantity(int quantity);
    protected abstract void updateQuantity();
    protected abstract void resetQuantity();
    protected abstract boolean isEmpty();
    protected abstract void fill();
    protected abstract boolean check();
}
