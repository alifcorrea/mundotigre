package br.com.mundotigre.funcoesprincipais.cadastro;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import br.com.mundotigre.objetos.Usuario;
import br.com.mundotigre.scripts.FuncoesCadastro;
import br.com.mundotigre.scripts.InteracoesNavegador;

public class CasoSenha {

	 @Test 
	 public void testarSenha(WebDriver driver, Logger logger, Usuario usuario, String link, InteracoesNavegador interacoesNavegador, FuncoesCadastro funcoesCadastro){		 
		 
		   long tempoInicio = System.currentTimeMillis(); 
		   String nomeCampo = "Senha";
		 
		   System.out.println("\n-----------------------------Teste "+nomeCampo+"-------------------------------");
		 
		 
		  int i = 0; 
		  int max = 1;	

		  int quantidadeAcertos = 0;
		  int quantidadeErros = 0;	
		  int acertosSemJS = 0;
		  int errosSemJS = 0;	
		  
		  while(i<=max){				  
			
					 
			  if(i==0){ 
				  usuario.setSenha("");
			  }		
			
			  if(i==1){
				  usuario.setSenha("Testes");
			  }
			  
			  if(i==2){ 
				  usuario.setSenha("testes123");
			  }
			  
			  if(i==3){
				  usuario.setSenha("testes123#$%¨&@#!+_)(");
			  }
			  
			  if(i==4){
				  usuario.setSenha("TESTANDOA2CTEST");
			  }
			 
			  if(i==5){
				  usuario.setSenha(" TESTANDO.A2C.TEST"); 
			  }
			  
			  if(i==6){
				  usuario.setSenha("Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sem");
			  }
			  
			  if(i==7){
				  usuario.setSenha("Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer um livro de modelos de tipos. Lorem Ipsum sobreviveu");
			  }
			  
			  String valorCampo = usuario.getSenha();
			  
			  funcoesCadastro.cadastroCompleto(driver, usuario, link, i);
			  
			  if(funcoesCadastro.errosValidacao(driver)){
				  System.out.println("------Erro de validação dos campos com o campo "+nomeCampo+": " + valorCampo);
			  }
			  

			  /* --------------------Impressao de log----------------------*/
			  if(funcoesCadastro.cadastroRealizado(driver)) {	
				  
				  funcoesCadastro.logCampoOK(driver, logger, nomeCampo, valorCampo);
					quantidadeAcertos++;
			
				  	}else {				  
						  funcoesCadastro.logCampoErro(driver, logger, nomeCampo, valorCampo);
						  quantidadeErros++;		
				  	}
			  
			  if(i==max){
				  funcoesCadastro.logInformacoesExecucao(driver, logger, nomeCampo, quantidadeAcertos, quantidadeErros, acertosSemJS, errosSemJS, tempoInicio);
			  }
		  
			  interacoesNavegador.AguardarCarregamento(driver);  
			  i++;
		} 
	}		
	
}
