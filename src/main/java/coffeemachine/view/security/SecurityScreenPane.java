package coffeemachine.view.security;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class SecurityScreenPane extends VBox {

    private Label aLabel = null;
    private Text message = null;

    private static SecurityScreenPane instance = null;

    private SecurityScreenPane() {
        initScreen();
    }

    public void initScreen() {
        this.setSpacing(10);
        this.getChildren().addAll(getLabel(), getMessage());
        this.getStyleClass().add("center-pane");
        this.setAlignment(Pos.CENTER);
        this.setMinHeight(130);
    }

    public static SecurityScreenPane getInstance(){
        if (instance == null){
            instance = new SecurityScreenPane();
        }
        return instance;
    }

    public Label getLabel() {
        if (aLabel == null) {
            aLabel = new Label("Security Activated");
            aLabel.getStyleClass().add("drink-selected");
        }
        return aLabel;
    }

    public Text getMessage() {
        if (message == null) {
            message = new Text("Press again to unlock security");
            message.getStyleClass().add("message");
        }
        return message;
    }
}
