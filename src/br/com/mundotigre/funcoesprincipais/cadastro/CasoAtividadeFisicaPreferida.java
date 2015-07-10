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

public class CasoAtividadeFisicaPreferida {
	
	@Test 
	public void testarAtividadeFisicaPreferida(WebDriver driver, Logger logger, Usuario usuario, InteracoesNavegador interacoesNavegador, FuncoesMT funcoesMT, FuncoesCadastro funcoesCadastro) throws Exception{		 
		
		long tempoInicio = System.currentTimeMillis(); 
		String nomeCampo = "Atividade Fisica Preferida";
		String valorCampo = usuario.getAtividadeFisicaPreferida();
		
		int i = 0; 
		int max = 2;	
		
		int quantidadeAcertos = 0;
		int quantidadeErros = 0;	
		int acertosSemJS = 0;
		int errosSemJS = 0;	
		
		funcoesMT.logInicio(driver, logger, nomeCampo);
		
		while(i<=max){
			
//			/ArrayList<Usuario> listaUsuarios  = new ArrayList<Usuario>();
			//listaUsuarios.add("as");
			
			if(i==17){
				interacoesNavegador.desativarJSFirefox(driver, logger, nomeCampo);
			}
			
			if(i == 0 || i == 17) {
				// usuario.setAtividadeFisicaPreferida(atividadeFisicaPreferida);
			}
			
			if (i == 1 || i == 18) {
				usuario.setAtividadeFisicaPreferida("5");
			}
			
			if (i == 2 || i == 19) {
				usuario.setAtividadeFisicaPreferida("3");
			}
			
			if (i == 3 || i == 20) {
				usuario.setAtividadeFisicaPreferida("4");
			}
			
			if (i == 4 || i == 21) {
				usuario.setAtividadeFisicaPreferida("6");
			}
			
			if (i == 5 || i == 22) {
				usuario.setAtividadeFisicaPreferida("1");
			}
			
			if (i == 6 || i == 23) {
				usuario.setAtividadeFisicaPreferida("13");
			}
			
			if (i == 7 || i == 24) {
				usuario.setAtividadeFisicaPreferida("12");
			}
			
			if (i == 8 || i == 25) {
				usuario.setAtividadeFisicaPreferida("7");
			}
			
			if (i == 9 || i == 26) {
				usuario.setAtividadeFisicaPreferida("2");
			}
			
			if (i == 10 || i == 27) {
				//*#################Marcar Várias Opções #######################
				//usuario.setAtividadeFisicaPreferida(3, 5);
			}
			
			if(i == 11 || i == 28) {
				//*#################Marcar Todas Opções #######################
				//usuario.setAtividadeFisicaPreferida(3, 5);
			}
			try{
				
				funcoesCadastro.cadastroCompleto(driver, usuario, "http://www.mundotigre.com.br/cadastro/new", i);
				
				if(funcoesCadastro.errosValidacao(driver)){
					  System.out.println("------Erro de validação dos campos com o campo "+nomeCampo+": " + valorCampo);
				}
				
				
//################################################################################################## IMPRESSAO DE lOG ###################################################################################//	
				
				if(funcoesCadastro.cadastroRealizado(driver)) {						
					funcoesMT.logCampoOK(driver, logger, nomeCampo, valorCampo);
					quantidadeAcertos++;
				}else{
						funcoesMT.logCampoErro(driver, logger, nomeCampo, valorCampo);
						quantidadeErros++;		
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
	}
}
