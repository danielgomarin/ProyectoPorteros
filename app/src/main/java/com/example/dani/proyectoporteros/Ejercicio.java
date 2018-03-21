package com.example.dani.proyectoporteros;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Dani on 07/03/2018.
 */

public class Ejercicio implements Parcelable {

    String nombre;
    String descripcion;
    String imagen;
    String material;


    public Ejercicio(String nombre, String descripcion, String imagen, String material) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.material = material;
    }

    protected Ejercicio(Parcel in) {
        nombre = in.readString();
        descripcion = in.readString();
        imagen = in.readString();
        material = in.readString();
    }

    public Ejercicio() {
    }

    public static final Creator<Ejercicio> CREATOR = new Creator<Ejercicio>() {
        @Override
        public Ejercicio createFromParcel(Parcel in) {
            return new Ejercicio(in);
        }

        @Override
        public Ejercicio[] newArray(int size) {
            return new Ejercicio[size];
        }
    };

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int describeContents(){return 0;}

    public  void  writeToParcel (Parcel dest, int flags) {
        dest.writeString (this.nombre);
        dest.writeString (this.descripcion);
        dest.writeString (this.imagen);
        dest.writeString (this.material);

    }
    private void readFromParcel (Parcel p) {
        this.nombre=p.readString();
        this.descripcion=p.readString();
        this.imagen=p.readString();
        this.material=p.readString();

    }
}