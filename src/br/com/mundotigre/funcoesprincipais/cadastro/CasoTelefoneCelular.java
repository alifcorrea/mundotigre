package br.com.mundotigre.funcoesprincipais.cadastro;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import br.com.mundotigre.objetos.Usuario;
import br.com.mundotigre.scripts.FuncoesCadastro;
import br.com.mundotigre.scripts.InteracoesNavegador;

public class CasoTelefoneCelular {
		
	 @Test 
	 public void testarTelefoneCelular(WebDriver driver, Usuario usuario, InteracoesNavegador interacoesNavegador, FuncoesCadastro funcoesCadastro){		 
		 
		  long tempoInicio = System.currentTimeMillis(); 		 
		  System.out.println("\n-----------------------------Teste Telefone Celular-------------------------------");
		 
		  int i = 0; 
		  int max = 7;	

		  int quantidadeAcertos = 0;
		  int quantidadeErros = 0;	
		  int acertosSemJS = 0;
		  int errosSemJS = 0;	
		  
		  while(i<=max){	
			  
			  if (i == 6) {
				    interacoesNavegador.desativarJSFirefox(driver);
					System.out.println("\n------------------Telefone celular com Javascript desabilitado--------------------");
				}
			  
			
			  if(i==0 || i==7){
				  usuario.setCelular("");
			  }
			  
			  if(i==1 || i==8){
				  usuario.setCelular("1234567890");
			  }
			  
			  if(i==2 || i==9){
				  usuario.setCelular("123456789");
			  }
			  
			  if(i==3 || i==10){
				  usuario.setCelular("12345678");	  
			  }			  
			
			  if(i==4 || i==11){
				  usuario.setCelular("1234567");
			  }
			
			  if(i==5 || i==12){
				  usuario.setCelular("teste");
			  }
			  
			  if(i==6 || i==13){
				  usuario.setCelular("@%&!");
			  }
			
			  funcoesCadastro.cadastroCompleto(driver, usuario, "http://www.mundotigre.com.br/cadastro/new", i);
			  
			  if(funcoesCadastro.errosValidacao(driver)){
				  System.out.println("------Erro de validação dos campos com o campo Telefone Celular: " + usuario.getCelular());
			  }
			  
			 /* --------------------Impressao de log----------------------*/
			  if(funcoesCadastro.cadastroRealizado(driver)) {	
				  
				  funcoesCadastro.logCampoOK(driver, "Telefone Celular", usuario.getCelular());
					quantidadeAcertos++;
		
			  }else {				  
				  funcoesCadastro.logCampoErro(driver, "Telefone Celular", usuario.getCelular());
					quantidadeErros++;
			  }
			  
			  if(i==max){
				  funcoesCadastro.logInformacoesExecucao(driver, "Telefone Celular", quantidadeAcertos, quantidadeErros, acertosSemJS, errosSemJS, tempoInicio);
			  }
		  
			i++;
		 } 
	 }	
}
