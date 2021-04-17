package com.group19.AndroidCafe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

/**
 * MainActivity to serve as the basis for the Android app.
 @author Sagnik Mukherjee, Michael Choe
 */
public class MainActivity extends AppCompatActivity
{
    /* -- Data fields. -- */
    static Order mainOrder = new Order();
    static StoreOrders mainStoreOrder = new StoreOrders();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
    }

    /**
     * Event function to create new sub-activity, for ordering Donuts.
     * @param view current View object
     */
    public void launchDonuts(View view) {
        try {
            Intent intent = new Intent(this,
                    DonutsActivity.class);
            startActivity(intent);
        } catch (IllegalStateException ex) {
            throwToast(ex.getMessage());
        }
    }

    /**
     * Event function to create new sub-activity, for ordering Coffee.
     * @param view current View object
     */
    public void launchCoffee(View view) {
        try {
            Intent intent = new Intent(this,
                    CoffeeActivity.class);
            startActivity(intent);
        } catch (IllegalStateException ex) {
            throwToast(ex.getMessage());
        }
    }

    /**
     * Event function to create new sub-activity, for placing an Order.
     * @param view current View object
     */
    public void launchAddOrder(View view) {
        try {
            Intent intent = new Intent(this, OrderActivity.class);
            startActivity(intent);
        } catch (IllegalStateException ex) {
            throwToast(ex.getMessage());
        }
    }

    /**
     * Event function to create new sub-activity, for reviewing Orders.
     * @param view current View object
     */
    public void launchStoreOrder(View view) {
        try {
            Intent intent = new Intent(this,
                    StoreOrdersActivity.class);
            startActivity(intent);
        } catch (IllegalStateException ex) {
            throwToast(ex.getMessage());
        }
    }

    /**
     * Helper to open Toast Message box when exception occurs.
     * @param ex String literal containing exception details
     */
    public void throwToast(String ex) {
        Toast.makeText(this.getApplicationContext(),
                "Failed to launch sub-activity. Details as follows...\n" +
                ex, Toast.LENGTH_SHORT).show();
    }
}