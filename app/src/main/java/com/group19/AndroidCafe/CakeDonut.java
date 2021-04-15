package com.group19.AndroidCafe;

import static com.group19.AndroidCafe.Consts.CAKE_PRICE;
import static com.group19.AndroidCafe.Consts.df;

/**
 * Represents a CakeDonut-type MenuItem.
 @author Sagnik Mukherjee, Michael Choe
 */
public class CakeDonut extends Donut
{
    //object fields
    private int amount;
    private CDFlavor flavor;
    public enum CDFlavor {
        BOSTON_KREME,
        STRAWBERRY,
        JELLY
    }

    /**
     * Default constructor.
     */
    public CakeDonut() {
        super();
        amount = 0;
        flavor = CDFlavor.JELLY;
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
            flavor = CDFlavor.valueOf((String) f);
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
        setPrice(CAKE_PRICE * amount);
    }

    /**
     * Returns a String containing current CakeDonut details.
     * @return String value, CakeDonut details
     */
    @Override
    public String toString() {
        return "Cake Donut, " + flavor + " Flavor, " + amount +
                " @ " + df.format(CAKE_PRICE)
                + " each, " + df.format(getPrice()) + ".";
    }
}
