package br.com.caelum.agiletickets.models;

import java.math.BigDecimal;

public enum TipoDeEspetaculo {
	
	CINEMA {
		public abstract void metodo();
	}, SHOW {
		@Override
		public void metodo() {
			// TODO Auto-generated method stub
			
		}
	}, TEATRO, BALLET, ORQUESTRA;
	
	public abstract void metodo();
	
}
