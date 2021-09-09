package coffeemachine.view;

import coffeemachine.view.issue.IssuePane;
import javafx.scene.Scene;

public class IssueScene extends Scene {

    public IssueScene() {
        super(new IssuePane());
        this.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
    }
}
