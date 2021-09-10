package coffeemachine.view.favorite;

import coffeemachine.model.CoffeeMachine;
import coffeemachine.model.FavoriteManager;
import coffeemachine.view.ButtonPanel;
import coffeemachine.view.CustomEvent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class FavoriteScreenPane extends VBox {

    CoffeeMachine cm = CoffeeMachine.getInstance();

    private ListView<String> favListView = null;
    private ArrayList<String> favoriteList;
    private ObservableList<String> observableFavList;
    private Text messageTxt = null;
    private ButtonPanel createFavorite = null;
    private ButtonPanel updateFavorite = null;

    public HBox screenRow1 = new HBox();
    public HBox screenRow2 = new HBox();
    public HBox screenRow3 = new HBox();

    FavoriteManager fm = FavoriteManager.getInstance();
    private static FavoriteScreenPane instance = null;

    private FavoriteScreenPane() {
        initScreen();
    }

    public void initScreen() {
        screenRow1.getChildren().add(getFavListView());
        screenRow2.getChildren().addAll(getMessageTxt());
        screenRow3.getChildren().addAll(getCreateFavorite(), getUpdateFavorite());
        this.setSpacing(10);
        this.getChildren().addAll(screenRow1, screenRow2, screenRow3);
        this.getStyleClass().add("center-pane");
        this.setMinHeight(130);
    }

    public static FavoriteScreenPane getInstance(){
        if (instance == null){
            instance = new FavoriteScreenPane();
        }
        return instance;
    }

    public ListView<String> getFavListView() {
        if (favListView == null) {
            favListView = new ListView<>();
            favListView.setItems(observableFavList);
        }
        return favListView;
    }

    public Text getMessageTxt() {
        if (messageTxt == null) {
            messageTxt = new Text("Default");
            messageTxt.setText("Select a drink to create or update a favorite drink");
            messageTxt.getStyleClass().add("message");
        }
        return messageTxt;
    }

    public void setMessageTxt(String message) {
        this.messageTxt.setText(message);
    }

    public ButtonPanel getCreateFavorite() {
        if (createFavorite == null) {
            createFavorite = new ButtonPanel("Create", "fav-btn");
            createFavorite.setOnAction(event -> {
                if (cm.currentState.getClass().getSimpleName().equals("IdleState")) {
                    fireEvent(new CustomEvent(CustomEvent.GO_TO_FAVORITE_SCENE));
                }
                createFavorite();
                setFavListView();
            });
        }
        return createFavorite;
    }

    public ButtonPanel getUpdateFavorite() {
        if (updateFavorite == null) {
            updateFavorite = new ButtonPanel("Update", "fav-btn");
            updateFavorite.setOnAction(event -> {
                if (cm.currentState.getClass().getSimpleName().equals("IdleState")) {
                    fireEvent(new CustomEvent(CustomEvent.GO_TO_FAVORITE_SCENE));
                }
                updateFavorite();
                setFavListView();
            });
        }
        return updateFavorite;
    }

    public void setFavListView() {
        favoriteList = FavoriteManager.getFavoriteListByName();
        observableFavList = FXCollections.observableArrayList(favoriteList);
        getFavListView().setItems(observableFavList);
    }

    public void createFavorite() {
        try {
            fm.addFavorite(cm.currentState.getDrinkSelected());
        } catch (ArrayIndexOutOfBoundsException exception) {
            setMessageTxt("Maximum reached! Already 4 drinks in favorite");

            System.out.println("ArrayIndexOutOfBoundsException Caught: \n" +
                    "Maximum reached! Already 4 drinks in favorite");
        }
    }

    public void updateFavorite() {
        try {
            String selectedItem = getFavListView().getSelectionModel().getSelectedItems().get(0);
            int drinkIndex = FavoriteManager.getFavoriteListByName().indexOf(selectedItem);
            fm.updateFavorite(cm.currentState.getDrinkSelected(), drinkIndex);
        }
        catch(ArrayIndexOutOfBoundsException exception) {
            setMessageTxt("Please make sure to select a favorite drink before");
            System.out.println("ArrayIndexOutOfBoundsException Caught: \n" +
                    "Please make sure to select a favorite drink before updating");
        }
        catch(NullPointerException exception) {
            setMessageTxt("Please make sur to select a favorite drink before");
            System.out.print("NullPointerException caught: \n" +
                    "Please make sur to select a favorite drink before updating");
        }
    }
}
