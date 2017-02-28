package com.example.gulshan.genericlistviewadapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by gulshan on 27/02/17.
 */
public interface IUniversalAdapter<T> {

    public View getView(T currentItem, int position, View convertView, ViewGroup parent);
}
