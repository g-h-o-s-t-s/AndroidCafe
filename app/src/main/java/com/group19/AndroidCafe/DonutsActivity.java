package com.group19.AndroidCafe;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.List;

import static com.group19.AndroidCafe.Consts.*;

/**
 * DonutsActivity to add Donuts to static Order.
 @author Sagnik Mukherjee, Michael Choe
 */
public class DonutsActivity extends AppCompatActivity
{
    //data fields
    Order tempOrder;
    Donut tempDonut;
    private int selected = DEFAULT_INDEX;

    //Android Node element handles.
    private Spinner flavors;
    private ListView currentDonuts;
    private EditText quantityText;
    private TextView subtotalText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.donuts_activity);

        //bind object handles to XML id's
        flavors = findViewById(R.id.flavorOptions);
        currentDonuts = findViewById(R.id.currentDonutsList);
        quantityText = findViewById(R.id.quantity);
        subtotalText = findViewById(R.id.subTotal);

        //get position of clicked currentDonuts list selection for removal,
        //otherwise remove topmost Donut object in list (selected == 0)
        currentDonuts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
             public void onItemClick(AdapterView<?> adapter, View v, int position, long id) {
                 selected = position;
             }
         });

        tempOrder = new Order();
        showFlavors(getCurrentFocus());
    }

    /**
     * Event function to show specific flavors depending on donut type.
     * @param view current View object
     */
    public void showFlavors(View view) {
        ArrayAdapter<CharSequence> adapter =
                ArrayAdapter.createFromResource(this,
                R.array.flavors_array, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        flavors.setAdapter(adapter);
    }

    /**
     * Quick helper to reset flavors and quantity.
     */
    private void resetSelections() {
        //start over with the tempDonut object and quantity field
        tempDonut = null;
        quantityText.setText("");
    }

    /**
     * Event function to temporarily add Donut.
     * @param view current View object
     */
    public void addDonut(View view) {
        try {
            setDonut();
            tempOrder.add(tempDonut);

            resetSelections();
            refreshTextFields();
        } catch (NumberFormatException | NullPointerException ex) {
            throwToast(ex.getMessage());
        }
    }

    /**
     * Event function to remove the selected Donut item from currentDonuts.
     * No action should occur if any item in the ListView is not selected.
     * @param view current View object
     */
    public void removeDonut(View view) {
        try {
            if (currentDonuts.getItemAtPosition(selected) != null) {
                tempOrder.getItemList().remove(selected);

                refreshTextFields();
            }
        } catch (Exception ex) {
            throwToast(ex.getMessage());
        }
    }

    /**
     * Helper to create a new Donut object according to user input.
     */
    private void setDonut() {
        tempDonut = new Donut();
        if (quantityText.getText() != null)
            tempDonut.setAmount(Integer.parseInt(String.valueOf(
                quantityText.getText())));
        tempDonut.setFlavor(flavors.getSelectedItem());
        tempDonut.itemPrice();
    }

    /**
     * Update the contents of currentDonuts and subtotalText.
     */
    private void refreshTextFields() {
        //reset listView Position
        selected = 0;
        String[] temp = tempOrder.toString().split("\n");
        temp = Arrays.copyOf(temp, temp.length - 1);

        //refresh and populate temporarily selected Donuts
        List<String> list = Arrays.asList(temp);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                list);
        currentDonuts.setAdapter(arrayAdapter);

        tempOrder.orderPrice();
        double subtotal = tempOrder.getSubtotal();
        subtotalText.setText(df.format(subtotal));
    }

    /**
     * Event function to finalize and add current Donut choices to an Order.
     * @param view current View object
     */
    public void addToOrder(View view) {
        try {
            if (tempOrder != null) {
                for (MenuItem i : tempOrder.getItemList())
                    MainActivity.mainOrder.add(i);
                //good to set null before closing out of sub-Activity
                tempOrder = null;
                this.finish();
            }
        } catch (Exception ex) {
            throwToast(ex.getMessage());
        }
    }

    /**
     * Helper to open Toast Message box when exception occurs.
     * @param ex String literal containing exception details
     */
    public void throwToast(String ex) {
        Toast.makeText(this.getApplicationContext(), ERROR +
                        ex, Toast.LENGTH_SHORT).show();
    }
}
