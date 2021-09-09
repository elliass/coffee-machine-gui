package coffeemachine.view.issue;

import coffeemachine.model.CoffeeMachine;
import coffeemachine.model.issue.Issue;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class IssueScreenPane extends VBox {

    CoffeeMachine cm = CoffeeMachine.getInstance();

    private Label issueSelectedLabel = null;
    private Text messageTxt = null;
    private String issueSelectedTxt;
    private static IssueScreenPane instance = null;

    private IssueScreenPane() {
        initScreen();
    }

    public void initScreen() {
        this.setSpacing(10);
        this.getChildren().addAll(getIssueSelectedLabel(), getMessageTxt());
        this.getStyleClass().add("center-pane");
        this.setAlignment(Pos.CENTER);
        this.setMinHeight(130);
    }

    public static IssueScreenPane getInstance(){
        if (instance == null){
            instance = new IssueScreenPane();
        }
        return instance;
    }

    public Label getIssueSelectedLabel() {
        if (issueSelectedLabel == null) {
            issueSelectedLabel = new Label("Default");
            issueSelectedLabel.getStyleClass().add("issue-selected");
        }
        return issueSelectedLabel;
    }

    public void setIssueSelectedLabel(String issueSelected) {
        this.issueSelectedLabel.setText(issueSelected);
    }

    public String getIssueSelectedTxt() {
        this.issueSelectedTxt = Issue.getIssuesList().get(0).getName();
        return issueSelectedTxt;
    }

    public Text getMessageTxt() {
        if (messageTxt == null) {
            messageTxt = new Text("Default");
            messageTxt.setText("Warning ! Please solve all issues");
            messageTxt.getStyleClass().add("message");
        }
        return messageTxt;
    }

    public void setMessageTxt(String message) {
        this.messageTxt.setText(message);
    }

    public void resetScreen() {
        setIssueSelectedLabel(getIssueSelectedTxt());
        setMessageTxt("Warning ! Please solve all issues");
    }
}
