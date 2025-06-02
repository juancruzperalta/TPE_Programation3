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
                        maquinas.add(new Maquina(nombre, valor));
                    }
                }
        }catch(Exception err) {
        	System.out.println(err);
        }
        
        
        Backtracking back = new Backtracking(maquinas, valorObjetivo);
        back.backTracking();
        back.imprimirSolucion();

    }
}