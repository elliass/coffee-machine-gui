package coffeemachine.model.issue;

import java.util.ArrayList;


public abstract class Issue {

    private static ArrayList<Issue> issues = new ArrayList<>();
    public static ArrayList<Issue> getIssuesList() {
        return issues;
    }
    public static void setIssuesList(Issue issue) {
        issues.add(issue);
    }
    public static void removeIssue(String issue) {
        issues.removeIf(i -> i.getName().equals(issue));
    }

    public abstract String getName();
    public abstract boolean getStatus();
    public abstract void setStatus(boolean status);
}
