package com.androidsrc.client;

public class NodoDoble {
	public String id;
	public int bytesTotales;
	public int bytesDisponibles;
	public NodoDoble siguiente;
	public NodoDoble anterior;
	
	//Constructor para cuando aun no hay nodos
	public NodoDoble(String id,int bytesTotales){
		this.id=id;
		this.bytesTotales=bytesTotales;
		this.anterior=null;
		this.siguiente=null;

	}
	
	//Constructor para cuando ya hay nodos
	public NodoDoble(String id,int bytesTotales, NodoDoble sig, NodoDoble ant) {
		id=id;
		this.bytesTotales=bytesTotales;
		siguiente=sig;
		anterior=ant;
	}
	
}