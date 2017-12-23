package com.example.ibrahim.international_app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class InternationalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void back(View v){
        finish();
    }
}
