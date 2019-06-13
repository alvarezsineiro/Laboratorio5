package com.example.alumno.tp_lab5;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Agus on 4/6/2019.
 */

public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    public ImageView imagen;
    public TextView titulo;
    public TextView descripcion;
    public TextView fecha;
    public TextView url;
    //ImageView Menos;
    //ImageView Mas;
    private IListener listener;
    private int position;
    private CardView item;

    public void setPosition(int position) {
        this.position = position;
    }

    public MyViewHolder(View v, IListener main) {
        super(v);
        this.imagen=(ImageView) v.findViewById(R.id.imagen);
        this.titulo=(TextView) v.findViewById(R.id.titulo);
        this.descripcion=(TextView) v.findViewById(R.id.descripcion);
        this.fecha=(TextView) v.findViewById(R.id.fecha);
        this.url=(TextView) v.findViewById(R.id.url);

        this.item=(CardView) v.findViewById(R.id.item);
        this.item.setOnClickListener(this);
        this.listener = main;

    }

    @Override
    public void onClick(View view) {
        this.listener.cargarPagina(this.position,view.getId());
    }
}
