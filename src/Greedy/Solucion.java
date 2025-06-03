package Greedy;

import java.util.List;

public class Solucion {
	List<Maquina> listaMaquina;
	int cantidadPiezasProducidas;
	int cantidadPuestaEnMarchas;
	int cantidadCandidatosSolicitados;
	public Solucion(List<Maquina> listaMaquina, int cantidadPiezasProducidas, int cantidadPuestaEnMarchas,
			int cantidadCandidatosSolicitados) {
		super();
		this.listaMaquina = listaMaquina;
		this.cantidadPiezasProducidas = cantidadPiezasProducidas;
		this.cantidadPuestaEnMarchas = cantidadPuestaEnMarchas;
		this.cantidadCandidatosSolicitados = cantidadCandidatosSolicitados;
	}
	public List<Maquina> getListaMaquina() {
		return listaMaquina;
	}
	public void setListaMaquina(List<Maquina> listaMaquina) {
		this.listaMaquina = listaMaquina;
	}
	public int getCantidadPiezasProducidas() {
		return cantidadPiezasProducidas;
	}
	public void setCantidadPiezasProducidas(int cantidadPiezasProducidas) {
		this.cantidadPiezasProducidas = cantidadPiezasProducidas;
	}
	public int getCantidadPuestaEnMarchas() {
		return cantidadPuestaEnMarchas;
	}
	public void setCantidadPuestaEnMarchas(int cantidadPuestaEnMarchas) {
		this.cantidadPuestaEnMarchas = cantidadPuestaEnMarchas;
	}
	public int getCantidadCandidatosSolicitados() {
		return cantidadCandidatosSolicitados;
	}
	public void setCantidadCandidatosSolicitados(int cantidadCandidatosSolicitados) {
		this.cantidadCandidatosSolicitados = cantidadCandidatosSolicitados;
	}
	
}
