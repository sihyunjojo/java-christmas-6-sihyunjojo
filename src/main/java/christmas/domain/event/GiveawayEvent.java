package christmas.domain.event;

import static christmas.global.BenefitDetail.*;

import christmas.domain.Benefit;
import christmas.domain.GiveAwayProduct;
import java.util.Objects;

public class GiveAwayEvent extends Benefit {
    private final GiveAwayProduct giveAwayProduct;

    public GiveAwayEvent(GiveAwayProduct giveAwayProduct) {
        this.giveAwayProduct = giveAwayProduct;
    }
    public static GiveAwayEvent createGiveAwayEvent(GiveAwayProduct giveAwayProduct) {
        return new GiveAwayEvent(giveAwayProduct);
    }
    public GiveAwayProduct getGiveAwayProduct() {
        return giveAwayProduct;
    }
    public int getGiveawayProductPrice() {
        return giveAwayProduct.product().getPrice();
    }
    @Override
    public String getDescription() {
        return GIVE_AWAY_EVENT.getMessage();
    }
    @Override
    public int getBenefitPrice() {
        return getGiveawayProductPrice();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GiveAwayEvent that = (GiveAwayEvent) o;
        return Objects.equals(giveAwayProduct, that.giveAwayProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(giveAwayProduct);
    }
}
