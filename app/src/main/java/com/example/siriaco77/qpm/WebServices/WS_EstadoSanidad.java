package com.example.siriaco77.qpm.WebServices;

import android.content.Context;

import com.example.siriaco77.qpm.Componentes.Estado_Sanidad.Estado_Sanidad;

import com.example.siriaco77.qpm.WS.ListRequest;
import com.example.siriaco77.qpm.WS.ResponseHandler;

import java.util.Map;

public class WS_EstadoSanidad {

    public static void findEstados(Context mContext, final Map<String, String> params , final ResponseHandler<Estado_Sanidad[]> handler){
        ListRequest sr = new ListRequest(mContext);
        sr.send("estado_sanidad", "find", params, Estado_Sanidad[].class ,new ResponseHandler<Estado_Sanidad[]>() {
            @Override
            public void onCompleted(Estado_Sanidad[] estados) {
                handler.onCompleted(estados);
            }
        });

    }

}
