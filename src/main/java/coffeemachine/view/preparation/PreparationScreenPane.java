package coffeemachine.view.preparation;

import coffeemachine.model.CoffeeMachine;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class PreparationScreenPane extends VBox {

    CoffeeMachine cm = CoffeeMachine.getInstance();

    private Label drinkSelectedLabel = null;
    private Text message = null;
    private ProgressBar preparationInProgress = null;
    private double progress;
    private String drinkSelectedTxt;

    private static PreparationScreenPane instance = null;

    private PreparationScreenPane() {
        initScreen();
    }

    public void initScreen() {
        this.setSpacing(10);
        this.getChildren().addAll(getDrinkSelectedLabel(), getMessage(), getPreparationInProgress());
        this.getStyleClass().add("center-pane");
        this.setAlignment(Pos.CENTER);
        this.setMinHeight(130);
    }

    public static PreparationScreenPane getInstance(){
        if (instance == null){
            instance = new PreparationScreenPane();
        }
        return instance;
    }

    public Label getDrinkSelectedLabel() {
        if (drinkSelectedLabel == null) {
            drinkSelectedLabel = new Label("Default");
            drinkSelectedTxt = cm.currentState.getDrinkSelected().getName();
            drinkSelectedLabel.setText(drinkSelectedTxt);
            drinkSelectedLabel.getStyleClass().add("drink-selected");
        }
        return drinkSelectedLabel;
    }

    public void setDrinkSelectedLabel(String drinkSelected) {
        this.drinkSelectedLabel.setText(drinkSelected);
    }

    public Text getMessage() {
        if (message == null) {
            message = new Text("Press stop to cancel preparation");
            message.getStyleClass().add("message");
        }
        return message;
    }

    public ProgressBar getPreparationInProgress() {
        if (preparationInProgress == null) {
            preparationInProgress = new ProgressBar();
            preparationInProgress.setProgress(0.0);
            preparationInProgress.setPrefWidth(200.0);
        }
        return preparationInProgress;
    }

    public void increaseProgressBar() {
        progress += 0.1;
        getPreparationInProgress().setProgress(progress);
    }

    public void resetProgressBar() {
        preparationInProgress.setProgress(0.0);
        progress = 0;
    }

    public void resetScreen() {
        setDrinkSelectedLabel(cm.currentState.getDrinkSelected().getName());
    }

}
