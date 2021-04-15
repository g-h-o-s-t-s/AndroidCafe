package com.group19.AndroidCafe;

/**
 * Customizable interface represents store menu items.
 @author Sagnik Mukherjee, Michael Choe
 */
public interface Customizable
{
    /**
     * Interface method to be implemented by other classes.
     * Adds an Object to a data structure.
     * @param obj Object value to be added
     * @return true if successful, false otherwise
     */
    boolean add(Object obj);

    /**
     * Interface method to be implemented by other classes.
     * Removes an Object from a data structure.
     * @param obj Object value to be removed
     * @return true if successful, false otherwise
     */
    boolean remove(Object obj);
}
