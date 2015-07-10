package br.com.mundotigre.funcoesprincipais.cadastro;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import br.com.mundotigre.objetos.Usuario;
import br.com.mundotigre.scripts.FuncoesCadastro;
import br.com.mundotigre.scripts.FuncoesMT;
import br.com.mundotigre.scripts.InteracoesNavegador;

public class CasoConfirmaSenha {
	
//############################################################################################## CONFIGURACOES INICIAIS #################################################################################//		

	@Test 
	public void testarConfirmaSenha(WebDriver driver, Logger logger, Usuario usuario, String link, InteracoesNavegador interacoesNavegador, FuncoesMT funcoesMT, FuncoesCadastro funcoesCadastro){		 
		
		long tempoInicio = System.currentTimeMillis(); 		 
		String nomeCampo = "Confirma Senha";
		String valorCampo = usuario.getConfirmaSenha();
		
		int i = 0; 
		int max = 1;	
		
		int quantidadeAcertos = 0;
		int quantidadeErros = 0;	
		int acertosSemJS = 0;
		int errosSemJS = 0;	

//################################################################################################ INICIO DA EXECUCAO ###################################################################################//	
		
		funcoesMT.logInicio(driver, logger, nomeCampo);
		
		while(i<=max){
			
			if(i==0){ 
				usuario.setConfirmaSenha("");
			}
			
			if(i==1){
				usuario.setConfirmaSenha("Testes");
			}
			
			if(i==2){ 
				usuario.setConfirmaSenha("testes123");
			}
			
			if(i==3){
				usuario.setConfirmaSenha("testes123#$%¨&@#!+_)(");
			}
			
			if(i==4){
				usuario.setConfirmaSenha("TESTANDOA2CTEST");
			}
			
			if(i==5){
				usuario.setConfirmaSenha(" TESTANDO.A2C.TEST"); 
			}
			
			if(i==6){
				usuario.setConfirmaSenha("Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sem");
			}
			
			if(i==7){
				usuario.setConfirmaSenha("Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer um livro de modelos de tipos. Lorem Ipsum sobreviveu");
			}
			
			funcoesCadastro.cadastroCompleto(driver, usuario, link, i);
			
			if(funcoesCadastro.errosValidacao(driver)){
				System.out.println("------Erro de validação dos campos com o campo "+nomeCampo+": " + valorCampo);
			}
			
			
//################################################################################################## IMPRESSAO DE lOG ###################################################################################//	
			
			if(funcoesCadastro.cadastroRealizado(driver)){	
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
		} 
	}	
}
