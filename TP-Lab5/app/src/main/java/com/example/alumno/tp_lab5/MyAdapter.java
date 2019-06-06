package com.example.alumno.tp_lab5;

import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Agus on 4/6/2019.
 */

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder>{

    List<Noticia> listado;
    //private IListener main;


    public MyAdapter(List<Noticia> listado/*,IListener main*/){

        this.listado =listado;
        //this.main=main;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v =null;
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout,parent,false);

        MyViewHolder myViewHolder = new MyViewHolder(v/*,main*/);


        return myViewHolder;

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Noticia p= this.listado.get(position);
        holder.setPosition(position);
        //holder.imagen.setImageResource(android.R.drawable.btn_plus);
        holder.imagen.setImageBitmap(BitmapFactory.decodeByteArray(p.getImagen(),0,p.getImagen().length));
        holder.titulo.setText("Titulo:"+p.getTitulo());
        holder.descripcion.setText("Descripcion:".concat(p.getDescripcion()));
    }

    @Override
    public int getItemCount() {
        return this.listado.size();
    }


}
