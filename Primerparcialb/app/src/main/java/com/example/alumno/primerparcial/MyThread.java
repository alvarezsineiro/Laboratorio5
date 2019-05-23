package com.example.alumno.primerparcial;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

/**
 * Created by alumno on 09/05/2019.
 */

public class MyThread extends Thread {
    public Handler h;
    public String  url;
    public int textimagen;

    public MyThread(Handler h,String url,int textimagen) {
        this.h=h;
        this.url=url;
        this.textimagen=textimagen;
    }

    @Override
    public void run()
    {
        Log.d("antes","conect");
        Myconect eje = new Myconect();
        Log.d("despues","conect");
        Message m =new Message();
        if (this.textimagen==1)
        {
            String s = eje.getString(this.url);
            //m.obj=s;
            m.arg1=1;
            m.obj= XmlParse.obtenerProductos(s);
        }
        else
        {
            //m.obj= eje.metodoimagen(this.url);
            //m.arg1=2;

        }
        this.h.sendMessage(m);
    }
}
