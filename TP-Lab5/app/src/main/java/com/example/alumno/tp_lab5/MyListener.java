package com.example.alumno.tp_lab5;

import android.content.DialogInterface;
import android.util.Log;

/**
 * Created by Agus on 13/6/2019.
 */

public class MyListener implements DialogInterface.OnClickListener{

    @Override
    public void onClick(DialogInterface dialog, int which) {
        Log.d("click",""+which);
    }
}
