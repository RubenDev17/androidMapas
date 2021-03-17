package com.example.gruposdemusica;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class PeticionGet extends AsyncTask<String, Void, String> {

    MainActivity mainActivity;

    //Como parametro de entrada en el constructor recibimos directamente la actividad principal

    PeticionGet(MainActivity mainActivity){
        this.mainActivity = mainActivity;
    }

    @Override
    protected String doInBackground(String... url) {
        //Este string es para obtener luego el resultado ya que en el try no nos deja crearlo.Lo declaramos fuera para que no de error
        String body = "";
        //Creamos un objeto okHttpCliente, osea un cliente http
        OkHttpClient okHttpClient = new OkHttpClient();
        //Construimos una peticion. Una peticion es un objeto de tipo Request
        Request peticion = new Request.Builder().url(url[0]).build();
        //Para ejecutar esta peticion, creamos una respuesta llamando a newCall().execute
        try { //el try-catch lo obtenemos como excepcion al ejecutar la peticion
            Response respuesta = okHttpClient.newCall(peticion).execute();
            body = respuesta.body().string(); //Obtenemos el resultado o la respuesta
        } catch (IOException e) {
            Log.d("PeticionGet", "Error de conexion");
        }
        return body;

    }

    @Override
    protected void onPostExecute(String respuesta) {

        //Con esto en la actividad principal procesamos la respuesta que llega del servicio
        mainActivity.respuestaGet(respuesta);
    }
}
