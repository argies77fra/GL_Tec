package com.example.siriaco77.qpm.Present.EstadoSanitario;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import com.example.siriaco77.qpm.Componentes.Data.Objeto_aux;
import com.example.siriaco77.qpm.Componentes.Enfermedad.Enfermedad;
import com.example.siriaco77.qpm.Componentes.Estado_Sanidad.Estado_Sanidad;
import com.example.siriaco77.qpm.Componentes.Historial_Estado_Sanidad.HistorialEstadoSanidad;
import com.example.siriaco77.qpm.Present.DetalleColmena.DetalleColmena;
import com.example.siriaco77.qpm.R;
import com.example.siriaco77.qpm.WS.ResponseHandler;
import com.example.siriaco77.qpm.WS.SimpleRequest;
import com.example.siriaco77.qpm.WebServices.WS_Enfermedad;
import com.example.siriaco77.qpm.WebServices.WS_EstadoSanidad;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EstadoSanitario extends AppCompatActivity {

    String colmena,colmenar,campo,tipoBusqueda,estado_actual,estadoColmena,idColmena;
    EditText edt_colmena,edt_colmenar,edt_campo,edt_estado_actual,edt_observaciones_2;

    Spinner spinner_nuevo_estado,spinner_enfermedad;
    Switch Aswitch;
    Enfermedad[] items_enfermedades;
    Estado_Sanidad[] items_estados;

    private static final int REQUEST_SIGNUP = 0;
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(getApplicationContext(), DetalleColmena.class); //SignupActivity
        intent.putExtra("tipoBusqueda", tipoBusqueda);
        intent.putExtra("colmena", colmena);
        intent.putExtra("colmenar", colmenar);
        intent.putExtra("campo", campo);
        intent.putExtra("estado_actual", estado_actual);
        intent.putExtra("estadoColmena",estadoColmena);

        startActivityForResult(intent, REQUEST_SIGNUP);
        finish();
        overridePendingTransition(R.transition.push_rigth_in, R.transition.push_rigth_out);

    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.estado_sanitario);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorMiel)));
        edt_colmena = findViewById(R.id.edt_colmena_2);
        edt_colmenar = findViewById(R.id.edt_colmenar_2);
        edt_campo = findViewById(R.id.edt_campo_2);
        edt_estado_actual = findViewById(R.id.edt_estado_actual_2);
        spinner_nuevo_estado =findViewById(R.id.spinner_nuevo_estado_2);//spinner_enfermedad
        spinner_enfermedad =findViewById(R.id.spinner_enfermedad_2);
        edt_observaciones_2= findViewById(R.id.edt_observaciones_2);
        Aswitch= findViewById(R.id.orfandad);


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            tipoBusqueda = extras.getString("tipoBusqueda");
            idColmena=extras.getString("idColmena");
            colmena = extras.getString("colmena");
            colmenar = extras.getString("colmenar");
            campo = extras.getString("campo");
            estadoColmena = extras.getString("estadoColmena");
            estado_actual = extras.getString("estado_actual");

            edt_colmena.setText(colmena);
            edt_colmenar.setText(colmenar);
            edt_campo.setText(campo);
            edt_estado_actual.setText(estado_actual);

        }

        Aswitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(Aswitch.isChecked()){
              //      Toast.makeText(EstadoSanitario.this, "check", Toast.LENGTH_SHORT).show();

                }else{
                //    Toast.makeText(EstadoSanitario.this, "no chechk", Toast.LENGTH_SHORT).show();
                }

            }
        });

        getNuevoEstado();

        getEnfermedades();


        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    public void getNuevoEstado(){
        try {

            final ArrayList<String> arrayList_2 = new ArrayList<>();
            Map<String, String> params = new HashMap<String, String>();
            //params.put("IdTarea",tareaId);
            //params.put("IdEmpleado",Empleado.getIdUsuarioActual());
            WS_EstadoSanidad.findEstados(this, params, new ResponseHandler<Estado_Sanidad[]>() {
                @Override
                public void onCompleted(Estado_Sanidad[] estados) {

                    items_estados = estados;

                    if (estados.length == 0) {
                        Toast.makeText(EstadoSanitario.this, "No hay estados para seleccionar.", Toast.LENGTH_SHORT).show();
                        //onBackPressed();
                    } else {

                        for (int a = 0; a < estados.length; a++) { //armo
                            arrayList_2.add(estados[a].getNombre());
                        }
                        spinner_nuevo_estado = (Spinner) findViewById(R.id.spinner_nuevo_estado_2);
                        spinner_nuevo_estado.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item, arrayList_2));
                        spinner_nuevo_estado.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                                Spinner mySpinner = (Spinner) findViewById(R.id.spinner_nuevo_estado_2);
                                String text = mySpinner.getSelectedItem().toString();
                                String text1 = adapterView.getItemAtPosition(position).toString();

                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {
                            }
                        });
                    }
                }
            });
        }catch(Exception e){
            Toast.makeText(this, "Hubo un error de conexion.", Toast.LENGTH_SHORT).show();
            Log.e("Error", "estado sanitario " + e.getMessage());

        }

    }

    private void getEnfermedades() {

        try {

            final ArrayList<String> arrayList_2 = new ArrayList<>();
            Map<String, String> params = new HashMap<String, String>();
            //params.put("IdTarea",tareaId);
            //params.put("IdEmpleado",Empleado.getIdUsuarioActual());
            WS_Enfermedad.findEnfermedades(this, params, new ResponseHandler<Enfermedad[]>() {
                @Override
                public void onCompleted(Enfermedad[] enfermedades) {

                    items_enfermedades = enfermedades;
                    if (enfermedades.length == 0) {
                        Toast.makeText(EstadoSanitario.this, "No hay estados para seleccionar.", Toast.LENGTH_SHORT).show();
                        //onBackPressed();
                    } else {

                        for (int a = 0; a < enfermedades.length; a++) { //armo
                            arrayList_2.add(enfermedades[a].getNombre());
                        }
                        spinner_enfermedad = findViewById(R.id.spinner_enfermedad_2);
                        spinner_enfermedad.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item, arrayList_2));
                        spinner_enfermedad.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                                Spinner mySpinner = findViewById(R.id.spinner_enfermedad_2);
                                String text = mySpinner.getSelectedItem().toString();
                                String text1 = adapterView.getItemAtPosition(position).toString();

                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {
                            }
                        });
                    }
                }
            });
        }catch(Exception e){
            Toast.makeText(this, "Hubo un error de conexion.", Toast.LENGTH_SHORT).show();
            Log.e("Error", "estado sanitario " + e.getMessage());

        }



    }

    public void updateState(){
        Map<String, String> params = new HashMap<String, String>();
        //IdColmena (de la colmena actual) y IdEstadoColmena=2
        params.put("IdColmena",idColmena);
        params.put("IdEstadoColmena", "2");
        SimpleRequest sr = new SimpleRequest(this);
        sr.send("colmena", "updateState", params, Objeto_aux.class ,new ResponseHandler<Objeto_aux>() {
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

    private void saveEstadoSanitario(){
     final Spinner spinner2 =findViewById(R.id.spinner_enfermedad_2);//spinner_enfermedad
     final String idEnfermedad = items_enfermedades[spinner2.getSelectedItemPosition()-1].getId();//
     final Spinner spinner3 =findViewById(R.id.spinner_nuevo_estado_2);//spinner_enfermedad
     final String idEstadoSanidad = items_estados[spinner3.getSelectedItemPosition()-1].getId();//
     final String observaciones = edt_observaciones_2.getText().toString();

     final HistorialEstadoSanidad historialEstadoSanidad = new HistorialEstadoSanidad();

     historialEstadoSanidad.setIdColmena(idColmena);
     historialEstadoSanidad.setIdEnfermedad(idEnfermedad);
     historialEstadoSanidad.setIdEstadoSanidad(idEstadoSanidad);
     historialEstadoSanidad.setObservaciones(observaciones);
     Gson gson2 = new Gson();
     final String jsonInString = gson2.toJson(historialEstadoSanidad);
     Map<String, String> params = new HashMap<String, String>();
    //IdColmena (de la colmena actual) y IdEstadoColmena=2
     params.put("estado", jsonInString);
        SimpleRequest sr = new SimpleRequest(this);
        sr.send("colmena", "registrarEstadoSanidad", params, Objeto_aux.class ,new ResponseHandler<Objeto_aux>() {
            @Override
            public void onCompleted(Objeto_aux r) {
                if (r.getResult()) {
                    //   Toast.makeText(getApplicationContext(), "Se marco la colmena huerfana con exito.", Toast.LENGTH_LONG).show();
                    onBackPressed();

                }else {
                    Toast.makeText(getApplicationContext(), "Hubo un Error, vuelva a intentarlo.", Toast.LENGTH_LONG).show();
                }
            }
        });


    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id==android.R.id.home){
            onBackPressed();
        } else if(id==R.id.action_accept){

            //ver si esta huerfana

            if(Aswitch.isChecked()){
                Toast.makeText(EstadoSanitario.this, "check", Toast.LENGTH_SHORT).show();
                updateState();
            }else{
                Toast.makeText(EstadoSanitario.this, "no chechk", Toast.LENGTH_SHORT).show();
            }

            saveEstadoSanitario();

            //guardar

        }

       // updateState

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        menu.findItem(R.id.action_settings).setVisible(false);
        menu.findItem(R.id.action_cambiar_pass).setVisible(false);
        menu.findItem(R.id.action_ayuda).setVisible(false);
        menu.findItem(R.id.action_settings).setVisible(false);
        menu.findItem(R.id.action_cancel).setVisible(false);

        return true;
    }



}
