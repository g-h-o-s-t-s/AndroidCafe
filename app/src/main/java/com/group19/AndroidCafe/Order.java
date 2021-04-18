package com.group19.AndroidCafe;

import java.util.ArrayList;
import java.util.Random;

import static com.group19.AndroidCafe.Consts.*;

/**
 * Represents a list of MenuItems ordered by user.
 @author Sagnik Mukherjee, Michael Choe
 */
@SuppressWarnings("FieldMayBeFinal")
public class Order implements Customizable
{
    //object fields
    private double total;
    private double tax;
    private double subtotal;
    private int orderID;
    private ArrayList<MenuItem> itemList;

    /**
     * Default constructor.
     */
    public Order() {
        total = ZERO;
        tax = ZERO;
        subtotal = ZERO;
        orderID = getRandomInRange();
        itemList = new ArrayList<>();
    }

    /**
     * Randomly assign a 5-digit number as the ID for this Order.
     * @return int value, random number within range
     */
    private int getRandomInRange() {
        final Random rand = new Random();
        return FROM + rand.nextInt(TO - FROM + FROM);
    }

    /**
     * Getter for Order total.
     * @return double value, Order total
     */
    public double getTotal(){
        return total;
    }

    /**
     * Getter for Order tax.
     * @return double value, Order tax
     */
    public double getTax(){
        return tax;
    }

    /**
     * Getter for Order subtotal.
     * @return double value, Order subtotal
     */
    public double getSubtotal(){
        return subtotal;
    }

    /**
     * Getter for List of MenuItems.
     * @return ArrayList of MenuItems, items in current order
     */
    public ArrayList<MenuItem> getItemList() {
        return itemList;
    }

    /**
     * Calculates cost of order overall.
     */
    public void orderPrice() {
        double sub = Consts.ZERO;
        for (MenuItem i : itemList)
            sub += i.getPrice();
        subtotal = sub;

        tax = subtotal * SALES_TAX;
        total = subtotal + tax;
    }

    /**
     * Implementing function from Customizable.
     * Adds a MenuItem to this Order.
     * @param obj Object value to be added, given that it is both a MenuItem
     *            value and a valid type of Donut or Coffee; of course,
     *            having type Donut/Coffee implies having type MenuItem
     * @return boolean value, indicates the success of add(Object)
     */
    @Override
    public boolean add(Object obj) {
        if (obj instanceof Donut || obj instanceof Coffee)
            return itemList.add((MenuItem) obj);
        return false;
    }

    /**
     * Implementing function from Customizable.
     * Removes a MenuItem from this Order.
     * @param obj Object value to be removed, given that it is
     *            a valid type of Donut or Coffee
     * @return boolean value, indicates the success of remove(Object)
     */
    @Override
    public boolean remove(Object obj) {
        if (obj instanceof Donut || obj instanceof Coffee)
            return itemList.remove(obj);
        return false;
    }

    /**
     * Returns a String containing current Order details neatly.
     * @return String value, concatenates MenuItems' toString results
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (MenuItem m : itemList)
        {
            result.append(m.toString()).append("\n");
        }
        result.append("Order ").append(orderf.format(orderID))
                .append(", Subtotal ").append(df.format(subtotal))
                .append(", Tax ").append(df.format(tax)).append(", Total ")
                .append(df.format(total));
        return result.toString();
    }
}
