package com.example.dani.proyectoporteros;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import org.w3c.dom.Text;

public class DetalleActivity extends AppCompatActivity {

    Ejercicio ejercicio;
    StorageReference storageRF;

    ImageView imagenEjercicio;
    TextView tvNombreEjercicio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        storageRF = FirebaseStorage.getInstance().getReference();

        imagenEjercicio = (ImageView)findViewById(R.id.iv_ejercicio);
        tvNombreEjercicio  = (TextView)findViewById(R.id.tvNombreEjercicio);

        Bundle b = getIntent().getExtras();

        if(b!=null){
            ejercicio = b.getParcelable("EJERCICIO");

            tvNombreEjercicio.setText(ejercicio.getNombre());
            cargarImagen(ejercicio.getImagen());
        }
    }



    private void cargarImagen(String nombre){
        storageRF.child("imagenes/"+nombre).getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Glide.with(getApplicationContext()).load(uri.toString()).into(imagenEjercicio);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.e("IMAGEN DETALLES", e.getMessage());
            }
        });
    }
}
