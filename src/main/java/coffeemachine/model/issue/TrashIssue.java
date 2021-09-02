package coffeemachine.model.issue;

public class TrashIssue extends Issue {

    private boolean trashOk = true;

    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }

    @Override
    public boolean getStatus() {
        return this.trashOk;
    }

    @Override
    public void setStatus(boolean status) {
        this.trashOk = status;
    }

}
