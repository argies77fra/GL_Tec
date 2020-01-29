package com.example.siriaco77.qpm.Present;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.siriaco77.qpm.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class RecuperarContrasena extends AppCompatActivity {


    Button btn_recuperar;
    @Bind(R.id.imput_email)EditText _emailRecuperar;
    @Bind (R.id.link_login)
    TextView _linkLogin;

    private static final int REQUEST_SIGNUP = 0;


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(getApplicationContext(), Login.class); //SignupActivity
        startActivityForResult(intent, REQUEST_SIGNUP);
        finish();
        overridePendingTransition(R.transition.push_rigth_in, R.transition.push_rigth_out);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rec_contrasena);

        ButterKnife.bind(this);

        btn_recuperar=(Button) findViewById(R.id.btn_resetear);

        btn_recuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        _linkLogin.setOnClickListener(new View.OnClickListener() { // sino tiene cuenta la crea
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Login.class); //SignupActivity
                startActivityForResult(intent, REQUEST_SIGNUP);
                finish();
                overridePendingTransition(R.transition.push_rigth_in, R.transition.push_rigth_out);
            }
        });

    }

}
