package br.com.mundotigre.funcoesprincipais.cadastro;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import br.com.mundotigre.objetos.Usuario;
import br.com.mundotigre.scripts.FuncoesCadastro;
import br.com.mundotigre.scripts.InteracoesNavegador;

public class CasoDataNascimento {

	@Test 
	 public void testarDataNascimento(WebDriver driver, Logger logger, Usuario usuario, String link, InteracoesNavegador interacoesNavegador, FuncoesCadastro funcoesCadastro){ 
		
		  long tempoInicio = System.currentTimeMillis(); 
		  String nomeCampo = "Data de Nascimento";
		  System.out.println("\n-----------------------------Teste "+nomeCampo+"-------------------------------");
				 
		  int i = 0; 
		  int max = 13;
		  
		  int quantidadeAcertos = 0;
		  int quantidadeErros = 0;		
		  int acertosSemJS = 0;
		  int errosSemJS = 0;		
	  
		  while(i<=max){
			  
			  if(i==37){
				  interacoesNavegador.desativarJSFirefox(driver, logger, nomeCampo);	
			  }
			
			  if(i==0 || i==7){
				  usuario.setDataNascimento("");
			  }
			  
			  if(i==1 || i==8){
				  usuario.setDataNascimento("35/02/2015");
			  } 
			  
			  if(i==2 || i==9){
				  usuario.setDataNascimento("02/35/2015");
			  } 
			  
			  if(i==3 || i==10){
				  usuario.setDataNascimento("02/35/0918");
			  } 
			  
			  if(i==4 || i==11){
				  usuario.setDataNascimento("15/02/1900");
			  }
			  
			  if(i==5 || i==12){
				  usuario.setDataNascimento("13/02/2015");
			  } 
			  
			  if(i==6 || i==13){
				  usuario.setDataNascimento("26/12/2015");
			  }

			  funcoesCadastro.cadastroCompleto(driver, usuario, link, i);
			  
			  if(funcoesCadastro.errosValidacao(driver)){
				  System.out.println("------Erro de validação dos campos com a data de nascimento: " + usuario.getDataNascimento());
			  }
			  
			  /*--------------------Impressao de log----------------------*/
			  if(funcoesCadastro.cadastroRealizado(driver)) {
		
				  funcoesCadastro.logCampoOK(driver, logger, nomeCampo, usuario.getDataNascimento());
			
					if(i<=6) {
						quantidadeAcertos++;
					}
		
					if(i>6) {
						acertosSemJS++;
					}
		
			  }else {
				  
				  	funcoesCadastro.logCampoErro(driver,logger, nomeCampo, usuario.getDataNascimento());
					
					if(i<=6) {
						quantidadeErros++;
					}		
					
					if(i>6) {
						errosSemJS++;
					}
			  }
		
			if(i==max) {
				 funcoesCadastro.logInformacoesExecucao(driver, logger, nomeCampo, quantidadeAcertos, quantidadeErros, acertosSemJS, errosSemJS, tempoInicio);
			
			}
		  
			interacoesNavegador.AguardarCarregamento(driver);			  
		  i++;
		 } 
	}	  
}	