package coffeemachine.view.overview;

import coffeemachine.model.CoffeeMachine;
import coffeemachine.model.PreparationSession;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class OverviewScreenPane extends VBox {

    CoffeeMachine cm = CoffeeMachine.getInstance();

    private Label drinkSelectedLabel = null;
    private Label strengthLabel = null;
    private Label quantityLabel = null;

    private Label waterLabel = null;
    private Label coffeeLabel = null;
    private Label milkLabel = null;
    private Label trashLabel = null;
    private Label cupsLeftLabel = null;

    HBox screenRow1 = new HBox();
    HBox screenRow2 = new HBox();
    HBox screenRow3 = new HBox();

    private String drinkSelectedTxt = cm.currentState.getDrinkSelected().getName();
    private String strengthTxt = cm.currentState.getDrinkSelected().getStrength().toString();
    private String quantityTxt = cm.currentState.getDrinkSelected().getQuantity().toString();

    PreparationSession ps = PreparationSession.getInstance();
    private static OverviewScreenPane instance = null;

    private OverviewScreenPane() {
        initScreen();
    }

    public void initScreen() {
        screenRow1.getChildren().addAll(getDrinkSelectedLabel());
        screenRow2.getChildren().addAll(getStrengthLabel(), getQuantityLabel());
        screenRow3.getChildren().addAll(getWaterLabel(), getCoffeeLabel(), getMilkLabel(), getTrashLabel(), getCupsLeftLabel());
        screenRow1.setAlignment(Pos.TOP_CENTER);
        screenRow2.setAlignment(Pos.BOTTOM_CENTER);
        screenRow2.setSpacing(150);
        this.getChildren().addAll(screenRow3, screenRow1, screenRow2);
        this.setSpacing(10);
        this.getStyleClass().add("center-pane");
        this.setAlignment(Pos.CENTER);
        this.setMinHeight(130);
    }

    public static OverviewScreenPane getInstance(){
        if (instance == null){
            instance = new OverviewScreenPane();
        }
        return instance;
    }

    public Label getDrinkSelectedLabel() {
        if (drinkSelectedLabel == null) {
            drinkSelectedLabel = new Label("Default");
            drinkSelectedLabel.setText(drinkSelectedTxt);
            drinkSelectedLabel.getStyleClass().add("drink-selected");
        }
        return drinkSelectedLabel;
    }

    public void setDrinkSelectedLabel(String drinkSelected) {
        this.drinkSelectedLabel.setText(drinkSelected);
    }

    public Label getStrengthLabel() {
        if (strengthLabel == null) {
            strengthLabel = new Label ("Default");
            strengthLabel.setText(strengthTxt);
        }
        return strengthLabel;
    }

    public void setStrengthLabel(String strength) {
        this.strengthLabel.setText(strength);
    }

    public Label getQuantityLabel() {
        if (quantityLabel == null) {
            quantityLabel = new Label ("Default");
            quantityLabel.setText(quantityTxt);
        }
        return quantityLabel;
    }

    public void setQuantityLabel(String quantity) {
        this.quantityLabel.setText(quantity);
    }

    public Label getWaterLabel() {
        if (waterLabel == null) {
            waterLabel = new Label();
            waterLabel.getStyleClass().add("container");
            int waterQuantity = ps.waterContainer.getQuantity();
            setWaterLabel(waterQuantity);
        }
        return waterLabel;
    }

    public void setWaterLabel(int quantity) {
        this.waterLabel.setText("Water: " + quantity);
    }

    public Label getCoffeeLabel() {
        if (coffeeLabel == null) {
            coffeeLabel = new Label();
            coffeeLabel.getStyleClass().add("container");
            int coffeeQuantity = ps.coffeeContainer.getQuantity();
            setCoffeeLabel(coffeeQuantity);
        }
        return coffeeLabel;
    }

    public void setCoffeeLabel(int quantity) {
        this.coffeeLabel.setText("Coffee: " + quantity);
    }

    public Label getMilkLabel() {
        if (milkLabel == null) {
            milkLabel = new Label();
            milkLabel.getStyleClass().add("container");
            int milkQuantity = ps.milkContainer.getQuantity();
            setMilkLabel(milkQuantity);
        }
        return milkLabel;
    }

    public void setMilkLabel(int quantity) {
        this.milkLabel.setText("Milk: " + quantity);
    }

    public Label getTrashLabel() {
        if (trashLabel == null) {
            trashLabel = new Label();
            trashLabel.getStyleClass().add("container");
            int trashQuantity = ps.trashContainer.getQuantity();
            setTrashLabel(trashQuantity);
        }
        return trashLabel;
    }

    public void setTrashLabel(int quantity) {
        this.trashLabel.setText("Trash: " + quantity);
    }

    public Label getCupsLeftLabel() {
        if (cupsLeftLabel == null) {
            cupsLeftLabel = new Label();
            cupsLeftLabel.getStyleClass().add("container");
            int cupsLeftQuantity = ps.getCupsLeft();
            setCupsLeftLabel(cupsLeftQuantity);
        }
        return cupsLeftLabel;
    }

    public void setCupsLeftLabel(int quantity) {
        this.cupsLeftLabel.setText("Cups Left: " + quantity);
    }

    public void resetQuantity() {
        setWaterLabel(ps.waterContainer.getQuantity());
        setCoffeeLabel(ps.coffeeContainer.getQuantity());
        setMilkLabel(ps.milkContainer.getQuantity());
        setTrashLabel(ps.trashContainer.getQuantity());
        setCupsLeftLabel(ps.getCupsLeft());
    }

    public void hideContainerDetails() {
        this.getChildren().remove(screenRow3);
    }

    public void showContainerDetails() {
        this.getChildren().add(0, screenRow3);
    }
}
