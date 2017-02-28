package com.example.gulshan.genericlistviewadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.HashMap;

/**
 * Created by gulshan on 27/02/17.
 */
public class UniversalAdapter<T> extends BaseAdapter {

    private Context context; //context
    private ArrayList<T> items; //data source of the list adapter
    private IUniversalAdapter<T> adapterDelegate;

    //public constructor
    public UniversalAdapter(ArrayList<T> items, IUniversalAdapter<T> adapterDelegate) {
        this.context = context;
        this.items = items;
        this.adapterDelegate = adapterDelegate;
    }

    @Override
    public int getCount() {
        return items.size(); //returns total of items in the list
    }

    @Override
    public Object getItem(int position) {
        return items.get(position); //returns list item at the specified position
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        return adapterDelegate.getView((T) getItem(position), position, convertView, parent);
    }
}