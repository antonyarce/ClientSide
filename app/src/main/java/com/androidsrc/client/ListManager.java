package com.androidsrc.client;

import java.util.PriorityQueue;

/**
 * Created by allan on 07/10/16.
 */

public class ListManager {
    public static ListaDoble listaBloques = new ListaDoble();
    private static int BytesTotales ;
    private static int BytesDisponibles ;

    public static void agregarBloque(int tamano){
        BytesDisponibles = BytesDisponibles-tamano;
    }

    public static int getBytesDisponibles() {
        return BytesDisponibles;
    }
    public static void liberarEspacio(int tamano){
        BytesDisponibles = BytesDisponibles+tamano;
    }

    public static int getBytesTotales() {
        return BytesTotales;
    }

    public static void setBytesTotales(int bytesTotales) {
        BytesTotales = bytesTotales;
    }
}
