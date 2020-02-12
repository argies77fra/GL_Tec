package com.example.siriaco77.qpm.Present;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import com.example.siriaco77.qpm.Componentes.Colmena.Colmena;
import com.example.siriaco77.qpm.Present.TareaProduccion.TareaProduccion;
import com.example.siriaco77.qpm.R;
import com.example.siriaco77.qpm.WS.ResponseHandler;
import com.example.siriaco77.qpm.WebServices.WS_Colmenas;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SeleccioneColmena extends AppCompatActivity {

    private static final int REQUEST_SIGNUP = 0;
    Spinner spinner;
    String tarea,colmena,tareaId,colmenaDestino,fecha,cantidadCeldas,tId,idColmenaDestino,idEstadoTarea;
    ArrayList<String> colmenasPCArray;
    Colmena[] colmenasPC ;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(getApplicationContext(), TareaProduccion.class); //SignupActivity
        intent.putExtra("tareaId", tareaId);
        intent.putExtra("tarea", tarea);
        intent.putExtra("colmena", colmena);
        intent.putExtra("colmenaDestino", colmenaDestino);
        intent.putExtra("fecha", fecha);
        intent.putExtra("cantidadCeldas", cantidadCeldas);

        intent.putExtra("tId", tId);
        intent.putExtra("idColmenaDestino", idColmenaDestino);
        intent.putExtra("idEstadoTarea", idEstadoTarea);


        startActivityForResult(intent, REQUEST_SIGNUP);
        finish();
        overridePendingTransition(R.transition.push_rigth_in, R.transition.push_rigth_out);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion_col);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorMiel)));

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            tareaId=extras.getString("tareaId");
            tarea = extras.getString("tarea");
            colmena = extras.getString("colmena");
            colmenaDestino = extras.getString("colmenaDestino");
            fecha = extras.getString("fecha");
            cantidadCeldas = extras.getString("cantidadCeldas");

            tId=extras.getString("tId");
            idColmenaDestino = extras.getString("idColmenaDestino");
            idEstadoTarea=extras.getString("idEstadoTarea");


        }
        colmenasPCArray =new ArrayList<>();

        getColmenasParaCambio();

    }

    public void getColmenasParaCambio(){
        try {

            final ArrayList<String> arrayList_2 = new ArrayList<>();
            Map<String, String> params = new HashMap<String, String>();
            params.put("IdTarea",tareaId);
            //params.put("IdEmpleado",Empleado.getIdUsuarioActual());
            WS_Colmenas.findColmenasParaCambio(this, params, new ResponseHandler<Colmena[]>() {
                @Override
                public void onCompleted(Colmena[] colmenas) {

                    if (colmenas.length == 0) {
                        Toast.makeText(SeleccioneColmena.this, "No hay colmenas para seleccionar.", Toast.LENGTH_SHORT).show();
                        onBackPressed();
                    } else {

                        for (int a = 0; a < colmenas.length; a++) { //armo
                            arrayList_2.add(colmenas[a].getDescripcion());
                        }
                        spinner = (Spinner) findViewById(R.id.spinner);
                        spinner.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item, arrayList_2));
                        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                                Spinner mySpinner = (Spinner) findViewById(R.id.spinner);
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
            Log.e("Error", "paso main " + e.getMessage());

        }

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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id==android.R.id.home){
            onBackPressed();
        }else if(id==R.id.action_accept){

            //traer el de spinner y ponerlo en colmena asi uso los mismos datos que tengo
            Spinner mySpinner = (Spinner) findViewById(R.id.spinner);
            String colmenaDestino = mySpinner.getSelectedItem().toString();
            //Toast.makeText(this, ""+colmenaDestino, Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(getApplicationContext(), TareaProduccion.class); //SignupActivity
            intent.putExtra("tareaId", tareaId);
            intent.putExtra("tarea", tarea);
            intent.putExtra("colmena", colmena);
            intent.putExtra("colmenaDestino", colmenaDestino);
            intent.putExtra("fecha", fecha);
            intent.putExtra("cantidadCeldas", cantidadCeldas);

            intent.putExtra("tId", tId);
            intent.putExtra("idColmenaDestino", idColmenaDestino);
            intent.putExtra("idEstadoTarea", idEstadoTarea);

            startActivityForResult(intent, REQUEST_SIGNUP);
            //finish();
            overridePendingTransition(R.transition.push_rigth_in, R.transition.push_rigth_out);



           // onBackPressed();
          //  Toast.makeText(this, "Exito!", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }



}
