package coffeemachine.view;

import coffeemachine.view.favorite.FavoritePane;
import javafx.scene.Scene;

public class FavoriteScene extends Scene {

    public FavoriteScene() {
        super(new FavoritePane());
        this.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
    }
}
