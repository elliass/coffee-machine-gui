package coffeemachine.view;

import coffeemachine.model.CoffeeMachine;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;


public class BottomPane extends HBox {

    CoffeeMachine cm = CoffeeMachine.getInstance();

    private ButtonPanel refillWater = null;
    private ButtonPanel refillCoffee = null;
    private ButtonPanel refillMilk = null;
    private ButtonPanel emptyTrash = null;

    public BottomPane() {
        initPane();
    }

    public void initPane() {
        this.getChildren().addAll(getRefillWater(), getRefillCoffee(), getRefillMilk(), getEmptyTrash());
        this.getStyleClass().add("bottom-pane");
        this.setPrefHeight(50);
        this.setAlignment(Pos.CENTER);
    }

    public ButtonPanel getRefillWater() {
        if (refillWater == null) {
            refillWater = new ButtonPanel("Refill Water", "bottom-btn");
            refillWater.setOnAction(e -> {
                cm.currentState.btn9Pressed(cm);
            });
        }
        return refillWater;
    }

    public ButtonPanel getRefillCoffee() {
        if (refillCoffee == null) {
            refillCoffee = new ButtonPanel("Refill Coffee", "bottom-btn");
            refillCoffee.setOnAction(e -> {
                cm.currentState.btn10Pressed(cm);
            });
        }
        return refillCoffee;
    }

    public ButtonPanel getRefillMilk() {
        if (refillMilk == null) {
            refillMilk = new ButtonPanel("Refill Milk", "bottom-btn");
            refillMilk.setOnAction(e -> {
                cm.currentState.btn11Pressed(cm);
            });
        }
        return refillMilk;
    }

    public ButtonPanel getEmptyTrash() {
        if (emptyTrash == null) {
            emptyTrash = new ButtonPanel("Empty Trash", "bottom-btn");
            emptyTrash.setOnAction(e -> {
                cm.currentState.btn12Pressed(cm);
            });
        }
        return emptyTrash;
    }

    public void disableAllBtn() {
        getRefillWater().setDisable(true);
        getRefillCoffee().setDisable(true);
        getRefillMilk().setDisable(true);
        getEmptyTrash().setDisable(true);
    }

}
