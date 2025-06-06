package Backtracking;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Maquina> maquinas = new LinkedList<>();
        String objetivo = "";
        int valorObjetivo=0;
        try {
        BufferedReader br = new BufferedReader(new FileReader("src/Backtracking/iniciales.txt"));
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
        	System.out.println("Error:No hay datos");
        }
        
        
        Backtracking back = new Backtracking(maquinas, valorObjetivo);
        Solucion sol = back.backTracking();
        if(sol!=null) {
        	back.imprimirSolucion();
        }else {
        	System.out.println("No hay solución");
        }

    }
}