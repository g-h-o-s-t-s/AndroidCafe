package com.group19.AndroidCafe;

import androidx.appcompat.app.AppCompatActivity;

/**
 * OrderActivity to finalize an Order instance.
 @author Sagnik Mukherjee, Michael Choe
 */
public class OrderActivity extends AppCompatActivity
{
//    /* -- Data Fields. -- */
//    //JavaFX Node element handles.
//     private TextArea subtotalText;
//     private TextArea salesTaxText;
//     private TextArea totalText;
//     private ListView<String> currentItems = new ListView<>();
//
//     private Button removeItemButton;
//     private Button placeOrderButton;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.order_activity);
//    }
//
//    /**
//     * A sort of "constructor" class for the Controller.
//     * Links Action Events to related JavaFX nodes.
//     */
//    public void initialize() {
//        //calculate and display Order subtotal/tax/total
//        updateFields();
//
//        removeItemButton.setOnMouseClicked((event) -> removeMenuItem());
//        placeOrderButton.setOnMouseClicked((event) -> placeOrder());
//    }
//
//    /**
//     * Event function to add Order to overall StoreOrders.
//     */
//    private void placeOrder() {
//        try {
//            if (MainActivity.mainOrder != null) {
//                MainActivity.mainStoreOrder.add(MainActivity.mainOrder);
//                MainActivity.mainOrder = new Order();
//
//                Stage stage = (Stage) placeOrderButton.getScene().getWindow();
//                stage.close();
//            }
//        } catch (Exception ex) {
//            throwToast(ex.getMessage());
//        }
//    }
//
//    /**
//     * Event function to remove the selected MenuItem from currentItems.
//     * No action will occur if ListView has no selected item.
//     */
//    private void removeMenuItem() {
//        try {
//            if (!currentItems.getSelectionModel().isEmpty()) {
//                int selected =
//                        currentItems.getSelectionModel().getSelectedIndex();
//                MainActivity.mainOrder.getItemList().remove(selected);
//
//                updateFields();
//            }
//        } catch (Exception ex) {
//            throwToast(ex.getMessage());
//        }
//    }
//
//    /**
//     * Helper to update the textArea/listView displays in real-time (ideally).
//     */
//    private void updateFields() {
//        MainActivity.mainOrder.orderPrice();
//        updateTexts();
//
//        //populate currentItems listView with all MenuItem
//        //object details, but leave off the last line
//        //which just reports the order's price field values
//        currentItems.getItems().clear();
//        String[] temp = MainActivity.mainOrder.toString().split("\n");
//        temp = Arrays.copyOf(temp, temp.length - 1);
//        currentItems.getItems().addAll(temp);
//    }
//
//    /**
//     * Another helper to update textAreas specifically.
//     */
//    private void updateTexts() {
//        subtotalText.setText(String.valueOf(
//                df.format(MainActivity.mainOrder.getSubtotal())));
//        salesTaxText.setText(String.valueOf(
//                df.format(MainActivity.mainOrder.getTax())));
//        totalText.setText(String.valueOf(
//                df.format(MainActivity.mainOrder.getTotal())));
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
}
