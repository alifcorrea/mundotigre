package br.com.mundotigre.funcoesprincipais.cadastro;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

import br.com.mundotigre.objetos.Usuario;
import br.com.mundotigre.scripts.FuncoesCadastro;
import br.com.mundotigre.scripts.InteracoesNavegador;

public class CasoSexo {
	
	 @Test 
	 public void testarSexo(WebDriver driver, Usuario usuario, InteracoesNavegador interacoesNavegador, FuncoesCadastro funcoesCadastro){
		 
		  long tempoInicio = System.currentTimeMillis(); 
		  System.out.println("\n-----------------------------Teste Sexo-------------------------------");
		 
		  int i = 0; 
		  int max = 2;		
		  
		  int quantidadeAcertos = 0;
		  int quantidadeErros = 0;	
		  int acertosSemJS = 0;
		  int errosSemJS = 0;
		
		  while(i<=max){			 
			  
			
			  if(i==0){
				  usuario.setSexo("");
			  }
			  
			  if(i==1){
				  usuario.setSexo("M");
			  }
			  
			  if(i==2){
				  usuario.setSexo("F");
			  }			  
			
			  funcoesCadastro.cadastroCompleto(driver, usuario, "http://www.mundotigre.com.br/cadastro/new", i);
			  
			  if(funcoesCadastro.errosValidacao(driver)){
				  System.out.println("------Erro de validação dos campos com o Sexo: " + usuario.getSexo());
			  }
			  
			  /*--------------------Impressao de log----------------------*/
			  if(funcoesCadastro.cadastroRealizado(driver)) {
		
				  	funcoesCadastro.logCampoOK(driver, "Sexo", usuario.getSexo());
					quantidadeAcertos++;
					
			  }else{
				  funcoesCadastro.logCampoErro(driver, "Sexo", usuario.getSexo());
					quantidadeErros++;		
			  		}
		
			  if(i==max){
				  funcoesCadastro.logInformacoesExecucao(driver, "Sexo", quantidadeAcertos, quantidadeErros, acertosSemJS, errosSemJS, tempoInicio);
			  } 
		  
			  interacoesNavegador.AguardarCarregamento(driver);  
			
		  i++;
		 } 
	 }	
}
