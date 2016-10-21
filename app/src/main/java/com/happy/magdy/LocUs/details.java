package com.happy.magdy.LocUs;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class details extends AppCompatActivity {

    String[] title={"Et3lem w 3lem","Chefchaon","Makan","Zone"};
    int [] imgs={R.drawable.et3lm,R.drawable.chefchaon,R.drawable.makan ,R.drawable.zone};
    String[] region={"CAIRO","EMBABA","EL MAZALAT","EL 5LFAWY"};
    int []img2={R.drawable.et3lm,R.drawable.chefchaon,R.drawable.makan };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details);


        Intent i = getIntent();
        int name = i.getIntExtra("name",0);
        int pos = i.getIntExtra("pos",0);
        TextView textView1 = (TextView)findViewById(R.id.txt1);
        textView1.setText(title[pos]);
        TextView textView2 = (TextView)findViewById(R.id.txt2);
        textView1.setText(region[pos]);
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle(title[pos]);
        setSupportActionBar(toolbar);

        ViewPager pager=(ViewPager)findViewById(R.id.pager);
        ViewpagerAdapter ad2=new ViewpagerAdapter(imgs,this);
        pager.setAdapter(ad2);
        ImageView imageView = (ImageView)findViewById(R.id.profile_id);
        imageView.setImageResource(name);
        //getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);




    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                finish();
        }
        return (super.onOptionsItemSelected(menuItem));
    }
}

