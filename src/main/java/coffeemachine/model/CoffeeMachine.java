package coffeemachine.model;

import coffeemachine.controller.CoffeeMachineState;
import coffeemachine.controller.IdleState;


public class CoffeeMachine {

    private CoffeeMachineState idleState;
    public CoffeeMachineState currentState;

    private static CoffeeMachine instance = null;

    public CoffeeMachine() {
        idleState = new IdleState(this);
        this.currentState = idleState;
    }

    public static CoffeeMachine getInstance(){
        if (instance == null) {
            instance = new CoffeeMachine();
        }
        return instance;
    }

    public void setState(CoffeeMachineState newState) {
        this.currentState = newState;
    }
    public CoffeeMachineState getState() {
        return this.currentState;
    }
    public CoffeeMachineState getIdleState(){
        return this.idleState;
    }
}
