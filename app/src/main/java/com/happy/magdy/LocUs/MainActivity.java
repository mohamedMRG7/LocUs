package com.happy.magdy.LocUs;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager ;
    private CustomSwipeAdapter viewPagerAdapter;
    private Intromanager intromanager ;
    private TextView [] dots ;

    Button next , skip ;
    private LinearLayout dotLayout ;
    private  int [] layouts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //intromanager = new Intromanager(this);


        Intent intent = new Intent(this, Specification.class);
        startActivity(intent);
        finish();
       /* if (!intromanager.check()) {

            Intent intent = new Intent(this, Specification.class);
            startActivity(intent);
            finish();
        } else {
            intromanager.setFirst(false);
        }
*/

        viewPager = (ViewPager) findViewById(R.id.view_pager);
        viewPagerAdapter = new CustomSwipeAdapter(this);
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.addOnPageChangeListener(viewListener);
       /* dotLayout = (LinearLayout)findViewById(R.id.layout_dots);
        next = (Button)findViewById(R.id.next);
        skip = (Button)findViewById(R.id.skip);

       layouts =new int[] {
            R.layout.activity_screen1,
                    R.layout.activity_screen2,
                    R.layout.activity_screen3,
                    R.layout.activity_screen4,
                    R.layout.activity_screen5,
        };
        addButtonDots(0);
        changeStatusBarColor();

        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(),Main2Activity.class);
                startActivity(intent);
                finish();
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int c = getItem(1);
                 if(c<layouts.length)
                 {
                     viewPager.setCurrentItem(c);
                     updateButtonDots(c);

                 }
                else
                 {
                     Intent intent = new Intent(getApplication(),Main2Activity.class);
                     startActivity(intent);
                     finish();

                 }
            }
        });


    }
    private int getItem(int i )
    {
        return  viewPager.getCurrentItem()+i ;
    }
    */
    }
   /* private void addButtonDots (int pos)
    {

        dots = new TextView[layouts.length];
        int [] colorActive = getResources().getIntArray(R.array.dot_active);
        int [] colorInActive = getResources().getIntArray(R.array.dot_inactive);
        dotLayout.removeAllViews();
        for (int i = 0 ; i <  dots.length;i++)
        {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("•"));
            //•••••
            if(i != pos )
            { dots[i].setTextColor(colorInActive[pos]); }
            else { dots[i].setTextColor(colorActive[pos]);}
            dots[i].setTextSize(35);
            dotLayout.addView(dots[i]);


        }
    }
    private void updateButtonDots (int pos)
    {

        dotLayout.removeAllViews();

        int [] colorActive = getResources().getIntArray(R.array.dot_active);
        int [] colorInActive = getResources().getIntArray(R.array.dot_inactive);

        for (int i = 0 ; i <  dots.length;i++)
        {

            dots[i].setText(Html.fromHtml("•"));
            //•••••
            if(i != pos )
            { dots[i].setTextColor(colorInActive[pos]); }
            else { dots[i].setTextColor(colorActive[pos]);}
            dots[i].setTextSize(35);
            dotLayout.addView(dots[i]);


        }
    }*/
    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

           // addButtonDots(position);
        /*    if(position==layouts.length-1)
            {
                next.setText("Proceed");
                skip.setVisibility(View.GONE);


            }
            else {

                next.setText("Next");
                skip.setVisibility(View.VISIBLE);

            }*/
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    } ;
    public void changeStatusBarColor()
    {

        if(Build.VERSION.SDK_INT == Build.VERSION_CODES.LOLLIPOP)
        {

            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);


        }
    }

}
