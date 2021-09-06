package coffeemachine.view;

import coffeemachine.model.CoffeeMachine;
import coffeemachine.model.drink.*;
import javafx.geometry.Pos;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import java.util.ArrayList;
import static coffeemachine.view.ButtonPanel.createDrinkView;

public class TopPane extends HBox {

    CoffeeMachine cm = CoffeeMachine.getInstance();

    private Espresso espresso = new Espresso();
    private EspressoMacchiato espressoMacchiato = new EspressoMacchiato();
    private BlackCoffee blackCoffee = new BlackCoffee();
    private Cappuccino cappuccino = new Cappuccino();
    private LatteMacchiato latteMacchiato = new LatteMacchiato();
    private MilkCoffee milkCoffee = new MilkCoffee();

    private ButtonPanel espressoBtn = null;
    private ButtonPanel espressoMacchiatoBtn = null;
    private ButtonPanel coffeeBtn = null;
    private ButtonPanel cappuccinoBtn = null;
    private ButtonPanel latteMacchiatoBtn = null;
    private ButtonPanel latteBtn = null;
    private ButtonPanel btn0 = null;

    private Tooltip tooltip = new Tooltip();
    private Drink drinkSelected;


    public TopPane() {
        initPane();
    }

    public void initPane() {
        this.getChildren().addAll(getEspressoBtn(), getEspressoMacchiatoBtn(), getCoffeeBtn(), getCappuccinoBtn(),
                getLatteMacchiatoBtn(), getLatteBtn(), getBtn0());
        this.setPrefHeight(100);
        this.setAlignment(Pos.CENTER);
    }

    public ButtonPanel getEspressoBtn() {
        if (espressoBtn == null) {
            ImageView espr = createDrinkView("espresso");
            espressoBtn = new ButtonPanel("", espr, "top-btn");
            addAction(espressoBtn, espresso);
            addTooltip(espressoBtn, espresso);
        }
        return espressoBtn;
    }

    public ButtonPanel getEspressoMacchiatoBtn() {
        if (espressoMacchiatoBtn == null) {
            ImageView esprM = createDrinkView("macchiato");
            espressoMacchiatoBtn = new ButtonPanel("", esprM, "top-btn");
            addAction(espressoMacchiatoBtn, espressoMacchiato);
            addTooltip(espressoMacchiatoBtn, espressoMacchiato);
        }
        return espressoMacchiatoBtn;
    }

    public ButtonPanel getCoffeeBtn() {
        if (coffeeBtn == null) {
            ImageView cof = createDrinkView("coffee");
            coffeeBtn = new ButtonPanel("", cof, "top-btn");
            addAction(coffeeBtn, blackCoffee);
            addTooltip(coffeeBtn, blackCoffee);
        }
        return coffeeBtn;
    }

    public ButtonPanel getCappuccinoBtn() {
        if (cappuccinoBtn == null) {
            ImageView cap = createDrinkView("cappuccino");
            cappuccinoBtn = new ButtonPanel("", cap, "top-btn");
            addAction(cappuccinoBtn, cappuccino);
            addTooltip(cappuccinoBtn, cappuccino);
        }
        return cappuccinoBtn;
    }

    public ButtonPanel getLatteMacchiatoBtn() {
        if (latteMacchiatoBtn == null) {
            ImageView latteM = createDrinkView("latte-macchiato");
            latteMacchiatoBtn = new ButtonPanel("", latteM, "top-btn");
            addAction(latteMacchiatoBtn, latteMacchiato);
            addTooltip(latteMacchiatoBtn, latteMacchiato);
        }
        return latteMacchiatoBtn;
    }

    public ButtonPanel getLatteBtn() {
        if (latteBtn == null) {
            ImageView latte = createDrinkView("latte");
            latteBtn = new ButtonPanel("", latte, "top-btn");
            addAction(latteBtn, milkCoffee);
            addTooltip(latteBtn, milkCoffee);
        }
        return latteBtn;
    }

    public ButtonPanel getBtn0() {
        if (btn0 == null) {
            btn0  = new ButtonPanel("start\nstop", "top-btn");
            btn0.getStyleClass().add("start-stop");
            btn0.setOnAction(e -> {
                cm.currentState.btn0Pressed(cm);
                if (cm.currentState.getClass().getSimpleName().equals("IssueState")) {
                    fireEvent(new CustomEvent(CustomEvent.GO_TO_ISSUE_SCENE));
                }
                if (cm.currentState.getClass().getSimpleName().equals("MaintenanceState")) {
                    fireEvent(new CustomEvent(CustomEvent.GO_TO_MAINTENANCE_SCENE));
                }
                if (cm.currentState.getClass().getSimpleName().equals("IdleState")) {
                    fireEvent(new CustomEvent(CustomEvent.GO_TO_OVERVIEW_SCENE));
                }
                if (cm.currentState.getClass().getSimpleName().equals("PreparationState")) {
                    fireEvent(new CustomEvent(CustomEvent.GO_TO_PREPARATION_SCENE));
                    // show containers details
                    LeftPane lp = new LeftPane();
                    lp.getBtn1().fire();
                }
            });
        }
        return btn0;
    }

    ArrayList<ButtonPanel> selectedBtns = new ArrayList<>();


    public void addAction(ButtonPanel btn, Drink drink) {
        btn.setOnAction(e -> {
            cm.currentState.selectDrink(drink);
            // add style to selected button
            for (int n = 0; n < selectedBtns.size(); n++) {
                selectedBtns.get(n).getStyleClass().remove("btn-selected");
                selectedBtns.remove(n);
            }
            btn.getStyleClass().add("btn-selected");
            selectedBtns.add(btn);
        });
    }

    public void addTooltip(ButtonPanel btn, Drink drink) {
        btn.setOnMouseEntered(event -> {
            tooltip.setText(drink.getIngredients());
            btn.setTooltip(tooltip);
        });
    }

    public void disableAllDrinkBtn() {
        getEspressoBtn().setDisable(true);
        getEspressoMacchiatoBtn().setDisable(true);
        getCoffeeBtn().setDisable(true);
        getCappuccinoBtn().setDisable(true);
        getLatteMacchiatoBtn().setDisable(true);
        getLatteBtn().setDisable(true);
    }

    public void disableBtn0() {
        getBtn0().setDisable(true);
    }
}