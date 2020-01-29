package com.example.siriaco77.qpm.Present.GlobalLogic;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.toolbox.ImageLoader;
import com.bumptech.glide.Glide;
import com.example.siriaco77.qpm.Componentes.DatosGL.DatosGL;
import com.example.siriaco77.qpm.Componentes.Tarea.Tarea;
import com.example.siriaco77.qpm.R;
import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapterGL extends  RecyclerView.Adapter<RecyclerViewHolderGL> {

    Context context;
    DatosGL[] persons_new; // new
    DatosGL[] persons_new_ori; // new
    LayoutInflater inflater;
    static String text1;

    public RecyclerAdapterGL(DatosGL[] Tareas,Context context) {
        this.context=context;
        inflater=LayoutInflater.from(context);
        this.persons_new=Tareas;
        this.persons_new_ori=Tareas;
    }

    public void update(DatosGL[] data) {
        persons_new = data;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerViewHolderGL onCreateViewHolder(ViewGroup parent, int viewType) {
        View v=inflater.inflate(R.layout.cardview_gl, parent, false);
        RecyclerViewHolderGL viewHolder=new RecyclerViewHolderGL(v);
        return viewHolder;
    }



    @Override
    public void onBindViewHolder(RecyclerViewHolderGL holder, int position) {

        DatosGL item = persons_new[position];
        //String title= persons_new[position].getTitle();
        //String description=persons_new[position].getDescription();
        //String image=persons_new[position].getImage();
        holder.colmena.setText(item.getDescription());
        holder.tarea.setText(item.getTitle());

        //ImageLoader.getInstance().displayImage(item.getImage(),subsImageHolder.imageView,options);

        Glide.with(context)
                .load(item.getImage())
                .into(holder.image);

    //holder.tarea.setText(item.getImage());
        //holder.txt_colmena.setTag(holder);
        //holder.txt_tarea.setTag(holder);
        holder.tarea.setTag(holder);
        holder.colmena.setTag(holder);
    }


    public int getItemCount() {
        return persons_new.length;
    }


    public int getPosition(View v){
        RecyclerViewHolderGL vholder= (RecyclerViewHolderGL) v.getTag();
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

