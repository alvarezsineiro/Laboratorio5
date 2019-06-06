package com.example.alumno.tp_lab5;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity implements Handler.Callback{

    List<Noticia> noticias;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //http://contenidos.lanacion.com.ar/herramientas/rss-origen=2

        Handler h =new Handler(this);

        MyThread t = new MyThread(h,"https://tn.com.ar/rss.xml",1);
        t.start();
    }

    @Override
    public boolean handleMessage(Message msg) {
        if (msg.arg1==1)
        {
            for(Noticia p:(List<Noticia>)msg.obj)
            {
                Log.d("asdawdsadwa",p.toString());
            }
            //Log.d("Handler",msg.obj.toString());
            //TextView t = (TextView)this.findViewById(R.id.txtview);
            //t.setText(msg.obj.toString());
            this.noticias=(List<Noticia>)msg.obj;

            RecyclerView lista =(RecyclerView)findViewById(R.id.listado);
            LinearLayoutManager layoutManager =new LinearLayoutManager(this);
            lista.setLayoutManager(layoutManager);
            adapter =new MyAdapter((List<Noticia>)msg.obj/*,this*/);
            lista.setAdapter(adapter);

        }
        else
        {
            Log.d("Handler","imagen");
            byte[] array = (byte[]) msg.obj;
            //ImageView v = (ImageView) this.findViewById(R.id.imagen);
            //v.setImageBitmap(BitmapFactory.decodeByteArray(array,0,array.length));
        }
        return false;
    }
}
