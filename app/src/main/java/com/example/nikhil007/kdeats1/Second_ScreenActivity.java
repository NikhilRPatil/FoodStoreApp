package com.example.nikhil007.kdeats1;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

import me.relex.circleindicator.CircleIndicator;

public class Second_ScreenActivity extends AppCompatActivity {

    private static ViewPager mPager;
    private static int currentPage = 0;
    private static final Integer[] imgs= {R.drawable.slider_1,R.drawable.slider_2,R.drawable.slider_3,R.drawable.slider_2,R.drawable.slider_3};
    private ArrayList<Integer> imgsArray = new ArrayList<Integer>();

    GridView simpleGrid;
    int logos[] = {R.drawable.biryani, R.drawable.cake, R.drawable.chinese, R.drawable.pizza,
            R.drawable.fruit, R.drawable.salad};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second__screen);

        simpleGrid = (GridView) findViewById(R.id.simpleGridView); // init GridView
        // Create an object of CustomAdapter and set Adapter to GirdView
        MenuListAdapter menuListAdapter = new MenuListAdapter(getApplicationContext(), logos);
        simpleGrid.setAdapter(menuListAdapter);
        // implement setOnItemClickListener event on GridView
        simpleGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // set an Intent to Another Activity
                 Intent intent = new Intent(Second_ScreenActivity.this, Third_Activity.class);
                intent.putExtra("image", logos[position]); // put image data in Intent
                 startActivity(intent); // start Intent
            }
        });
        init();
    }

    private void init() {
        for(int i=0;i<imgs.length;i++)
            imgsArray.add(imgs[i]);

        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setAdapter(new MyAdapter(Second_ScreenActivity.this,imgsArray));
        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);
        indicator.setViewPager(mPager);

        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == imgs.length) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        if (item.getItemId()==R.id.action_settings1) {

            Intent intent = new Intent(Second_ScreenActivity.this, Third_Activity.class);

            startActivity(intent);

        }


        return true;
    }




}
