package com.example.siriaco77.qpm.WebServices;

import android.content.Context;

import com.example.siriaco77.qpm.Componentes.Colmena.Colmena;
import com.example.siriaco77.qpm.Componentes.Tarea.Tarea;
import com.example.siriaco77.qpm.WS.ListRequest;
import com.example.siriaco77.qpm.WS.ResponseHandler;
import com.example.siriaco77.qpm.WS.SimpleRequest;

import java.util.Map;

public class WS_Colmenas {

    public static void findColmenas(Context mContext, final Map<String, String> params , final ResponseHandler<Colmena[]> handler){
        ListRequest sr = new ListRequest(mContext);
        sr.send("colmena", "find", params, Colmena[].class ,new ResponseHandler<Colmena[]>() {
            @Override
            public void onCompleted(Colmena[] colmenas) {
                handler.onCompleted(colmenas);
            }
        });

    }

    public static void findColmenasParaCambio(Context mContext, final Map<String, String> params , final ResponseHandler<Colmena[]> handler){
        ListRequest sr = new ListRequest(mContext);
        sr.send("colmena", "findcolmenasparacambio", params, Colmena[].class ,new ResponseHandler<Colmena[]>() {
            @Override
            public void onCompleted(Colmena[] colmenas) {
                handler.onCompleted(colmenas);
            }
        });

    }


}
