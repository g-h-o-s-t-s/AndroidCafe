package com.group19.AndroidCafe;

import static com.group19.AndroidCafe.Consts.*;

/**
 * Represents a HoleDonut-type MenuItem.
 @author Sagnik Mukherjee, Michael Choe
 */
public class HoleDonut extends Donut
{
    //object fields
    private int amount;
    private HDFlavor flavor;
    public enum HDFlavor {
        PUMPKIN_SPICE,
        CHOCOLATE_GLAZE,
        POWDERED
    }

    /**
     * Default constructor.
     */
    public HoleDonut() {
        super();
        amount = 0;
        flavor = HDFlavor.POWDERED;
    }

    /**
     * Setter for donut flavor.
     * @param f enum value, flavor of donut
     */
    public void setFlavor(Object f) {
        if (f instanceof String)
            flavor = HDFlavor.valueOf((String) f);
    }

    /**
     * Setter for donut amount.
     * @param a int value, number of donuts
     */
    public void setAmount(int a) {
        amount = a;
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
        setPrice(HOLE_PRICE * amount);
    }

    /**
     * Returns a String containing current HoleDonut details.
     * @return String value, HoleDonut details
     */
    @Override
    public String toString() {
        return "Hole Donut, " + flavor + " Flavor, " + amount +
                " @ " + df.format(HOLE_PRICE)
                + " each, " + df.format(getPrice()) + ".";
    }
}
