package com.example.ibrahim.international_app;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    public final static int ENGLISH = 0;
    public final static int FRENCH = 1;
    public final static int ITALIAN = 2;
    public final static int POLISH = 3;
    public final static int SPANISH = 4;

    Spinner languageChooser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        languageChooser = (Spinner) findViewById(R.id.cylspinner);
        languageChooser.setOnItemSelectedListener(this);
    }

    public void launchActivity(View v){

    }

    public void onItemSelected(AdapterView<?> parent, View view,int position, long id){
        Locale locale = new Locale("en_EN");
        switch (position){
            case ENGLISH: locale = new Locale("en_EN"); break;
            case FRENCH: locale = new Locale("fr_FR"); break;
            case ITALIAN: locale = new Locale("it_IT"); break;
            case POLISH: locale = new Locale("pl_PL"); break;
            case SPANISH: locale = new Locale("es_ES"); break;
        }
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        this.getApplicationContext().getResources().updateConfiguration(config,null);
        Toast.makeText(this,"position : "+position,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        
    }
}
