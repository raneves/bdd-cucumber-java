package br.com.empresa.leilao.acceptance.steps;

import org.junit.Assert;

import br.com.empresa.leilao.e2e.pages.Browser;
import br.com.empresa.leilao.e2e.pages.LeiloesPage;
import br.com.empresa.leilao.e2e.pages.LoginPage;
import br.com.empresa.leilao.e2e.pages.NovoLeilaoPage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class LeilaoSteps {
	private LoginPage loginPage;
    private LeiloesPage leiloesPage;
    private NovoLeilaoPage novoLeilaoPage;
    private Browser browser;


    //exemplo utilizando lambda
    //Dado("um usuario logado", () -> {
    //    this.browser = new Browser();
    //    browser.seed();
    //    loginPage = browser.getLoginPage();
    //    leiloesPage = loginPage.realizaLoginComoFulano();
    //});
    
	@Dado("um usuario logado")
	public void um_usuario_logado() {
	    // Write code here that turns the phrase above into concrete actions	   
		this.browser = new Browser();
        browser.seed();
        loginPage = browser.getLoginPage();
        leiloesPage = loginPage.realizaLoginComoFulano();
	}

	@Quando("acessa a pagina de novo leilao")
	public void acessa_a_pagina_de_novo_leilao() {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
		novoLeilaoPage = this.leiloesPage.visitaPaginaParaCriarUmNovoLeilao();
	}
	@Quando("prenche o formulario com dados validos")
	public void prenche_o_formulario_com_dados_validos() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		this.leiloesPage = this.novoLeilaoPage.preencheForm("PC Novo1", "1500", "01/11/2020");
	}
	@Entao("volta para a pagina de leiloes")
	public void volta_para_a_pagina_de_leiloes() {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
		Assert.assertTrue(this.leiloesPage.estaNaPaginaDeLeiloes());
	}
	@Entao("o novo leilao aparece na tabela")
	public void o_novo_leilao_aparece_na_tabela() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		this.leiloesPage.existe("PC Novo1", "1500", "01/11/2020", "fulano");
		this.browser.clean();

	}
}
