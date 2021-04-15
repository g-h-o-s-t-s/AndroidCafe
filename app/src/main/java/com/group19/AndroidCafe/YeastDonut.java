package com.group19.AndroidCafe;

import static com.group19.AndroidCafe.Consts.*;

/**
 * Represents a YeastDonut-type MenuItem.
 @author Sagnik Mukherjee, Michael Choe
 */
public class YeastDonut extends Donut
{
    //object fields
    private int amount;
    private YDFlavor flavor;
    public enum YDFlavor {
        VANILLA_GLAZE,
        CHOCOLATE,
        OLD_FASHIONED
    }

    /**
     * Default constructor.
     */
    public YeastDonut() {
        super();
        amount = 0;
        flavor = YDFlavor.OLD_FASHIONED;
    }

    /**
     * Setter for donut flavor.
     * @param f enum value, flavor of donut
     */
    public void setFlavor(Object f) {
        if (f instanceof String)
            flavor = YDFlavor.valueOf((String) f);
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
        setPrice(YEAST_PRICE * amount);
    }

    /**
     * Returns a String containing current YeastDonut details.
     * @return String value, YeastDonut details
     */
    @Override
    public String toString() {
        return "Yeast Donut, " + flavor + " Flavor, " + amount +
                " @ " + df.format(YEAST_PRICE) +
                " each, " + df.format(getPrice()) + ".";
    }
}
