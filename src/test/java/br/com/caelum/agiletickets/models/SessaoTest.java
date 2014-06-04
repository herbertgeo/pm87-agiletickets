package br.com.caelum.agiletickets.models;

import org.junit.Assert;
import org.junit.Test;

public class SessaoTest {
<<<<<<< HEAD


=======
>>>>>>> dc6fa041172b2c7a25214ff0694b07dcd959f0cb
	
	@Test
	public void deveVender5ingressosSeHa10vagas() throws Exception {
		Sessao sessao = new Sessao();
		sessao.setTotalIngressos(10);
		
		Assert.assertTrue(sessao.podeReservar(5));
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
<<<<<<< HEAD
	public void deveReservarQuantidadeDisponivelDeIngressos(){
		Sessao sessao = new Sessao();
		sessao.setTotalIngressos(100);
		Boolean podeReservar = sessao.podeReservar(100);
		Assert.assertTrue(podeReservar);
				
=======
	public void deveReservarQuantidadeTotalDisponivelDeIngressos() throws Exception {
		
		Sessao sessao = new Sessao();
		sessao.setTotalIngressos(5);
		boolean podeReservar=sessao.podeReservar(5);
		
		Assert.assertTrue(podeReservar);
		
>>>>>>> dc6fa041172b2c7a25214ff0694b07dcd959f0cb
	}
	
}
