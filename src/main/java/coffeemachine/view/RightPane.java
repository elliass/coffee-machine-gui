package coffeemachine.view;

import coffeemachine.model.CoffeeMachine;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import static coffeemachine.view.ButtonPanel.createImageView;

public class RightPane extends VBox {

    CoffeeMachine cm = CoffeeMachine.getInstance();

    private ButtonPanel btn5 = null;
    private ButtonPanel btn6 = null;
    private ButtonPanel btn7 = null;
    private ButtonPanel btn8 = null;

    HBox rightRow1 = new HBox();
    HBox rightRow2 = new HBox();

    long startTime;
    long endTime;

    public RightPane() {
        initPane();
    }

    public void initPane() {
        rightRow1.getChildren().addAll(getBtn5(), getBtn6());
        rightRow2.getChildren().addAll(getBtn7(), getBtn8());
        this.getChildren().addAll(rightRow1, rightRow2);
        this.setAlignment(Pos.CENTER);
    }

    public ButtonPanel getBtn5() {
        if (btn5 == null) {
            ImageView ok = createImageView("ok");
            btn5 = new ButtonPanel("ok", ok, "left-btn");
            btn5.setOnAction(event -> {
                cm.currentState.btn5Pressed(cm);
            });
        }
        return btn5;
    }

    public ButtonPanel getBtn6() {
        if (btn6 == null) {
            btn6 = new ButtonPanel("menu","right-btn");
            btn6.setOnMousePressed(event -> {
                startTime = System.currentTimeMillis();
            });

            btn6.setOnMouseReleased(event -> {
                endTime = System.currentTimeMillis();
                // long pressure -> go to favorite
                if (endTime - startTime > 0.2*1000) {
                    if (cm.currentState.getClass().getSimpleName().equals("IdleState")) {
                        fireEvent(new CustomEvent(CustomEvent.GO_TO_FAVORITE_SCENE));
                    }
                } else {
                    // simple click -> go to maintenance
                    cm.currentState.btn6Pressed(cm);
                    if (cm.currentState.getClass().getSimpleName().equals("MaintenanceState")) {
                        fireEvent(new CustomEvent(CustomEvent.GO_TO_MAINTENANCE_SCENE));
                    }
                }
            });
        }
        return btn6;
    }

    public ButtonPanel getBtn7() {
        if (btn7 == null) {
            btn7 = new ButtonPanel("ml", "right-btn");
            btn7.setOnAction(event -> {
                cm.currentState.btn7Pressed(cm);
            });
        }
        return btn7;
    }

    public ButtonPanel getBtn8() {
        if (btn8 == null) {
            ImageView fav = createImageView("2users");
            btn8 = new ButtonPanel("", fav, "left-btn");
            btn8.setOnMousePressed(event -> {
                startTime = System.currentTimeMillis();
            });

            btn8.setOnMouseReleased(event -> {
                endTime = System.currentTimeMillis();
                // long pressure -> go to security
                if (endTime - startTime > 0.2*1000) {
                    // Security activated -> block all buttons
                    if (cm.currentState.getClass().getSimpleName().equals("IdleState")) {
                        fireEvent(new CustomEvent(CustomEvent.GO_TO_SECURITY_SCENE));
                        cm.setState(cm.getMaintenanceState());
                    }
                    // Security deactivated -> unlock all buttons
                    if (cm.currentState.getClass().getSimpleName().equals("MaintenanceState")) {
                        fireEvent(new CustomEvent(CustomEvent.GO_TO_OVERVIEW_SCENE));
                        cm.setState(cm.getIdleState());
                    }

                } else {
                    // simple click -> call favorite
                    cm.currentState.btn8Pressed(cm);
                }
            });
        }
        return btn8;
    }

    public void disableAllBtn() {
        getBtn5().setDisable(true);
        getBtn6().setDisable(true);
        getBtn7().setDisable(true);
        getBtn8().setDisable(true);
    }

    public void disableAllBtnForMaintenance() {
        getBtn7().setDisable(true);
        getBtn8().setDisable(true);
    }

    public void disableAllBtnForSecurity() {
        getBtn5().setDisable(true);
        getBtn6().setDisable(true);
        getBtn7().setDisable(true);
    }
}