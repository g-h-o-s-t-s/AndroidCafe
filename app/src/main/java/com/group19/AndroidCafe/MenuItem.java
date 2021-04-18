package com.group19.AndroidCafe;

import static com.group19.AndroidCafe.Consts.*;

/**
 * Object superclass for all menu item types.
 @author Sagnik Mukherjee, Michael Choe
 */
public abstract class MenuItem
{
    //object fields
    private double price;

    /**
     * Default constructor.
     */
    public MenuItem() {
        price = ZERO;
    }

    /**
     * Getter for MenuItem price field.
     * @return double value for price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Setter for MenuItem price field.
     * @param p double value to set price to
     */
    public void setPrice(double p) {
        price = p;
    }

    /**
     * Abstract method to be implemented by subclasses as needed.
     * Calculates price of this MenuItem.
     */
    public abstract void itemPrice();
}
