package com.group19.AndroidCafe;

import java.text.DecimalFormat;

/**
 * The Consts class houses all immutable constant values.
 @author Sagnik Mukherjee, Michael Choe
 */
@SuppressWarnings({"WeakerAccess"})
public class Consts
{
    /* Constants which appear in multiple classes */
    public static final DecimalFormat df
            = new DecimalFormat("$#,##0.00"),
            orderf = new DecimalFormat("00000");
    public static final String EMPTY = "";
    //New Jersey Sales and Use Tax Rate = 6.625%
    public static final double SALES_TAX = 0.06625;
    public static final double ZERO = 0.0;

    //Pre-determining the resolutions for parent/child GUIs.
    public static final int DEFAULT_WIDTH = 1280, DEFAULT_HEIGHT = 720;
    public static final int REDUCED_WIDTH = 960, REDUCED_HEIGHT = 540;


    /* Donut() constants */
    public static final double YEAST_PRICE = 1.39,
            CAKE_PRICE = 1.59, HOLE_PRICE = 0.33;
    public static final String TYPE1 = "CakeDonut", TYPE2 = "HoleDonut",
            TYPE3  = "YeastDonut";


    /* Coffee() constants */
    public static final double BASE_PRICE = 1.99,
            ADD_IN_COST = 0.20, SIZE_COST = 0.50;
    public static final double DOUBLE = 2, TRIPLE = 3;
    public static final String SHORT = "Short", TALL = "Tall",
            GRANDE = "Grande", VENTI = "Venti";


    /* Order() constants */
    public static final int FROM = 1, TO = 10000;


    /**
     * Constructor prevents other classes from instantiating objects of
     * type Consts when calling this class.
     */
    private Consts() {
        throw new AssertionError();
    }
}
