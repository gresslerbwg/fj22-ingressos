package br.com.caelum.ingresso.model.descontos;

import java.math.BigDecimal;

public class DescontoParaEstudantes implements Desconto {

	public BigDecimal aplicaDescontoSobre(BigDecimal precoOrigial) {
		return precoOrigial.divide(new BigDecimal(2));
	}

}
