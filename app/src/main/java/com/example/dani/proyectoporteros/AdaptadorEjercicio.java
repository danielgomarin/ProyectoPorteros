package com.example.dani.proyectoporteros;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

/**
 * Created by Dani on 07/03/2018.
 */

public class AdaptadorEjercicio  extends ArrayAdapter<Ejercicio>{


        ArrayList<Ejercicio> ejercicios;
        Context c;
StorageReference storageRF;
        public AdaptadorEjercicio(Context c, ArrayList<Ejercicio> ejercicios) {
            super(c, R.layout.item_ejercicios, ejercicios);
            this.ejercicios = ejercicios;
            this.c = c;
            this.storageRF = FirebaseStorage.getInstance().getReference();
        }

        public View getView(int position, View view, ViewGroup viewGroup) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.item_ejercicios, null);

            TextView tv_Nombre = (TextView) item.findViewById(R.id.item_tvNombre);
            tv_Nombre.setText(ejercicios.get(position).getNombre());

            TextView tv_Descripcion = (TextView) item.findViewById(R.id.item_tvDesripcion);
            tv_Descripcion.setText(ejercicios.get(position).getDescripcion());

            TextView tv_Material = (TextView) item.findViewById(R.id.iteem_tvMaterial);
            tv_Descripcion.setText(ejercicios.get(position).getMaterial());

            String nombreImagen=ejercicios.get(position).getImagen();
            ImageView iv_logo =
                    (ImageView)item.findViewById(R.id.item_imegenejercicios);

            cargarImagen(nombreImagen, item, iv_logo);
            return item;
        }
    private void cargarImagen(String nombre, final View item, final ImageView iv_logo){
            storageRF.child("imagenes/"+nombre).getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                @Override
                public void onSuccess(Uri uri) {
                    Glide.with(item).load(uri.toString()).into(iv_logo);
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {

                }
            });
    }
    }



