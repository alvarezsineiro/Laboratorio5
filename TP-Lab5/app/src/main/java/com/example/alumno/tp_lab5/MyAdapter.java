package com.example.alumno.tp_lab5;

import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.os.Handler;

import java.text.DateFormat;
import java.util.List;


/**
 * Created by Agus on 4/6/2019.
 */

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder>{

    List<Noticia> listado;
    private IListener main;
    private Handler handler;


    public MyAdapter(List<Noticia> listado, IListener main, Handler handler){

        this.listado =listado;
        this.main=main;
        this.handler=handler;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v =null;
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout,parent,false);

        MyViewHolder myViewHolder = new MyViewHolder(v,main);


        return myViewHolder;

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Noticia p= this.listado.get(position);
        holder.setPosition(position);


        holder.titulo.setText(p.getTitulo());
        holder.url.setText(p.getUrl().substring(0, 35).concat("..."));
        if (p.getDescripcion().length()>50) {
            holder.descripcion.setText(p.getDescripcion().substring(0, 50).concat("..."));
        }
        else
        {
            holder.descripcion.setText(p.getDescripcion());
        }
        holder.fecha.setText( DateFormat.getDateInstance().format(p.getFecha())); //p.getFecha().toString());
        if(p.getImagen()==null)
        {
            MyThread hilo = new MyThread(this.handler,p.getImagenUrl(),2,position);
            hilo.start();
        }
        else
        {
            holder.imagen.setImageBitmap(BitmapFactory.decodeByteArray(p.getImagen(), 0, p.getImagen().length));
        }

    }


    @Override
    public int getItemCount() {
        return this.listado.size();
    }

    public void SetImagen(byte[] imagen,int position){
        Noticia p = this.listado.get(position);
        p.setImagen(imagen);
    }

    public void setListado(List<Noticia> listado) {
        this.listado = listado;
    }

    public List<Noticia> getListado() {
        return listado;
    }
}
