package colas;

public class Jugador {
	
	private String usuario;
	private int cantidadFiguras;
	private int totalPuntos;
	
	public Jugador(){
		
		this.usuario = usuario;
		this.cantidadFiguras = cantidadFiguras;
		this.totalPuntos = totalPuntos;
		
	}
	

	@Override
	public String toString() {
		return "Jugador "+ "Nombre:" + getUsuario() + ", CantidadFiguras" 
				+ getCantidadFiguras()
				+ ", TotalPuntos" + getTotalPuntos();
	}


	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public int getCantidadFiguras() {
		return cantidadFiguras;
	}

	public void setCantidadFiguras(int cantidadFiguras) {
		this.cantidadFiguras = cantidadFiguras;
	}

	public int getTotalPuntos() {
		return totalPuntos;
	}

	public void setTotalPuntos(int totalPuntos) {
		this.totalPuntos = totalPuntos;
	}

	
}
