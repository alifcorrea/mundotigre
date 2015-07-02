package br.com.mundotigre.funcoesprincipais.cadastro;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

import br.com.mundotigre.objetos.Usuario;
import br.com.mundotigre.scripts.FuncoesCadastro;
import br.com.mundotigre.scripts.InteracoesNavegador;

public class CasoConfirmaSenha {

	 @Test 
	 public void testarConfirmaSenha(WebDriver driver, Usuario usuario, InteracoesNavegador interacoesNavegador, FuncoesCadastro funcoesCadastro){		 
		 System.out.println("\n-----------------------------Teste Confirma Senha-------------------------------");
		 long tempoInicio = System.currentTimeMillis(); 		 
		
		 String campo = "Confirma Senha";
		 
		  int i = 0; 
		  int max = 1;	

		  int quantidadeAcertos = 0;
		  int quantidadeErros = 0;	
		  int acertosSemJS = 0;
		  int errosSemJS = 0;	
		  
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
			  
			  String valorCampo = usuario.getConfirmaSenha();
				 
			  funcoesCadastro.cadastroCompleto(driver, usuario, "http://www.mundotigre.com.br/cadastro/new", i);
			  
			  if(funcoesCadastro.errosValidacao(driver)){
				  System.out.println("------Erro de validação dos campos com o campo "+campo+": " + valorCampo);
			  }
			  

			  /* --------------------Impressao de log----------------------*/
			  if(funcoesCadastro.cadastroRealizado(driver)) {	
				  
				  funcoesCadastro.logCampoOK(driver, campo, valorCampo);
					quantidadeAcertos++;
			
				  	}else {				  
						  funcoesCadastro.logCampoErro(driver, campo, valorCampo);
						  quantidadeErros++;		
				  	}
			  
			  if(i==max){
				  funcoesCadastro.logInformacoesExecucao(driver, campo, quantidadeAcertos, quantidadeErros, acertosSemJS, errosSemJS, tempoInicio);
			  }
		  
			  interacoesNavegador.AguardarCarregamento(driver);  
			  i++;
		} 
	}	
	
}
