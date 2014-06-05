package br.com.caelum.agiletickets.domain.precos;

import java.math.BigDecimal;
import java.util.Map;

import br.com.caelum.agiletickets.models.Sessao;
import br.com.caelum.agiletickets.models.TipoDeEspetaculo;

public class CalculadoraDePrecos {

	public void calculo(TipoDeEspetaculo tipo1){
		
		
	}
	private static void teste(TipoDeEspetaculo tipo){
		tipo.metodo();
	}
	
	public static BigDecimal calcula(Sessao sessao, Integer quantidade) {
		BigDecimal preco;
		TipoDeEspetaculo tipo = sessao.getEspetaculo().getTipo();
	tipo.metodo();
		
/*		Map<TipoDeEspetaculo, String> mapa = null;
		mapa.put(TipoDeEspetaculo.BALLET, "c1");
		mapa.put(TipoDeEspetaculo.CINEMA, "c1");
		mapa.put(TipoDeEspetaculo.ORQUESTRA, "c1");
		mapa.put(TipoDeEspetaculo.SHOW, "c1");
		mapa.put(TipoDeEspetaculo.TEATRO, "c1");*/
		switch (tipo) {
		case CINEMA:
		case SHOW:
			//quando estiver acabando os ingressos... 
			preco = calculaPrecoDosIngressos(sessao, 0.05, 0.10);	
			break;
		case BALLET:
		case ORQUESTRA:
			preco  = calculaPrecoDosIngressos(sessao, 0.50, 0.20);
			
			if(sessao.getDuracaoEmMinutos() > 60){
				preco = preco.add(sessao.getPreco().multiply(BigDecimal.valueOf(0.10)));
			}
		
		break;
		default:
			//nao aplica aumento para teatro (quem vai é pobretão)
			preco = sessao.getPreco();			
			break;
		}
		
		

		return preco.multiply(BigDecimal.valueOf(quantidade));
	}

	private static BigDecimal calculaPrecoDosIngressos(Sessao sessao, double percentualDoIngresso, double percentualDoPreco) {
		BigDecimal preco;
		if(getPercentualDeIngressosDisponiveis(sessao) <= percentualDoIngresso) { 
			preco = aplicaAumentoPercentualNoPreco(sessao, percentualDoPreco);
		} else {
			preco = sessao.getPreco();
		}
		return preco;
	}

	private static BigDecimal aplicaAumentoPercentualNoPreco(Sessao sessao, double valor) {
		return sessao.getPreco().add(sessao.getPreco().multiply(BigDecimal.valueOf(valor)));
	}

	private static double getPercentualDeIngressosDisponiveis(Sessao sessao) {
		return getIngressosDisponiveis(sessao) / getTotalDeIngressos(sessao);
	}

	private static double getTotalDeIngressos(Sessao sessao) {
		return sessao.getTotalIngressos().doubleValue();
	}

	private static int getIngressosDisponiveis(Sessao sessao) {
		return sessao.getTotalIngressos() - sessao.getIngressosReservados();
	}

}