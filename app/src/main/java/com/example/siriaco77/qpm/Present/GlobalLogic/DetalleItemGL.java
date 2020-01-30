package com.example.siriaco77.qpm.Present.GlobalLogic;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.siriaco77.qpm.Present.Login;
import com.example.siriaco77.qpm.R;

import org.w3c.dom.Text;

public class DetalleItemGL extends AppCompatActivity {

    private static final int REQUEST_SIGNUP = 0;
    TextView title, description;
    ImageView imageView;


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        irHome();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detalle_global_logic);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorMiel)));

        title = findViewById(R.id.title);
        description = findViewById(R.id.description);


        Bundle parametros = this.getIntent().getExtras();
        if(parametros !=null){
            String datos = parametros.getString("title");
            String datos2 = parametros.getString("description");
            String datos3 = parametros.getString("image");
            title.setText(datos);
            description.setText(datos2);
        }




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
        Intent intent = new Intent(getApplicationContext(), GlobalLogic.class); //SignupActivity
        startActivityForResult(intent, REQUEST_SIGNUP);
        finish();
        overridePendingTransition(R.transition.push_rigth_in, R.transition.push_rigth_out);
    }

}
