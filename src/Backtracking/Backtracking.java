package Backtracking;

import java.util.List;
import java.util.LinkedList;
public class Backtracking {
	List<Maquina> conjMaquinas;
	int piezasAProducir;
	Solucion secuenciaÓptima;
	public Backtracking(List<Maquina> conjMaquinas, int piezasAProducir) {
		super();
		this.conjMaquinas = conjMaquinas;
		this.piezasAProducir = piezasAProducir;
	}
	
	public Solucion backTracking() {
		Estado e = new Estado(new LinkedList<>(), 0, new Maquina("",0));
		secuenciaÓptima = new Solucion(new LinkedList<>(), 0, 0);
		backTracking(e);
		return secuenciaÓptima;
	}
	private void backTracking(Estado e) {
		if(e.getPiezasUsadasActuales()==this.piezasAProducir) {
			if(e.maquinasActuales.size() > secuenciaÓptima.cantidadPuestasEnMarcha) {				
				secuenciaÓptima.secuenciaMaquinas = new LinkedList<>(e.maquinasActuales);
				secuenciaÓptima.cantidadPiezasProducidas = e.piezasUsadasActuales;
				secuenciaÓptima.cantidadPuestasEnMarcha = e.maquinasActuales.size();
			}
		}else {
			for(Maquina m: conjMaquinas) {
				if(!e.maquinasActuales.contains(m)) {					
					e.aplicarMaquina(m);
					e.marcarUsada(m);
					e.piezaUsadaMas(m.cantPiezasPorProducir);
					//if(!poda(e))
					backTracking(e);
					e.quitarUso();
					e.piezaUsadaMenos(m.cantPiezasPorProducir);
				}
			}
		}
	}

	public void imprimirSolucion() {
		for(Maquina m : this.secuenciaÓptima.secuenciaMaquinas) {
			System.out.println(m);
		}
		System.out.println("Piezas producidas: " + secuenciaÓptima.cantidadPiezasProducidas);
		System.out.println("Cantidad puestas en marchas: " + secuenciaÓptima.cantidadPuestasEnMarcha);
	}
}
