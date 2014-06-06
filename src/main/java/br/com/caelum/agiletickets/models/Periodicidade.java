package br.com.caelum.agiletickets.models;

public enum Periodicidade {
	
	DIARIA(1), SEMANAL(7);
	public int dias;
	
	private Periodicidade(int valor) {
		this.dias = valor;
	}
	
	public int getValor() {
		return dias;
	}
}
