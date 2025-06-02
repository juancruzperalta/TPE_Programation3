package Backtracking;
import java.util.List;
import java.util.LinkedList;
public class Main {
	public static void main(String[]args) {
		Maquina m1 = new Maquina("M1", 7);
		Maquina m2 = new Maquina("M2", 3);
		Maquina m3 = new Maquina("M3", 4);
		Maquina m4 = new Maquina("M4", 1);
		Maquina m5 = new Maquina("M5", 2);
		Maquina m6 = new Maquina("M6", 8);
		Maquina m7 = new Maquina("M7", 1);
		List<Maquina> maquinas = new LinkedList<>();
		maquinas.add(m1);
		maquinas.add(m2);
		maquinas.add(m3);
		maquinas.add(m4);
		maquinas.add(m5);
		maquinas.add(m6);
		maquinas.add(m7);
		
		Backtracking back = new Backtracking(maquinas, 12);
		back.backTracking();
		back.imprimirSolucion();
		//FALTA TODAVIA REVISAR QUE ME IMPRIMA LA MENOR CANTIDAD DE MAQUINAS
		//REVISAR ENUNCIADO
	}
}
