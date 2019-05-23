package com.example.alumno.primerparcial;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

/**
 * Created by alumno on 09/05/2019.
 */

public class MyListener implements View.OnClickListener {

    public Activity miactivity;
    public MyListener(Activity a) {

        this.miactivity=a;
    }


    @Override
    public void onClick(View view) {

        if (view.getId()==R.id.btnuno)
        {
            Intent i=new Intent(miactivity, SegundaActivity.class);
            miactivity.startActivity(i);
        }
        else {
            miactivity.finish();
        }

    }
}
