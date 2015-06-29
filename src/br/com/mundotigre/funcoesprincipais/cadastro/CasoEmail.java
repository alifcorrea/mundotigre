package br.com.mundotigre.funcoesprincipais.cadastro;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import br.com.mundotigre.objetos.Usuario;
import br.com.mundotigre.scripts.FuncoesCadastro;
import br.com.mundotigre.scripts.InteracoesNavegador;

public class CasoEmail {
	
	public InteracoesNavegador funcoes;
	public FuncoesCadastro funcoesCadastro;
	
	
	@Before
	public void Inicio() {
		funcoes = new InteracoesNavegador();
		funcoesCadastro = new FuncoesCadastro();
	}
	
	@Test
	public void testarEmail(WebDriver driver, Usuario usuario){
		
		funcoes.AguardarCarregamento(driver);
		
		long tempoInicio = System.currentTimeMillis();
		System.out.println("\n-----------------------------Teste Email-------------------------------");
	
		int i = 0;
		int max = 33;
	
		int quantidadeAcertos = 0;
		int quantidadeErros = 0;	
		int acertosSemJS = 0;
		int errosSemJS = 0;
	
		while (i <= max) {
	
			String cpf = usuario.getCpf()+i;
			
			if (i == 17) {
				
				FirefoxProfile profile = new FirefoxProfile();
				profile.setPreference("browser.download.folderList", 2);
				profile.setPreference("javascript.enabled", false);
				driver = new FirefoxDriver(profile);
				System.out.println("\n------------------Email com Javascript desabilitado--------------------");
			}
	
			funcoes.abrirLink(driver, "http://www.mundotigre.com.br/cadastro/new");
			funcoes.clicarESetarPorID(driver, "login-cpf", cpf);
			
			
			if (i == 0 || i == 17) {
				usuario.setEmail("");
			}
	
			if (i == 1 || i == 18) {
				usuario.setEmail("nome@mail");
			}
	
			if (i == 2 || i == 19) {
				usuario.setEmail("nome@mail.com");
			}
	
			if (i == 3 || i == 20) {
				usuario.setEmail("nome_!$#%@mail.com");
			}
	
			if (i == 4 || i == 21) {
				usuario.setEmail("nome.sobrenome@mail");
			}
	
			if (i == 5 || i == 22) {
				usuario.setEmail("nome.sobrenome@mail.com");
			}
	
			if (i == 6 || i == 23) {
				usuario.setEmail("nome.sobrenome123@mail.com");
			}
	
			if (i == 7 || i == 24) {
				usuario.setEmail("nome.sobrenome@mail.com.br");
			}
	
			if (i == 8 || i == 25) {
				usuario.setEmail("nome_sobrenome@mail");
			}
	
			if (i == 9 || i == 26) {
				usuario.setEmail("nome_sobrenome@mail.com");
			}
	
			if (i == 10 || i == 27) {
				usuario.setEmail("nome_sobrenome123@mail.com");
			}
	
			if (i == 11 || i == 28) {
				usuario.setEmail("nome_sobrenome@mail.com.br");
			}
	
			if (i == 12 || i == 29) {
				usuario.setEmail("nome_sobrenome_outrosobrenome@mail");
			}
	
			if (i == 13 || i == 30) {
				usuario.setEmail("nome_sobrenome_outrosobrenome@mail.com");
			}
	
			if (i == 14 || i == 31) {
				usuario.setEmail("nome_sobrenome1!@23_outrosobrenome@mail.com");
			}
	
			if (i == 15 || i == 32) {
				usuario.setEmail("nome_sobrenome_outrosobrenome@mail.com.br");
			}
	
			if (i == 16 || i == 33) {
				usuario.setEmail("nome_sobrenom!@e_outr¨&$%osobrenome@mail.com.br");
			}
	
			funcoes.clicarESetarPorID(driver, "login-senha", usuario.getEmail());
			funcoes.clicarCampoPorXpath(driver, "//*[@value='Cadastrar']");
	
			/*--------------------Impressao de log----------------------*/
			if (funcoesCadastro.passouCadastroCompleto(driver)) {
	
				funcoesCadastro.logCampoOK(driver, "Email", usuario.getEmail());
	
				if (i <= 16) {					
					quantidadeAcertos++;
					}else {
						acertosSemJS++;
					}
	
			} else {
	
				funcoesCadastro.logCampoErro(driver, "Email", usuario.getEmail());
	
				if (i <= 16) {
						quantidadeErros++;
					}else {
							errosSemJS++;
						}
			}
	
			if (i==max) {
				funcoesCadastro.logInformacoesExecucao(driver, "Email", quantidadeAcertos, quantidadeErros, acertosSemJS, errosSemJS, tempoInicio);
				driver.close();
			}
			
			funcoes.AguardarCarregamento(driver);
			i++;
			
		}
	}
}
