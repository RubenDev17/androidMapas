package com.example.gruposdemusica;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ListaGruposMusicales listaGruposMusicales;
    ListView listaGruposMusicalesLV;
    ListaGruposMusicalesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Mis grupos de música");

        listaGruposMusicalesLV = findViewById(R.id.listaGruposMusicalesLV);
        listaGruposMusicales = new ListaGruposMusicales();

        Toast.makeText(this, "Pinche en el botón para ver sus grupos musicales favoritos", Toast.LENGTH_LONG).show();

    }

    public void peticionLista(View view) {   //Creamos una peticionGet que nos devolverá una vista
        String url = "http://docs.google.com/uc?export=open&id=19LC-uf-H-VBQfA-tey7We4JgnBnb0nW5";
        PeticionGet peticionGet = new PeticionGet(this);
        peticionGet.execute(url);
    }

    public void respuestaGet(String respuesta){
            listaGruposMusicales = new ListaGruposMusicales();
            listaGruposMusicales = listaGruposMusicales.fromJson(respuesta);

            //Creamos el nuevo adapter asignando al adapter, ListaGruposMusicalesAdapter y recibe el contexto, el layout que hemos creado
            //para que represente nuestros elementos y la lista de gruposmusicales con el arraylist que hemos definido
            adapter = new ListaGruposMusicalesAdapter(this, R.layout.elemento, listaGruposMusicales.grupos);
            listaGruposMusicalesLV.setAdapter(adapter);
    }

}

