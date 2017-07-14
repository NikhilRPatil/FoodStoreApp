package com.example.nikhil007.kdeats1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

/**
 * Created by Nikhil007 on 13-07-2017.
 */

public class MenuListAdapter extends BaseAdapter {

    Context context;
    int logos[];
    LayoutInflater inflter;
    public MenuListAdapter(Context applicationContext, int[] logos) {
        this.context = applicationContext;
        this.logos = logos;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return logos.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        View view = inflter.inflate(R.layout.menu_list, null); // inflate the layout
        ImageView icon = (ImageView) view.findViewById(R.id.menu_category_images); // get the reference of ImageView
        icon.setImageResource(logos[i]); // set logo images
        return view;
    }
}
