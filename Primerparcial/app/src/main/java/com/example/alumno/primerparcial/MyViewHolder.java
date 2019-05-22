package com.example.alumno.primerparcial;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

/**
 * Created by alumno on 09/05/2019.
 */

public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    public TextView nombre;
    public TextView cantidad;
    public TextView precio;
    ImageView Menos;
    ImageView Mas;
    private IListener lisener;
    private int position;

    public void setPosition(int position) {
        this.position = position;
    }

    public MyViewHolder(View v,IListener main) {
        super(v);
        this.nombre=(TextView) v.findViewById(R.id.textnombre);
        this.cantidad=(TextView) v.findViewById(R.id.textcantidad);
        this.precio=(TextView) v.findViewById(R.id.textprecio);

        Mas = (ImageView) itemView.findViewById(R.id.mas);
        Menos = (ImageView) itemView.findViewById(R.id.menos);
        Mas.setOnClickListener(this);
        Menos.setOnClickListener(this);
        this.lisener = main;

    }

    @Override
    public void onClick(View view) {
        lisener.controlStock(position, view.getId());
    }
}
