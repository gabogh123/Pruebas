package colas;

public class Lista {
	
	private NodoCola inicio;
	private NodoCola fin;
	
	
	public Lista(){
		inicio = null;
		fin = null;
	}
	
	
	public boolean isEmpty(){
		if(inicio == null){
			return true;
		}else{
			return false;
		}
	}
	
	public void insertar(Jugador jugador){
		
		NodoCola actual;
		if(isEmpty()){
			
			actual = new NodoCola(jugador,null);
			inicio = actual;
			fin = actual;
			
		}else{
			
			actual = new NodoCola(jugador, null);
			fin.setNext(actual);
			fin = actual;
			
		}
	}
	
	
	

}
