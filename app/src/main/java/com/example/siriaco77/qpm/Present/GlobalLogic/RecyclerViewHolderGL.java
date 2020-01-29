package com.example.siriaco77.qpm.Present.GlobalLogic;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.siriaco77.qpm.R;

public class RecyclerViewHolderGL extends RecyclerView.ViewHolder {

        TextView fecha,colmena,tarea,descripcion,txt_colmena,txt_tarea,txt_descripcion;
        ImageView image;

        public RecyclerViewHolderGL(View itemView) {
            super(itemView);

            image =itemView.findViewById(R.id.image);

            colmena =(TextView) itemView.findViewById(R.id.Colmena);
            tarea=(TextView) itemView.findViewById(R.id.Tarea);
            //descripcion= itemView.findViewById(R.id.Descripcion);

            txt_colmena=(TextView) itemView.findViewById(R.id.txtColmena);
            txt_tarea=(TextView) itemView.findViewById(R.id.txtTarea);
            // txt_descripcion=(TextView) itemView.findViewById(R.id.txtDescripcion);

        }
 }


