package com.happy.magdy.LocUs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Splash extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);
        final TextView loading = (TextView) findViewById(R.id.text2);
        try {
            new Thread()
            {
                public void run()
                {

                    try {
                        sleep(2000);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    finally {
                        finish();
                        Intent i = new Intent(getBaseContext(),MainActivity.class);
                        startActivity(i);
                    }

                }
            }.start();

        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
