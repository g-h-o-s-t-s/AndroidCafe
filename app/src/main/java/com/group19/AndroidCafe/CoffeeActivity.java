package com.group19.AndroidCafe;

import androidx.appcompat.app.AppCompatActivity;

/**
 * CoffeeActivity to add Coffee to static Order.
 @author Sagnik Mukherjee, Michael Choe
 */
public class CoffeeActivity extends AppCompatActivity
{
//    //data fields
//    Coffee tempCoffee;
//
//    //JavaFX Node element handles.
//     private ToggleGroup size;
//     private CheckBox creamBox;
//     private CheckBox syrupBox;
//     private CheckBox milkBox;
//     private CheckBox caramelBox;
//     private CheckBox whippedBox;
//     private TextField subtotalText;
//     private Button addToOrderButton;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.coffee_activity);
//    }
//
//    /**
//     * A sort of "constructor" class for the Controller.
//     * Links Action Events to related JavaFX nodes.
//     */
//    public void initialize() {
//        tempCoffee  = new Coffee();
//        disableCheckboxes();
//        addToOrderButton.setDisable(true);
//
//        //Adds an Event Listener to the RadioButton ToggleGroup.
//        //If any of the sizes are selected, the checkboxes are enabled.
//        size.selectedToggleProperty().addListener(
//                (observable, oldValue, newValue) -> {
//            RadioButton r = (RadioButton) size.getSelectedToggle();
//
//            if (r != null) {
//                updateSize(r);
//                enableCheckboxes();
//                addToOrderButton.setDisable(false);
//            }
//        });
//
//        initCheckListeners();
//
//        addToOrderButton.setOnMouseClicked((event) -> addToOrder());
//    }
//
//    /**
//     * Helper to add on Event Listeners for each distinct CheckBox,
//     * updates respective flavor for tempCoffee.
//     */
//    private void initCheckListeners() {
//        creamBox.selectedProperty().addListener(
//                (observable, oldValue, newValue) -> updateAddIn(creamBox));
//
//        syrupBox.selectedProperty().addListener(
//                (observable, oldValue, newValue) -> updateAddIn(syrupBox));
//
//        milkBox.selectedProperty().addListener(
//                (observable, oldValue, newValue) -> updateAddIn(milkBox));
//
//        caramelBox.selectedProperty().addListener(
//                (observable, oldValue, newValue) -> updateAddIn(caramelBox));
//
//        whippedBox.selectedProperty().addListener(
//                (observable, oldValue, newValue) -> updateAddIn(whippedBox));
//    }
//
//    /**
//     * Helper to disable checkboxes.
//     */
//    private void disableCheckboxes() {
//        creamBox.setDisable(true);
//        syrupBox.setDisable(true);
//        milkBox.setDisable(true);
//        caramelBox.setDisable(true);
//        whippedBox.setDisable(true);
//    }
//
//    /**
//     * Helper to enable checkboxes.
//     */
//    private void enableCheckboxes() {
//        creamBox.setDisable(false);
//        syrupBox.setDisable(false);
//        milkBox.setDisable(false);
//        caramelBox.setDisable(false);
//        whippedBox.setDisable(false);
//    }
//
//    /**
//     * Event function to set size of Coffee.
//     * @param r RadioButton value, if selected
//     */
//    private void updateSize(RadioButton r) {
//        String selected = r.getText();
//        tempCoffee.setSize(selected);
//        tempCoffee.itemPrice();
//        updateSubtotal();
//    }
//
//    /**
//     * Helper to update the AddIn for tempCoffee based on CheckBox values.
//     * @param c CheckBox value, add String if checked, remove otherwise
//     */
//    private void updateAddIn(CheckBox c) {
//        boolean selected = c.isSelected();
//        if (selected)
//            tempCoffee.add(c.getText());
//        else
//            tempCoffee.remove(c.getText());
//
//        tempCoffee.itemPrice();
//        updateSubtotal();
//    }
//
//    /**
//     * Helper to update the subtotalText display in real-time (ideally).
//     */
//    private void updateSubtotal() {
//        subtotalText.setText(String.valueOf(
//                df.format(tempCoffee.getPrice())));
//    }
//
//    /**
//     * Event function to finalize and add tempCoffee to mainOrder.
//     */
//    private void addToOrder() {
//        try {
//            if (tempCoffee != null) {
//                MainActivity.mainOrder.add(tempCoffee);
//                //good to set null before closing out of sub-Activity
//                tempCoffee = null;
//                Stage stage = (Stage) addToOrderButton.getScene().getWindow();
//                stage.close();
//            }
//        } catch (Exception ex) {
//            throwToast(ex.getMessage());
//        }
//    }
//
//    /**
//     * Helper to open Toast Message box when exception occurs.
//     * @param ex String literal containing exception details
//     */
//    public void throwToast(String ex) {
//        Toast.makeText(this.getApplicationContext(),
//                "Failed to launch sub-activity. Details as follows...\n" +
//                        ex, Toast.LENGTH_SHORT).show();
//    }
//
}
