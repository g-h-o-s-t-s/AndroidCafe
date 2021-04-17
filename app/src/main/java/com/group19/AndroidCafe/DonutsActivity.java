package com.group19.AndroidCafe;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.List;

import static com.group19.AndroidCafe.Consts.df;

/**
 * DonutsActivity to add Donuts to static Order.
 @author Sagnik Mukherjee, Michael Choe
 */
public class DonutsActivity extends AppCompatActivity
{
    //data fields
    Order tempOrder;
    Donut tempDonut;

    //Android Node element handles.
    private ListView flavors;
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

        tempOrder = new Order();
        quantityText.setEnabled(false);
        showFlavors(getCurrentFocus());
    }

    /**
     * Event function to show specific flavors depending on donut type.
     * @param view current View object
     */
    public void showFlavors(View view) {
        List<Donut.Flavor> enumList = Arrays.asList(
                Donut.Flavor.class.getEnumConstants());

        ArrayAdapter<Donut.Flavor> arrayAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                enumList);

        flavors.setAdapter(arrayAdapter);
    }

    /**
     * Quick helper to reset flavors and quantity, disable quantity.
     */
    private void resetSelections() {
        //forces user to start over each time
        tempDonut = null;
        quantityText.setText("");
        quantityText.setEnabled(true);
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
            if (currentDonuts.getSelectedItem() != null) {
                int selected = currentDonuts.getSelectedItemPosition();
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
        Toast.makeText(this.getApplicationContext(),
                "Failed to launch sub-activity. Details as follows...\n" +
                        ex, Toast.LENGTH_SHORT).show();
    }
}
