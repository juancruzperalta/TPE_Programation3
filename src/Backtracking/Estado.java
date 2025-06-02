package Backtracking;

import java.util.List;

public class Estado {
	List<Maquina> maquinasActuales;
	int piezasUsadasActuales;
	Maquina maquinaActual;
	public Estado(List<Maquina> maquinasActuales, int piezasUsadasActuales, Maquina maquinaActual) {
		super();
		this.maquinasActuales = maquinasActuales;
		this.piezasUsadasActuales = piezasUsadasActuales;
		this.maquinaActual = maquinaActual;
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
	public Maquina getMaquinaActual() {
		return maquinaActual;
	}
	public void setMaquinaActual(Maquina maquinaActual) {
		this.maquinaActual = maquinaActual;
	}
	public void aplicarMaquina(Maquina m) {
		this.maquinaActual = m;
	}
	public void marcarUsada(Maquina m) {
		this.maquinasActuales.add(m);
	}
	public void quitarUso() {
		this.maquinasActuales.remove(this.maquinasActuales.size()-1);
	}
	public void piezaUsadaMas(int cantPiezasPorProducir) {
		this.piezasUsadasActuales+=cantPiezasPorProducir;
	}
	public void piezaUsadaMenos(int cantPiezasPorProducir) {
		this.piezasUsadasActuales-=cantPiezasPorProducir;
	}
	
	
}
