package coffeemachine.view;

import coffeemachine.view.maintenance.MaintenancePane;
import javafx.scene.Scene;

public class MaintenanceScene extends Scene {

    public MaintenanceScene() {
        super(new MaintenancePane());
        this.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
    }
}
