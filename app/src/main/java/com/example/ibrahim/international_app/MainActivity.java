package com.example.ibrahim.international_app;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    public final static int ENGLISH = 0;
    public final static int FRENCH = 1;
    public final static int ITALIAN = 2;
    public final static int POLISH = 3;
    public final static int SPANISH = 4;

    Spinner languageChooser;
    TextView tv;
    Button btn;

    Locale locale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        languageChooser = (Spinner) findViewById(R.id.cylspinner);
        languageChooser.setOnItemSelectedListener(this);

        tv = (TextView) findViewById(R.id.txvLanguage);

        btn = (Button) findViewById(R.id.btnLaunch);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent secondActivity = new Intent(MainActivity.this, InternationalActivity.class);
                startActivity(secondActivity);
            }
        });
    }

    //Méthode qui se déclenche lorsqu'on choisit un élément de notre Spinner
    public void onItemSelected(AdapterView<?> parent, View view,int position, long id){
        tv.setText(R.string.lang);
        btn.setText(R.string.launch);
        switch (position){
            case ENGLISH: locale = new Locale("en_EN"); break;
            case FRENCH: locale = new Locale("fr_FR"); break;
            case ITALIAN: locale = new Locale("it_IT"); break;
            case POLISH: locale = new Locale("pl_PL"); break;
            case SPANISH: locale = new Locale("es_ES"); break;
        }
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.setLocale(locale);
        this.getApplicationContext().getResources().updateConfiguration(config,null);

        Toast.makeText(this,"Langue choisie : "+parent.getItemAtPosition(position).toString(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
