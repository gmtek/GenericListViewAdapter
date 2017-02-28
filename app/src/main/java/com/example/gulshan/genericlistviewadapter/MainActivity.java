package com.example.gulshan.genericlistviewadapter;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements IUniversalAdapter<Item> {

    private ArrayList<Item> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        itemList = generateItemsList();

        ListView itemsListView  = (ListView)findViewById(R.id.list_view_items);

        itemsListView.setAdapter(new UniversalAdapter<Item>(itemList, this));
    }

    @Override
    public View getView(Item currentItem, int position, View convertView, ViewGroup parent) {

        UniversalViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(this).inflate(R.layout.liatview_item_template, parent, false);
            viewHolder = new UniversalViewHolder();
            viewHolder.saveView("itemName", convertView.findViewById(R.id.text_view_item_name));
            viewHolder.saveView("itemDescription", convertView.findViewById(R.id.text_view_item_description));

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (UniversalViewHolder) convertView.getTag();
        }

        viewHolder.<TextView>getView("itemName").setText(currentItem.getItemName());
        viewHolder.<TextView>getView("itemDescription").setText(currentItem.getItemDescription());

        return convertView;
    }

    private ArrayList<Item> generateItemsList() {
        String itemNames[] = getResources().getStringArray(R.array.items_name);
        String itemDescriptions[] = getResources().getStringArray(R.array.item_description);

        ArrayList<Item> list = new ArrayList<>();

        for (int i = 0; i < itemNames.length; i++) {
            list.add(new Item(itemNames[i], itemDescriptions[i]));
        }

        return list;
    }
}
