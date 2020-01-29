package com.example.siriaco77.qpm.Present.DetalleColmena;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import com.example.siriaco77.qpm.Componentes.Data.Objeto_aux;
import com.example.siriaco77.qpm.Componentes.Nivel_Produccion.Nivel_Produccion;
import com.example.siriaco77.qpm.Present.ActivityColmena.ActivityColmena;
import com.example.siriaco77.qpm.Present.EstadoSanitario.EstadoSanitario;
import com.example.siriaco77.qpm.Present.Nivelproduccion.NivelProduccion;
import com.example.siriaco77.qpm.Present.ReemplazoReina;
import com.example.siriaco77.qpm.R;
import com.example.siriaco77.qpm.WS.ResponseHandler;
import com.example.siriaco77.qpm.WS.SimpleRequest;

import java.util.HashMap;
import java.util.Map;

import static com.example.siriaco77.qpm.Present.DetalleColmena.AdapterItemMenu.persons_2;


public class DetalleColmena extends AppCompatActivity {

    private static final int REQUEST_SIGNUP = 0;
    String colmena,campo,colmenar,tipoBusqueda,estadoColmena,idColmena,estado_actual,nivel_actual;
    GridView gridView;
    EditText edt_campo2,edt_colmenar2;
    private AdapterItemMenu adaptador;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(getApplicationContext(), ActivityColmena.class); //SignupActivity
        intent.putExtra("tipoBusqueda", tipoBusqueda);
        intent.putExtra("colmena", colmena);
        intent.putExtra("colmenar", colmenar);
        intent.putExtra("campo", campo);
        intent.putExtra("estadoColmena", estadoColmena);
        startActivityForResult(intent, REQUEST_SIGNUP);
        finish();
        overridePendingTransition(R.transition.push_rigth_in, R.transition.push_rigth_out);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalle_colmena);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorMiel)));
        persons_2.clear();

        edt_campo2=(EditText) findViewById(R.id.edt_campo2);
        edt_colmenar2=(EditText) findViewById(R.id.edt_colmenar2);
        gridView = (GridView) findViewById(R.id.grid);
        adaptador = new AdapterItemMenu(this);
        gridView.setAdapter(adaptador);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            tipoBusqueda=extras.getString("tipoBusqueda");
            colmena = extras.getString("colmena");
            colmenar = extras.getString("colmenar");
            campo=extras.getString("campo");
            estadoColmena=extras.getString("estadoColmena");
            idColmena=extras.getString("idColmena");
            estado_actual=extras.getString("estado_actual");
          // nivel_actual=extras.getString("nivel_actual");

            edt_campo2.setText(campo);
            edt_colmenar2.setText(colmenar);
        }

        if(estadoColmena.equals("2")){
            persons_2.remove(3);
        }
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                String positionX = adaptador.getItem(position).getNombre();

                if (positionX.equals("2")) {
                    Intent intent = new Intent(DetalleColmena.this, ReemplazoReina.class);
                    intent.putExtra("tipoBusqueda", tipoBusqueda);
                    intent.putExtra("colmena", colmena);
                    intent.putExtra("colmenar", colmenar);
                    intent.putExtra("campo", campo);
                    startActivity(intent);
                    overridePendingTransition(R.transition.push_left_in, R.transition.push_left_out);
                }else if (positionX.equals("0")){
                    Intent intent = new Intent(DetalleColmena.this, EstadoSanitario.class);
                    intent.putExtra("tipoBusqueda", tipoBusqueda);
                    intent.putExtra("idColmena", idColmena);
                    intent.putExtra("colmena", colmena);
                    intent.putExtra("colmenar", colmenar);
                    intent.putExtra("campo", campo);
                    intent.putExtra("estado_actual", estado_actual);
                    intent.putExtra("estadoColmena", estadoColmena);
                    startActivity(intent);
                    overridePendingTransition(R.transition.push_left_in, R.transition.push_left_out);
                }else if(positionX.equals("3")){

                    AlertDialog alertDialog = new AlertDialog.Builder(DetalleColmena.this).create();
                    alertDialog.setTitle("Atención!");
                    alertDialog.setMessage("Esta seguro de que desea marcar esta colmena como huérfana?");
                    alertDialog.setCancelable(false);
                    alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    updateState();
                                    Toast.makeText(DetalleColmena.this, "La colmena se marco como huerfana.", Toast.LENGTH_SHORT).show();
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Cancelar",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();

                } else if(positionX.equals("1")){
                    Intent intent = new Intent(DetalleColmena.this, NivelProduccion.class);
                    intent.putExtra("tipoBusqueda", tipoBusqueda);
                    intent.putExtra("colmena", colmena);
                    intent.putExtra("colmenar", colmenar);
                    intent.putExtra("campo", campo);
                    intent.putExtra("estado_actual", estado_actual);
                    intent.putExtra("estadoColmena", estadoColmena);
                    intent.putExtra("nivel_actual", nivel_actual);
                    startActivity(intent);
                    overridePendingTransition(R.transition.push_left_in, R.transition.push_left_out);

                }


            }
         });
    this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id==android.R.id.home){
            onBackPressed();
        }else if(id==R.id.action_cancel){

            Toast.makeText(this, "aa", Toast.LENGTH_SHORT).show();
        }


        return super.onOptionsItemSelected(item);
    }
}

