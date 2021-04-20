package com.group19.AndroidCafe;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import static com.group19.AndroidCafe.Consts.*;

/**
 * OrderActivity to finalize an Order instance.
 @author Sagnik Mukherjee, Michael Choe
 */
public class OrderActivity extends PopulateList
{
    //data fields
    private int selected = DEFAULT_INDEX;

    //Android Node element handles.
    private TextView subtotalText;
    private TextView salesTaxText;
    private TextView totalText;
    private ListView currentItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_activity);

        //bind object handles to XML id's
        subtotalText = findViewById(R.id.subtotalOrderDisplay);
        salesTaxText = findViewById(R.id.salesTaxDisplay);
        totalText = findViewById(R.id.totalDisplay);
        currentItems = findViewById(R.id.currentItemsDisplay);

        updateFields();

        //get position of clicked currentDonuts list selection for removal,
        //otherwise remove topmost Item object in list (selected == 0)
        currentItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position, long id) {
                selected = position;
            }
        });
    }

    /**
     * Event function to add Order to overall StoreOrders.
     * @param view current View object
     */
    public void placeOrder(View view) {
        try {
            if (MainActivity.mainOrder != null) {
                MainActivity.mainStoreOrder.add(MainActivity.mainOrder);
                MainActivity.mainOrder = new Order();

                this.finish();
            }
        } catch (Exception ex) {
            throwToast(ex.getMessage());
        }
    }

    /**
     * Event function to remove the selected MenuItem from currentItems.
     * No action should occur if ListView has no selected item.
     * @param view current View object
     */
    public void removeMenuItem(View view) {
        try {
            if (currentItems.getItemAtPosition(selected) != null) {
                MainActivity.mainOrder.getItemList().remove(selected);

                updateFields();
            }
        } catch (Exception ex) {
            throwToast(ex.getMessage());
        }
    }

    /**
     * Helper to update the textArea/listView displays in real-time (ideally).
     */
    private void updateFields() {
        selected = 0;
        String[] temp = MainActivity.mainOrder.toString().split("\n");
        populateListHelper(currentItems, temp);

        MainActivity.mainOrder.orderPrice();
        updateTexts();
    }

    /**
     * Another helper to update textAreas specifically.
     */
    private void updateTexts() {
        subtotalText.setText(df.format(MainActivity.mainOrder.getSubtotal()));
        salesTaxText.setText(df.format(MainActivity.mainOrder.getTax()));
        totalText.setText(df.format(MainActivity.mainOrder.getTotal()));
    }

    /**
     * Helper to open Toast Message box when exception occurs.
     * @param ex String literal containing exception details
     */
    public void throwToast(String ex) {
        Toast.makeText(this.getApplicationContext(),
                ERROR + ex, Toast.LENGTH_SHORT).show();
    }
}
