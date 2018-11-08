package br.com.caelum.ingresso.model.descontos;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.caelum.ingresso.model.Filme;
import br.com.caelum.ingresso.model.Ingresso;
import br.com.caelum.ingresso.model.Sala;
import br.com.caelum.ingresso.model.Sessao;

public class DescontoTest {
	
	private Sessao sessao;
	
	@Before
	public void prepara(){
		Sala sala = new Sala("Eldorado - IMax", new BigDecimal("12.50"));
		Filme filme = new Filme("Rogue One", Duration.ofMinutes(120), "SCI-FI", new BigDecimal("12"));
		sessao = new Sessao(LocalTime.parse("10:00:00"), sala, filme);
	}

	@Test
	public void naoDeveConcederDescontoParaIngressoNormal(){
		Ingresso ingresso = new Ingresso(sessao, new SemDesconto());
		BigDecimal precoEsperado = new BigDecimal("24.50");
		Assert.assertEquals(precoEsperado, ingresso.getPreco());
	}

	@Test
	public void deveAplicarDescontoEstudante(){
		Ingresso ingresso = new Ingresso(sessao, new DescontoParaEstudantes());
		BigDecimal precoEsperado = new BigDecimal("12.25");
		Assert.assertEquals(precoEsperado, ingresso.getPreco());
	}
	
	@Test
	public void deveAplicarDescontoBancario(){
		Ingresso ingresso = new Ingresso(sessao, new DescontoParaBancarios());
		BigDecimal precoEsperado = new BigDecimal("17.15");
		Assert.assertEquals(precoEsperado, ingresso.getPreco());
	}
}
