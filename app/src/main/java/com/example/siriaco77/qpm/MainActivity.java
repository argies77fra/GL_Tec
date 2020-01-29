package com.example.siriaco77.qpm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.siriaco77.qpm.Componentes.Empleado.Empleado;
import com.example.siriaco77.qpm.Componentes.Tarea.Tarea;
import com.example.siriaco77.qpm.Present.ActivityColmena.ActivityColmena;
import com.example.siriaco77.qpm.Present.CambiarContraseña;
import com.example.siriaco77.qpm.Present.Login;
import com.example.siriaco77.qpm.Present.RecuperarContrasena;
import com.example.siriaco77.qpm.Present.TareaProduccion.TareaProduccion;
import com.example.siriaco77.qpm.Present.TareaSanitaria.DetalleTareaSanitaria;
import com.example.siriaco77.qpm.Present.TareaSanitaria.TareasSanitarias;
import com.example.siriaco77.qpm.WS.ResponseHandler;
import com.example.siriaco77.qpm.WebServices.WS_Tareas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final int REQUEST_SIGNUP = 0;
    RecyclerView recyclerView;
    RecyclerAdapter adapter;
    List<Tarea> persons;
    EditText edt_buscar;
   // public SearchView search;
    CardView cv;
    Tarea[] items_tareas ;
    Tarea[] items_tareas_filtradas ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View hView = navigationView.getHeaderView(0);
        TextView nav_user = (TextView) hView.findViewById(R.id.txtNombreUser);
        TextView nav_establecimiento = (TextView) hView.findViewById(R.id.txtEstablecimiento);
        nav_user.setText(Empleado.getNombreUsuarioActual());
        nav_establecimiento.setText("Establecimiento: "+Empleado.getIdEstablecimientoActual());
        recyclerView = (RecyclerView) findViewById(R.id.recycler_buscar);
        edt_buscar = (EditText) findViewById(R.id.edt_buscar);
        edt_buscar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence query, int i, int i1, int i2) {
                query = query.toString().toLowerCase(); //obtiene la palaba
                List<Tarea> filteredList = new ArrayList<>();
                for (Tarea model : persons) { //recorre las tareas y va agregando las que correponda a un nuevo array
                    final String text = model.getColmena_origen().getDescripcion().toLowerCase();
                    if (text.contains(query)) {
                        filteredList.add(model);
                    }
                }
                items_tareas_filtradas = filteredList.toArray(new Tarea[0]);
                /*recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                adapter2 = new RecyclerAdapter2(filteredList,MainActivity.this);
                recyclerView.setAdapter(adapter2);
                adapter2.notifyDataSetChanged();  // data set changed*/

                adapter = new RecyclerAdapter(items_tareas_filtradas, getBaseContext());
                recyclerView.setAdapter(adapter);
              //  recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
                adapter.notifyDataSetChanged();
            }
            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
        getTareas();
        //addTextListener();
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

    }

    public void getTareas(){
        try {
            Map<String, String> params = new HashMap<String, String>();
            //params.put("IdEmpleado","7");
            params.put("IdEmpleado",Empleado.getIdUsuarioActual());
            WS_Tareas.findTareas(this, params, new ResponseHandler<Tarea[]>() {
                @Override
                public void onCompleted(Tarea[] tareas) {
                    items_tareas = tareas;
                    persons = Arrays.asList(items_tareas); //cargo para buscador
                    adapter = new RecyclerAdapter(items_tareas, getBaseContext());
                    recyclerView.setAdapter(adapter);
                    recyclerView.setHasFixedSize(true);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
                    adapter.notifyDataSetChanged();
                }
            });
        }catch(Exception e){
            Toast.makeText(this, "Hubo un error de conexion.", Toast.LENGTH_SHORT).show();
            Log.e("Error", "paso main " + e.getMessage());

        }

    }

    private void cargarValores() {
   /*     persons_new = new ArrayList<>();
        persons_new.add(new Tarea("1", "1", "1", "Inserción en Núcleo"));
        persons_new.add(new Tarea("1", "3", "4", "Transpaso a colmena de Maduraciòn"));
        persons_new.add(new Tarea("1", "21", "2", "Transferencia de Larvas\n"));
        persons_new.add(new Tarea("1", "33", "4", "Transpaso a colmena de Maduracion"));
        persons_new.add(new Tarea("1", "47", "3", "Extraccion de celdas maduras"));
        persons_new.add(new Tarea("1", "58", "2", "Transferencia de Larvas\n"));

        persons_new.add(new Tarea("1", "59", "1", "Inserción en Núcleo"));
        persons_new.add(new Tarea("1", "67", "3", "Extraccion de celdas maduras"));
        persons_new.add(new Tarea("1", "76", "3", "Extraccion de celdas maduras"));
        persons_new.add(new Tarea("1", "80", "2", "Transferencia de Larvas\n"));
        persons_new.add(new Tarea("1", "91", "1", "Inserción en Núcleo"));
        persons_new.add(new Tarea("1", "100", "4", "Transpaso a colmena de Maduración"));*/
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        menu.findItem(R.id.action_accept).setVisible(false);
        menu.findItem(R.id.action_cancel).setVisible(false);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Intent intent = new Intent(MainActivity.this, Login.class);
            startActivity(intent);
            finish();
            return true;
        }else if(id==R.id.action_cambiar_pass){
            Intent intent = new Intent(MainActivity.this, CambiarContraseña.class);
            startActivity(intent);
            finish();
            overridePendingTransition(R.transition.push_left_in, R.transition.push_left_out);
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_transf_larvas) {
           /* Intent intent = new Intent(MainActivity.this, TareaProduccion.class);
            startActivity(intent);
            overridePendingTransition(R.transition.push_left_in, R.transition.push_left_out);*/
            return true;
        }else if (id == R.id.nav_colmena) {
            Intent intent = new Intent(MainActivity.this, ActivityColmena.class);
            intent.putExtra("tipoBusqueda", "1");
            startActivity(intent);
            finish();
            overridePendingTransition(R.transition.push_left_in, R.transition.push_left_out);
            return true;
        }else if (id==R.id.nav_colmenas_huerfanas){
            Intent intent = new Intent(MainActivity.this, ActivityColmena.class);
            intent.putExtra("tipoBusqueda", "2");
            startActivity(intent);
            finish();
            overridePendingTransition(R.transition.push_left_in, R.transition.push_left_out);
            return true;

        }else if(id==R.id.nav_tareas_sanitarias){
            Intent intent = new Intent(MainActivity.this, TareasSanitarias.class);
            //intent.putExtra("tipoBusqueda", "2");
            startActivity(intent);
            finish();
            overridePendingTransition(R.transition.push_left_in, R.transition.push_left_out);
            return true;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void irARecuperarContrasena(View view) {
        Intent intent = new Intent(getApplicationContext(), RecuperarContrasena.class); //SignupActivity
        startActivityForResult(intent, REQUEST_SIGNUP);
        //finish();
        overridePendingTransition(R.transition.push_left_in, R.transition.push_left_out);
    }

    public void onClickTareaProduccion(View arg0) {
        Log.e("Error", "entra click" );
       try {
           int pos = adapter.getPosition(arg0);//obtengo posicion
           String tId = items_tareas[pos].getEtapa_produccion().getId();
           String tareaId = items_tareas[pos].getId();
           String colmena = items_tareas[pos].getColmena_origen().getDescripcion();
           String tarea = items_tareas[pos].getEtapa_produccion().getDescripcion();//adapter.getColmena(adapter.getPosition(arg0));
           String colmenaDestino = items_tareas[pos].getColmena_destino().getDescripcion();
           String cantidadCeldas=items_tareas[pos].getCantidadCeldas();
           String idColmenaDestino=items_tareas[pos].getColmena_destino().getId();
           String idEstadoTarea =items_tareas[pos].getIdEstadoTarea();
           //String fecha = items_tareas[pos].getFecha();
            String fecha = items_tareas[pos].get_FechaF();
           if (tId.equals("1")) {
               Intent intent = new Intent(MainActivity.this, TareaProduccion.class);

               intent.putExtra("tareaId", tareaId); //85
               intent.putExtra("tId", tId);         // 1
               intent.putExtra("tarea", tarea);
               intent.putExtra("colmena", colmena);
               intent.putExtra("colmenaDestino", colmenaDestino);
               intent.putExtra("cantidadCeldas", cantidadCeldas);
               intent.putExtra("idColmenaDestino", idColmenaDestino);
               intent.putExtra("idEstadoTarea", idEstadoTarea);
               intent.putExtra("fecha", fecha);

               startActivity(intent);
               overridePendingTransition(R.transition.push_left_in, R.transition.push_left_out);
           } else if (tId.equals("2")) {
               Intent intent = new Intent(MainActivity.this, TareaProduccion.class);
               intent.putExtra("tareaId", tareaId); //85
               intent.putExtra("tId", tId);         // 1
               intent.putExtra("tarea", tarea);
               intent.putExtra("colmena", colmena);
               intent.putExtra("colmenaDestino", colmenaDestino);
               intent.putExtra("cantidadCeldas", cantidadCeldas);
               intent.putExtra("idColmenaDestino", idColmenaDestino);
               intent.putExtra("idEstadoTarea", idEstadoTarea);
               intent.putExtra("fecha", fecha);
               startActivity(intent);
               overridePendingTransition(R.transition.push_left_in, R.transition.push_left_out);
           } else if (tId.equals("3")) {
               Intent intent = new Intent(MainActivity.this, TareaProduccion.class);
               intent.putExtra("tareaId", tareaId); //85
               intent.putExtra("tId", tId);         // 1
               intent.putExtra("tarea", tarea);
               intent.putExtra("colmena", colmena);
               intent.putExtra("colmenaDestino", colmenaDestino);
               intent.putExtra("cantidadCeldas", cantidadCeldas);
               intent.putExtra("idColmenaDestino", idColmenaDestino);
               intent.putExtra("idEstadoTarea", idEstadoTarea);
               intent.putExtra("fecha", fecha);
               startActivity(intent);
               overridePendingTransition(R.transition.push_left_in, R.transition.push_left_out);

           } else if (tId.equals("4")) {
               Intent intent = new Intent(MainActivity.this, TareaProduccion.class);
               intent.putExtra("tareaId", tareaId); //85
               intent.putExtra("tId", tId);         // 1
               intent.putExtra("tarea", tarea);
               intent.putExtra("colmena", colmena);
               intent.putExtra("colmenaDestino", colmenaDestino);
               intent.putExtra("cantidadCeldas", cantidadCeldas);
               intent.putExtra("idColmenaDestino", idColmenaDestino);
               intent.putExtra("idEstadoTarea", idEstadoTarea);
               intent.putExtra("fecha", fecha);
               startActivity(intent);
               overridePendingTransition(R.transition.push_left_in, R.transition.push_left_out);
           } else {
               Toast.makeText(this, "No se Tiene información de la Tarea seleccionada", Toast.LENGTH_SHORT).show();
           }
       }catch (Exception e){
           Log.e("Error", ""+e.getMessage() );
           Toast.makeText(this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
       }


    }
}
