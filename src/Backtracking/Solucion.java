package Backtracking;

import java.util.List;

public class Solucion {
	List<Maquina> secuenciaMaquinas;
	int cantidadPiezasProducidas;
	int cantidadPuestasEnMarcha;
	public Solucion(List<Maquina> secuenciaMaquinas, int cantidadPiezasProducidas, int cantidadPuestasEnMarcha) {
		super();
		this.secuenciaMaquinas = secuenciaMaquinas;
		this.cantidadPiezasProducidas = cantidadPiezasProducidas;
		this.cantidadPuestasEnMarcha = cantidadPuestasEnMarcha;
	}
	public List<Maquina> getSecuenciaMaquinas() {
		return secuenciaMaquinas;
	}
	public void setSecuenciaMaquinas(List<Maquina> secuenciaMaquinas) {
		this.secuenciaMaquinas = secuenciaMaquinas;
	}
	public int getCantidadPiezasProducidas() {
		return cantidadPiezasProducidas;
	}
	public void setCantidadPiezasProducidas(int cantidadPiezasProducidas) {
		this.cantidadPiezasProducidas = cantidadPiezasProducidas;
	}
	public int getCantidadPuestasEnMarcha() {
		return cantidadPuestasEnMarcha;
	}
	public void setCantidadPuestasEnMarcha(int cantidadPuestasEnMarcha) {
		this.cantidadPuestasEnMarcha = cantidadPuestasEnMarcha;
	}
	
}
