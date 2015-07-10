package br.com.mundotigre.funcoesprincipais.cadastro;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import br.com.mundotigre.objetos.Usuario;
import br.com.mundotigre.scripts.FuncoesCadastro;
import br.com.mundotigre.scripts.FuncoesMT;
import br.com.mundotigre.scripts.InteracoesNavegador;

public class CasoCPF {

//############################################################################################## CONFIGURACOES INICIAIS #################################################################################//		

	@Test
	public boolean testarCPF(WebDriver driver, Logger logger, Usuario usuario, String link, InteracoesNavegador interacoesNavegador, FuncoesMT funcoesMT, FuncoesCadastro funcoesCadastro) throws Exception {	
		
		long tempoInicio = System.currentTimeMillis(); 
		
		int i = 0;
		int max = 15;
		
		int quantidadeAcertos = 0;
		int quantidadeErros = 0;		
		int acertosSemJS = 0;
		int errosSemJS = 0;	
		
		
		String cpf = "";
		String email = funcoesMT.caracteresAleatorios()+i+"@teste.com.br";	
		String nomeCampo = "CPF";
		
		
//################################################################################################ INICIO DA EXECUCAO ###################################################################################//	
		
		funcoesMT.logInicio(driver, logger, nomeCampo);
		
		while(i<=max){	
			
			if(i==8){
				interacoesNavegador.desativarJSFirefox(driver, logger, nomeCampo);
			}
			
			
//################################################################################################## VALORES DO TESTE ###################################################################################//	
			
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
				
				interacoesNavegador.abrirLink(driver, link);
				interacoesNavegador.AguardarCarregamento(driver);
				
				interacoesNavegador.clicarESetarPorID(driver, "login-cpf", cpf);
				interacoesNavegador.clicarESetarPorID(driver, "login-senha", email);
				interacoesNavegador.clicarCampoPorXpath(driver, "//*[@value='Cadastrar']");
				
				
//################################################################################################## IMPRESSAO DE lOG ###################################################################################//	
			
				if(funcoesCadastro.passouCadastroCompleto(driver)) {
					
					funcoesMT.logCampoOK(driver, logger, nomeCampo, cpf);
					
					if(i<=7){
						quantidadeAcertos++;
					}else{
							acertosSemJS++;	
						}
				}else{
						funcoesMT.logCampoErro(driver, logger, nomeCampo, cpf);
						
						if(i<=7){		
							quantidadeErros++;
						}else{
								errosSemJS++;
							}
					}
				
				if(i==max){	
					funcoesMT.logInformacoesExecucao(driver, logger, nomeCampo, quantidadeAcertos, quantidadeErros, acertosSemJS, errosSemJS, tempoInicio);
				}
				
				interacoesNavegador.AguardarCarregamento(driver);
				i++;
				
			}catch(Exception e1){
				
				logger.error("Houve um Problema.");
				
				File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(screenshot, new File("C:/Users/alif.correa/Workspace/MundoTigre/screenshots/"+nomeCampo+"/"+funcoesMT.numerosAleatorios()+".jpeg"));
				throw(e1);
			}			
		}
		return true;
	}
}