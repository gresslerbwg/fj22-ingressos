package br.com.caelum.ingresso.model;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;




import org.junit.Assert;
import org.junit.Test;

public class SessaoTest {

	@Test
	public void oPrecoDaSessaoDeveSerIgualASomaDoPrecoDaSalaMaisOPrecoDoFilme() {
		Sala sala = new Sala("Eldorado - Imax", new BigDecimal("22.50"));
		Filme filme = new Filme("Cube", Duration.ofMinutes(134),"SCI-FI", new BigDecimal("12.00"));
		
		BigDecimal somaDosPrecos = sala.getPreco().add(filme.getPreco());
		
		Sessao sessao = new Sessao(LocalTime.parse("10:00:00"), sala, filme);
		
		Assert.assertEquals(somaDosPrecos, sessao.getPreco());
	}

}
