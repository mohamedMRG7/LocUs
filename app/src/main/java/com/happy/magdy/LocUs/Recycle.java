package com.happy.magdy.LocUs;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;



public class Recycle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.themain);


        String[] title={"Et3lem w 3lem","Chefchaon","Makan","Zone"};
        int [] imgs={R.drawable.et3lm,R.drawable.chefchaon,R.drawable.makan ,R.drawable.zone};
        String[] region={"CAIRO","EMBABA","EL MAZALAT","EL 5LFAWY"};
        boolean [] available={true,false,true,false};
        Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        NavDrawerFragment nav= new NavDrawerFragment();
        nav.setup((DrawerLayout)findViewById(R.id.activity_main),this,toolbar);

        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.recyclerView);

        Recycler_adapter adapter=new Recycler_adapter(title,imgs,this,region,available);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



    }


}
