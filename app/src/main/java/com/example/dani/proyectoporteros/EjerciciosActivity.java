package com.example.dani.proyectoporteros;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class EjerciciosActivity extends AppCompatActivity {

    ListView lvEjercicios;
    private DatabaseReference dbRef;
    private ValueEventListener valueEventListener;
    ArrayList<Ejercicio> lista_ejercicios = new ArrayList<Ejercicio>();
    String tipo_ejercicio ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicios);

        lvEjercicios = (ListView) findViewById(R.id.lvEjercicios);

        Bundle b = getIntent().getExtras();

        if(b!=null){
            tipo_ejercicio = b.getString("EJERCICIO");

            cargarDatosFirebase();
        }

    }
    private void cargarDatosFirebase() {
        dbRef = FirebaseDatabase.getInstance().getReference()
                .child(tipo_ejercicio);
        valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                lista_ejercicios.clear();
                for (DataSnapshot productosDataSnapshot : dataSnapshot.getChildren()) {
                    cargarListView(productosDataSnapshot);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e("EjerciciosActivity", "DATABASE ERROR");

            }
        };
        dbRef.addValueEventListener(valueEventListener);
    }

    private void cargarListView(DataSnapshot dataSnapshot) {

        lista_ejercicios.add(dataSnapshot.getValue(Ejercicio.class));
        AdaptadorEjercicio adapter = new AdaptadorEjercicio(getApplicationContext(),
                lista_ejercicios);
        lvEjercicios.setAdapter(adapter);

        lvEjercicios.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Ejercicio ejercicio = ((Ejercicio) adapterView.getItemAtPosition(i));

                Intent intent=new Intent(getApplicationContext(), DetalleActivity.class);
                intent.putExtra("EJERCICIO", ejercicio);
                startActivity(intent);
            }
        });

    }};



