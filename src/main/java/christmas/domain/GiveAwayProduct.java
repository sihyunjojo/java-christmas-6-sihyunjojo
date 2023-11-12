package christmas.domain;

import christmas.global.FoodMenu;

public record GiveAwayProduct(FoodMenu product, int count) {

    public static GiveAwayProduct createGiveAwayProduct(FoodMenu product, int count) {
        return new GiveAwayProduct(product, count);
    }
}
