package com.he.lq.demo;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
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
