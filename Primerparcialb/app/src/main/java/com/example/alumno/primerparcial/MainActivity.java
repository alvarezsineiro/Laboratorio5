package com.example.alumno.primerparcial;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Handler.Callback,IListener{
    List<Producto> productos;
    Myadapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Handler h =new Handler(this);



        //MyThread t = new MyThread(h,"http://192.168.2.154:8080/a/listaPersonasImg.xml",1);
        MyThread t = new MyThread(h,"http://192.168.0.2/a/Productos.xml",1);
        t.start();

        Button b = (Button) findViewById(R.id.btnuno);

        b.setOnClickListener(new MyListener(this));
    }

    @Override
    public boolean handleMessage(Message msg) {
        if (msg.arg1==1)
        {
            for(Producto p:(List<Producto>)msg.obj)
            {
                Log.d("asdawdsadwa",p.toString());
            }
            //Log.d("Handler",msg.obj.toString());
            //TextView t = (TextView)this.findViewById(R.id.txtview);
            //t.setText(msg.obj.toString());
           this.productos=(List<Producto>)msg.obj;

            RecyclerView lista =(RecyclerView)findViewById(R.id.listado);
            LinearLayoutManager layoutManager =new LinearLayoutManager(this);
            lista.setLayoutManager(layoutManager);
            adapter =new Myadapter((List<Producto>)msg.obj,this);
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
    public void controlStock(int position, int btnId){
        Producto p = productos.get(position);
        Log.d("asdawdsadwa",""+position);
        if(btnId == R.id.mas) {
            p.setCantidad(p.getCantidad() + 1);
        }
        if(btnId == R.id.menos) {
            if(p.getCantidad() != 0) p.setCantidad(p.getCantidad() - 1);
        }
        adapter.notifyItemChanged(position);
    }
}
