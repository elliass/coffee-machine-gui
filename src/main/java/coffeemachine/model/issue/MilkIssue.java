package coffeemachine.model.issue;

public class MilkIssue extends Issue {

    private boolean milkOk = true;

    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }

    @Override
    public boolean getStatus() {
        return this.milkOk;
    }

    @Override
    public void setStatus(boolean status) {
        this.milkOk = status;
    }

}

