package com.example.gulshan.genericlistviewadapter;

import android.view.View;

import java.util.HashMap;

/**
 * Created by gulshan on 27/02/17.
 */
public class UniversalViewHolder {

    private HashMap<String,View> viewList;

    public UniversalViewHolder() {
        viewList = new HashMap<String, View>() ;
    }

    public void saveView(String key, View viewElement){
        viewList.put(key,viewElement);
    }

    public <T> T getView(String key){
        return (T)viewList.get(key);
    }

}
