package coffeemachine.view;

import coffeemachine.view.preparation.PreparationPane;
import javafx.scene.Scene;

public class PreparationScene extends Scene {

    public PreparationScene() {
        super(new PreparationPane());
        this.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
    }
}
