package com.example.gruposdemusica;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

import java.util.List;

public class ListaGruposMusicalesAdapter extends ArrayAdapter {

    Context context;
    int layout;
    List <Grupos> grupos;

    public ListaGruposMusicalesAdapter(@NonNull Context context, int resource, @NonNull List<Grupos> grupos) {
        super(context, resource, grupos);
        this.context = context;
        this.layout = resource;
        this.grupos = grupos;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //Creamos una vista
        if(convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(context);  //Necesario para crear una vista
            //Creamos la vista a través del recurso que hemos pasado (layout que representa mi fila y pasamos
            //la vista padre y pondremos false para que no se asocie a ella
            convertView = layoutInflater.inflate(layout, parent, false);
        }

        TextView nombreTV = convertView.findViewById(R.id.nombreTV);
        TextView descripcionTV = convertView.findViewById(R.id.descripcionTV);
        ImageView imagenIV = convertView.findViewById(R.id.imagenIV);

        nombreTV.setText(grupos.get(position).nombre);
        descripcionTV.setText(grupos.get(position).descripcion);
        Picasso.get().load(grupos.get(position).imagen).into(imagenIV);

        return convertView;
    }
}
