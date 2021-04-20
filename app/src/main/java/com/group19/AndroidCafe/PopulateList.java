package com.group19.AndroidCafe;

import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Arrays;
import java.util.List;

/**
 * PopulateList is an abstract superclass, since the single method
 * here is used in both Donuts, Order, and StoreOrders, to
 * populate a ListView object with the appropriate items.
 @author Sagnik Mukherjee, Michael Choe
 */
public abstract class PopulateList extends AppCompatActivity
{
    /**
     * Update contents of ListView object.
     * @param lv ListView object reference to be updated
     * @param temp String[] toString contents to be added to ListView
     */
    protected void populateListHelper(ListView lv, String[] temp) {
        temp = Arrays.copyOf(temp, temp.length - 1);

        //refresh and populate ListView
        List<String> list = Arrays.asList(temp);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(
                this, R.layout.list_view, list);
        lv.setAdapter(arrayAdapter);
    }
}
