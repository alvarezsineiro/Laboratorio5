package com.example.alumno.tp_lab5;

import android.content.Intent;
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

import java.util.List;

public class MainActivity extends AppCompatActivity implements Handler.Callback,MyListener,SearchView.OnQueryTextListener{

    List<Noticia> noticias;
    MyAdapter adapter;
    Handler h;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar =getSupportActionBar();
        actionBar.setTitle("Noticias");

        //https://www.pagina12.com.ar/rss/portada
        //https://tn.com.ar/rss.xml
        this.h =new Handler(this);

        MyThread t = new MyThread(h,"https://www.pagina12.com.ar/rss/portada",1);
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
            this.adapter =new MyAdapter((List<Noticia>)msg.obj,this,this.h);
            lista.setAdapter(adapter);

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
            Log.d("Opcion 1","Toco opcion 2");
        }


        return super.onOptionsItemSelected(item);
    }
}
