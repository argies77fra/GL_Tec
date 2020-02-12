package com.example.siriaco77.qpm.Present;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.siriaco77.qpm.Componentes.Empleado.Empleado;
import com.example.siriaco77.qpm.Componentes.Data.Objeto_aux;
import com.example.siriaco77.qpm.Present.GlobalLogic.GlobalLogic;
import com.example.siriaco77.qpm.MainActivity;
import com.example.siriaco77.qpm.R;
import com.example.siriaco77.qpm.WS.ResponseHandler;
import com.example.siriaco77.qpm.WS.SimpleRequest;

import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;

public class Login  extends AppCompatActivity {

    private static final int REQUEST_SIGNUP = 0;
    Button btn_ingresar,btn_register,btn_gl;
    @Bind(R.id.txt_username)EditText _emailText;
    @Bind (R.id.txt_password)EditText _passwordText;//link_recuperar
    @Bind (R.id.link_recuperar)TextView _linkRecuperar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        btn_ingresar = (Button) findViewById(R.id.btn_login);

        btn_register = (Button) findViewById(R.id.btn_register);

        btn_gl = (Button) findViewById(R.id.btn_gl);

        btn_ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                login();

            }
        });

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("http://qpm.myros.com.ar/frontend/login.php/");

                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });


        _linkRecuperar.setOnClickListener(new View.OnClickListener() { // sino tiene cuenta la crea
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RecuperarContrasena.class); //SignupActivity
                startActivityForResult(intent, REQUEST_SIGNUP);
                finish();
                overridePendingTransition(R.transition.push_left_in, R.transition.push_left_out);
            }
        });

        btn_gl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), GlobalLogic.class); //SignupActivity
                startActivityForResult(intent, REQUEST_SIGNUP);
                finish();
                overridePendingTransition(R.transition.push_left_in, R.transition.push_left_out);
            }
        });


        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

    }

    public void login (){
        Map<String, String> params = new HashMap<String, String>();
        //params.put("filters","idEmpleado=7");
        //params.put("filters","id=7");
        //params.put("IdEmpleado","7");
        //params.put("filters","id=5");
        params.put("user",_emailText.getText().toString());
        params.put("pass", _passwordText.getText().toString());
        SimpleRequest sr = new SimpleRequest(this);
        sr.send("authenticate", "login", params, Objeto_aux.class ,new ResponseHandler<Objeto_aux>() {

            @Override
            public void onCompleted(Objeto_aux r) {
                if (r.getResult()) {

                    Empleado.setNombreUsuarioActual(r.getNombreUsuario());
                    Empleado.setIdEstablecimientoActual(r.getIdEstablecimiento());
                    Empleado.setIdUsuarioActual(r.getIdUsuario());
                    Intent intent = new Intent(Login.this, MainActivity.class);
                    //intent.putExtra("pantalla", "nuevos");
                    startActivity(intent);
                }else {
                    _passwordText.setText("");
                    _emailText.setText("");
                    Toast.makeText(getApplicationContext(), "Usuario y/o Password Incorrecto.", Toast.LENGTH_LONG).show();
                }
            }
        });

    }


}


