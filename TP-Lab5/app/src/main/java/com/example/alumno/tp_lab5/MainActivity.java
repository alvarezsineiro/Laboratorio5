package com.example.alumno.tp_lab5;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Handler.Callback,IListener,SearchView.OnQueryTextListener{

    public static List<Noticia> noticias;
    MyAdapter adapter;
    public static Handler h;
    public static View view;
    public static SharedPreferences shared ;
    public static List<String> urls;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar =getSupportActionBar();
        actionBar.setTitle("Noticias");

        MainActivity.shared=getPreferences(Context.MODE_PRIVATE);

        urls= new ArrayList<>();
        urls.add("https://www.pagina12.com.ar/rss/portada");
        urls.add("https://tn.com.ar/rss.xml");
        urls.add("http://www.telam.com.ar/rss2/ultimasnoticias.xml");
        urls.add("https://cronicaglobal.elespanol.com/es/rss/general-001.xml");

        this.h =new Handler(this);

        //MyThread t = new MyThread(h,"https://cronicaglobal.elespanol.com/es/rss/general-001.xml",1);
        //t.start();
        for (String s:MainActivity.urls)
        {
            if (MainActivity.shared.getBoolean(s,true))
            {
                MyThread t = new MyThread(h,s,1);
                t.start();
                Log.d("asda",s);
            }
        }

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
            if (this.noticias==null)
            {
                this.noticias= (List < Noticia >)msg.obj;
            }
            else
            {
                this.noticias.addAll( (List < Noticia >)msg.obj);
            }

            Collections.sort(this.noticias);
            RecyclerView lista =(RecyclerView)findViewById(R.id.listado);
            LinearLayoutManager layoutManager =new LinearLayoutManager(this);
            lista.setLayoutManager(layoutManager);
            this.adapter =new MyAdapter(this.noticias,this,this.h);
            lista.setAdapter(adapter);
            this.adapter.notifyDataSetChanged();

        }
        else
        {
            Log.d("Handler","imagen");
            byte[] array = (byte[]) msg.obj;
            //ImageView v = (ImageView) this.findViewById(R.id.imagen);
            //v.setImageBitmap(BitmapFactory.decodeByteArray(array,0,array.length));
            this.adapter.SetImagen(array,msg.arg2);
            this.adapter.notifyItemChanged(msg.arg2);
        }
        return false;
    }

    @Override
    public void cargarPagina(int position, int id) {
        Noticia n = noticias.get(position);
        Log.d("asdawdsadwa",""+position);
        Intent i = new Intent(this, SegundaActivity.class);
        i.putExtra("Url", n.getUrl());
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);

        MenuItem mi = menu.findItem(R.id.opcion1);
        SearchView sv= (SearchView) mi.getActionView();
        sv.setOnQueryTextListener(this);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        Log.d("submit",query);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        Log.d("change",newText);
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.opcion2)
        {
            MyMessenge mensaje =new MyMessenge();
            mensaje.show(getSupportFragmentManager(),"");

        }


        return super.onOptionsItemSelected(item);
    }
    public static void metodo()
    {
        MainActivity.noticias.clear();
        for (String s:MainActivity.urls)
        {
            if (MainActivity.shared.getBoolean(s,true))
            {
                MyThread t = new MyThread(h,s,1);
                t.start();
                Log.d("asda",s);
            }
        }
    }
}
