package com.example.gruposdemusica;

import com.google.gson.Gson;

import java.util.ArrayList;

public class ListaGruposMusicales {

    ArrayList<Grupos> grupos;

    ListaGruposMusicales() {       //En el constructor inicializamos la lista para evitar problemas
        grupos = new ArrayList<>();
    }

    //Esta función crea una lista de grupos musicales a partir de un objeto json(o un string en java que dentro irá un
    //formato en json.
    public ListaGruposMusicales fromJson(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, ListaGruposMusicales.class);
    }

}