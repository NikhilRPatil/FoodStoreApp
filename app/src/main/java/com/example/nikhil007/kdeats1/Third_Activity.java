package com.example.nikhil007.kdeats1;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

import me.relex.circleindicator.CircleIndicator;

public class Third_Activity extends AppCompatActivity implements View.OnClickListener,AdapterView.OnItemClickListener{

    //UI variables
    private ListView listView;
    private ViewPager second_pager;
    private ImageView full_image_view;
    private ImageButton left_nav,right_nav;


    //NON-UI variables

    private ArrayList<String> menu_namesAL;
    private ArrayList<Integer> menu_iconAL;
    private ArrayList<String> detailsAL;
    private int SelectedPosition=-1;
    private ThirdActivity_Adapter adapter;
    private  int currentPage=0;
    private String TAG = "Third_Activity";
    private Integer[] imgs= {R.drawable.slider_1,R.drawable.slider_2,R.drawable.slider_3,R.drawable.slider_2,R.drawable.slider_3};
    private ArrayList<Integer> imgsArray = new ArrayList<Integer>();

    int logos[] = {R.drawable.biryani, R.drawable.cake, R.drawable.chinese, R.drawable.pizza,
            R.drawable.fruit, R.drawable.salad};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_screen_activity);
        init();
        generateEvents();

    }

    private void generateEvents() {
        left_nav.setOnClickListener(this);
        right_nav.setOnClickListener(this);
    }

    private void init() {

        // mDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("(SAHI BIRYANI)");
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //findviews
        listView = (ListView) findViewById(R.id.listView);
        second_pager = (ViewPager) findViewById(R.id.second_pager);
        full_image_view = (ImageView) findViewById(R.id.full_image_view);
        left_nav = (ImageButton) findViewById(R.id.left_nav);
        right_nav = (ImageButton) findViewById(R.id.right_nav);

        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            return;
        }
        int res = extras.getInt("image");
//            full_image_view.setImageResource(res);
        full_image_view.setBackgroundResource(res);



        menu_iconAL = new ArrayList<Integer>();
        menu_namesAL = new ArrayList<String>();
        detailsAL = new ArrayList<String>();

        adapter = new ThirdActivity_Adapter(Third_Activity.this,Third_Activity.this,menu_namesAL,menu_iconAL,detailsAL);

        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        viewPager();

    }

    private void viewPager(){
        for(int i=0;i<imgs.length;i++)
            imgsArray.add(imgs[i]);

        second_pager = (ViewPager) findViewById(R.id.second_pager);
        second_pager.setAdapter(new MyAdapter(Third_Activity.this,imgsArray));

        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == imgs.length) {
                    currentPage = 0;
                }
                second_pager.setCurrentItem(currentPage++, true);
            }
        };
    }

    @Override
    protected void onResume() {
        super.onResume();
        addMenuIcons();
    }

    private void addMenuIcons() {
        menu_iconAL.clear();
        menu_namesAL.clear();
        detailsAL.clear();
        int pos=1;

        Log.d(TAG,"Aman Check image== "+getIntent().getExtras().get("image"));
//        getIntent().getExtras().get("image");

        menu_iconAL.add(R.drawable.biryani);
        menu_namesAL.add("20% Off, Use Code:NVN20");
        detailsAL.add("Expires on 2017-06-24");

        menu_iconAL.add(R.drawable.cake);
        menu_namesAL.add("Shahi Biryani (Server 1) Menu");
        detailsAL.add("Server 1");

        menu_iconAL.add(R.drawable.chinese);
        menu_namesAL.add("Shahi Biryani (Server 2) Menu");
        detailsAL.add("Server 2");
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    public void onClick(View v) {
    switch (v.getId()) {
        case R.id.left_nav:
            int tab = second_pager.getCurrentItem();
            if (tab > 0) {
                tab--;
                second_pager.setCurrentItem(tab);
            } else if (tab == 0) {
                second_pager.setCurrentItem(tab);
            }
            break;
        case R.id.right_nav:
            int tab1 = second_pager.getCurrentItem();
            tab1++;
            second_pager.setCurrentItem(tab1);
            break;
    }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        SelectedPosition=position;
        if(position==-1) {
            Toast.makeText(this, "1st Item", Toast.LENGTH_SHORT).show();
        }
        else if(position==2){
            Toast.makeText(this, "2st Item", Toast.LENGTH_SHORT).show();
        }
        else if(position==3){
            Toast.makeText(this, "3st Item", Toast.LENGTH_SHORT).show();
        }
    }
}
