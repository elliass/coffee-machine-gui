package coffeemachine.model.issue;

public class WaterIssue extends Issue {

    private boolean waterOk = true;

    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }

    @Override
    public boolean getStatus() {
        return this.waterOk;
    }

    @Override
    public void setStatus(boolean status) {
        this.waterOk = status;
    }

}
