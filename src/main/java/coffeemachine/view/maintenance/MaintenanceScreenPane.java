package coffeemachine.view.maintenance;

import coffeemachine.model.CoffeeMachine;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class MaintenanceScreenPane extends VBox {

    CoffeeMachine cm = CoffeeMachine.getInstance();

    private Label operationSelectedLabel = null;
    private Text messageTxt = null;
    private String operationSelectedTxt;
    private static MaintenanceScreenPane instance = null;

    private MaintenanceScreenPane() {
        initScreen();
    }

    public void initScreen() {
        this.setSpacing(10);
        this.getChildren().addAll(getOperationSelectedLabel(), getMessageTxt());
        this.getStyleClass().add("center-pane");
        this.setAlignment(Pos.CENTER);
        this.setMinHeight(130);
    }

    public static MaintenanceScreenPane getInstance(){
        if (instance == null){
            instance = new MaintenanceScreenPane();
        }
        return instance;
    }

    public Label getOperationSelectedLabel() {
        if (operationSelectedLabel == null) {
            operationSelectedLabel = new Label("Default");
            operationSelectedTxt = cm.currentState.getOperationSelected();
            operationSelectedLabel.setText(operationSelectedTxt);
            operationSelectedLabel.getStyleClass().add("operation-selected");
        }
        return operationSelectedLabel;
    }

    public void setOperationSelectedLabel(String operationSelected) {
        this.operationSelectedLabel.setText(operationSelected);
    }

    public Text getMessageTxt() {
        if (messageTxt == null) {
            messageTxt = new Text("Default");
            messageTxt.setText("Press Menu to select a service");
            messageTxt.getStyleClass().add("message");
        }
        return messageTxt;
    }

    public void setMessageTxt(String message) {
        this.messageTxt.setText(message);
    }

    public void resetScreen() {
        setOperationSelectedLabel("Service required!");
        setMessageTxt("Press Menu to select a service");
    }
}
