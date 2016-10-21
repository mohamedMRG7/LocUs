package com.happy.magdy.LocUs;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.happy.magdy.LocUs.R;

/**
 * Created by moham on 21/10/2016.
 */




public class ViewpagerAdapter extends PagerAdapter {

    int [] imgres;
    Context ctx;

    public ViewpagerAdapter(int[] imgres , Context ctx) {
        this.imgres = imgres;
        this.ctx=ctx;
    }

    @Override
    public int getCount() {
        return imgres.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        LayoutInflater inflater=(LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View v=inflater.inflate(R.layout.inf_viewpager,container,false);

        ImageView imageView=(ImageView)v.findViewById(R.id.inf_pageradapter);
        imageView.setImageResource(imgres[position]);

        container.addView(v);
        return v;


    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);
    }
}
