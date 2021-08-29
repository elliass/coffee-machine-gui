package coffeemachine.model.drink;

public class BlackCoffee extends Drink {

    private String name = "Coffee";
    private int minCoffee = 10;
    private int minWater = 50;
    private int minMilk = 0;
    private int minFoam = 0;
    private int minTrash = 1;

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getCoffeeQuantity() {
        if (getDoubleCupStatus()) {
            return this.minCoffee * 2;
        } else {
            return this.minCoffee;
        }
    }

    @Override
    public int getWaterQuantity() {
        if (getDoubleCupStatus()) {
            return this.minWater * 2;
        } else {
            return this.minWater;
        }
    }

    @Override
    public int getMilkQuantity() {
        if (getDoubleCupStatus()) {
            return this.minMilk * 2;
        } else {
            return this.minMilk;
        }
    }

    @Override
    public int getFoamQuantity() {
        if (getDoubleCupStatus()) {
            return this.minFoam * 2;
        } else {
            return this.minFoam;
        }
    }

    @Override
    public int getTrashQuantity() {
        if (getDoubleCupStatus()) {
            return this.minTrash * 2;
        } else {
            return this.minTrash;
        }
    }

    @Override
    public String getIngredients() {
        String c = "Coffee: " + minCoffee + " gr";
        String w = "Water: " + minWater + " ml";
        String ingredients = c + "\n" + w;
        return ingredients;
    }
}