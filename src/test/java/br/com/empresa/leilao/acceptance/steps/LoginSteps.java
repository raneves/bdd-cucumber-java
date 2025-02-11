package br.com.empresa.leilao.acceptance.steps;

import org.junit.Assert;

import br.com.empresa.leilao.e2e.pages.Browser;
import br.com.empresa.leilao.e2e.pages.LeiloesPage;
import br.com.empresa.leilao.e2e.pages.LoginPage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class LoginSteps {
	private Browser browser;
	private LoginPage loginPage;
	private LeiloesPage leiloesPage;

	@Dado("o usuario valido")
	public void o_usuario_valido() {
		browser = new Browser("firefox");
		browser.seed();
		loginPage = browser.getLoginPage();
	    //throw new io.cucumber.java.PendingException();
	}

	@Quando("realiza login")
	public void realiza_login() {	 
		leiloesPage = this.loginPage.realizaLoginComo("fulano", "pass");
	    //throw new io.cucumber.java.PendingException();
	}
	@Entao("é redirecionado para a pagina de leiloes")
	public void é_redirecionado_para_a_pagina_de_leiloes() {	
		Assert.assertTrue(this.leiloesPage.estaNaPaginaDeLeiloes());
		browser.clean();
	    //throw new io.cucumber.java.PendingException();
	}
			

	@Dado("o usuario invalido")
	public void o_usuario_invalido() {
		browser = new Browser("firefox");
		browser.seed();
		loginPage = browser.getLoginPage();
	   // throw new io.cucumber.java.PendingException();
	}

	@Quando("tenta se logar")
	public void tenta_se_logar() {		   
	    //throw new io.cucumber.java.PendingException();
		leiloesPage = this.loginPage.realizaLoginComo("fulano", "xpto");
	}
	@Entao("continua na página de login")
	public void continua_na_página_de_login() {		   
	    //throw new io.cucumber.java.PendingException();
		Assert.assertTrue(this.leiloesPage.estaNaPaginaDeLoginComErro());
		browser.clean();
	}
}