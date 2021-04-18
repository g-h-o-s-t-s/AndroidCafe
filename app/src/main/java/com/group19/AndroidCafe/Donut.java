package com.group19.AndroidCafe;

import static com.group19.AndroidCafe.Consts.DONUT_PRICE;
import static com.group19.AndroidCafe.Consts.df;

/**
 * Represents Donut-type MenuItem.
 @author Sagnik Mukherjee, Michael Choe
 */
public class Donut extends MenuItem
{
    //object fields
    private int amount;
    private Donut.Flavor flavor;
    public enum Flavor {
        BOSTON_KREME,
        STRAWBERRY,
        JELLY,
        VANILLA_GLAZE,
        CHOCOLATE,
        OLD_FASHIONED,
        PUMPKIN_SPICE,
        CHOCOLATE_GLAZE,
        POWDERED
    }

    /**
     * Default constructor.
     */
    public Donut() {
        super();
        amount = 0;
        flavor = Flavor.BOSTON_KREME;
    }

    /**
     * Setter for donut amount.
     * @param a int value, number of donuts
     */
    public void setAmount(int a) {
        amount = a;
    }

    /**
     * Setter for donut flavor.
     * @param f enum value, flavor of donut
     */
    public void setFlavor(Object f) {
        if (f instanceof String)
            flavor = Donut.Flavor.valueOf((String) f);
    }

    /**
     * Getter for price of this Donut.
     * @return super.price field value
     */
    @Override
    public double getPrice() {
        return super.getPrice();
    }

    /**
     * Setter for price of this Donut.
     * @param p value to set super.price to
     */
    @Override
    public void setPrice(double p) {
        super.setPrice(p);
    }

    /**
     * Assigns the price for this Donut item.
     */
    @Override
    public void itemPrice() {
        setPrice(DONUT_PRICE * amount);
    }

    /**
     * Returns a String containing current Donut details.
     * @return String value, Donut details
     */
    @Override
    public String toString() {
        return "Donut, " + flavor + " Flavor, " + amount +
                " @ " + df.format(DONUT_PRICE)
                + " each, " + df.format(getPrice()) + ".";
    }
}
