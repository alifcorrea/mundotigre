package br.com.mundotigre.funcoesprincipais.cadastro;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

import br.com.mundotigre.objetos.Usuario;
import br.com.mundotigre.scripts.FuncoesCadastro;
import br.com.mundotigre.scripts.InteracoesNavegador;

public class CasoTelefone {
	
	 @Test 
	 public void testarTelefone(WebDriver driver, Usuario usuario, InteracoesNavegador interacoesNavegador, FuncoesCadastro funcoesCadastro){		 
		 
		  long tempoInicio = System.currentTimeMillis(); 		 
		  System.out.println("\n-----------------------------Teste Telefone-------------------------------");
		 
		  int i = 0; 
		  int max = 7;	

		  int quantidadeAcertos = 0;
		  int quantidadeErros = 0;	
		  int acertosSemJS = 0;
		  int errosSemJS = 0;	
		  
		  while(i<=max){	
			  
			  if (i==6) {
				  	interacoesNavegador.desativarJSFirefox(driver);
					System.out.println("\n------------------Telefone com Javascript desabilitado--------------------");
			  }
		
			 	
			  
			  if(i==0 || i==7){
				  usuario.setTelefone("");
			  }
			  
			  if(i==1 || i==8){
				  usuario.setTelefone("1234567890");
			  }
			  
			  if(i==2 || i==9){
				  usuario.setTelefone("123456789");
			  }
			  
			  if(i==3 || i==10){
				  usuario.setTelefone("12345678");	  
			  }			  
			
			  if(i==4 || i==11){
				  usuario.setTelefone("1234567");
			  }
			
			  if(i==5 || i==12){
				  usuario.setTelefone("teste");
			  }
			  
			  if(i==6 || i==13){
				  usuario.setTelefone("@%&!");
			  }
			  
			  funcoesCadastro.cadastroCompleto(driver, usuario, "http://www.mundotigre.com.br/cadastro/new", i);
			
			  if(funcoesCadastro.errosValidacao(driver)){
				  System.out.println("------Erro de validação dos campos com o campo Telefone: " + usuario.getTelefone());
			  }
			  
			  /*--------------------Impressao de log----------------------*/
			  if(funcoesCadastro.cadastroRealizado(driver)) {	
				  
				  funcoesCadastro.logCampoOK(driver, "Telefone", usuario.getTelefone());
					quantidadeAcertos++;
		
			  }else {				  
				  funcoesCadastro.logCampoErro(driver, "Telefone", usuario.getTelefone());
					quantidadeErros++;
			  }
			  
			  if(i==max){
				  funcoesCadastro.logInformacoesExecucao(driver, "Telefone", quantidadeAcertos, quantidadeErros, acertosSemJS, errosSemJS, tempoInicio);
			  }
		  
			i++;
		 } 
	 }	
}
