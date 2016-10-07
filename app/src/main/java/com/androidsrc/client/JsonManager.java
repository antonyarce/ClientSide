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
        String accion = parser.getString("Accion");
        if(estado.equalsIgnoreCase("ConexionExitosa")){
        }
        if(accion.equalsIgnoreCase("Solicitar"))
        {
            String id = parser.getString("ID");
            int size = parser.getInt("Size");
        }
        if(accion.equalsIgnoreCase("Agregar1")){
            String id = parser.getString("UUIDEspacio");
            int size = Integer.parseInt(parser.getString("Size"));
            ListManager.listaBloques.agregarInicio(id,null,size);
        }
        if(accion.equalsIgnoreCase("Agregar2")){
            String id = parser.getString("UUIDEspacio");
            int size = Integer.parseInt(parser.getString("Size"));
            String dato = parser.getString("Dato");
            ListManager.listaBloques.agregarInicio(id,dato,size);

        }
        if(accion.equalsIgnoreCase("Liberar")){
            String id = parser.getString("UUIDEspacio");
            ListManager.listaBloques.borrar(id);
        }

    }
}
