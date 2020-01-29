package com.example.siriaco77.qpm.Present.TareaProduccion;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.siriaco77.qpm.Componentes.Auxiliar.Result;
import com.example.siriaco77.qpm.Componentes.Data.Objeto_aux;
import com.example.siriaco77.qpm.MainActivity;
import com.example.siriaco77.qpm.Present.DetalleColmena.DetalleColmena;
import com.example.siriaco77.qpm.Present.SeleccioneColmena;
import com.example.siriaco77.qpm.R;
import com.example.siriaco77.qpm.WS.ResponseHandler;
import com.example.siriaco77.qpm.WS.SimpleRequest;

import java.util.HashMap;
import java.util.Map;

public class TareaProduccion extends AppCompatActivity {

    private static final int REQUEST_SIGNUP = 0;
    String tarea,descripcion,colmena,tareaId,colmenaDestino,cantidadCeldas,idColmenaDestino,idEstadoTarea,fecha,tId;
    TextView txtTitle;
    EditText edt_colmena_2,edt_observaciones_2;
    EditText edt_colmena_destino2,edt_cant_celdas_2,edt_cant_real_2,edt_motivo_des_2,edt_colmena_destino_2,edt_fecha_2;
    TextInputLayout edt_colmena_destino,edt_cant_celdas,edt_cant_real,edt_motivo_des;


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(getApplicationContext(), MainActivity.class); //SignupActivity
        startActivityForResult(intent, REQUEST_SIGNUP);
        finish();
        overridePendingTransition(R.transition.push_rigth_in, R.transition.push_rigth_out);

    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tarea_produccion);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorMiel)));
        txtTitle=(TextView) findViewById(R.id.txtTitle);
        edt_colmena_2 =(EditText) findViewById(R.id.edt_colmena_2);
        edt_colmena_destino_2= findViewById(R.id.edt_colmena_destino_2);
        edt_observaciones_2=(EditText) findViewById(R.id.edt_observaciones_2);
        edt_colmena_destino = (TextInputLayout) findViewById(R.id.edt_colmena_destino);
        edt_colmena_destino2=(EditText) findViewById(R.id.edt_colmena_destino_2);
        edt_cant_celdas = (TextInputLayout) findViewById(R.id.edt_cant_celdas);
        edt_cant_celdas_2=(EditText) findViewById(R.id.edt_cant_celdas_2);
        edt_cant_real = (TextInputLayout) findViewById(R.id.edt_cant_real);
        edt_cant_real_2=(EditText) findViewById(R.id.edt_cant_real_2);
        edt_motivo_des = (TextInputLayout) findViewById(R.id.edt_motivo_des);
        edt_motivo_des_2=(EditText) findViewById(R.id.edt_motivo_des_2);
        edt_fecha_2 = findViewById(R.id.edt_fecha_2);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {

            tId= extras.getString("tId");
            tareaId=extras.getString("tareaId");
            tarea = extras.getString("tarea");
            colmena = extras.getString("colmena");
            idColmenaDestino=extras.getString("idColmenaDestino");
            colmenaDestino=extras.getString("colmenaDestino");
            cantidadCeldas=extras.getString("cantidadCeldas");
            idEstadoTarea =extras.getString("idEstadoTarea");
            fecha = extras.getString("fecha");

            txtTitle.setText(tarea);
            edt_colmena_2.setText(colmena);
            edt_colmena_destino_2.setText(colmenaDestino);
            edt_cant_celdas_2.setText(cantidadCeldas);
            edt_fecha_2.setText(fecha);

        }

        if(tId.equals("1")){
            edt_observaciones_2.requestFocus();
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.showSoftInput(edt_observaciones_2, InputMethodManager.SHOW_IMPLICIT);
            edt_colmena_destino2.setVisibility(View.GONE);
            edt_colmena_destino.setVisibility(View.GONE);
            edt_cant_celdas.setVisibility(View.GONE);
            edt_cant_celdas_2.setVisibility(View.GONE);
            edt_cant_real_2.setVisibility(View.GONE);
            edt_cant_real.setVisibility(View.GONE);
            edt_motivo_des_2.setVisibility(View.GONE);
            edt_motivo_des.setVisibility(View.GONE);

            //reboto cant de celdas
            edt_cant_real_2.setText(cantidadCeldas);

        }else if(tId.equals("2")){
            //edt_colmena_2.setText(colmena);
            edt_observaciones_2.requestFocus();
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.showSoftInput(edt_observaciones_2, InputMethodManager.SHOW_IMPLICIT);
            edt_cant_celdas.setVisibility(View.GONE);
            edt_cant_celdas_2.setVisibility(View.GONE);
            edt_cant_real_2.setVisibility(View.GONE);
            edt_cant_real.setVisibility(View.GONE);
            edt_motivo_des_2.setVisibility(View.GONE);
            edt_motivo_des.setVisibility(View.GONE);

            //reboto cant de celdas
            edt_cant_real_2.setText(cantidadCeldas);

        }else if(tId.equals("3")){
            //edt_colmena_2.setText(colmena);
        }else if(tId.equals("4")){
            edt_colmena_destino_2.setVisibility(View.GONE);
            edt_colmena_destino.setVisibility(View.GONE);
        }
        edt_colmena_destino2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_UP) {
                    if(event.getRawX() >= edt_colmena_destino2.getRight() - edt_colmena_destino2.getTotalPaddingRight()){
                        // your action for drawable click event
                        Intent intent = new Intent(TareaProduccion.this, SeleccioneColmena.class);
                        intent.putExtra("tareaId", tareaId);
                        intent.putExtra("tarea", tarea);
                        intent.putExtra("colmena", colmena);
                        intent.putExtra("colmenaDestino", colmenaDestino);
                        /**fecha cantidad de celdas **/
                        intent.putExtra("fecha", fecha);
                        intent.putExtra("cantidadCeldas", cantidadCeldas);


                        intent.putExtra("tId", tId);
                        intent.putExtra("idColmenaDestino", idColmenaDestino);
                        intent.putExtra("idEstadoTarea", idEstadoTarea);



                        startActivity(intent);
                        overridePendingTransition(R.transition.push_left_in, R.transition.push_left_out);
                    }
                }
                return false;
            }
        });

      edt_cant_real_2.addTextChangedListener(new TextChangedListener<EditText>(edt_cant_real_2) {
            @Override
            public void onTextChanged(EditText target, Editable s) {
                //Do stuff
               Integer cantCeldas=0;
               Integer cantReal=0;
               String a = edt_cant_celdas_2.getText().toString();//Integer.parseInt(edt_cant_celdas_2.getText().toString());
               String b =edt_cant_real_2.getText().toString();//cantReal = Integer.parseInt(edt_cant_real_2.getText().toString());
           try {
                 cantCeldas=Integer.valueOf(a);
                 cantReal=Integer.valueOf(b);
                }catch(NumberFormatException ex) {

               }
               if (cantCeldas > cantReal) {
                    edt_motivo_des_2.setEnabled(true);
                } else {
                    edt_motivo_des_2.setEnabled(false);
                    edt_motivo_des_2.setText("");
                    Toast.makeText(TareaProduccion.this, "La Cantidad ingresada no puede superar la cantidad existente.", Toast.LENGTH_SHORT).show();
                }

            }
        });
       this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

    }

    public void tareaRealizada(){
        Integer cantCeldas=0;
        Integer cantReal=0;
        String a = edt_cant_celdas_2.getText().toString();//Integer.parseInt(edt_cant_celdas_2.getText().toString());
        String b =edt_cant_real_2.getText().toString();//cantReal = Integer.parseInt(edt_cant_real_2.getText().toString());
        try {
            cantCeldas=Integer.valueOf(a);
            cantReal=Integer.valueOf(b);
        }catch(NumberFormatException ex) {

        }
        if (cantCeldas >= cantReal) {  //  en etapa 1 y 2

            //edt_motivo_des_2.setEnabled(true);
        Map<String, String> params = new HashMap<String, String>();
        params.put("IdTarea", tareaId);
        params.put("Observaciones", edt_observaciones_2.getText().toString());
        params.put("CantidadCeldas", edt_cant_real_2.getText().toString()); //este es cero y no debria
        //params.put("CantidadCeldas", cantCeldas.toString()); //este es cero y no debria
        params.put("MotivoDescarte", edt_motivo_des_2.getText().toString());
        params.put("IdColmenaDestino", idColmenaDestino);
        params.put("MotivoCambio", "");


        SimpleRequest sr = new SimpleRequest(this);
        sr.send("tarea", "tareaRealizada", params, Result.class ,new ResponseHandler<Result>() {

            @Override
            public void onCompleted(Result r) {
                if (r.getResult().equals("true")) {
                    Toast.makeText(getApplicationContext(), ""+r.getMessage(), Toast.LENGTH_SHORT).show();
                   // Intent intent = new Intent(TareaProduccion.this, MainActivity.class);
                    //intent.putExtra("pantalla", "nuevos");
                   // startActivity(intent);
                }else {
                    Toast.makeText(getApplicationContext(), ""+r.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
     } else {
            //edt_motivo_des_2.setEnabled(false);
            //edt_motivo_des_2.setText("");
       Toast.makeText(TareaProduccion.this, "La Cantidad ingresada no puede superar la cantidad existente.", Toast.LENGTH_SHORT).show();
      }



    }


    public abstract class TextChangedListener<T> implements TextWatcher {
        private T target;

        public TextChangedListener(T target) {
            this.target = target;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {}

        @Override
        public void afterTextChanged(Editable s) {
            this.onTextChanged(target, s);
        }

        public abstract void onTextChanged(T target, Editable s);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        menu.findItem(R.id.action_settings).setVisible(false);
        menu.findItem(R.id.action_cambiar_pass).setVisible(false);
        menu.findItem(R.id.action_ayuda).setVisible(false);
        menu.findItem(R.id.action_settings).setVisible(false);


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id==android.R.id.home){
            onBackPressed();
        }else if(id==R.id.action_accept){
            tareaRealizada();
            onBackPressed();
            //Toast.makeText(this, "La Tarea "+descripcion+" se guardo con exito", Toast.LENGTH_SHORT).show();
        }else if(id==R.id.action_cancel){
            cancelarTarea();
        }
        return super.onOptionsItemSelected(item);
    }

    public void cancelTarea(){

        Map<String, String> params = new HashMap<String, String>();
        //IdColmena (de la colmena actual) y IdEstadoColmena=2
        params.put("IdTarea",tareaId);
        params.put("IdEstadoTarea", "4"); //en duro por la estoy cancelando
        params.put("Observaciones",edt_observaciones_2.getText().toString());

        SimpleRequest sr = new SimpleRequest(this);
        sr.send("tarea", "updatestate", params, Objeto_aux.class ,new ResponseHandler<Objeto_aux>() {
            @Override
            public void onCompleted(Objeto_aux r) {
                if (r.getResult()) {
                    //   Toast.makeText(getApplicationContext(), "Se marco la colmena huerfana con exito.", Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(getApplicationContext(), "Hubo un Error, vuelva a intentarlo.", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void cancelarTarea(){
        AlertDialog alertDialog = new AlertDialog.Builder(TareaProduccion.this).create();
        alertDialog.setTitle("Atención!");
        alertDialog.setMessage("Esta seguro de que desea cancelar la Tarea?");
        alertDialog.setCancelable(false);
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        cancelTarea();
                        Toast.makeText(TareaProduccion.this, "La tarea se cancelo con exito.", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                        onBackPressed();
                    }
                });
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Cancelar",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }
}
