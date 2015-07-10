package br.com.mundotigre.funcoesprincipais.cadastro;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import br.com.mundotigre.objetos.Usuario;
import br.com.mundotigre.scripts.FuncoesCadastro;
import br.com.mundotigre.scripts.FuncoesMT;
import br.com.mundotigre.scripts.InteracoesNavegador;

public class CasoCEP {
	
	 @Test 
	 public void testarCEP(WebDriver driver, Logger logger, Usuario usuario, String link, InteracoesNavegador interacoesNavegador, FuncoesMT funcoesMT, FuncoesCadastro funcoesCadastro){		 
		 
		  long tempoInicio = System.currentTimeMillis(); 
		  String nomeCampo = "CEP";
		  System.out.println("\n-----------------------------Teste "+nomeCampo+"-------------------------------");
		 
		  int i = 0; 
		  int max = 7;	

		  int quantidadeAcertos = 0;
		  int quantidadeErros = 0;	
		  int acertosSemJS = 0;
		  int errosSemJS = 0;	
		  
		  while(i<=max){	
			  			  
			  if(i==0 || i==7){
				  usuario.setCep("");
			  }
			  
			  if(i==1 || i==8){
				  usuario.setCep("190");
			  }
			  
			  if(i==2 || i==9){
				  usuario.setCep("1234567890");
			  }
			  
			  if(i==3 || i==10){
				  usuario.setCep("12345678");	  
			  }			  
			
			  if(i==4 || i==11){
				  usuario.setCep("1234567");
			  }
			
			  if(i==5 || i==12){
				  usuario.setCep("teste");
			  }
			  
			  if(i==6 || i==13){
				  usuario.setCep("@%&!");
			  }
			  
			  funcoesCadastro.cadastroCompleto(driver, usuario, link, i);
			  
			  if(funcoesCadastro.errosValidacao(driver)){
				  System.out.println("------Erro de validação dos campos com o campo CEP: " + usuario.getCep());
			  }
			  
			 /* --------------------Impressao de log----------------------*/
			  if(funcoesCadastro.cadastroRealizado(driver)) {	
				  
				  funcoesMT.logCampoOK(driver, logger, nomeCampo, usuario.getCep());
					
				  if(i <= 7) {
					  quantidadeAcertos++;
				  }else {
						acertosSemJS++;							
				  		}
		
			  }else {				  
				  funcoesMT.logCampoErro(driver, logger, nomeCampo, usuario.getCep());
				  	
					  if(i <= 7) {							
							quantidadeErros++;
					  }else {			
								errosSemJS++;
							}
			 }
			  
			if(i==max){
				funcoesMT.logInformacoesExecucao(driver, logger, nomeCampo, quantidadeAcertos, quantidadeErros, acertosSemJS, errosSemJS, tempoInicio);
			}
			i++;
		} 
	}
}	
	 

