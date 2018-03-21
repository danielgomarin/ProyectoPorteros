package com.example.dani.proyectoporteros;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }
    public void ClickCalentamiento(View view) {
        Intent i = new Intent(getApplicationContext(), EjerciciosActivity.class);
        i.putExtra("EJERCICIO","CALENTAMIENTO");
        startActivity(i);
    }
    public void ClickAbdominales(View view) {
        Intent i = new Intent(getApplicationContext(), EjerciciosActivity.class);
        i.putExtra("EJERCICIO","ABDOMINALES");
        startActivity(i);
    }
    public void ClickResistencia(View view) {
        Intent i = new Intent(getApplicationContext(), EjerciciosActivity.class);
        i.putExtra("EJERCICIO", "RESISTENCIA");
        startActivity(i);
    }
    public void ClickVelocidaddereaccion(View view) {
        Intent i = new Intent(getApplicationContext(), EjerciciosActivity.class);
        i.putExtra("EJERCICIO", "VELOCIDAD DE REACCION");
        startActivity(i);
    }
    public void ClickJuegoaereo(View view) {
        Intent i = new Intent(getApplicationContext(), EjerciciosActivity.class);
        i.putExtra("EJERCICIO", "JUEGO AEREO");
        startActivity(i);
    }
    public void ClickJuegodepie(View view) {
        Intent i = new Intent(getApplicationContext(), EjerciciosActivity.class);
        i.putExtra("EJERCICIO", "JUEGO DE PIE");
        startActivity(i);
    }
    public void ClickDesplazamiento(View view) {
        Intent i = new Intent(getApplicationContext(), EjerciciosActivity.class);
        i.putExtra("EJERCICIO", "DESPLAZAMIENTO");
        startActivity(i);
    }
    public void ClickEstiramiento(View view) {
        Intent i = new Intent(getApplicationContext(), EjerciciosActivity.class);
        i.putExtra("EJERCICIO", "ESTIRAMIENTO");
        startActivity(i);
    }
    public void ClickMandanostuentrenamiento(View view) {
        Intent intent=new Intent(Intent.ACTION_SEND);
        String[] recipients={"appentrenamientosporteros@gmail.com"};
        intent.putExtra(Intent.EXTRA_EMAIL, recipients);
        intent.putExtra(Intent.EXTRA_SUBJECT,"Entrenamiento Personalizado");
        intent.setType("text/html");
        intent.setPackage("com.google.android.gm");
        startActivity(Intent.createChooser(intent, "Send mail"));

    }
}
