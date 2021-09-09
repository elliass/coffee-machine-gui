package coffeemachine.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CoffeeMakerApp extends Application {

    private OverviewScene overviewScene = null;
    private PreparationScene preparationScene = null;
    private MaintenanceScene maintenanceScene = null;
    private Stage stage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.stage = primaryStage;
        stage.setTitle("Coffee Machine");
        stage.setScene(getOverviewScene());
        stage.setResizable(false);
        stage.show();
    }

    private Scene getOverviewScene() {
        if (overviewScene == null) {
            overviewScene = new OverviewScene();
            overviewScene.addEventFilter(CustomEvent.GO_TO_PREPARATION_SCENE, event -> {
                stage.setScene(getPreparationScene());
            });

            overviewScene.addEventFilter(CustomEvent.GO_TO_MAINTENANCE_SCENE, event -> {
                stage.setScene(getMaintenanceScene());
            });
        }
        return overviewScene;
    }

    private PreparationScene getPreparationScene() {
        if (preparationScene == null) {
            preparationScene = new PreparationScene();
            preparationScene.addEventFilter(CustomEvent.GO_TO_OVERVIEW_SCENE, event -> {
                stage.setScene(getOverviewScene());
            });
        }
        return preparationScene;
    }

    private MaintenanceScene getMaintenanceScene() {
        if (maintenanceScene == null) {
            maintenanceScene = new MaintenanceScene();
            maintenanceScene.addEventFilter(CustomEvent.GO_TO_OVERVIEW_SCENE, event -> {
                stage.setScene(getOverviewScene());
            });
        }
        return maintenanceScene;
    }
}
