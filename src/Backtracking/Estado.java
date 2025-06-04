package Backtracking;

import java.util.List;

public class Estado {
	List<Maquina> maquinasActuales;
	int piezasUsadasActuales;
	int puestaEnMarcha;
	public Estado(List<Maquina> maquinasActuales, int piezasUsadasActuales) {
		super();
		this.maquinasActuales = maquinasActuales;
		this.piezasUsadasActuales = piezasUsadasActuales;
	}
	public List<Maquina> getMaquinasActuales() {
		return maquinasActuales;
	}
	public void setMaquinasActuales(List<Maquina> maquinasActuales) {
		this.maquinasActuales = maquinasActuales;
	}
	public int getPiezasUsadasActuales() {
		return piezasUsadasActuales;
	}
	public void setPiezasUsadasActuales(int piezasUsadasActuales) {
		this.piezasUsadasActuales = piezasUsadasActuales;
	}
	public void marcarUsada(Maquina m) {
		this.maquinasActuales.add(m);
	}
	public void quitarUso() {
		this.maquinasActuales.remove(this.maquinasActuales.size()-1);
	}
	public void sumarCantPiezas(int cantPiezasPorProducir) {
		this.piezasUsadasActuales+=cantPiezasPorProducir;
	}
	public void restarCantPiezas(int cantPiezasPorProducir) {
		this.piezasUsadasActuales-=cantPiezasPorProducir;
	}
	public void puestaEnMarcha() {
		this.puestaEnMarcha++;
	}
	public void quitarPuestaEnMarcha() {
		this.puestaEnMarcha--;
	}
	
}
