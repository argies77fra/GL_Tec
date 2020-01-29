package com.example.siriaco77.qpm.WebServices;

import android.content.Context;

import com.example.siriaco77.qpm.Componentes.Tarea.Tarea;
import com.example.siriaco77.qpm.WS.ListRequest;
import com.example.siriaco77.qpm.WS.ResponseHandler;

import java.util.Map;

public class WS_Tareas {

    public static void findTareas(Context mContext, final Map<String, String> params , final ResponseHandler<Tarea []> handler){
        ListRequest sr = new ListRequest(mContext);
        sr.send("tarea", "findcurrentbyempleado", params, Tarea[].class ,new ResponseHandler<Tarea []>() {
            @Override
            public void onCompleted(Tarea[] tareas) {
                handler.onCompleted(tareas);
            }
        });
    }

    public static void findTareasSanitarias(Context mContext, final Map<String, String> params , final ResponseHandler<Tarea []> handler){
        ListRequest sr = new ListRequest(mContext);
        sr.send("tarea_sanidad", "find", params, Tarea[].class ,new ResponseHandler<Tarea []>() {
            @Override
            public void onCompleted(Tarea[] tareas) {
                handler.onCompleted(tareas);
            }
        });
    }



}
