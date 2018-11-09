package br.com.caelum.ingresso.model.descontos;

import java.math.BigDecimal;

public class DescontoParaBancarios implements Desconto {

	public BigDecimal aplicaDescontoSobre(BigDecimal precoOrigial) {
		return precoOrigial.multiply(new BigDecimal("0.7"));
	}

	@Override
	public String getDescricao() {
		// TODO Auto-generated method stub
		return "Desconto Bancário";
	}
}
