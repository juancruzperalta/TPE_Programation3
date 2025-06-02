package Backtracking;

import java.util.List;

/*
 * Como sería el arbol de exploración: 
 * 		-[M1 V=7]  -------------- -
 * 	 -   	 	- 	  -				- 
 * 	-      	 	-        -		 	   -
 * -		 	- 			-			  -
 *[M1 V=7] 		[M2=3] 	  [M3 V=4]		[M4 V=1]
 *PODA			   -			-			-
 * *==14 > 12...   -			  -				-.....
 * 				   -				-
 * 					...			 [M4 V=1]
 * 			   				 [SOLUCION OPTIMA]
 * 			
 * 
 * --->Una poda posible es que si ya la suma de piezas utilizadas es mayor
 * --->a la piezas que quieren producir(12 por ej), cortaríamos y no buscaríamos más por esa rama.
 * 
 * -Estado final: [M1,M3,M4] V=12.
 * -Estado solucion: [M1,M3,M4] Piezas=12, PuestasEnMarcha=3;
 */
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
		secuenciaÓptima = new Solucion(new LinkedList<>(), 0, 0,0);
		int contador=0;
		backTracking(e, contador);
		return secuenciaÓptima;
	}
	private void backTracking(Estado e, int contador) {
		contador++;
		if(e.getPiezasUsadasActuales()==this.piezasAProducir) {
			if(secuenciaÓptima.cantidadPuestasEnMarcha==0 || contador <= secuenciaÓptima.cantidadPuestasEnMarcha) {				
				secuenciaÓptima.setSecuenciaMaquinas(new LinkedList<>(e.maquinasActuales));
				secuenciaÓptima.setCantidadPiezasProducidas(e.getPiezasUsadasActuales());
				secuenciaÓptima.setCantidadPuestasEnMarcha(e.puestaEnMarcha);
				secuenciaÓptima.setCantidadEstadosGenerados(contador);
			}
		}else {
			for(Maquina m: conjMaquinas) {				
					e.aplicarMaquina(m);
					e.marcarUsada(m);
					e.puestaEnMarcha();
					e.sumarCantPiezas(m.getCantPiezasPorProducir());
					if(!poda(e))
					backTracking(e,contador);
					e.quitarUso();
					e.quitarPuestaEnMarcha();
					e.restarCantPiezas(m.getCantPiezasPorProducir());
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
