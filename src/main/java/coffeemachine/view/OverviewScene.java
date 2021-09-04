package coffeemachine.view;

import coffeemachine.view.overview.OverviewPane;
import javafx.scene.Scene;


public class OverviewScene extends Scene {

    public OverviewScene() {
        super(new OverviewPane());
        this.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
    }
}
