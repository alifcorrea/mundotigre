package br.com.mundotigre.funcoesprincipais.cadastro;

import org.junit.Test;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;

import br.com.mundotigre.objetos.Usuario;
import br.com.mundotigre.scripts.FuncoesCadastro;
import br.com.mundotigre.scripts.InteracoesNavegador;

public class CasoCPF {
	
	@Test
	public void testarCPF(WebDriver driver, Usuario usuario, InteracoesNavegador interacoesNavegador, FuncoesCadastro funcoesCadastro) {	
		long tempoInicio = System.currentTimeMillis(); 
		
		System.out.println("\n-----------------------------Teste CPF-------------------------------");

		int i = 0;
		int max = 15;

		int quantidadeAcertos = 0;
		int quantidadeErros = 0;		
		int acertosSemJS = 0;
		int errosSemJS = 0;	

		while (i <= max) {	
		

			String cpf = "";
			String email = funcoesCadastro.caracteresAleatorios()+i+"@teste.com.br";		
			
			/* Não preencher o campo CPF */
			if (i == 0 || i == 8) {
				cpf = "";
			}

			 /*Preencher com 10 números */
			if (i == 1 || i == 9) {
				cpf = "012345671" + i;
			}

			/* Preencher com 12 ou mais números, 13 */
			if (i == 2 || i == 10) {
				cpf = "21474836472"+i;
			}

			/* Preencher com pontuação */
			if (i == 3 || i == 11) {
				cpf = "091.215.038.2" + i;
			}

			/* Preencher sem pontuação */
			if (i == 4 || i == 12) {
				cpf = "2147483647" + i;
			}

			/* Com vírgulas */
			if (i == 5 || i == 13) {
				cpf = "654,123,212,2" + i;
			}

			/* Cadastrar com letras */
			if (i == 6 || i == 14) {
				cpf = "OnzeLETRASA";
			}

			/* Com caracteres especiais */
			if (i == 7 || i == 15) {
				cpf = "!@#$%¨&*()_";
			}
			
			
			try{
				interacoesNavegador.abrirLink(driver, "http://www.mundotigre.com.br/cadastro/new");
				interacoesNavegador.AguardarCarregamento(driver);

				// setar os valores e enviar
				interacoesNavegador.clicarESetarPorID(driver, "login-cpf", cpf);
				interacoesNavegador.clicarESetarPorID(driver, "login-senha", email);
				interacoesNavegador.clicarCampoPorXpath(driver, "//*[@value='Cadastrar']");

				/*--------------------Impressao de log----------------------*/
				if(funcoesCadastro.passouCadastroCompleto(driver)) {
					
					funcoesCadastro.logCampoOK(driver, "CPF", cpf);
					
					if (i<=7) {
						quantidadeAcertos++;
					}else {
							acertosSemJS++;
							
						 }
				}else{
						funcoesCadastro.logCampoErro(driver, "CPF", cpf);
						
						if (i<=7) {							
								quantidadeErros++;
						}else {				
								errosSemJS++;
							}
					}

				if (i==max) {				
					funcoesCadastro.logInformacoesExecucao(driver, "CPF", quantidadeAcertos, quantidadeErros, acertosSemJS, errosSemJS, tempoInicio);
				} 
				
				interacoesNavegador.AguardarCarregamento(driver);
				i++;
			}catch(StaleElementReferenceException e){
				e.printStackTrace();
			}

		
		}
	}
}