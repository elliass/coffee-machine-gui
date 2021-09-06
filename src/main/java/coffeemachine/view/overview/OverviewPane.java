package coffeemachine.view.overview;

import coffeemachine.view.BottomPane;
import coffeemachine.view.LeftPane;
import coffeemachine.view.RightPane;
import coffeemachine.view.TopPane;
import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;


public class OverviewPane extends BorderPane {
    private LeftPane leftPane = null;
    private RightPane rightPane = null;
    private OverviewScreenPane screenPane = null;
    private TopPane topPane = null;
    private BottomPane bottomPane = null;

    public OverviewPane() {
        initPane();
    }

    private void initPane() {
        this.setLeft(getLeftPane());
        this.setRight(getRightPane());
        this.setCenter(getScreenPane());
        this.setTop(getTopPane());
        this.setBottom(getBottomPane());

        this.setPrefHeight(300);
        this.setPrefWidth(850);
        this.setMargin(screenPane, new Insets(10));
        this.setPadding(new Insets(5));
    }

    private LeftPane getLeftPane() {
        if (leftPane == null) {
            leftPane = new LeftPane();
            leftPane.disableAllBtnForOverview();
        }
        return leftPane;
    }

    private RightPane getRightPane() {
        if (rightPane == null) {
            rightPane = new RightPane();
        }
        return rightPane;
    }

    private OverviewScreenPane getScreenPane() {
        if (screenPane == null) {
            screenPane = OverviewScreenPane.getInstance();
        }
        return screenPane;
    }

    private TopPane getTopPane() {
        if (topPane == null) {
            topPane = new TopPane();
        }
        return topPane;
    }

    private BottomPane getBottomPane() {
        if (bottomPane == null) {
            bottomPane = new BottomPane();
        }
        return bottomPane;
    }
}
