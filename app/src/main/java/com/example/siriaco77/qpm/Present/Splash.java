package com.example.siriaco77.qpm.Present;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.siriaco77.qpm.R;

public class Splash extends AppCompatActivity {

    public static final String PREFERENCES = "PreferencesFile_smarket";

    private final int DURACION_SPLASH = 1000; // 3 segundos

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        /****sesion****/
        // Restore preferences
        SharedPreferences settings = getSharedPreferences(PREFERENCES, 0);
        String first = settings.getString("app1", "");
        if (first.isEmpty()) {

            new Handler().postDelayed(new Runnable() {
                public void run() {
                    // Cuando pasen los 3 segundos, pasamos a la actividad principal de la aplicaci�n


                    try {
                        Intent intent = new Intent(Splash.this, Login.class);
                        startActivity(intent);
                        finish();
                    } catch (Exception e) {
                        Toast.makeText(getApplicationContext(), "cargar usuario catch" + e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }

                ;
            }, DURACION_SPLASH);
        }else {
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    // Cuando pasen los 3 segundos, pasamos a la actividad principal de la aplicaci�n


                    try {
                        Intent intent = new Intent(Splash.this, Login.class);
                        startActivity(intent);
                        finish();
                    } catch (Exception e) {
                        Toast.makeText(getApplicationContext(), "cargar usuario catch" + e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }

                ;
            }, DURACION_SPLASH);

        }
    }

}
