package com.group19.AndroidCafe;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import static com.group19.AndroidCafe.Consts.ERROR;
import static com.group19.AndroidCafe.Consts.INT_ZERO;

/**
 * StoreOrdersActivity to hold all currently existing Order objects.
 @author Sagnik Mukherjee, Michael Choe
 */
public class StoreOrdersActivity extends PopulateList
{
    //data fields
    private int selected = INT_ZERO;

    //Android Node element handles.
    private ListView currentOrders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.store_orders_activity);

        //bind object handles to XML id's
        currentOrders = findViewById(R.id.currentOrdersList);

        updateFields();

        //get position of clicked currentDonuts list selection for removal,
        //otherwise remove topmost Order object in list (selected == 0)
        currentOrders.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position, long id) {
                selected = position;
            }
        });
    }


    /**
     * Event function to remove the selected Order from currentOrders.
     * No action should occur if ListView has no selected item.
     * @param view current View object
     */
    public void removeOrder(View view) {
        try {
            if (currentOrders.getItemAtPosition(selected) != null) {
                MainActivity.mainStoreOrder.getOrderList().remove(selected);

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
        String[] temp = MainActivity.mainStoreOrder.toString().
                split("\n==================\n");
        populateListHelper(currentOrders, temp);
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
