package coffeemachine.model;

public class Maintenance {

    private String[] operations = {"Cleaning", "Descaling", "CalcNClean"};
    private String selectedOperation;
    public String operationPerformed;

    public String[] getOperations() {
        return operations;
    }

    public String getOperation(int index) {
        String operation = operations[index];
        return operation;
    }

    public String getSelectedOperation() {
        return this.selectedOperation;
    }

    public void setSelectedOperation(String selectedOperation) {
        this.selectedOperation = selectedOperation;
    }

    public String startOperation(){
        if (selectedOperation == "Cleaning") {
            startCleaning();
        }
        if (selectedOperation == "Descaling") {
            startDescaling();
        }
        if (selectedOperation == "CalcNClean") {
            startCalcNClean();
        }
        return this.operationPerformed;
    }

    public void startCleaning() {
        this.operationPerformed = "Cleaning";
    }

    public void startDescaling() {
        this.operationPerformed = "Descaling";
    }

    public void startCalcNClean() {
        this.operationPerformed = "CalcNClean";
    }
}
