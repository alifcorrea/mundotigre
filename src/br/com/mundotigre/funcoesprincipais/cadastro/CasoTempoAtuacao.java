package br.com.mundotigre.funcoesprincipais.cadastro;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

import br.com.mundotigre.objetos.Usuario;
import br.com.mundotigre.scripts.FuncoesCadastro;
import br.com.mundotigre.scripts.InteracoesNavegador;

public class CasoTempoAtuacao {

	 @Test 
	 public void testarTempoAtuacao(WebDriver driver, Usuario usuario, InteracoesNavegador interacoesNavegador, FuncoesCadastro funcoesCadastro){
		 
       	  long tempoInicio = System.currentTimeMillis(); 		 
		  System.out.println("\n------------------------------Teste Tempo Atuação--------------------------------");
		 
		  int i = 0; 
		  int max = 4;
		  
		  int quantidadeAcertos = 0;
		  int quantidadeErros = 0;	
		  int acertosSemJS = 0;
		  int errosSemJS = 0;
		  
		  while(i<=max){  
			  
			  if(i==0){
				  usuario.setTempoAtuacao("");
			  }
			  
			  if(i==1){
				  usuario.setTempoAtuacao("1");
			  }
			  
			  if(i==2){
				  usuario.setTempoAtuacao("2");
			  }
			  
			  if(i==3){
				  usuario.setTempoAtuacao("3");
			  }
		
			  if(i==4){
				  usuario.setTempoAtuacao("4");
			  }
			  			  
			  funcoesCadastro.cadastroCompleto(driver, usuario, "http://www.mundotigre.com.br/cadastro/new", i);				
			
			  if(funcoesCadastro.errosValidacao(driver)){
				  System.out.println("------Erro de validação dos campos com o campo Tempo atuação: " + usuario.getTempoAtuacao());
			  }
			  
			  /*--------------------Impressao de log----------------------*/
			  if(funcoesCadastro.cadastroRealizado(driver)) {		
				  	funcoesCadastro.logCampoOK(driver, "Tempo Atuação", usuario.getTempoAtuacao());
					quantidadeAcertos++;
				
			  }else{		  
						funcoesCadastro.logCampoErro(driver, "Tempo Atuação", usuario.getTempoAtuacao());
						quantidadeErros++;		
			  		}
		
			  if(i==max){
				  funcoesCadastro.logInformacoesExecucao(driver, "Tempo Atuação", quantidadeAcertos, quantidadeErros, acertosSemJS, errosSemJS, tempoInicio);
			} /*--------------------Fim Impressao de log----------------------*/	
			
			i++;
		 } 
	 }
	
}
