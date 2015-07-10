package br.com.mundotigre.funcoesprincipais.cadastro;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import br.com.mundotigre.objetos.Usuario;
import br.com.mundotigre.scripts.FuncoesCadastro;
import br.com.mundotigre.scripts.FuncoesMT;
import br.com.mundotigre.scripts.InteracoesNavegador;

public class CasoAreaDesejaReceberInfo {


//############################################################################################## CONFIGURACOES INICIAIS #################################################################################//		
	
	@Test 
	 public void testarCasoAreaDesejaReceberInfo(WebDriver driver, Logger logger, Usuario usuario, String link, InteracoesNavegador interacoesNavegador, FuncoesMT funcoesMT, FuncoesCadastro funcoesCadastro) throws Exception {		 
		
		long tempoInicio = System.currentTimeMillis();
		
		int i = 0; 
		int max = 1;	
		
		int quantidadeAcertos = 0;
		int quantidadeErros = 0;	
		int acertosSemJS = 0;
		int errosSemJS = 0;	
		
		String nomeCampo = "Area Deseja Receber informações";
		String valorCampo = usuario.getAreaDesejaReceberInfo();
		
		
//################################################################################################ INICIO DA EXECUCAO ###################################################################################//	
		
		funcoesMT.logInicio(driver, logger, nomeCampo);
		
		while(i<=max){
			
			
			if(i==0){
				
				usuario.setAreaDesejaReceberInfo("");
			}
			
			
			if(i==1){
				
				usuario.setAreaDesejaReceberInfo("1");
			}
			
			
			if(i==2){
				
				usuario.setAreaDesejaReceberInfo("2");
			}
			
			if(i==3){
				
				usuario.setAreaDesejaReceberInfo("3");
			}
			
			
			if(i==4){
				usuario.setAreaDesejaReceberInfo("4");
			}
			
			
			funcoesCadastro.cadastroCompleto(driver, usuario, link, i);
			
			if(funcoesCadastro.errosValidacao(driver)){
				  System.out.println("------Erro de validação dos campos com o campo "+nomeCampo+": " + valorCampo);
			}
			
			
//############################################################################################# IMPRESSAO DE lOG #########################################################################################//	
			
			if(funcoesCadastro.cadastroRealizado(driver)) {	
				
				funcoesMT.logCampoOK(driver, logger, nomeCampo, valorCampo);			
				quantidadeAcertos++;
			}else {
				
					funcoesMT.logCampoErro(driver, logger, nomeCampo, valorCampo);
					quantidadeErros++;
				}
			
			if(i==max){
				
				funcoesMT.logInformacoesExecucao(driver, logger, nomeCampo, quantidadeAcertos, quantidadeErros, acertosSemJS, errosSemJS, tempoInicio);
			}
		  
			interacoesNavegador.AguardarCarregamento(driver);  
			i++;
		} 
	}		
}
