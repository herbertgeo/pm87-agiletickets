package br.com.caelum.agiletickets.models;

import org.junit.Assert;
import org.junit.Test;

public class SessaoTest {

	
	@Test
	public void deveVender50IngressosSeHa50() throws Exception {
		Sessao sessao = new Sessao();
		sessao.setTotalIngressos(50);
		
		Assert.assertTrue(sessao.podeReservar(50));
	}

	@Test
	public void deveVender1IngressosSeHamenos1() throws Exception {
		Sessao sessao = new Sessao();
		sessao.setTotalIngressos(-1);
		
		Assert.assertFalse(sessao.podeReservar(1));
	}

	@Test
	public void naoDeveVender3ingressoSeHa2vagas() throws Exception {
		Sessao sessao = new Sessao();
		sessao.setTotalIngressos(2);

		Assert.assertFalse(sessao.podeReservar(3));
	}

	@Test
	public void reservarIngressosDeveDiminuirONumeroDeIngressosDisponiveis() throws Exception {
		Sessao sessao = new Sessao();
		sessao.setTotalIngressos(5);

		sessao.reserva(3);
		Assert.assertEquals(2, sessao.getIngressosDisponiveis().intValue());
	}
	
	@Test

	public void deveReservarQuantidadeDisponivelDeIngressos(){
		Sessao sessao = new Sessao();
		sessao.setTotalIngressos(100);
		Boolean podeReservar = sessao.podeReservar(100);
		Assert.assertTrue(podeReservar);
	}		

	public void deveReservarQuantidadeTotalDisponivelDeIngressos() throws Exception {
		
		Sessao sessao = new Sessao();
		sessao.setTotalIngressos(5);
		boolean podeReservar=sessao.podeReservar(5);
		
		Assert.assertTrue(podeReservar);
		

	}
	
}
