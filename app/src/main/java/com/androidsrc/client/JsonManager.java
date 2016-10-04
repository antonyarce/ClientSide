package com.androidsrc.client;

/**
 * Created by allan on 03/10/16.
 */

import org.json.JSONException;
import org.json.JSONObject;

public class JsonManager {
    public static void parse(String texto) throws JSONException {
        JSONObject parser = new JSONObject(texto);
        String estado = parser.getString("Estado");
        if(estado.equalsIgnoreCase("ConexionExitosa")){
        }

    }
}
