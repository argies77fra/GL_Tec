package com.example.siriaco77.qpm.Present;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import com.example.siriaco77.qpm.Present.DetalleColmena.DetalleColmena;
import com.example.siriaco77.qpm.R;

public class ReemplazoReina  extends AppCompatActivity {

    private static final int REQUEST_SIGNUP = 0;
    String colmena,colmenar,campo,tipoBusqueda;
    EditText edt_colmena2,edt_colmenar2,edt_campo2;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(getApplicationContext(), DetalleColmena.class); //SignupActivity
        startActivityForResult(intent, REQUEST_SIGNUP);
        intent.putExtra("tipoBusqueda", tipoBusqueda);
        intent.putExtra("colmena", colmena);
        intent.putExtra("colmenar", colmenar);
        intent.putExtra("campo", campo);

        finish();
        overridePendingTransition(R.transition.push_rigth_in, R.transition.push_rigth_out);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reemplazo_reina);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorMiel)));

        edt_colmena2=findViewById(R.id.edt_colmena2);
        edt_colmenar2=findViewById(R.id.edt_colmenar2);
        edt_campo2=findViewById(R.id.edt_campo2);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            tipoBusqueda=extras.getString("tipoBusqueda");
            colmena=extras.getString("colmena");
            campo=extras.getString("campo");
            colmenar = extras.getString("colmenar");

            edt_colmena2.setText(colmena);
            edt_campo2.setText(campo);
            edt_colmenar2.setText(colmenar);
        }

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        menu.findItem(R.id.action_settings).setVisible(false);
        menu.findItem(R.id.action_cambiar_pass).setVisible(false);
        menu.findItem(R.id.action_ayuda).setVisible(false);
        menu.findItem(R.id.action_settings).setVisible(false);
        //menu.findItem(R.id.action_search).setVisible(false);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id==android.R.id.home){
            onBackPressed();
        }else if(id==R.id.action_accept){
            onBackPressed();
            Toast.makeText(this, "La Reemplazo de Reina se realizo con exito!", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

}

