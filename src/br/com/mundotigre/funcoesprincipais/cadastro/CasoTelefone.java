package br.com.mundotigre.funcoesprincipais.cadastro;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import br.com.mundotigre.objetos.Usuario;
import br.com.mundotigre.scripts.FuncoesCadastro;
import br.com.mundotigre.scripts.FuncoesMT;
import br.com.mundotigre.scripts.InteracoesNavegador;

public class CasoTelefone {
	
	@Test 
	public void testarTelefone(WebDriver driver, Logger logger, Usuario usuario, String link, InteracoesNavegador interacoesNavegador, FuncoesMT funcoesMT, FuncoesCadastro funcoesCadastro){		 
		
		long tempoInicio = System.currentTimeMillis(); 		
		String nomeCampo = "Telefone";
		System.out.println("\n-----------------------------Teste "+nomeCampo+"-------------------------------");
		
		int i = 0; 
		int max = 7;	
		
		int quantidadeAcertos = 0;
		int quantidadeErros = 0;	
		int acertosSemJS = 0;
		int errosSemJS = 0;	
		
		while(i<=max){	
			
			if (i==6) {
				interacoesNavegador.desativarJSFirefox(driver, logger, nomeCampo);
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
			
			funcoesCadastro.cadastroCompleto(driver, usuario, link, i);
			
			if(funcoesCadastro.errosValidacao(driver)){
				System.out.println("------Erro de valida��o dos campos com o campo Telefone: " + usuario.getTelefone());
			}
			
			/*--------------------Impressao de log----------------------*/
			if(funcoesCadastro.cadastroRealizado(driver)) {	
			
				funcoesMT.logCampoOK(driver, logger, nomeCampo, usuario.getTelefone());
				quantidadeAcertos++;
			}else {				  
					funcoesMT.logCampoErro(driver, logger, nomeCampo, usuario.getTelefone());
					quantidadeErros++;
				}
			
			if(i==max){
				funcoesMT.logInformacoesExecucao(driver, logger, nomeCampo, quantidadeAcertos, quantidadeErros, acertosSemJS, errosSemJS, tempoInicio);
			}
			
		i++;
		} 
	}	
}
