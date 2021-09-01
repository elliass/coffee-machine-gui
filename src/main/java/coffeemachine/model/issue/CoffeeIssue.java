package coffeemachine.model.issue;


public class CoffeeIssue extends Issue {

    private boolean coffeeOk = true;

    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }

    @Override
    public boolean getStatus() {
        return this.coffeeOk;
    }

    @Override
    public void setStatus(boolean status) {
        this.coffeeOk = status;
    }

}
