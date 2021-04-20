package com.group19.AndroidCafe;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import static com.group19.AndroidCafe.Consts.*;

/**
 * CoffeeActivity to add Coffee to static Order.
 @author Sagnik Mukherjee, Michael Choe
 */
public class CoffeeActivity extends AppCompatActivity
{
    //data fields
    Coffee tempCoffee;

    //Android Node element handles.
    private Spinner sizes;
    private CheckBox cream;
    private CheckBox syrup;
    private CheckBox milk;
    private CheckBox caramel;
    private CheckBox whipped_cream;
    private TextView subtotalText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coffee_activity);

        //bind object handles to XML id's
        sizes = findViewById(R.id.sizeOptions);
        cream = findViewById(R.id.creamBox);
        syrup = findViewById(R.id.syrupBox);
        milk = findViewById(R.id.milkBox);
        caramel = findViewById(R.id.caramelBox);
        whipped_cream = findViewById(R.id.whippedBox);
        subtotalText = findViewById(R.id.subtotalCoffee);

        tempCoffee = new Coffee();
        showSizes(getCurrentFocus());
        initCheckListeners();
    }

    /**
     * Event function to show Coffee size options.
     * @param view current View object
     */
    public void showSizes(View view) {
        ArrayAdapter<CharSequence> adapter =
                ArrayAdapter.createFromResource(this,
                R.array.sizes_array, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        sizes.setAdapter(adapter);
    }

    /**
     * Helper to add on Event Listeners for each distinct CheckBox,
     * updates respective flavor for tempCoffee.
     */
    private void initCheckListeners() {
        //checkboxes enabled once size is chosen
        sizes.setOnItemSelectedListener(new AdapterView.
                OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView,
                    View selectedItemView, int position, long id) {
                updateSize();
                //Spinner's selected item doesn't respond to android:textSize
                //under Spinner theme in styles.xml, so we use this instead
                ((TextView) parentView.getChildAt(INT_ZERO)).
                        setTextSize(SPINNER_TEXT_SIZE);
            }

            //nothing to implement here
            @Override
            public void onNothingSelected(AdapterView<?> parent) { }
        });

        cream.setOnCheckedChangeListener(new CompoundButton.
                OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                    boolean isChecked) {
                updateAddIn(cream);
            }
        });

        syrup.setOnCheckedChangeListener(new CompoundButton.
                OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                    boolean isChecked) {
                updateAddIn(syrup);
            }
        });

        milk.setOnCheckedChangeListener(new CompoundButton.
                OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                    boolean isChecked) {
                updateAddIn(milk);
            }
        });

        caramel.setOnCheckedChangeListener(new CompoundButton.
                OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                    boolean isChecked) {
                updateAddIn(caramel);
            }
        });

        whipped_cream.setOnCheckedChangeListener(new CompoundButton.
                OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                    boolean isChecked) {
                updateAddIn(whipped_cream);
            }
        });
    }

    /**
     * Event function to set size of Coffee.
     */
    private void updateSize() {
        try {
            tempCoffee.setSize((String) sizes.getSelectedItem());
            tempCoffee.itemPrice();
            updateSubtotal();
        } catch (Exception ex) {
            throwToast(ex.getMessage());
        }
    }

    /**
     * Helper to update the AddIn for tempCoffee based on CheckBox values.
     * @param c CheckBox value, add String if checked, remove otherwise
     */
    private void updateAddIn(CheckBox c) {
        try {
            boolean selected = c.isChecked();
            if (selected)
                tempCoffee.add(c.getText());
            else
                tempCoffee.remove(c.getText());

            tempCoffee.itemPrice();
            updateSubtotal();
        } catch (Exception ex) {
            throwToast(ex.getMessage());
        }
    }

    /**
     * Helper to update the subtotalText display in real-time (ideally).
     */
    private void updateSubtotal() {
        try {
        subtotalText.setText(df.format(tempCoffee.getPrice()));
        } catch (Exception ex) {
            throwToast(ex.getMessage());
        }
    }

    /**
     * Event function to finalize and add tempCoffee to mainOrder.
     * @param view current View object
     */
    public void addToOrder(View view) {
        try {
            if (tempCoffee != null) {
                MainActivity.mainOrder.add(tempCoffee);
                //good to set null before closing out of sub-Activity
                tempCoffee = null;
            }
        } catch (Exception ex) {
            throwToast(ex.getMessage());
        } finally {
            this.finish();
        }
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
