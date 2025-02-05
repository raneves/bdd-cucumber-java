package br.com.empresa.leilao.model;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

public class LanceTest {
	public void deveRecusarLancesComValorDeZero() {
		assertThrows(IllegalArgumentException.class, () -> new Lance(new Usuario("John Doe"), BigDecimal.ZERO));
	}

	@Test
	public void deveRecusarLancesComValorNegativo() {
		assertThrows(IllegalArgumentException.class, () -> new Lance(new Usuario("John Doe"), new BigDecimal("-10")));
	}

}
