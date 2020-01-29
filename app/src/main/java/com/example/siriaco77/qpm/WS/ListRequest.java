package com.example.siriaco77.qpm.WS;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.Map;
import java.util.concurrent.Callable;

public class ListRequest extends AppCompatActivity {

    String webService;
    String op;
    Map<String, String> params;
    Callable callable;
    ProgressDialog dialog;
    Context mContext=getBaseContext();
    String url;


    public ListRequest(Context mContext) {
        this.mContext=mContext;
    }

    public <T> void  send(String webService, String op, final Map<String, String> params, final Class <T[]> type , final ResponseHandler<T[]> responseHandler){
        try {
            dialog = ProgressDialog.show(mContext, "","Procesando..espere.." , true);
            RequestQueue queue2 = Volley.newRequestQueue(mContext);
           // String url = "http://"+Entorno.getEntorno_actual()+"comunicar.myros.com.ar/backend/"+webService+".php?op="+op; //authenticate.php?op=login
            if(webService.equals("GlobalLogic")){
                url="http://private-f0eea-mobilegllatam.apiary-mock.com/list";

            }else {
                url = "http://qpm.myros.com.ar/backend/common/" + webService + ".php?op=" + op;
            }
            //http://qpm.myros.com.ar/backend/common/colmena.php?op=find
            StringRequest postRequest = new StringRequest(Request.Method.GET, url,
                    new Response.Listener<String>()
                    {
                        @Override
                        public void onResponse(String response) {
                            try {
                                Gson gson = new Gson();
                                T[] r = gson.fromJson(response,type);
                                responseHandler.onCompleted(r);
                                dialog.dismiss();
                              }catch (Exception e) {
                                dialog.dismiss();
                                  Log.e("Error", "Error de Volley: " + e.getMessage());
                            }
                        }
                    },
                    new Response.ErrorListener()
                    {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            try{
                                dialog.dismiss();
                                Toast.makeText(mContext,"Hubo un Error de conexión vuelva a intentarlo por favor.",Toast.LENGTH_LONG).show();
                                if (error instanceof TimeoutError || error instanceof NoConnectionError) {
                                    Log.e("Error", "Error de Volley: NoConnectionError" + error.getMessage());
                                } else if (error instanceof AuthFailureError) {
                                    //TODO
                                    Log.e("Error", "Error de Volley : AuthFailureError" + error.getMessage());
                                } else if (error instanceof ServerError) {
                                    Log.e("Error", "Error de Volley: ServerError" + error.getMessage());
                                    //TODO
                                } else if (error instanceof NetworkError) {
                                    Log.e("Error", "Error de Volley:NetworkError " + error.getMessage());
                                    //TODO
                                } else if (error instanceof ParseError) {
                                    Log.e("Error", "Error de Volley: ParseError" + error.getMessage());
                                    //Toast.makeText(getApplicationContext(),"4",Toast.LENGTH_LONG).show();
                                    //TODO
                                }

                            } catch (Exception e) {

                                dialog.dismiss();
                            }
                        }
                    }


            ) {
                @Override
                protected Map<String, String> getParams()
                {

                    final Thread.UncaughtExceptionHandler oldHandler = Thread.getDefaultUncaughtExceptionHandler();

                    Thread.setDefaultUncaughtExceptionHandler(
                            new Thread.UncaughtExceptionHandler() {
                                @Override
                                public void uncaughtException(Thread paramThread, Throwable paramThrowable) {
                                    //Do your own error handling here

                                    Log.e("Error", "paso por aqui2 null" );
                                    finishAffinity();
                                    System.exit(2); //Prevents the service/app from freezing


                                }
                            });
                    return params;
                }
            };

            queue2.add(postRequest);
        } catch (Exception e) {

            dialog.dismiss();
            Toast.makeText(getApplicationContext(), "lista 3" + e.getMessage(), Toast.LENGTH_LONG).show();

        }
    }





}

