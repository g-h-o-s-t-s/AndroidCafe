package com.group19.AndroidCafe;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;

/**
 * MainActivity to serve as the basis for the Android app.
 @author Sagnik Mukherjee, Michael Choe
 */
public class MainActivity extends AppCompatActivity
{
    private ImageButton donutButton;
    private ImageButton coffeeButton;
    private ImageButton addOrderButton;
    private ImageButton orderHistoryButton;

    /**
     * Initialization method for the main activity of the app.
     * Executes and instantiates objects for initial setup.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        donutButton = findViewById(R.id.donutOrder);
        coffeeButton = findViewById(R.id.coffeeOrder);
        addOrderButton = findViewById(R.id.addOrder);
        orderHistoryButton = findViewById(R.id.storeOrders);

        //Define listener functions, attach to respective buttons.
        donutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDonutActivity();
            }
        });

        coffeeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCoffeeActivity();
            }
        });

        addOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAddOrderActivity();
            }
        });

        orderHistoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showStoreOrdersActivity();
            }
        });
    }

    /**
     * Instantiate new activity for ordering donuts.
     */
    private void showDonutActivity() {

    }

    /**
     * Instantiate new activity for ordering coffee.
     */
    private void showCoffeeActivity() {

    }

    /**
     * Instantiate new activity for placing an order.
     */
    private void showAddOrderActivity() {

    }

    /**
     * Instantiate new activity for reviewing order history.
     */
    private void showStoreOrdersActivity() {

    }
}