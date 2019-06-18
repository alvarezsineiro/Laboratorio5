package com.example.alumno.tp_lab5;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;

/**
 * Created by Agus on 13/6/2019.
 */

public class MyMessenge extends DialogFragment {


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        LayoutInflater li = LayoutInflater.from(this.getContext());
        View v= li.inflate(R.layout.messenge,null);
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        builder.setTitle("Elija la opcion deseada");
        //builder.setMessage("Mensaje");

        MyListener m=new MyListener();
        builder.setView(v);
        MainActivity.view=v;



        SharedPreferences.Editor e= MainActivity.shared.edit();
        for (View vi:MainActivity.view.findViewById(R.id.ll).getTouchables())
        {
            CheckBox cb=(CheckBox)vi;

            cb.setChecked(MainActivity.shared.getBoolean(cb.getText().toString(),true));
        }

        builder.setNegativeButton("Cancelar",m);
        //builder.setNeutralButton("neutral",m);
        builder.setPositiveButton("Aceptar",m);

        return builder.create();
    }
}
