package com.androidsrc.client;

public class ListaDoble {
	// se  declara  un nodo inicial de la lista  y uno final.
	public NodoDoble inicio,fin;

	public ListaDoble(){
		// le asigna por  defecto a los  nodos  creados  que apunteen a null.
		inicio=fin=null;
	}
	
	/**
	 * m�todo  que  analiza si la lista  esta  vacia,
	 * @return retorna  un  tipo de dato boolean   
	 * 
	 */
	public boolean estaVacia(){
		return inicio==null;
	}

	/**
	 * agregarFinal es   un  metodo  se  encarga  de   agregar  un elemento al final de  la lista.
	 * 
	 */
	public void agregarFinal(String id,int byteTotales){
		if (!estaVacia()){
			fin= new NodoDoble(id,byteTotales, null, fin);// se hace  una instancia creando un nodo  al final de la lista.
			fin.anterior.siguiente=fin;
			}else{
				inicio=fin=new NodoDoble(id,byteTotales);
			}
		}
	/**
	 * agregarInicio es un metodo cuya funci�n es agregar un elemento al inicio de  la lista 
	 *  
	 */
	public void agregarInicio(String id, int byteTotales){
		if (!estaVacia()){//verifica que la lista no est� vac�a 
			inicio=new NodoDoble(id,byteTotales,inicio, null);
			inicio.siguiente.anterior= inicio;
			}else{
				inicio=fin=new NodoDoble(id,byteTotales);
			}
		}
	
	
	/**
	 *  este  M�todo esta  encargado de mostrar todos  los elementos que tiene  la  lista desde  su inicio hasta el final de la misma 
	 * @return retorna  la lista entera de inicio  a fin 
	 */
	public String mostrarInicioFin(){
		String datos="<=>";
		if(!estaVacia()){
			NodoDoble auxiliar = inicio;
			while (auxiliar!=null){
				datos = datos + "{"+auxiliar.id+"}"+"<=>";
				auxiliar=auxiliar.siguiente;
				
			}	
		}
		return datos;
	}
	
	/**
	 * este metodo  tiene  la funcion  de  mostrar  todos los elementos de la  lista de  una  forma  inversa    
	 * @return retorna  un String  con los elementos de la lista 
	 */
	public String mostrarFinInicio(){
		String datos="<=>";
		if(!estaVacia()){
			NodoDoble auxiliar = fin;
			while (auxiliar!=null){
				datos = datos + "{"+auxiliar.id+"}"+"<=>";
				auxiliar=auxiliar.anterior;
				
			}		
		}
		return datos;
	}
	
	/**
	 *  la fun del M�todo  buscar  es tratar de encontrar en la lista el elemento que se desea encontrar
	 *  
	 * @return  si  se encuentra el  elemento se  retorna
	 */
	public Object buscar(Object elemento){
		NodoDoble auxiliar=inicio;
		for ( ; auxiliar != null && !elemento.equals(auxiliar.id); auxiliar = auxiliar.siguiente);
		if(auxiliar==null){
			return null;
		}else{
			return auxiliar.id;
		}
		
	}
	

	//M�todo para borrar el Inicio
	public void borrarInicio(){
		if(inicio==fin){
			inicio=fin=null;
		}else{
			inicio=inicio.siguiente;
			inicio.anterior=null;
		}
	}
	
	//M�todo para borrar el Final
	public void borrarFinal(){
		if(inicio==fin){
			inicio=fin=null;
		}else{
			fin=fin.anterior;
			fin.siguiente=null;
		}
	}
	
	
	
	
	/**
	 *  la funcion de este m�todo consiste en buscar un elemento en la lista y lo elimina
	 *
	 */
	public void borrar(Object dato){
		NodoDoble buscado = null; 
		NodoDoble iterador = inicio;
		if(inicio==fin){
			inicio=fin=null;
		}else if (dato.equals(inicio.id)){
			inicio=inicio.siguiente;
			inicio.anterior=null;
		}else if (dato.equals(fin.id)){
			fin=fin.anterior;
			fin.siguiente=null;
		}else{
			while ( buscado == null && iterador != null ) {
				if ( dato.equals(iterador.id)) {
					buscado = iterador; 
				} 
				iterador = iterador.siguiente; 
			 	}
			buscado.anterior.siguiente=buscado.siguiente;
			buscado.siguiente.anterior=buscado.anterior;
			}
		}

	public int length(){
		NodoDoble auxiliar = inicio;
		int contador = 0;
		if(inicio==null && fin==null){
			return contador;
		}
		if(inicio==fin){
			return 1;
		}else{
			while(auxiliar!=null){
				contador=contador+1;
				auxiliar=auxiliar.siguiente;
			}
			return contador;
		}
	}
	



	

	
	/*public ListaDoble enlistar_Array(JSONArray arrayString, JSONArray arrayNumeral ) throws JSONException{
		ListaDoble lista_array = new ListaDoble();
		if (arrayString == null && arrayNumeral!=null){
			for(int i=0; i < arrayNumeral.length(); i++){
				String dato = String.valueOf(arrayNumeral.getInt(i));
				lista_array.agregarInicio(dato);	
		}
		}if(arrayString!= null && arrayNumeral==null){
			for(int i=0; i < arrayString.length(); i++){
				lista_array.agregarInicio(arrayString.getString(i));
		}
		}
		return lista_array;
	}*/

}