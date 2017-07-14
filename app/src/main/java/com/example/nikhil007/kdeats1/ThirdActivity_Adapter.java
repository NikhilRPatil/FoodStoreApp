package com.example.nikhil007.kdeats1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by amangupta on 14/07/17.
 */

public class ThirdActivity_Adapter extends BaseAdapter{

    private Object instanceOf;
    private Context context;
    private View view;
    private ArrayList<String> menu_namesAL;
    private ArrayList<Integer> menu_iconAL;
    private ArrayList<String> detailsAL;

    public ThirdActivity_Adapter(Context context,Object instanceOf, ArrayList<String> menu_namesAL,ArrayList<Integer> menu_iconAL,ArrayList<String> detailsAL){
        this.context = context;
        this.instanceOf = instanceOf;
        this.menu_namesAL = menu_namesAL;
        this.menu_iconAL = menu_iconAL;
        this.detailsAL = detailsAL;

    }

    @Override
    public int getCount() {
        return menu_iconAL.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = view;
        ThirdActivity_Adapter.ViewHolder holder = null;

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.single_row_for_thirdscreen, parent, false);

            holder = new ViewHolder(row);
            row.setTag(holder);
        } else {
            holder = (ThirdActivity_Adapter.ViewHolder) row.getTag();
        }

        if (instanceOf != null && instanceOf instanceof Third_Activity) {

            if (context.getResources().getConfiguration().orientation == context.getResources().getConfiguration().ORIENTATION_PORTRAIT) {
//                ImageView imageView1 = (ImageView) vi.findViewById(R.id.imageView1);
                holder.list_image.setImageResource(menu_iconAL.get(position));

//                TextView textView1 = (TextView) vi.findViewById(R.id.textView1);
                holder.menu_name.setText(menu_namesAL.get(position));
                holder.details.setText(detailsAL.get(position));
//
            }
        }
        return row;
    }

    public class ViewHolder {
        private TextView menu_name,details;
        private ImageView list_image;

        public ViewHolder(View view) {
            menu_name = (TextView) view.findViewById(R.id.menu_name);
            details = (TextView) view.findViewById(R.id.details);
            list_image = (ImageView) view.findViewById(R.id.list_image);


//            txt_customer_name1.setGravity(Gravity.CENTER);
//            txt_mobile1.setGravity(Gravity.CENTER);

        }
    }
}
