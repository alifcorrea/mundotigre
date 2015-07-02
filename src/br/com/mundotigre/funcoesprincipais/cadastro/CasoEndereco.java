package br.com.mundotigre.funcoesprincipais.cadastro;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

import br.com.mundotigre.objetos.Usuario;
import br.com.mundotigre.scripts.FuncoesCadastro;
import br.com.mundotigre.scripts.InteracoesNavegador;

public class CasoEndereco {

	
	 @Test 
	 public void testarEndereco(WebDriver driver, Usuario usuario,  InteracoesNavegador interacoesNavegador, FuncoesCadastro funcoesCadastro){		 
		 
		  long tempoInicio = System.currentTimeMillis(); 		 
		  System.out.println("\n-----------------------------Teste Endere�o-------------------------------");
		 
		  int i = 0; 
		  int max = 13;	

		  int quantidadeAcertos = 0;
		  int quantidadeErros = 0;	
		  int acertosSemJS = 0;
		  int errosSemJS = 0;	
		  
		  while(i<=max){	
			  
			  if(i==7)
				interacoesNavegador.desativarJSFirefox(driver);
				System.out.println("\n------------------Telefone Endere�o com Javascript desabilitado--------------------");
			  }
		
			  
			  if(i==0 || i==7){
				  usuario.setEndereco("");
			  }
			  
			  if(i==1 || i==8){
				  usuario.setEndereco("Teste");
			  }
			  
			  if(i==2 || i==9){
				  usuario.setEndereco("Teste67890");
			  }
			  
			  if(i==3 || i==10){
				  usuario.setEndereco("!@#$%+=-");	  
			  }			  
			
			  if(i==4 || i==11){
				  usuario.setEndereco("Lorem Ipsum � simplesmente uma simula��o de texto da ind�stria tipogr�fica e de impressos, e vem sendo utilizado desde");
			  }
			
			  if(i==5 || i==12){
				  usuario.setEndereco("Lorem Ipsum � simplesmente uma simula��o de texto da ind�stria tipogr�fica e de impressos, e vem sendo utilizado desde o s�culo XVI, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou");
			  }
			  
			  if(i==6 || i==13){
				  usuario.setEndereco("Lorem Ipsum � simplesmente uma simula��o de texto da ind�stria tipogr�fica e de impressos, e vem sendo utilizado desde o s�culo XVI, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer um livro de modelos de tipos. Lorem Ipsum sobreviveu n�o s� a cinco s�culos, como tamb�m ao salto para a");
			  }
			  
			  funcoesCadastro.cadastroCompleto(driver, usuario, "http://www.mundotigre.com.br/cadastro/new", i);
			  
			  if(funcoesCadastro.errosValidacao(driver)){
				  System.out.println("------Erro de valida��o dos campos com o campo Endere�o: " + usuario.getEndereco());
			  }
			  
			 /* --------------------Impressao de log----------------------*/
			  if(funcoesCadastro.cadastroRealizado(driver)) {	
				  
				  funcoesCadastro.logCampoOK(driver, "Endere�o", usuario.getEndereco());
					quantidadeAcertos++;
		
			  }else {				  
				  funcoesCadastro.logCampoErro(driver, "Endere�o", usuario.getEndereco());
					quantidadeErros++;
			  }
			  
			  if(i==max){
				  funcoesCadastro.logInformacoesExecucao(driver, "Endere�o", quantidadeAcertos, quantidadeErros, acertosSemJS, errosSemJS, tempoInicio);
			  }
		  
			i++;
		 } 
	 }	
