package com.example.siriaco77.qpm.Present.GlobalLogic;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.example.siriaco77.qpm.Componentes.DatosGL.DatosGL;
import com.example.siriaco77.qpm.MainActivity;
import com.example.siriaco77.qpm.Present.ActivityColmena.ActivityColmena;
import com.example.siriaco77.qpm.Present.Login;
import com.example.siriaco77.qpm.R;
import com.example.siriaco77.qpm.WS.ResponseHandler;
import com.example.siriaco77.qpm.WebServices.WS_GlobalLogic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GlobalLogic extends AppCompatActivity {

    private static final int REQUEST_SIGNUP = 0;
    RecyclerView recyclerView;
    RecyclerAdapterGL adapter;
    List<DatosGL> persons;
    EditText edt_buscar;
    CardView cv;
    DatosGL[] items;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        irHome();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_global_logic);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorMiel)));
        recyclerView = (RecyclerView) findViewById(R.id.recycler_gl);
        getDatosGL();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id==android.R.id.home){
            irHome();
            return true;
        }
       return super.onOptionsItemSelected(item);
    }

    public void irHome(){
        Intent intent = new Intent(getApplicationContext(), Login.class); //SignupActivity
        startActivityForResult(intent, REQUEST_SIGNUP);
        finish();
        overridePendingTransition(R.transition.push_rigth_in, R.transition.push_rigth_out);
    }

    public void getDatosGL(){
        try {
            Map<String, String> params = new HashMap<String, String>();
            //params.put("IdEmpleado","7");
            //params.put("IdEmpleado",Empleado.getIdUsuarioActual());
            WS_GlobalLogic.findDatos(this, params, new ResponseHandler<DatosGL[]>() {
                @Override
                public void onCompleted(DatosGL[] datos) {

                    items = datos;
                    persons = Arrays.asList(items); //cargo para buscador
                    adapter = new RecyclerAdapterGL(items, getBaseContext());
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

    public void onClickItemGL(View arg0){
       Log.e("Error", "entra click" );
            try {
                int pos = adapter.getPosition(arg0);//obtengo posicion
                String title = items[pos].getTitle();
                String description = items[pos].getDescription();
                String image = items[pos].getImage();

                Intent intent = new Intent(GlobalLogic.this, DetalleItemGL.class);
                intent.putExtra("title", title);
                intent.putExtra("description", description);
                intent.putExtra("image", image);
                startActivity(intent);
                finish();
                overridePendingTransition(R.transition.push_left_in, R.transition.push_left_out);


            }catch (Exception e){
                Log.e("Error", ""+e.getMessage() );
                Toast.makeText(this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }

}
