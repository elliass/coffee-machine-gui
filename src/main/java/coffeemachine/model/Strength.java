package coffeemachine.model;

public enum Strength {
    SOFT,
    REGULAR,
    STRONG;

    public static Strength getStrFromInt(int value) {
        Strength str = Strength.SOFT;
        if(value == 0){
            str = Strength.SOFT;
        }
        if(value == 1){
            str = Strength.REGULAR;
        }
        if(value == 2){
            str = Strength.STRONG;
        }
        return str;
    }
}
