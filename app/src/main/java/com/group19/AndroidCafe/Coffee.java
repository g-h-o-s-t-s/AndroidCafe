package com.group19.AndroidCafe;

import java.util.ArrayList;
import static com.group19.AndroidCafe.Consts.*;

/**
 * Represents a Coffee-type MenuItem.
 @author Sagnik Mukherjee, Michael Choe
 */
@SuppressWarnings("FieldMayBeFinal")
public class Coffee extends MenuItem implements Customizable
{
    //object fields
    private String size;
    private ArrayList<String> addIns;

    /**
     * Default constructor.
     */
    public Coffee() {
        super();
        size = EMPTY;
        addIns = new ArrayList<>();
    }

    /**
     * Setter for Coffee size.
     * @param s String value, size of coffee
     */
    public void setSize(String s){
        this.size = s;
    }

    /**
     * Getter for price of this Coffee.
     * @return super.price field value
     */
    @Override
    public double getPrice() {
        return super.getPrice();
    }

    /**
     * Setter for overall price of this Coffee.
     * @param p value to set super.price to
     */
    @Override
    public void setPrice(double p) {
        super.setPrice(p);
    }

    /**
     * Assigns the price for this Coffee.
     */
    @Override
    public void itemPrice() {
        double price = ZERO;
        switch (size) {
            case SHORT: price += BASE_PRICE; break;
            case TALL: price += BASE_PRICE + SIZE_COST; break;
            case GRANDE: price += BASE_PRICE + (DOUBLE * SIZE_COST); break;
            case VENTI: price += BASE_PRICE + (TRIPLE * SIZE_COST); break;
        }
        price += ADD_IN_COST * addIns.toArray().length;
        setPrice(price);
    }

    /**
     * Implementing function from Customizable.
     * Adds an add-in option to this Coffee.
     * @param obj Object value to be added, given that it is both a String
     *            value and a valid type of add-in
     * @return boolean value, indicates the success of add(Object)
     */
    @Override
    public boolean add(Object obj) {
        //obj must be casted before it can be added to an ArrayList
        //of String values.
        if (obj instanceof String)
            return addIns.add((String) obj);
        return false;
    }

    /**
     * Implementing function from Customizable.
     * Removes an add-in option from this Coffee.
     * @param obj Object value to be removed, given that it is both a String
     *            value and a valid type of add-in
     * @return boolean value, indicates the success of remove(Object)
     */
    @Override
    public boolean remove(Object obj) {
        //obj is implied to be String if we are even to remove its matching
        // value from the ArrayList, thus there is no casting necessary.
        if (obj instanceof String)
            return addIns.remove(obj);
        return false;
    }

    /**
     * Returns a String containing current Coffee details.
     * @return String value, Coffee details
     */
    @Override
    public String toString() {
        return size + " Coffee, " + printAddIns()
                + df.format(getPrice()) + ".";
    }

    /**
     * Returns a String of selected addIns.
     * @return String value, addIn details
     */
    public String printAddIns() {
        if (!addIns.isEmpty()) {
            StringBuilder result = new StringBuilder();
            for (String s : addIns) {
                result.append(s).append(", ");
            }
            return result.toString();
        }
        else
            return "Plain, ";
    }
}
