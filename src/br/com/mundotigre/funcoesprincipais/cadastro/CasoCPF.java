package br.com.mundotigre.funcoesprincipais.cadastro;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import br.com.mundotigre.objetos.Usuario;
import br.com.mundotigre.scripts.FuncoesCadastro;
import br.com.mundotigre.scripts.InteracoesNavegador;

public class CasoCPF {
	
	public InteracoesNavegador funcoes;
	public FuncoesCadastro funcoesCadastro;

	@Before
	public void Inicio(){
		funcoes = new InteracoesNavegador();
		funcoesCadastro = new FuncoesCadastro();
	}

	@Test
	public void testarCPF(WebDriver driver, Usuario usuario) {
		
		long tempoInicio = System.currentTimeMillis(); 
		
		System.out.println("\n-----------------------------Teste CPF-------------------------------");

		int i = 0;
		int max = 15;

		int quantidadeAcertos = 0;
		int quantidadeErros = 0;		
		int acertosSemJS = 0;
		int errosSemJS = 0;	

		while (i <= max) {	
			
			String email = usuario.getEmail()+i+"@teste.com.br";

			/* Desativar JS. (Na oitava execução) */
			if (i == 8) {
				FirefoxProfile profile = new FirefoxProfile();
				profile.setPreference("javascript.enabled", false);
				driver = new FirefoxDriver(profile);
				System.out.println("\n------------------CPF com Javascript desabilitado--------------------");
			}

			funcoes.abrirLink(driver, "http://www.mundotigre.com.br/cadastro/new");
			funcoes.AguardarCarregamento(driver);

			/* Não preencher o campo CPF */
			if (i == 0 || i == 8) {
				usuario.setCpf("");
			}

			 /*Preencher com 10 números */
			if (i == 1 || i == 9) {
				usuario.setCpf("012345671" + i);
			}

			/* Preencher com 12 ou mais números, 13 */
			if (i == 2 || i == 10) {
				usuario.setCpf("012345678921" + i);
			}

			/* Preencher com pontuação */
			if (i == 3 || i == 11) {
				usuario.setCpf("091.215.038.2" + i);
			}

			/* Preencher sem pontuação */
			if (i == 4 || i == 12) {
				usuario.setCpf("0912150382" + i);
			}

			/* Com vírgulas */
			if (i == 5 || i == 13) {
				usuario.setCpf("654,123,212,2" + i);
			}

			/* Cadastrar com letras */
			if (i == 6 || i == 14) {
				usuario.setCpf("OnzeLETRASA");
			}

			/* Com caracteres especiais */
			if (i == 7 || i == 15) {
				usuario.setCpf("!@#$%¨&*()_");;
			}

			// setar os valores e enviar
			funcoes.clicarESetarPorID(driver, "login-cpf", usuario.getCpf());
			funcoes.clicarESetarPorID(driver, "login-senha", email);
			funcoes.clicarCampoPorXpath(driver, "//*[@value='Cadastrar']");

			/*--------------------Impressao de log----------------------*/
			if(funcoesCadastro.passouCadastroCompleto(driver)) {
				
				funcoesCadastro.logCampoOK(driver, "CPF", usuario.getCpf());
				
				if (i<=7) {
					quantidadeAcertos++;
				}else {
						acertosSemJS++;
						
					 }
			}else{
					funcoesCadastro.logCampoErro(driver, "CPF", usuario.getCpf());
					
					if (i<=7) {							
							quantidadeErros++;
					}else {				
							errosSemJS++;
						}
				}

			if (i==max) {				
				funcoesCadastro.logInformacoesExecucao(driver, "CPF", quantidadeAcertos, quantidadeErros, acertosSemJS, errosSemJS, tempoInicio);
				driver.close();
			} 
			
			funcoes.AguardarCarregamento(driver);
			i++;
		}
	}
}
