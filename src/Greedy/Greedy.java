package Greedy;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/*
 * Los candidatos son conjuntos de máquinas.
 * ----
 * Tendríamos que ordenar a las máquinas por la cantidad de piezas, primero utilizando
 * las que mayores piezas tienen para así, poder llegar a nuestro objetivo más rápido.
 * Cuántas menos máquinas usemos más óptimizado será y menos arranques tendremos.
 * Por ende ordenadas nos quedarían [M1,M3,M2,M4]
 * ----
 * Si encuentro una solucion, la mostrará, y si no la encuentra mostrará un mensaje
 * avisando que no pudo encontrar la solución.
 */
public class Greedy {
	List<Maquina> maquinas;
	Solucion secuenciaMaquinas;
	int piezasAProducir;
	public Greedy(List<Maquina> maquinas, int piezasAProducir) {
		super();
		this.maquinas = maquinas;
		this.piezasAProducir = piezasAProducir;
		secuenciaMaquinas = new Solucion(new LinkedList<>(),0,0,0);
	}
	
	public Solucion greedy() {
		Collections.sort(maquinas);
		int piezasFaltantes = this.piezasAProducir; 
		while(!maquinas.isEmpty()) {
			Maquina mejorMaquina = seleccionarMaquinaMejor();
			secuenciaMaquinas.cantidadCandidatosSolicitados++;
			int cantidadMaquinasPosible = piezasFaltantes/mejorMaquina.getCantPiezasPorProducir();
			while(cantidadMaquinasPosible>0) { //Si las piezas faltantes dividido las piezas de esa
				//maquina, es mayor a 0, nos daría la cantidad de máquinas iguales a insertar.
				//Si da 1, la agregará una sola vez y la quitará luego, si da 2 o más, la agrega esas cant de veces.
					secuenciaMaquinas.listaMaquina.add(mejorMaquina);
					secuenciaMaquinas.cantidadPiezasProducidas+=mejorMaquina.getCantPiezasPorProducir();
					secuenciaMaquinas.cantidadPuestaEnMarchas++;
					cantidadMaquinasPosible--;
					piezasFaltantes-=mejorMaquina.getCantPiezasPorProducir();
			}
			this.maquinas.remove(mejorMaquina);				
		}
		if(secuenciaMaquinas.getCantidadPiezasProducidas()==this.piezasAProducir) {
			return secuenciaMaquinas;
		}else {			
			return null;
		}
	}

	private Maquina seleccionarMaquinaMejor() {
		return this.maquinas.get(0);
	}

	public void imprimirSolucion() {
		System.out.println("-----GREEDY------");
		for(Maquina m: this.secuenciaMaquinas.listaMaquina) {
			System.out.print(m);
			System.out.print(",");
		}
		System.out.println();
		System.out.println("Cantidad de piezas producidas: " + secuenciaMaquinas.getCantidadPiezasProducidas());
		System.out.println("Cantidad de puestas en marcha: " + secuenciaMaquinas.getCantidadPuestaEnMarchas());
		System.out.println("Cantidad de candidatos considerados: "+ secuenciaMaquinas.getCantidadCandidatosSolicitados());
	}
	
	
}
