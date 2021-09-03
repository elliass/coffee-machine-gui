package coffeemachine.model;

import coffeemachine.model.drink.Drink;
import java.util.ArrayList;


public class FavoriteManager {

    private static ArrayList<Drink> favoriteList;
    private static ArrayList<String> favoriteListByName;
    private static Drink favoriteDrink;
    private static String favoriteDrinkByName;

    private static FavoriteManager instance = null;

    public static FavoriteManager getInstance(){
        if (instance == null){
            instance = new FavoriteManager();
            favoriteList = new ArrayList<Drink>(4);
            favoriteListByName = new ArrayList<String>(4);
        }
        return instance;
    }

    public static ArrayList<Drink> getFavoriteList() {
        return favoriteList;
    }

    public static ArrayList<String> getFavoriteListByName() {
        return favoriteListByName;
    }

    public static Drink getFavoriteDrink(int index) {
        favoriteDrink = favoriteList.get(index);
        return favoriteDrink;
    }

    public static String getFavoriteDrinkByName(int index) {
        favoriteDrinkByName = favoriteListByName.get(index);
        return favoriteDrinkByName;
    }

    public void addFavorite(Drink drink) throws ArrayIndexOutOfBoundsException {
        if (favoriteList.size() < 4) {
            favoriteList.add(drink);
            favoriteListByName.add(drink.getName());
        } else {
            throw new ArrayIndexOutOfBoundsException("ArrayIndexOutOfBoundsException Thrown: \n" +
                    "Maximum reached! Already 4 drinks in favorite");
        }
    }

    public void updateFavorite(Drink drink, int index) throws ArrayIndexOutOfBoundsException {
        if (!favoriteList.isEmpty()) {
            favoriteList.set(index, drink);
            favoriteListByName.set(index, drink.getName());
        } else {
            throw new ArrayIndexOutOfBoundsException("ArrayIndexOutOfBoundsException Caught: \n" +
                    "Please make sure to call a favorite drink before updating");
        }
    }

    public void removeAllFavorite(ArrayList<Drink> favoriteList) {
        favoriteList.removeAll(favoriteList);
    }

    public boolean isEmpty() {
        if (favoriteList.size() == 0) {
            return true;
        } else {
            return false;
        }
    }
}
