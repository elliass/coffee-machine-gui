package coffeemachine.model;

public enum Quantity {
    SMALL,
    MEDIUM,
    LARGE;

    public static Quantity getQtyFromInt(int value) {
        Quantity qty = Quantity.SMALL;
        if(value == 0){
            qty = Quantity.SMALL;
        }
        if(value == 1){
            qty = Quantity.MEDIUM;
        }
        if(value == 2){
            qty = Quantity.LARGE;
        }
        return qty;
    }
}
