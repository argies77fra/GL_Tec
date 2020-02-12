package com.example.siriaco77.qpm.Present.ActivityColmena;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.siriaco77.qpm.Componentes.Colmena.Colmena;
import com.example.siriaco77.qpm.R;
import java.util.ArrayList;
import java.util.List;


public class RecyclerAdapterIC  extends  RecyclerView.Adapter<RecyclerViewHolderIC> {

    Context context;
    //List<ItemColmena> persons_new;
    //List<ItemColmena> persons_new_ori;
    Colmena[] persons_new; // new
    Colmena[] persons_new_ori; // new

    LayoutInflater inflater;
    static String text1;

    public RecyclerAdapterIC(Colmena[] Tareas, Context context) {
        this.context=context;
        inflater=LayoutInflater.from(context);
        this.persons_new=Tareas;
        this.persons_new_ori=Tareas;
    }


    public void update(Colmena[] data) {
        persons_new = data;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerViewHolderIC onCreateViewHolder(ViewGroup parent, int viewType) {
        View v=inflater.inflate(R.layout.cardview_ic, parent, false);
        RecyclerViewHolderIC viewHolder=new RecyclerViewHolderIC(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolderIC holder, int position) {

        Colmena item = persons_new[position];

        holder.colmena.setText(item.getDescripcion());
        holder.colmenar.setText(item.getColmenar().getNombre());
        holder.campo.setText(item.getColmenar().getCampo().getNombre());
        holder.estado_sanitario.setText(item.getEstado_sanidad().getNombre());
        holder.estado.setText(item.getEstado_colmena().getNombre());

        try{
            if(item.getNivel_produccion().getNombre().isEmpty()){
                holder.estado_produccion.setText("");
            }else{
                holder.estado_produccion.setText(item.getNivel_produccion().getNombre());
            }
        }catch (Exception e){
            holder.estado_produccion.setText("");
        }

        holder.estado.setTag(holder);
        holder.txt_estado.setTag(holder);
        holder.colmena.setTag(holder);
        holder.colmenar.setTag(holder);
        holder.campo.setTag(holder);
        holder.estado_sanitario.setTag(holder);
        holder.estado_produccion.setTag(holder);
        holder.txt_colmena.setTag(holder);
        holder.txt_colmenar.setTag(holder);
        holder.txt_campo.setTag(holder);
        holder.txt_estado_sanitario.setTag(holder);
        holder.txt_estado_produccion.setTag(holder);
    }

    public void setFilter(List<Colmena> Tarea){
        Tarea = new ArrayList<>();
        Tarea.addAll(Tarea);
        notifyDataSetChanged();
    }

    public int getItemCount() {
        return persons_new.length;
    }


  public int getPosition(View v){
        RecyclerViewHolderIC vholder= (RecyclerViewHolderIC) v.getTag();
        return vholder.getAdapterPosition();

    }


/*    public String getColmenar(int position){
        ItemColmena item = persons_new.get(position);
        String aux = item.getColmenar();
        return aux;

    }
    public String getCampo(int position){
        ItemColmena item = persons_new.get(position);
        String aux = item.getCampo();
        return aux;

    }



    public String getColmena(int position){
        ItemColmena item = persons_new.get(position);
        String aux = item.getColmena();
        return aux;

    }*/


}

