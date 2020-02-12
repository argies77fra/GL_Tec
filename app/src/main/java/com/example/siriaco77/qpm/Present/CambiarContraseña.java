package com.example.siriaco77.qpm.Present;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import com.example.siriaco77.qpm.Componentes.Data.Objeto_aux;
import com.example.siriaco77.qpm.Componentes.Empleado.Empleado;
import com.example.siriaco77.qpm.MainActivity;
import com.example.siriaco77.qpm.R;
import com.example.siriaco77.qpm.WS.ResponseHandler;
import com.example.siriaco77.qpm.WS.SimpleRequest;

import java.util.HashMap;
import java.util.Map;

public class CambiarContraseña extends AppCompatActivity {

    private static final int REQUEST_SIGNUP = 0;
    EditText edt_contrasena2,edt_contrasena_new2,edt_repita_new2;

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent intent = new Intent(getApplicationContext(), MainActivity.class); //SignupActivity
        startActivityForResult(intent, REQUEST_SIGNUP);
        finish();
        overridePendingTransition(R.transition.push_rigth_in, R.transition.push_rigth_out);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cambiar_contrasena);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorMiel)));
        edt_contrasena2=(EditText) findViewById(R.id.edt_contrasena2);
        edt_contrasena_new2=(EditText) findViewById(R.id.edt_contrasena_new2);
        edt_repita_new2=(EditText) findViewById(R.id.edt_repita_new2);



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

            setChangePass();
        }


        return super.onOptionsItemSelected(item);
    }

    private void setChangePass() {
        Map<String, String> params = new HashMap<String, String>();
        params.put("idUsuario",Empleado.getIdUsuarioActual());
        params.put("oldPass",edt_contrasena2.getText().toString());
        params.put("newPass", edt_repita_new2.getText().toString());
        SimpleRequest sr = new SimpleRequest(this);
        sr.send("empleado", "changepassword", params, Objeto_aux.class ,new ResponseHandler<Objeto_aux>() {

            @Override
            public void onCompleted(Objeto_aux r) {
                if (r.getResult()) {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class); //SignupActivity
                    startActivityForResult(intent, REQUEST_SIGNUP);
                    finish();
                    overridePendingTransition(R.transition.push_rigth_in, R.transition.push_rigth_out);
                    Toast.makeText(getApplicationContext(), "La Contraseña se actualizo con exito!", Toast.LENGTH_SHORT).show();

                }else {
                  //  _passwordText.setText("");
                  //  _emailText.setText("");
                    Toast.makeText(getApplicationContext(), "Usuario y/o Password Incorrecto.", Toast.LENGTH_LONG).show();
                }
            }
        });


    }
}
