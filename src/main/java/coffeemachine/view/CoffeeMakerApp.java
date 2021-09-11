package coffeemachine.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CoffeeMakerApp extends Application {

    private OverviewScene overviewScene = null;
    private PreparationScene preparationScene = null;
    private MaintenanceScene maintenanceScene = null;
    private IssueScene issueScene = null;
    private FavoriteScene favoriteScene = null;
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

            overviewScene.addEventFilter(CustomEvent.GO_TO_ISSUE_SCENE, event -> {
                stage.setScene(getIssueScene());
            });

            overviewScene.addEventFilter(CustomEvent.GO_TO_MAINTENANCE_SCENE, event -> {
                stage.setScene(getMaintenanceScene());
            });

            overviewScene.addEventFilter(CustomEvent.GO_TO_FAVORITE_SCENE, event -> {
                stage.setScene(getFavoriteScene());
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

    private IssueScene getIssueScene() {
        if (issueScene == null) {
            issueScene = new IssueScene();
            issueScene.addEventFilter(CustomEvent.GO_TO_OVERVIEW_SCENE, event -> {
                stage.setScene(getOverviewScene());
            });
        }
        return issueScene;
    }

    private FavoriteScene getFavoriteScene() {
        if (favoriteScene == null) {
            favoriteScene = new FavoriteScene();
            favoriteScene.addEventFilter(CustomEvent.GO_TO_OVERVIEW_SCENE, event -> {
                stage.setScene(getOverviewScene());
            });
        }
        return favoriteScene;
    }
}
