package br.com.empresa.leilao.acceptance.steps;

import java.math.BigDecimal;

import org.junit.Assert;

import br.com.empresa.leilao.model.Lance;
import br.com.empresa.leilao.model.Leilao;
import br.com.empresa.leilao.model.Usuario;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class PropondoLanceSteps {
	private Lance lance;
	private Leilao leilao;
	
	@Dado("Dado um lance valido")
	public void dado_um_lance_valido() {
	    // Write code here that turns the phrase above into concrete actions
		Usuario usuario = new Usuario("fulano");
		lance = new Lance(usuario, BigDecimal.TEN);
	    //throw new io.cucumber.java.PendingException();
	}


	@Quando("Quando propoe o lance")
	public void quando_propoe_o_lance() {
	    // Write code here that turns the phrase above into concrete actions
		leilao = new Leilao("Carro Automatico");
		leilao.propoe(lance);
	    //throw new io.cucumber.java.PendingException();
	}
	
	@Entao("Entao o lance eh aceito")
	public void entao_o_lance_eh_aceito() {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertEquals(1, leilao.getLances().size());
		Assert.assertEquals(BigDecimal.TEN, leilao.getLances().get(0).getValor());
	    //throw new io.cucumber.java.PendingException();
	}
}
