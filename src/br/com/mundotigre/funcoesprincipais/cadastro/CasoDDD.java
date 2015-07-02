package br.com.mundotigre.funcoesprincipais.cadastro;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import br.com.mundotigre.objetos.Usuario;
import br.com.mundotigre.scripts.FuncoesCadastro;
import br.com.mundotigre.scripts.InteracoesNavegador;

public class CasoDDD {
	
	public InteracoesNavegador funcoes;
	public FuncoesCadastro funcoesCadastro;

	@Before
	public void Inicio() {
		funcoes = new InteracoesNavegador();
		funcoesCadastro = new FuncoesCadastro();	
	}
	
	 @Test 
	 public void testarDDD(WebDriver driver, Usuario usuario, InteracoesNavegador interacoesNavegador, FuncoesCadastro funcoesCadastro) {		 
		 
		  long tempoInicio = System.currentTimeMillis(); 		 
		  System.out.println("\n-----------------------------Teste DDD-------------------------------");
		 
		  int i = 0; 
		  int max = 7;	

		  int quantidadeAcertos = 0;
		  int quantidadeErros = 0;	
		  int acertosSemJS = 0;
		  int errosSemJS = 0;	
		  
		  while(i<=max){	
			  
			  if (i == 6) {
					interacoesNavegador.desativarJSFirefox(driver);
					System.out.println("\n------------------DDD com Javascript desabilitado--------------------");
				}
			 
			  if(i==0 || i==6){
				  usuario.setDDD("");
			  }
			  
			  if(i==1 || i==7){
				  usuario.setDDD("4");
			  }
			  
			  if(i==2 || i==8){
				  usuario.setDDD("47");
			  }
			  
			  if(i==3 || i==9){
				  usuario.setDDD("479");	  
			  }			  
			
			  if(i==4 || i==10){
				  usuario.setDDD("te");
			  }
			
			  if(i==5 || i==11){
				  usuario.setDDD("#$%");
			  }
			  
			
			  funcoesCadastro.cadastroCompleto(driver, usuario, "http://www.mundotigre.com.br/cadastro/new", i);
			  
			  
			  if(funcoesCadastro.errosValidacao(driver)){
				  System.out.println("------Erro de validação dos campos com o campo DDD: " + usuario.getDDD());
			  }
			  
			  /*--------------------Impressao de log----------------------*/
			  if(funcoesCadastro.cadastroRealizado(driver)) {	
				  
				  funcoesCadastro.logCampoOK(driver, "DDD", usuario.getDDD());
					quantidadeAcertos++;
		
			  }else {				  
				  funcoesCadastro.logCampoErro(driver, "DDD", usuario.getDDD());
					quantidadeErros++;
			  }
			  
			  if(i==max){
				  funcoesCadastro.logInformacoesExecucao(driver, "DDD", quantidadeAcertos, quantidadeErros, acertosSemJS, errosSemJS, tempoInicio);
			  }
		  
			i++;
		 } 
	 }	
}
