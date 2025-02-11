package br.com.empresa.leilao.acceptance.steps;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Assert;

import br.com.empresa.leilao.model.Lance;
import br.com.empresa.leilao.model.Leilao;
import br.com.empresa.leilao.model.Usuario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.cucumber.datatable.DataTable;

public class PropondoLanceSteps {
	private Lance lance;
	private Leilao leilao;
	private List<Lance> lista;
	
	
	@Before //cuidado, tem que ser o import do cucumber
    public void setup() {
		this.lista = new ArrayList<Lance>();
		leilao = new Leilao("Carro Automatico");
		System.out.println("before");
	}
	
	@After
	public void tearDown( ) {
		System.out.println("after.....");
	}
	
	@Dado("um lance valido")
	public void dado_um_lance_valido() {
	    // Write code here that turns the phrase above into concrete actions
		Usuario usuario = new Usuario("fulano");
		lance = new Lance(usuario, BigDecimal.TEN);		
	    //throw new io.cucumber.java.PendingException();
	}


	@Quando("propoe ao leilao")
	public void quando_propoe_o_lance() {
	    // Write code here that turns the phrase above into concrete actions
		leilao = new Leilao("Carro Automatico");
		leilao.propoe(lance);
	    //throw new io.cucumber.java.PendingException();
	}
	
	@Entao("o lance eh aceito")
	public void entao_o_lance_eh_aceito() {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertEquals(1, leilao.getLances().size());
		Assert.assertEquals(BigDecimal.TEN, leilao.getLances().get(0).getValor());
	    //throw new io.cucumber.java.PendingException();
	}
	
	
//	@Dado("varios lances validos")
//	public void varios_lances_validos() {
//	    // Write code here that turns the phrase above into concrete actions
//		Usuario usuario = new Usuario("fulano");
//		lance10 = new Lance(usuario, BigDecimal.TEN);
//		
//		Usuario usuario2 = new Usuario("beltrano");
//		lance15 = new Lance(usuario2, new BigDecimal("15.0"));
//		leilao = new Leilao("Carro Automatico");
//		
//	    //throw new io.cucumber.java.PendingException();
//	}


	
	@Dado("um lance de {double} reais do usuario {string}")
	public void um_lance_de_reais_do_usuario_fulano(Double valor, String nomeUsuario) {
	    // Write code here that turns the phrase above into concrete actions
		Lance lance = new Lance(new Usuario(nomeUsuario), new BigDecimal(valor));
		lista.add(lance);
	   //throw new io.cucumber.java.PendingException();
	}
	

	@Quando("propoe varios lances ao leilao")
	public void propoe_varios_lances_ao_leilao() {
	    // Write code here that turns the phrase above into concrete actions
		this.lista.forEach(lance -> leilao.propoe(lance));
		//leilao.propoe(lance10);
		//leilao.propoe(lance15);
	    //throw new io.cucumber.java.PendingException();
	}
	@Entao("os lances sao aceitos")
	public void os_lances_sao_aceitos() {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertEquals(this.lista.size(), leilao.getLances().size());
		Assert.assertEquals(this.lista.get(0).getValor(), leilao.getLances().get(0).getValor());
		Assert.assertEquals(this.lista.get(1).getValor(), leilao.getLances().get(1).getValor());
	    //throw new io.cucumber.java.PendingException();
	}
	
		
//////////////
	

		@Dado("um lance invalido de {double} reais e do usuario {string}")
		public void um_lance_invalido_de_reais(Double valor, String nomeUsuario) {
		    // Write code here that turns the phrase above into concrete actions
			System.out.println(valor + " do usuario: "+nomeUsuario);
		    this.lance = new Lance(new BigDecimal(valor));
		}


		@Quando("propoe o lance ao leilao")
		public void propoe_o_lance_ao_leilao() {
		    // Write code here that turns the phrase above into concrete actions		   
			leilao.propoe(lance);
		}
		@Entao("o lances nao eh aceitos")
		public void o_lances_nao_eh_aceitos() {
		    Assert.assertEquals(0, leilao.getLances().size());
		}
	
		
		
//////////////

		@Dado("dois lances")
		public void dois_lances(DataTable dataTable) {
		    List<Map<String, String>> valores = dataTable.asMaps();
		    for(Map<String, String> map : valores) {
		    	String valor = map.get("valor");
		    	String usuario = map.get("nomeUsuario");
		    	Lance l = new Lance(new Usuario(usuario), new BigDecimal(valor));
		    	lista.add(l);
		    	System.out.println(map.values());
		    }
		    //throw new io.cucumber.java.PendingException();
		}
		
		@Entao("o segundo lance nao eh aceito")
		public void o_segundo_lance_nao_eh_aceito() {
		    // Write code here that turns the phrase above into concrete actions
			Assert.assertEquals(1, leilao.getLances().size());
			Assert.assertEquals(this.lista.get(0).getValor(), leilao.getLances().get(0).getValor());
		}

		

			




	
}
