package br.com.mundotigre.funcoesprincipais.cadastro;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import br.com.mundotigre.objetos.Usuario;
import br.com.mundotigre.scripts.FuncoesCadastro;
import br.com.mundotigre.scripts.InteracoesNavegador;

public class CasoNome {
	
	 @Test 
	 public void testarNome(WebDriver driver, Logger logger, Usuario usuario, String link, InteracoesNavegador interacoesNavegador, FuncoesCadastro funcoesCadastro){		 
		 
		  long tempoInicio = System.currentTimeMillis(); 	
		  
		  String nomeCampo = "Nome";
		  
		  System.out.println("\n-----------------------------Teste "+nomeCampo+"-------------------------------");
		 
		  int i = 0; 
		  int max = 7;	

		  int quantidadeAcertos = 0;
		  int quantidadeErros = 0;	
		  int acertosSemJS = 0;
		  int errosSemJS = 0;	
		  
		  while(i<=max){	
			  
			  if(i==0){ 
				  usuario.setNome(usuario.getNome()+i);
				//funcoes.contarElementosPorXpath(driver, "//select[@id='mundo_tigre_mtg_id_est_emp']//option");
			  }		
			
			  if(i==1){
				  usuario.setNome(usuario.getNome()+"123"+i);
			  }
			  
			  if(i==2){ 
				  usuario.setNome("123!@#%#@#"+i);
			  }
			  
			  if(i==3){
				  usuario.setNome("TESTANDO");
			  }
			  
			  if(i==4){
				  usuario.setNome("TESTANDO.A2C.TEST");
			  }
			  
			  if(i==5){
				  usuario.setNome("TESTANDO A2C TEST"); 
			  }
			  
			  if(i==6){
				  usuario.setNome("Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sem");
			  }
			  
			  if(i==7){
				  usuario.setNome("Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer um livro de modelos de tipos. Lorem Ipsum sobreviveu");
			  }
			
			  funcoesCadastro.cadastroCompleto(driver, usuario, link, i);
			  
			  
			  if(funcoesCadastro.errosValidacao(driver)){
				  System.out.println("------Erro de validação dos campos com o nome: " + usuario.getNome());
			  }
			  
			  /*--------------------Impressao de log----------------------*/
			  if(funcoesCadastro.cadastroRealizado(driver)) {	
				  
				  	funcoesCadastro.logCampoOK(driver, logger, nomeCampo, usuario.getNome());
					
					 if(i <= 7) {
						 quantidadeAcertos++;
					 }else {
							acertosSemJS++;							
					  		}
		
			  }else {				  
				  	funcoesCadastro.logCampoErro(driver, logger, nomeCampo, usuario.getNome());	
				  	
				    if(i <= 7) {							
						quantidadeErros++;
				    }else {			
							errosSemJS++;
						}
			  }
			  
			  if(i==max){
				  funcoesCadastro.logInformacoesExecucao(driver, logger, nomeCampo, quantidadeAcertos, quantidadeErros, acertosSemJS, errosSemJS, tempoInicio);
			  }
		  
			i++;
		 } 
	 }	
}
