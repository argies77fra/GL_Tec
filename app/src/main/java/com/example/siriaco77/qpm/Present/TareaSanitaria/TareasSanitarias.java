package com.example.siriaco77.qpm.Present.TareaSanitaria;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import com.example.siriaco77.qpm.Componentes.Colmena.Colmena;
import com.example.siriaco77.qpm.Componentes.Colmenar.Colmenar;
import com.example.siriaco77.qpm.Componentes.Estado_Sanidad.Estado_Sanidad;
import com.example.siriaco77.qpm.Componentes.Tarea.Tarea;
import com.example.siriaco77.qpm.MainActivity;
import com.example.siriaco77.qpm.Present.ActivityColmena.ActivityColmena;
import com.example.siriaco77.qpm.Present.ActivityColmena.RecyclerAdapterIC;
import com.example.siriaco77.qpm.Present.DetalleColmena.DetalleColmena;
import com.example.siriaco77.qpm.R;
import com.example.siriaco77.qpm.RecyclerAdapter;
import com.example.siriaco77.qpm.WS.ResponseHandler;
import com.example.siriaco77.qpm.WebServices.WS_Colmenas;
import com.example.siriaco77.qpm.WebServices.WS_Tareas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TareasSanitarias extends AppCompatActivity {
    private static final int REQUEST_SIGNUP = 0;
    EditText search_colmena;
    String tipoBusqueda;
    // List<ItemColmena> persons_new;
    RecyclerView recyclerView;
    RecyclerAdapterTS adapter;
    Colmena[] items_colmenas;
    List<Tarea> persons;
    Tarea[] items_colmenas_filtradas ;
    Tarea[] items_tareas ;
    Tarea[] items_tareas_filtradas ;
    List<Tarea> persons1;
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
        setContentView(R.layout.tareas_sanitarias);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorMiel)));
        search_colmena=(EditText) findViewById(R.id.edt_buscar_colmena);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_buscar_ic);
        getColmenasSanitarias();
        /*Bundle extras = getIntent().getExtras();
        if (extras != null) {
            tipoBusqueda=extras.getString("tipoBusqueda");
        }
        if(tipoBusqueda.equals("1")){
            getColmenas(tipoBusqueda);
        }else if(tipoBusqueda.equals("2")){
            getColmenasHuerfanas(tipoBusqueda);
        }else{
            onBackPressed();
        }*/



        search_colmena.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence query, int i, int i1, int i2) {
                query = query.toString().toLowerCase(); //obtiene la palaba
                List<Tarea> filteredList = new ArrayList<>();
                for (Tarea model : persons) { //recorre las tareas y va agregando las que correponda a un nuevo array
                    final String text = model.getObservaciones().toLowerCase();
                    if (text.contains(query)) {
                        filteredList.add(model);
                    }
                }
                items_colmenas_filtradas = filteredList.toArray(new Tarea[0]);  /// da error por que es null
                adapter = new RecyclerAdapterTS(items_tareas_filtradas, getBaseContext());
                recyclerView.setAdapter(adapter);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
                adapter.notifyDataSetChanged();
            }
            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

    }



    private void getColmenasSanitarias() {
        try {
            Map<String, String> params = new HashMap<String, String>();
            //params.put("IdEstadoColmena",tipoBusqueda);
            //params.put("filters","IdEstadoColmena="+tipoBusqueda);
            WS_Tareas.findTareasSanitarias(this, params, new ResponseHandler<Tarea[]>() {
                @Override
                public void onCompleted(Tarea[] tareas) {
                    items_tareas = tareas;
                    persons = Arrays.asList(items_tareas); //cargo para buscador
                    adapter = new RecyclerAdapterTS(items_tareas, getBaseContext());
                    recyclerView.setAdapter(adapter);
                    recyclerView.setHasFixedSize(true);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
                    adapter.notifyDataSetChanged();
                }
            });
        }
        catch(Exception e){
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
        menu.findItem(R.id.action_accept).setVisible(false);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id==android.R.id.home){
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }


    public void onClickColmena(View arg0) {
        int pos = adapter.getPosition(arg0);//obtengo posicion
        String colmena = items_colmenas[pos].getDescripcion();
        String colmenar =items_colmenas[pos].getColmenar().getNombre();
        String estadoColmena=items_colmenas[pos].getEstado_colmena().getId();
        String campo = items_colmenas[pos].getColmenar().getCampo().getNombre();
        String estado_actual =items_colmenas[pos].getEstado_sanidad().getNombre();
        // String idEnfermedad= items_colmenas[pos].getE
//        String nivel_actual =items_colmenas[pos].getNivel_produccion().getNombre();

        String idColmena=items_colmenas[pos].getId();

        if (!colmena.equals(null)) {

            Intent intent = new Intent(TareasSanitarias.this, DetalleColmena.class);
            intent.putExtra("tipoBusqueda", tipoBusqueda);
            intent.putExtra("colmena", colmena);
            intent.putExtra("campo", campo);
            intent.putExtra("colmenar", colmenar);
            intent.putExtra("estadoColmena", estadoColmena);
            intent.putExtra("idColmena", idColmena);
            intent.putExtra("estado_actual", estado_actual);
            //  intent.putExtra("nivel_actual", nivel_actual);
            startActivity(intent);
            overridePendingTransition(R.transition.push_left_in, R.transition.push_left_out);
        }else {
            Toast.makeText(this, "No se Tiene información de la Colmena seleccionada", Toast.LENGTH_SHORT).show();
        }
    }


}


