package com.example.alumno.tp_lab5;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;

/**
 * Created by Agus on 13/6/2019.
 */

public class MyListener implements DialogInterface.OnClickListener{

    @Override
    public void onClick(DialogInterface dialog, int which)
    {
        if (which== AlertDialog.BUTTON_POSITIVE)
        {
            Log.d("click",""+which);

            View v = MainActivity.view.findViewById(R.id.ll);
            SharedPreferences.Editor e= MainActivity.shared.edit();
            for (View vi:v.getTouchables())
            {
                CheckBox cb=(CheckBox)vi;
                e.putBoolean(cb.getText().toString(),cb.isChecked());
                Log.d("asd",cb.getText().toString());
            }
            e.commit();
            MainActivity.metodo();
        }

    }
}
