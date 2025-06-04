package Backtracking;

public class Maquina {
	String nombreMaquina;
	int cantPiezasPorProducir;
	public Maquina(String nombreMaquina, int cantPiezasPorProducir) {
		super();
		this.nombreMaquina = nombreMaquina;
		this.cantPiezasPorProducir = cantPiezasPorProducir;
	}
	public String getNombreMaquina() {
		return nombreMaquina;
	}
	public void setNombreMaquina(String nombreMaquina) {
		this.nombreMaquina = nombreMaquina;
	}
	public int getCantPiezasPorProducir() {
		return cantPiezasPorProducir;
	}
	public void setCantPiezasPorProducir(int cantPiezasPorProducir) {
		this.cantPiezasPorProducir = cantPiezasPorProducir;
	}
	@Override
	public String toString() {
		return "[" + nombreMaquina + " - " + cantPiezasPorProducir + "]";
	}
	
	
}
