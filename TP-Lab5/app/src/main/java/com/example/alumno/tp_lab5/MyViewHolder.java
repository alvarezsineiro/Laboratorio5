package com.example.alumno.tp_lab5;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Agus on 4/6/2019.
 */

public class MyViewHolder extends RecyclerView.ViewHolder {

    public ImageView imagen;
    public TextView titulo;
    public TextView descripcion;
    ImageView Menos;
    ImageView Mas;
    //private IListener lisener;
    private int position;

    public void setPosition(int position) {
        this.position = position;
    }

    public MyViewHolder(View v/*, IListener main*/) {
        super(v);
        this.imagen=(ImageView) v.findViewById(R.id.imagen);
        this.titulo=(TextView) v.findViewById(R.id.titulo);
        this.descripcion=(TextView) v.findViewById(R.id.descripcion);

        /*Mas = (ImageView) itemView.findViewById(R.id.mas);
        Menos = (ImageView) itemView.findViewById(R.id.menos);
        Mas.setOnClickListener(this);
        Menos.setOnClickListener(this);
        this.lisener = main;*/

    }
}
