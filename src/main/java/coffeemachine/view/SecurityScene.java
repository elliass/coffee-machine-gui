package coffeemachine.view;

import coffeemachine.view.security.SecurityPane;
import javafx.scene.Scene;

public class SecurityScene extends Scene {

    public SecurityScene() {
        super(new SecurityPane());
        this.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
    }
}
