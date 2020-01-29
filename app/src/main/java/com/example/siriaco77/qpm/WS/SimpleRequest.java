package com.example.siriaco77.qpm.WS;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
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

public class SimpleRequest extends AppCompatActivity {

    String webService;
    String op;
    Map<String, String> params;
    Callable callable;
    ProgressDialog dialog;
    Context mContext=getBaseContext();

    public SimpleRequest(Context mContext) {
        this.mContext=mContext;
    }

    public <T> void  send(String webService, String op, final Map<String, String> params, final Class<T> type, final ResponseHandler<T> responseHandler){
        try {
            dialog = ProgressDialog.show(mContext, "","Procesando..espere.." , true);
            RequestQueue queue2 = Volley.newRequestQueue(mContext);
            String url="http://qpm.myros.com.ar/backend/common/"+webService+".php?op="+op;
            //String url = "http://"+Entorno.getEntorno_actual()+"comunicar.myros.com.ar/backend/"+webService+".php?op="+op; //authenticate.php?op=login
            //String url="http://qpm.myros.com.ar/backend/common/authenticate.php?op=login";
            //String url ="http://qpm.myros.com.ar/backend/common/tarea.php?op=find";
            //String url ="http://qpm.myros.com.ar/backend/common/empleado.php?op=find";//findcurrentbyempleado
            //String url ="http://qpm.myros.com.ar/backend/common/tarea.php?op=findcurrentbyempleado";
            //String url ="http://qpm.myros.com.ar/backend/common/colmena.php?op=find";
            StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                    new Response.Listener<String>()
                    {
                        @Override
                        public void onResponse(String response) {
                            try {

                                Gson gson = new Gson();
                                T r = gson.fromJson(response,type);
                                //  callable.call();
                                responseHandler.onCompleted(r);
                                dialog.dismiss();

                            }catch (Exception e) {
                                dialog.dismiss();
                                //ObjectResponse r =new ObjectResponse();
                                //r.setResult(false);
                                //r.setMessage("Ocurrio un error, vuelva a intentarlo");
                                Log.e("Error", "Error de Volley: " + e.getMessage());
                                //Toast.makeText(getApplicationContext(),"Error Simple Request.",Toast.LENGTH_SHORT).show();
                                //  responseHandler.onCompleted(r);

                            }

                        }
                    },
                    new Response.ErrorListener()
                    {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            //  Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_LONG).show();


                            try{
                                dialog.dismiss();
                                Toast.makeText(mContext,"Hubo un Error de conexion vuelva a intentarlo."+error.getMessage(),Toast.LENGTH_LONG).show();
                                //snackbar1 = snackbar1.make(coordinatorLayout.,"Hubo un error vuelva intentar", Snackbar.LENGTH_LONG);
                                //snackbar1.show();
                                if (error instanceof TimeoutError) {
                                    //Toast.makeText(mContext,mContext.getString(R.string.error_network_timeout),Toast.LENGTH_LONG).show();

                                    //  Toast.makeText(getApplicationContext(),"time out",Toast.LENGTH_LONG).show();

                                    Log.e("Error", "Error de Volley: NoConnectionError" + error.getMessage());
                                } else if (error instanceof AuthFailureError) {
                                    //TODO
                                    // Toast.makeText(getApplicationContext(),"1 AuthFailureError",Toast.LENGTH_LONG).show();
                                    Log.e("Error", "Error de Volley : AuthFailureError" + error.getMessage());
                                } else if (error instanceof ServerError) {
                                    //Toast.makeText(getApplicationContext(),"2",Toast.LENGTH_LONG).show();
                                    Log.e("Error", "Error de Volley: ServerError" + error.getMessage());
                                    //TODO
                                } else if (error instanceof NetworkError) {
                                    //  Toast.makeText(getApplicationContext(),"3",Toast.LENGTH_LONG).show();
                                    Log.e("Error", "Error de Volley:NetworkError " + error.getMessage());
                                    //TODO
                                } else if (error instanceof ParseError) {
                                    Log.e("Error", "Error de Volley: ParseError" + error.getMessage());
                                    // Toast.makeText(getApplicationContext(),"4",Toast.LENGTH_LONG).show();
                                    //TODO
                                }
                                //Toast.makeText(getApplicationContext(),"time out",Toast.LENGTH_LONG).show();
                            } catch (Exception e) {

                                // dialog.dismiss();
                                Log.e("Error", "Error de Volley: " + e.getMessage());
                                //Toast.makeText(getApplicationContext(), "sale por error response." + e.getMessage(), Toast.LENGTH_LONG).show();
                                //System.exit(2); //Prevents the service/app from freezing


                                //getAppVersion();

                            }

                        }
                    }


            ) {
                @Override
                protected Map<String, String> getParams() {

                    final Thread.UncaughtExceptionHandler oldHandler = Thread.getDefaultUncaughtExceptionHandler();

                    Thread.setDefaultUncaughtExceptionHandler(
                            new Thread.UncaughtExceptionHandler() {
                                @Override
                                public void uncaughtException(
                                        Thread paramThread,
                                        Throwable paramThrowable

                                ) {
                                    //Do your own error handling here
                                    Log.e("Error", "paso por aqui null" );
                                    finishAffinity();
                                    System.exit(2); //Prevents the service/app from freezing
                                }
                            });
                    return params;


                }
            };

            queue2.add(postRequest);
        } catch (Exception e) {

            //dialog.dismiss();
            Toast.makeText(getApplicationContext(), "try principal." + e.getMessage(), Toast.LENGTH_LONG).show();
            //System.exit(2); //Prevents the service/app from freezing

            //getAppVersion();

        }


    }

}




    /*public void borrarMensaje(final String idMensaje){

        RequestQueue queue2 = Volley.newRequestQueue(this);

        //Toast.makeText(getApplicationContext(),idMensaje,Toast.LENGTH_LONG).show();
        String url = "http://testing.comunicar.myros.com.ar/backend/mensajes.php?op=delete"; //authenticate.php?op=login
        StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response) {
                        Log.d("Response", response);
                        String aux= response.toString();

                        try {
                            if (response.contains("true")) {
                                Toast.makeText(getApplicationContext(),"El mensaje se borro con exito.",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(DetalleMensaje.this, MainActivity.class);
                                intent.putExtra("pantalla",tipoPantalla );
                                startActivityForResult(intent, 0);
                                finish();
                                overridePendingTransition(R.anim.push_rigth_in, R.anim.push_rigth_out);

                            }
                        }catch (Exception e) {
                            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
                        }

                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_LONG).show();
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("idMensaje", idMensaje);
                params.put("idUsuario", Usuario.getIdUsuarioActual());

                return params;
            }
        };

        queue2.add(postRequest);


    }*/
