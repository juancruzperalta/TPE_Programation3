package Greedy;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Maquina> maquinas = new LinkedList<>();
        String objetivo = "";
        int valorObjetivo=0;
        try {
        BufferedReader br = new BufferedReader(new FileReader("src/Greedy/inicialGreedy.txt"));
                objetivo = br.readLine().trim();
                valorObjetivo = Integer.parseInt(objetivo);
             String linea;
             while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                    if (partes.length == 2) {
                        String nombre = partes[0].trim();
                        int valor = Integer.parseInt(partes[1].trim());
                        if(valor > 0) {                        	
                        maquinas.add(new Maquina(nombre, valor));
                        }
                    }
                }
        }catch(Exception err) {
        	System.out.println("Error, no hay datos");
        }

        Greedy eje = new Greedy(maquinas, valorObjetivo);
        Solucion sol = eje.greedy();
        //También verifico que se imprima sólo si el valorObjetivo es mayor a un numero razonable
        if(sol!=null && valorObjetivo > 0) {
        	eje.imprimirSolucion();
        }else {
        	System.out.println("GREEDY: -> No hemos llegado a una solución posible.");
        }
        
    }
}