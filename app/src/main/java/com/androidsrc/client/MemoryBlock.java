package com.androidsrc.client;

public class MemoryBlock {
	int size;
	String idEspacio;
	String dato;
	public MemoryBlock siguiente;
	public MemoryBlock anterior;
	boolean itsFree;
	
	//Constructor para cuando aun no hay nodos
	public MemoryBlock(String id, String dato, int size){
		this.idEspacio=id;
		this.anterior=null;
		this.siguiente=null;
		this.dato=dato;
		this.size=size;
		this.itsFree=false;


	}


	
	//Constructor para cuando ya hay nodos
	public MemoryBlock(String id,String dato, int size, MemoryBlock sig, MemoryBlock ant) {
		this.size=size;
		this.dato=dato;
		this.idEspacio=id;
		siguiente=sig;
		anterior=ant;
		this.itsFree=false;
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

	public boolean isItsFree() {return itsFree;}

	public void setItsFree(boolean itsFree) {this.itsFree = itsFree;}
}