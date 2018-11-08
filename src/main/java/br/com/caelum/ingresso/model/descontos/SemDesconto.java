package br.com.caelum.ingresso.model.descontos;

import java.math.BigDecimal;

public class SemDesconto implements Desconto {

	public BigDecimal aplicaDescontoSobre(BigDecimal precoOrigial) {
		return precoOrigial;
	}

}
