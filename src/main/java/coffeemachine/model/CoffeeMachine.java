package coffeemachine.model;

import coffeemachine.controller.*;


public class CoffeeMachine {

    private CoffeeMachineState idleState;
    public CoffeeMachineState currentState;
    private CoffeeMachineState preparationState;
    private CoffeeMachineState maintenanceState;
    private CoffeeMachineState issueState;

    private static CoffeeMachine instance = null;

    public CoffeeMachine() {
        idleState = new IdleState(this);
        this.currentState = idleState;
        preparationState = new PreparationState(this);
        maintenanceState = new MaintenanceState(this);
        issueState = new IssueState(this);
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
    public CoffeeMachineState getPreparationState(){
        return this.preparationState;
    }
    public CoffeeMachineState getMaintenanceState(){
        return this.maintenanceState;
    }
    public CoffeeMachineState getIssueState(){
        return this.issueState;
    }
}
