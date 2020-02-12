package com.example.siriaco77.qpm.Present.TareaSanitaria;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.siriaco77.qpm.Componentes.Tarea.Tarea;
import com.example.siriaco77.qpm.R;
import com.example.siriaco77.qpm.RecyclerViewHolder;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapterTS extends  RecyclerView.Adapter<RecyclerViewHolderTS> {

    Context context;
    Tarea[] persons_new; // new
    Tarea[] persons_new_ori; // new
    LayoutInflater inflater;
    static String text1;

    public RecyclerAdapterTS(Tarea[] Tareas,Context context) {
        this.context=context;
        inflater=LayoutInflater.from(context);
        this.persons_new=Tareas;
        this.persons_new_ori=Tareas;
    }

    public void update(Tarea[] data) {
        persons_new = data;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerViewHolderTS onCreateViewHolder(ViewGroup parent, int viewType) {
        View v=inflater.inflate(R.layout.cardview, parent, false);
        RecyclerViewHolderTS viewHolder=new RecyclerViewHolderTS(v);
        return viewHolder;
    }



    @Override
    public void onBindViewHolder(RecyclerViewHolderTS holder, int position) {

        Tarea item = persons_new[position];
        //String col_aux=persons_new[position].getColmena_origen().getDescripcion();
        //String tarea_aux= persons_new[position].getEtapa_produccion().getDescripcion();

        holder.colmena.setText(item.getObservaciones());
        holder.tarea.setText(item.get_FechaI());
        holder.txt_colmena.setTag(holder);
        holder.txt_tarea.setTag(holder);
        holder.tarea.setTag(holder);
        holder.colmena.setTag(holder);
    }


    public int getItemCount() {
        return persons_new.length;
    }


    public int getPosition(View v){
        RecyclerViewHolderTS vholder= (RecyclerViewHolderTS) v.getTag();
        return vholder.getAdapterPosition();

    }

    public void setFilter(List<Tarea> itemObjects){
        itemObjects = new ArrayList<>();
        itemObjects.addAll(itemObjects);
        notifyDataSetChanged();
    }

 /*  public String getName(int position){
        Tarea item = persons_new.get(position);
        String aux = item.getColmena();
        return aux;

    }

    public String getTarea(int position){
        Tarea item = persons_new.get(position);
        String aux = item.getTarea();
        return aux;

    }

    public String getDescripcion(int position){
        Tarea item = persons_new.get(position);
        String aux = item.getDescripcion();
        return aux;

    }

    public String getColmena(int position){
        Tarea item = persons_new.get(position);
        String aux = item.getColmena();
        return aux;

    }*/


}

