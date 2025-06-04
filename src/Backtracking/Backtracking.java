package Backtracking;

import java.util.List;
import java.util.LinkedList;

public class Backtracking {
	List<Maquina> conjMaquinas;
	int piezasAProducir;
	Solucion secuenciaÓptima;
	int cantidadEstadosGenerados;
	public Backtracking(List<Maquina> conjMaquinas, int piezasAProducir) {
		super();
		this.conjMaquinas = conjMaquinas;
		this.piezasAProducir = piezasAProducir;
		this.cantidadEstadosGenerados=0;
	}
	/*
	 * Como sería el arbol de exploración: 
	 * Primero y principal pondría una máquina [M1] supongamos, y luego iría al próximo
	 * nivel del arbol y probaría con la siguiente máquina, obviamente poniendo primero la [M1] nuevamente
	 * (repetida), y luego la siguiente ejemplo: [M1] [M2] [M3] [M4], en el próximo nivel, probaría nuevamente
	 * con la siguiente máquina, y así sucesivamente hasta terminar con las máquinas y/o encontrar la solucion.
	 * ___PODA___
	 * --->¿Dónde podaría? Podaría por ejemplo en el siguiente arbol [M1 V=7, M2 V=3, M3 V=4] ya al llegar a M3
	 * 		el resultado de piezas a producir iría en 14, se excedió, entonces ya podaría y no seguiría
	 * 		por esa misma rama.
	 * 
	 * -Estado final: dónde la cantidad de piezas sea igual a la cantidad de piezas a producir,
	 * -Estado solucion: [M1,M3,M4] Piezas=12, este es un ejemplo, pero el estado solución sería
	 * cuándo es estado final, y además, es menor cantidad de puestas en marcha(en este ejemplo)
	 * sería una solución adecuada al problema. 
	 */
	public Solucion backTracking() {
		Estado e = new Estado(new LinkedList<>(), 0);
		secuenciaÓptima = new Solucion(new LinkedList<>(),0,0,0);
		backTracking(e);
		if(!secuenciaÓptima.secuenciaMaquinas.isEmpty()) {			
			secuenciaÓptima.setCantidadEstadosGenerados(cantidadEstadosGenerados);
			return secuenciaÓptima;
		}
		return null;
	}
	private void backTracking(Estado e) {
		this.cantidadEstadosGenerados++;
		if(e.getPiezasUsadasActuales()==this.piezasAProducir) {
			if(secuenciaÓptima.secuenciaMaquinas.isEmpty() || e.puestaEnMarcha <= secuenciaÓptima.cantidadPuestasEnMarcha) {				
				secuenciaÓptima.setSecuenciaMaquinas(new LinkedList<>(e.maquinasActuales));
				secuenciaÓptima.setCantidadPiezasProducidas(e.getPiezasUsadasActuales());
				secuenciaÓptima.setCantidadPuestasEnMarcha(e.puestaEnMarcha);
			}
		}else {
			for(Maquina m: conjMaquinas) {	
					e.marcarUsada(m); //Agrego la máquina actual como usada
					e.puestaEnMarcha(); //Añado 1 más al estado para saber cuantas puestas en marcha voy
					e.sumarCantPiezas(m.getCantPiezasPorProducir()); //sumo las cant de pieszas
					if(!poda(e))
					backTracking(e);
					e.quitarUso(); //Quito la máquina actual
					e.quitarPuestaEnMarcha(); //Resto la máquina puesta en marcha
					e.restarCantPiezas(m.getCantPiezasPorProducir()); //Resto la cant de piezas
			}
		}
	}

	private boolean poda(Estado e) {
		if(e.getPiezasUsadasActuales() > this.piezasAProducir) {
			return true;
		}
		return false;
	}

	public void imprimirSolucion() {
		System.out.println("--------BACKTRACKING--------");
		for(Maquina m : this.secuenciaÓptima.secuenciaMaquinas) {
			System.out.print(m);
			System.out.print(",");
		}
		System.out.println();
		System.out.println("Piezas producidas: " + secuenciaÓptima.getCantidadPiezasProducidas());
		System.out.println("Cantidad puestas en marchas: " + secuenciaÓptima.getCantidadPuestasEnMarcha());
		System.out.println("Estados generados "+ secuenciaÓptima.getCantidadEstadosGenerados());
	}
}
