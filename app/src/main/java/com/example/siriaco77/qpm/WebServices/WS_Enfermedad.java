package com.example.siriaco77.qpm.WebServices;

import android.content.Context;

import com.example.siriaco77.qpm.Componentes.Enfermedad.Enfermedad;
import com.example.siriaco77.qpm.Componentes.Estado_Sanidad.Estado_Sanidad;
import com.example.siriaco77.qpm.WS.ListRequest;
import com.example.siriaco77.qpm.WS.ResponseHandler;

import java.util.Map;

public class WS_Enfermedad {

    public static void findEnfermedades(Context mContext, final Map<String, String> params , final ResponseHandler<Enfermedad[]> handler){
        ListRequest sr = new ListRequest(mContext);
        sr.send("enfermedad", "find", params, Enfermedad[].class ,new ResponseHandler<Enfermedad[]>() {
            @Override
            public void onCompleted(Enfermedad[] enfermedades) {
                handler.onCompleted(enfermedades);
            }
        });

    }

}
