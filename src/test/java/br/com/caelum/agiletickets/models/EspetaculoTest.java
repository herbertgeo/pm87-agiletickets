package br.com.caelum.agiletickets.models;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import junit.framework.Assert;

import org.joda.time.JodaTimePermission;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.junit.Test;

public class EspetaculoTest {
	
	
	@Test
	public void deveCriarUmaSessaoCasoAsDatasInicioEFimSejamIguaisEAPeriodicidadeForDiaria(){
		LocalDate inicioSessao = new LocalDate(2014, 07, 20);
		LocalDate fimSessao = inicioSessao;
		LocalTime hora = LocalTime.now();
		Periodicidade periodicidade = Periodicidade.DIARIA;
		Espetaculo espetaculo = new Espetaculo();
		
		List<Sessao> sessoes = espetaculo.criaSessoes(inicioSessao, fimSessao, hora, periodicidade);
		Assert.assertNotNull(sessoes);
		Assert.assertEquals(1, sessoes.size());
		Assert.assertEquals(espetaculo, sessoes.get(0).getEspetaculo());
		Assert.assertEquals(inicioSessao, sessoes.get(0).getInicio().toLocalDate());	
	}
	
	@Test
	public void deveCriarCincoSessoesCasoAsDatasInicioEFimTenhamDiferencaDeCincoDiasEPeriodicidadeSejaDiaria() {
		LocalDate inicioSessao = new LocalDate(2014, 07, 20);
		LocalDate fimSessao = new LocalDate(2014, 07, 24);
		LocalTime hora = LocalTime.now();
		Periodicidade periodicidade = Periodicidade.DIARIA;
		Espetaculo espetaculo = new Espetaculo();
		
		List<Sessao> sessoes = espetaculo.criaSessoes(inicioSessao, fimSessao, hora, periodicidade);
		Assert.assertNotNull(sessoes);
		Assert.assertEquals(5, sessoes.size());

	}
	
	@Test
	public void deveCriarCincoSessoesCasoAsDatasInicioEFimTenhamDiferencaDeTrintaDiasEPeriodicidadeSejaSemanal() {
		LocalDate inicioSessao = new LocalDate(2014, 7, 20);
		LocalDate fimSessao = new LocalDate(2014, 8, 19);
		LocalTime hora = LocalTime.now();
		Periodicidade periodicidade = Periodicidade.SEMANAL;
		Espetaculo espetaculo = new Espetaculo();
		
		List<Sessao> sessoes = espetaculo.criaSessoes(inicioSessao, fimSessao, hora, periodicidade);
		Assert.assertNotNull(sessoes);
		Assert.assertEquals(5, sessoes.size());

	}	
	
	@Test
	public void deveCriarDuasSessoesCasoAsDatasInicioEFimTenhamDiferencaDeUmaSemanaESeisDiasEPeriodicidadeSejaSemanal() {
		LocalDate inicioSessao = new LocalDate(2014, 7, 1);
		LocalDate fimSessao = new LocalDate(2014, 7, 14);
		LocalTime hora = LocalTime.now();
		Periodicidade periodicidade = Periodicidade.SEMANAL;
		Espetaculo espetaculo = new Espetaculo();
		
		List<Sessao> sessoes = espetaculo.criaSessoes(inicioSessao, fimSessao, hora, periodicidade);
		Assert.assertNotNull(sessoes);
		Assert.assertEquals(2, sessoes.size());

	}		
	
	@Test
	public void naoDeveCriarSessoesCasoADataInicioSejaMenorQueADataFim() {
		LocalDate inicioSessao = new LocalDate(2014, 7, 20);
		LocalDate fimSessao = new LocalDate(2014, 7, 14);
		LocalTime hora = LocalTime.now();
		Periodicidade periodicidade = Periodicidade.SEMANAL;
		Espetaculo espetaculo = new Espetaculo();
		
		List<Sessao> sessoes = espetaculo.criaSessoes(inicioSessao, fimSessao, hora, periodicidade);
		Assert.assertNotNull(sessoes);
		Assert.assertEquals(0, sessoes.size());

	}	
	
	
	@Test
	public void deveInformarSeEhPossivelReservarAQuantidadeDeIngressosDentroDeQualquerDasSessoes() {
		Espetaculo ivete = new Espetaculo();

		ivete.getSessoes().add(sessaoComIngressosSobrando(1));
		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(2));

		assertTrue(ivete.Vagas(5));
	}

	@Test
	public void deveInformarSeEhPossivelReservarAQuantidadeExataDeIngressosDentroDeQualquerDasSessoes() {
		Espetaculo ivete = new Espetaculo();

		ivete.getSessoes().add(sessaoComIngressosSobrando(1));
		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(2));

		assertTrue(ivete.Vagas(6));
	}

	@Test
	public void DeveInformarSeNaoEhPossivelReservarAQuantidadeDeIngressosDentroDeQualquerDasSessoes() {
		Espetaculo ivete = new Espetaculo();

		ivete.getSessoes().add(sessaoComIngressosSobrando(1));
		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(2));

		assertFalse(ivete.Vagas(15));
	}

	@Test
	public void DeveInformarSeEhPossivelReservarAQuantidadeDeIngressosDentroDeQualquerDasSessoesComUmMinimoPorSessao() {
		Espetaculo ivete = new Espetaculo();

		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(4));

		assertTrue(ivete.Vagas(5, 3));
	}

	@Test
	public void DeveInformarSeEhPossivelReservarAQuantidadeExataDeIngressosDentroDeQualquerDasSessoesComUmMinimoPorSessao() {
		Espetaculo ivete = new Espetaculo();

		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(4));

		assertTrue(ivete.Vagas(10, 3));
	}

	@Test
	public void DeveInformarSeNaoEhPossivelReservarAQuantidadeDeIngressosDentroDeQualquerDasSessoesComUmMinimoPorSessao() {
		Espetaculo ivete = new Espetaculo();

		ivete.getSessoes().add(sessaoComIngressosSobrando(2));
		ivete.getSessoes().add(sessaoComIngressosSobrando(2));
		ivete.getSessoes().add(sessaoComIngressosSobrando(2));

		assertFalse(ivete.Vagas(5, 3));
	}

	private Sessao sessaoComIngressosSobrando(int quantidade) {
		Sessao sessao = new Sessao();
		sessao.setTotalIngressos(quantidade * 2);
		sessao.setIngressosReservados(quantidade);

		return sessao;
	}
	
}
