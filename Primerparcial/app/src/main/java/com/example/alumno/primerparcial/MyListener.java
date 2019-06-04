package com.example.alumno.primerparcial;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

/**
 * Created by alumno on 09/05/2019.
 */

public class MyListener implements View.OnClickListener {

    public Activity miactivity;
    public Handler mihandler;
    public MyListener(Activity a) {

        this.miactivity=a;
    }
    public MyListener(Activity a,Handler h) {

        this.mihandler=h;
        this.miactivity=a;
    }


    @Override
    public void onClick(View view) {

        if (view.getId()==R.id.btnuno)
        {
            Intent i=new Intent(miactivity, SegundaActivity.class);
            //miactivity.startActivity(i);
            miactivity.finish();
        }
        /*else {
            miactivity.finish();
        }*/

        if (view.getId()==R.id.btningreso)
        {
            EditText mail=(EditText) this.miactivity.findViewById(R.id.editmail);
            EditText clave=(EditText) this.miactivity.findViewById(R.id.editclave);
            String Url= "http://192.168.2.181:3000/login/"+mail.getText()+"/"+clave.getText();


            MyThread t = new MyThread(this.mihandler,Url,0);
            t.start();
            //miactivity.finish();


        }

    }
}
