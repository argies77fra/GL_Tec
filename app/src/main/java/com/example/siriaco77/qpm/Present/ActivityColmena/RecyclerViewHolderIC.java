package com.example.siriaco77.qpm.Present.ActivityColmena;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.siriaco77.qpm.R;

public class RecyclerViewHolderIC extends RecyclerView.ViewHolder {
    TextView colmena,campo,txt_colmena,txt_campo,estado_sanitario,estado_produccion,txt_estado_sanitario,txt_estado_produccion,colmenar,txt_colmenar,estado,txt_estado;

    public RecyclerViewHolderIC(View itemView) {
        super(itemView);

        colmena =(TextView) itemView.findViewById(R.id.Colmena);
        txt_colmena=(TextView) itemView.findViewById(R.id.txtColmena);
        campo=(TextView) itemView.findViewById(R.id.Campo);
        txt_campo=(TextView) itemView.findViewById(R.id.txtCampo);
        estado_sanitario=(TextView) itemView.findViewById(R.id.EstadoSanitario);
        txt_estado_sanitario=(TextView) itemView.findViewById(R.id.txtEstadoSanitario);
        estado_produccion =(TextView) itemView.findViewById(R.id.EstadoProduccion);
        txt_estado_produccion=(TextView) itemView.findViewById(R.id.txtEstadoProduccion);
        colmenar=(TextView) itemView.findViewById(R.id.Colmenar);
        txt_colmenar=(TextView) itemView.findViewById(R.id.txtColmenar);
        estado=itemView.findViewById(R.id.estado);
        txt_estado=itemView.findViewById(R.id.txt_estado);



    }
}
