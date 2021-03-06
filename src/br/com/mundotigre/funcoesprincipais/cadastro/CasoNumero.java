package br.com.mundotigre.funcoesprincipais.cadastro;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import br.com.mundotigre.objetos.Usuario;
import br.com.mundotigre.scripts.FuncoesCadastro;
import br.com.mundotigre.scripts.FuncoesMT;
import br.com.mundotigre.scripts.InteracoesNavegador;

public class CasoNumero {
	
	@Test 
	public void testarNumero(WebDriver driver, Logger logger, Usuario usuario, String link, InteracoesNavegador interacoesNavegador, FuncoesMT funcoesMT, FuncoesCadastro funcoesCadastro){		 
		
		long tempoInicio = System.currentTimeMillis(); 	
		String nomeCampo = "N�mero";
		System.out.println("\n-----------------------------Teste "+nomeCampo+"-------------------------------");		 
		int i = 0; 
		int max = 7;	
		
		int quantidadeAcertos = 0;
		int quantidadeErros = 0;	
		int acertosSemJS = 0;
		int errosSemJS = 0;	
		
		while(i<=max){	
			
			if(i==6) {
				interacoesNavegador.desativarJSFirefox(driver, logger, nomeCampo);
				System.out.println("\n------------------"+nomeCampo+" com Javascript desabilitado--------------------");
			}
			
			if(i==0 || i==7){
				usuario.setNumero("");
			}
			
			if(i==1 || i==8){
				usuario.setNumero("Teste");
			}
			
			if(i==2 || i==9){
				usuario.setNumero("Teste67890");
			}
			
			if(i==3 || i==10){
				usuario.setNumero("!@#$%+=-");	  
			}			  
			
			if(i==4 || i==11){
				usuario.setNumero("Lorem Ipsum � simplesmente uma simula��o de texto da ind�stria tipogr�fica e de impressos, e vem sendo utilizado desde");
			}
			
			if(i==5 || i==12){
				usuario.setNumero("Lorem Ipsum � simplesmente uma simula��o de texto da ind�stria tipogr�fica e de impressos, e vem sendo utilizado desde o s�culo XVI, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou");
			}
			
			if(i==6 || i==13){
				usuario.setNumero("Lorem Ipsum � simplesmente uma simula��o de texto da ind�stria tipogr�fica e de impressos, e vem sendo utilizado desde o s�culo XVI, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer um livro de modelos de tipos. Lorem Ipsum sobreviveu n�o s� a cinco s�culos, como tamb�m ao salto para a");
			}
			
			funcoesCadastro.cadastroCompleto(driver, usuario, link, i);
			
			if(funcoesCadastro.errosValidacao(driver)){
				System.out.println("------Erro de valida��o dos campos com o campo N�mero: " + usuario.getNumero());
			}
			
			/* --------------------Impressao de log----------------------*/
			if(funcoesCadastro.cadastroRealizado(driver)) {	
				
				funcoesMT.logCampoOK(driver, logger, nomeCampo, usuario.getNumero());
				quantidadeAcertos++;
					
			}else {				  
					funcoesMT.logCampoErro(driver, logger, nomeCampo, usuario.getNumero());
					quantidadeErros++;
				}
			
			if(i==max){
				funcoesMT.logInformacoesExecucao(driver, logger, nomeCampo, quantidadeAcertos, quantidadeErros, acertosSemJS, errosSemJS, tempoInicio);
			}
		
		i++;
		} 
	}
}