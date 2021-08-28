package coffeemachine.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CoffeeMakerApp extends Application {

    private Stage stage;
    private Scene overviewScene;

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
        return overviewScene;
    }
}
