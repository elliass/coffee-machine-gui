package coffeemachine.view;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ButtonPanel extends Button {

    public ButtonPanel(String text, String styleClass) {
        super(text);
        getStyleClass().add(styleClass);
    }

    public ButtonPanel(String text, ImageView img, String styleClass) {
        super(text, img);
        getStyleClass().add(styleClass);
    }

    public static ImageView createImageView(String name){
        Image img = new Image("/img/" + name + ".png", 25, 25, true, false);
        ImageView iView = new ImageView(img);
        return iView;
    }

    public static ImageView createDrinkView(String name){
        Image img = new Image("/img/" + name + ".png", 100, 100, true, true);
        ImageView dView = new ImageView(img);
        return dView;
    }

}
