package com.example.siriaco77.qpm.Present.Nivelproduccion;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.siriaco77.qpm.Present.DetalleColmena.DetalleColmena;
import com.example.siriaco77.qpm.R;

public class NivelProduccion extends AppCompatActivity {

    private static final int REQUEST_SIGNUP = 0;
    String colmena,colmenar,campo,tipoBusqueda,nivel_actual,estadoColmena;
    EditText edt_colmena,edt_colmenar,edt_campo,edt_estado_actual;

    Spinner spinner_nuevo_estado,spinner_enfermedad;



    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(getApplicationContext(), DetalleColmena.class); //SignupActivity
        intent.putExtra("tipoBusqueda", tipoBusqueda);
        intent.putExtra("colmena", colmena);
        intent.putExtra("colmenar", colmenar);
        intent.putExtra("campo", campo);
       // intent.putExtra("nivel_actual", nivel_actual);
        intent.putExtra("estadoColmena",estadoColmena);

        startActivityForResult(intent, REQUEST_SIGNUP);
        finish();
        overridePendingTransition(R.transition.push_rigth_in, R.transition.push_rigth_out);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nivel_produccion);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorMiel)));

        edt_colmena = findViewById(R.id.edt_colmena_2);
        edt_colmenar = findViewById(R.id.edt_colmenar_2);
        edt_campo = findViewById(R.id.edt_campo_2);
        edt_estado_actual = findViewById(R.id.edt_estado_actual_2);
        spinner_nuevo_estado =findViewById(R.id.spinner_nuevo_estado_2);//spinner_enfermedad
        spinner_enfermedad =findViewById(R.id.spinner_enfermedad_2);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            tipoBusqueda = extras.getString("tipoBusqueda");
            colmena = extras.getString("colmena");
            colmenar = extras.getString("colmenar");
            campo = extras.getString("campo");
            estadoColmena = extras.getString("estadoColmena");
            //nivel_actual = extras.getString("nivel_actual");

            edt_colmena.setText(colmena);
            edt_colmenar.setText(colmenar);
            edt_campo.setText(campo);
            edt_estado_actual.setText(nivel_actual);

        }

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id==android.R.id.home){
            onBackPressed();
        }
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
