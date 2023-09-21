package com.patriciasoft.examen.ui.lugaresTuristicos;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class GalleryViewModel extends AndroidViewModel {

    private Context context;

    private MutableLiveData<List<Lugares>> mLugares;

    public GalleryViewModel(@NonNull Application application) {
        super(application);
        this.context = application.getApplicationContext();
    }

    public LiveData<List<Lugares>> getMLugares(){
        if(mLugares==null){
            mLugares = new MutableLiveData<>();
        }
        return mLugares;
    }

    public void armarLista(){
        List<Lugares> lista=new ArrayList<>();
        lista.add(new Lugares("Merlo", "Se encuentra en una zona montañosa conocida como la Región de Cuyo"));
        lista.add(new Lugares("San Luis", "Su clima es templado semi árido."));
        lista.add(new Lugares("Potrero de los Funes", "Es uno de los embalses más antiguos de Sudamérica"));
        lista.add(new Lugares("Villa Mercedes", "Ciudad cabecera del departamento General Pedernera y la segunda ciudad más importante de la provincia de San Luis"));
        lista.add(new Lugares("La Florida", "La Elegida por los Adolescentes"));

        mLugares.setValue(lista);
    }
}