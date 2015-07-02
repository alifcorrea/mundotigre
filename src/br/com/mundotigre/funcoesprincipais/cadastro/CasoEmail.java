package br.com.mundotigre.funcoesprincipais.cadastro;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

import br.com.mundotigre.objetos.Usuario;
import br.com.mundotigre.scripts.FuncoesCadastro;
import br.com.mundotigre.scripts.InteracoesNavegador;

public class CasoEmail {
	
	@Test
	public void testarEmail(WebDriver driver, Usuario usuario, InteracoesNavegador interacoesNavegador, FuncoesCadastro funcoesCadastro){
		
		long tempoInicio = System.currentTimeMillis();
		System.out.println("\n-----------------------------Teste Email-------------------------------");
	
		int i = 0;
		int max = 33;
		
		int quantidadeAcertos = 0;
		int quantidadeErros = 0;	
		int acertosSemJS = 0;
		int errosSemJS = 0;
	
		while (i <= max) {
	
			String cpf = funcoesCadastro.numerosAleatorios();
			
			if (i == 17) {
				interacoesNavegador.desativarJSFirefox(driver);				
				System.out.println("\n------------------Email com Javascript desabilitado--------------------");
			}
	
			interacoesNavegador.abrirLink(driver, "http://www.mundotigre.com.br/cadastro/new");
			interacoesNavegador.clicarESetarPorID(driver, "login-cpf", cpf);
			
			
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
	
			interacoesNavegador.clicarESetarPorID(driver, "login-senha", usuario.getEmail());
			interacoesNavegador.clicarCampoPorXpath(driver, "//*[@value='Cadastrar']");
	
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
			}
			
			interacoesNavegador.AguardarCarregamento(driver);
			i++;
			
		}
	}
}
