package com.group19.AndroidCafe;

/**
 * Donut superclass for three types of Donuts.
 @author Sagnik Mukherjee, Michael Choe
 */
public abstract class Donut extends MenuItem
{
    /**
     * Default constructor.
     */
    public Donut() {
        super();
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
     * Abstract method to be implemented by subclasses as needed.
     * Sets amount of donuts for this object.
     */
    public abstract void setAmount(int amount);

    /**
     * Abstract method to be implemented by subclasses as needed.
     * Sets donut flavor.
     */
    public abstract void setFlavor(Object o);

    /**
     * Abstract method to be implemented by subclasses as needed.
     * Calculates the price for a set of donuts.
     */
    public abstract void itemPrice();

    /**
     * Abstract method, toString for each Donut type.
     * @return String value, Donut contents
     */
    public abstract String toString();
}
