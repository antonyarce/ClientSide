package com.androidsrc.client;

public class NodoDoble {
	public Object dato;
	public NodoDoble siguiente;
	public NodoDoble anterior;
	
	//Constructor para cuando aun no hay nodos
	public NodoDoble(Object ele){
		this(ele,null,null);
	}
	
	//Constructor para cuando ya hay nodos
	public NodoDoble(Object ele, NodoDoble sig, NodoDoble ant) {
		dato=ele;
		siguiente=sig;
		anterior=ant;
	}
	
}