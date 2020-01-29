package com.example.siriaco77.qpm.WebServices;

import android.content.Context;

import com.example.siriaco77.qpm.Componentes.DatosGL.DatosGL;
import com.example.siriaco77.qpm.Componentes.Estado_Sanidad.Estado_Sanidad;

import com.example.siriaco77.qpm.WS.ListRequest;
import com.example.siriaco77.qpm.WS.ResponseHandler;

import java.util.Map;

public class WS_GlobalLogic {

    public static void findDatos(Context mContext, final Map<String, String> params , final ResponseHandler<DatosGL[]> handler){
        ListRequest sr = new ListRequest(mContext);
        sr.send("GlobalLogic", "", params, DatosGL[].class ,new ResponseHandler<DatosGL[]>() {
            @Override
            public void onCompleted(DatosGL[] estados) {
                handler.onCompleted(estados);
            }
        });

    }


}
