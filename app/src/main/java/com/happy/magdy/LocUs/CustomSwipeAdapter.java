package com.happy.magdy.LocUs;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by engma on 10/19/2016.
 */
public class CustomSwipeAdapter extends PagerAdapter {
    private LayoutInflater layoutInflater;
    private Context ctx ;
    public CustomSwipeAdapter(Context ctx)
    {
        this.ctx = ctx;


    }
    private  int [] images_resources =
            {
                    R.drawable.logo1,
                    R.drawable.logo2,
                    R.drawable.logo3,
                    R.drawable.logo4,
                    R.drawable.logo5

            };

    @Override
    public int getCount() {

        return images_resources.length;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = layoutInflater.inflate(R.layout.activity_screen,container,false);
        ImageView imageView =(ImageView) v.findViewById(R.id.image_ux);
        TextView textView1 = (TextView)v.findViewById(R.id.txt_ux1) ;
        TextView textView2 = (TextView)v.findViewById(R.id.txt_ux2) ;
        imageView.setImageResource(images_resources[position]);
        textView1.setText("Logo: "+position);
        textView2.setText("this is the logo number "+position);



        container.addView(v);
        return v;
    }

    @Override
    public boolean isViewFromObject(View view, Object object)
    {
        return (view ==(RelativeLayout) object);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView((RelativeLayout)object);

    }
}
