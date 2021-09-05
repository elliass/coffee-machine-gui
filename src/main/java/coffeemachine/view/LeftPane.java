package coffeemachine.view;

import coffeemachine.model.CoffeeMachine;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import static coffeemachine.view.ButtonPanel.createImageView;

public class LeftPane extends VBox {

    CoffeeMachine cm = CoffeeMachine.getInstance();

    private ButtonPanel btn1 = null;
    private ButtonPanel btn2 = null;
    private ButtonPanel btn3 = null;
    private ButtonPanel btn4 = null;

    HBox leftRow1 = new HBox();
    HBox leftRow2 = new HBox();

    public LeftPane() {
        initPane();
    }

    public void initPane() {
        leftRow1.getChildren().addAll(getBtn1(), getBtn2());
        leftRow2.getChildren().addAll(getBtn3(), getBtn4());
        this.getChildren().addAll(leftRow1, leftRow2);
        this.setAlignment(Pos.CENTER);
    }

    public ButtonPanel getBtn1() {
        if (btn1 == null) {
            ImageView imgV = createImageView("hide");
            btn1 = new ButtonPanel("", imgV, "left-btn");
            btn1.setOnAction(event -> {
                cm.currentState.btn1Pressed(cm);
            });
        }
        return btn1;
    }

    public ButtonPanel getBtn2() {
        if (btn2 == null) {
            ImageView back = createImageView("return");
            btn2 = new ButtonPanel("", back, "left-btn");
            btn2.setOnAction(event -> {
                cm.currentState.btn2Pressed(cm);
                if (cm.currentState.getClass().getSimpleName().equals("IdleState")) {
                    fireEvent(new CustomEvent(CustomEvent.GO_TO_OVERVIEW_SCENE));
                }
            });
        }
        return btn2;
    }

    public ButtonPanel getBtn3() {
        if (btn3 == null) {
            ImageView dblCup = createImageView("coffee-cup2");
            btn3 = new ButtonPanel("", dblCup, "left-btn");
            btn3.setOnAction(event -> {
                cm.currentState.btn3Pressed(cm);
            });
        }
        return btn3;
    }

    public ButtonPanel getBtn4() {
        if (btn4 == null) {
            ImageView grain = createImageView("coffee-bean");
            btn4 = new ButtonPanel("", grain, "left-btn");
            btn4.setOnAction(event -> {
                cm.currentState.btn4Pressed(cm);
            });
        }
        return btn4;
    }

    public void disableAllBtn() {
        getBtn1().setDisable(true);
        getBtn2().setDisable(true);
        getBtn3().setDisable(true);
        getBtn4().setDisable(true);
    }

    public void disableAllBtnExceptBack() {
        getBtn1().setDisable(true);
        getBtn3().setDisable(true);
        getBtn4().setDisable(true);
    }

    public void disableAllBtnForOverview() {
        getBtn2().setDisable(true);
    }

}
