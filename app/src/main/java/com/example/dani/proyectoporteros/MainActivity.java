package com.example.dani.proyectoporteros;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    //Seleccionar la duracion del Splash Screen
    private static final long SPLASH_SCREEN_DELAY= 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Seleccionar orientacion
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        setContentView(R.layout.activity_main);


        setContentView(R.layout.activity_main);

        TimerTask task = new TimerTask() {
            @Override
            public void run() {

                //Empezar nueva activity
                Intent mainIntent = new Intent().setClass(
                        MainActivity.this, MenuActivity.class);
                startActivity(mainIntent);
            }
        };

        //Simular una carga larga al iniciar la aplicacion
        Timer timer=new Timer();
        timer.schedule(task,SPLASH_SCREEN_DELAY);
    }
}
