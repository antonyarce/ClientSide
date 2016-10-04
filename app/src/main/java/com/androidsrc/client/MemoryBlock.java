package com.androidsrc.client;

/**
 * Created by allan on 03/10/16.
 */

public class MemoryBlock {
    int size;
    String idEspacio;
    String dato;

    public MemoryBlock(String idEspacio, String dato, int size) {
        this.idEspacio = idEspacio;
        this.dato = dato;
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getIdEspacio() {
        return idEspacio;
    }

    public void setIdEspacio(String idEspacio) {
        this.idEspacio = idEspacio;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }
}
