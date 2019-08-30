package com.he.lq.demo;


import android.arch.lifecycle.LifecycleOwner;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import io.flutter.facade.FlutterFragment;

public class MainActivity extends AppCompatActivity implements LifecycleOwner {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, new FlutterFragment())
                    .commitNow();
        }
    }
}
