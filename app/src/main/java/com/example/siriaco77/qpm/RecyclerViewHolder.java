package com.example.siriaco77.qpm;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;


public class RecyclerViewHolder extends RecyclerView.ViewHolder {
    TextView fecha,colmena,tarea,descripcion,txt_colmena,txt_tarea,txt_descripcion;

    public RecyclerViewHolder(View itemView) {
        super(itemView);
        //fecha  = (TextView) itemView.findViewById(R.id.Fecha);
        colmena =(TextView) itemView.findViewById(R.id.Colmena);
        tarea=(TextView) itemView.findViewById(R.id.Tarea);
        //descripcion= itemView.findViewById(R.id.Descripcion);

        txt_colmena=(TextView) itemView.findViewById(R.id.txtColmena);
        txt_tarea=(TextView) itemView.findViewById(R.id.txtTarea);
       // txt_descripcion=(TextView) itemView.findViewById(R.id.txtDescripcion);

    }
}