package Greedy;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/*
 * Los candidatos son las máquinas.
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
		Collections.sort(this.maquinas);
		
		while(!maquinas.isEmpty()) {
			Maquina mejorMaquina = seleccionarMaquinaMejor();
			this.maquinas.remove(mejorMaquina);
			
			if(secuenciaMaquinas.cantidadPiezasProducidas+mejorMaquina.getCantPiezasPorProducir()
					== this.piezasAProducir) {
				secuenciaMaquinas.listaMaquina.add(mejorMaquina);
				secuenciaMaquinas.cantidadPiezasProducidas+=mejorMaquina.getCantPiezasPorProducir();
			}
		}
		if(secuenciaMaquinas!=null) {
			return secuenciaMaquinas;
		}
		return null;
	}

	private Maquina seleccionarMaquinaMejor() {
		return this.maquinas.get(0);
	}

	public void imprimirSolucion() {
		for(Maquina m: this.secuenciaMaquinas.listaMaquina) {
			System.out.println(m);
		}
		System.out.println(secuenciaMaquinas.getCantidadPiezasProducidas());
	}
	
	
}
