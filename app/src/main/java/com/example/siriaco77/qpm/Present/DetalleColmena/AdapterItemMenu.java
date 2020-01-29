package com.example.siriaco77.qpm.Present.DetalleColmena;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.siriaco77.qpm.R;

import java.util.ArrayList;
import java.util.List;

public class AdapterItemMenu extends BaseAdapter {
    Context context;
    //static Typeface font;

    public  static List<ItemMenu> persons_2 = new ArrayList<>();

    public AdapterItemMenu(Context context) {
        this.context = context;
        persons_2.add(new ItemMenu("0"));
        persons_2.add(new ItemMenu("1"));
        persons_2.add(new ItemMenu("2"));
        persons_2.add(new ItemMenu("3"));
        persons_2.add(new ItemMenu("4"));

    }

    @Override
    public int getCount() {
        return persons_2.size() ;
    }

    @Override
    public ItemMenu getItem(int position) {
        return persons_2.get(position);
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        if (view == null ) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.grid_view, viewGroup, false);
        }
        Typeface font = Typeface.createFromAsset(context.getAssets(),"fonts/fontawesome-webfont.ttf");
        TextView nombreCoche = (TextView) view.findViewById(R.id.nombre_coche);
        nombreCoche.setTypeface(font);
        TextView txtTitulo =(TextView) view.findViewById(R.id.txtTitulo);
        ItemMenu item = getItem(position);
        if(item.getNombre().equals("0")) {
            nombreCoche.setText("\uf0fa"); //mismo fondo
            txtTitulo.setText("Estado Sanitario");
        }if (persons_2.get(position).getNombre().equals("1")) {
            nombreCoche.setText("\uf275"); //mismo fondo
            txtTitulo.setText("Estado Producción");
        }if(item.getNombre().equals("2")) {
            nombreCoche.setText("\uf021"); //mismo fondo
            txtTitulo.setText("Reemplazar Reina");
        } if(item.getNombre().equals("3")) {
            nombreCoche.setText("\uf071"); //mismo fondo
            txtTitulo.setText("Colmena Huérfana");
        } if(item.getNombre().equals("4")) {
            nombreCoche.setText("\uf0ad"); //mismo fondo
            txtTitulo.setText("Material a Trasladar");
        }



        return view;
    }

}