package com.patriciasoft.examen.ui.salir;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Dialogo {
    public static void crearDialogo(Activity context) {
        new AlertDialog.Builder(context)
                .setMessage("Desea Cerrar la Aplicación?")
                .setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ((AppCompatActivity)context).finishAndRemoveTask();
                        context.finishAffinity();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(context, "Continuamos Navegando", Toast.LENGTH_SHORT).show();
                    }
                }).show();
    }
}

