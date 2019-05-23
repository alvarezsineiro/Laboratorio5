package com.example.alumno.primerparcial;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by alumno on 09/05/2019.
 */

public class Myadapter extends RecyclerView.Adapter<MyViewHolder>
{
    List<Producto> listado;
    private IListener main;
    public Myadapter(List<Producto> listado,IListener main){

        this.listado =listado;
        this.main=main;
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

        Producto p= this.listado.get(position);
        holder.setPosition(position);
        holder.cantidad.setText("Cantidad:"+p.getCantidad());
        holder.nombre.setText(p.getNombre());
        holder.precio.setText("Precio:".concat(p.getPrecio()));
    }

    @Override
    public int getItemCount() {
        return this.listado.size();
    }


}
