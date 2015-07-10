package br.com.mundotigre.funcoesprincipais.cadastro;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import br.com.mundotigre.objetos.Usuario;
import br.com.mundotigre.scripts.FuncoesCadastro;
import br.com.mundotigre.scripts.FuncoesMT;
import br.com.mundotigre.scripts.InteracoesNavegador;

public class CasoDDD {
	
	
//############################################################################################## CONFIGURACOES INICIAIS #################################################################################//			
	
	@Test 
	public void testarDDD(WebDriver driver, Logger logger, Usuario usuario, String link, InteracoesNavegador interacoesNavegador, FuncoesMT funcoesMT, FuncoesCadastro funcoesCadastro) {		 
		
		long tempoInicio = System.currentTimeMillis(); 
		String nomeCampo = "DDD";
		
		int i = 0; 
		int max = 7;	
		
		int quantidadeAcertos = 0;
		int quantidadeErros = 0;	
		int acertosSemJS = 0;
		int errosSemJS = 0;	
		
		funcoesMT.logInicio(driver, logger, nomeCampo);
		
		
//############################################################################################### INICIO DA EXECUCAO ###################################################################################//	
		
		while(i<=max){	
			
			if (i == 6) {
				interacoesNavegador.desativarJSFirefox(driver, logger, nomeCampo);
			}
			
			if(i==0 || i==6){
				usuario.setDDD("");
			}
			
			if(i==1 || i==7){
				usuario.setDDD("4");
			}
			
			if(i==2 || i==8){
				usuario.setDDD("47");
			}
			
			if(i==3 || i==9){
				usuario.setDDD("479");	  
			}
			
			if(i==4 || i==10){
				usuario.setDDD("te");
			}
			
			if(i==5 || i==11){
				usuario.setDDD("#$%");
			}
			
			funcoesCadastro.cadastroCompleto(driver, usuario, link, i);
			
			if(funcoesCadastro.errosValidacao(driver)){
				System.out.println("------Erro de validação dos campos com o campo DDD: " + usuario.getDDD());
			}
			
			
//################################################################################################## IMPRESSAO DE lOG ###################################################################################//	
			
			if(funcoesCadastro.cadastroRealizado(driver)){	
				
				funcoesMT.logCampoOK(driver, logger, nomeCampo, usuario.getDDD());
				quantidadeAcertos++;
				
			}else{				  
					funcoesMT.logCampoErro(driver, logger, nomeCampo, usuario.getDDD());
					quantidadeErros++;
				}
			
			if(i==max){
				funcoesMT.logInformacoesExecucao(driver, logger, nomeCampo, quantidadeAcertos, quantidadeErros, acertosSemJS, errosSemJS, tempoInicio);
			}
			i++;
		}
	}
}
