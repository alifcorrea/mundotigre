package br.com.mundotigre.funcoesprincipais.cadastro;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import br.com.mundotigre.objetos.Usuario;
import br.com.mundotigre.scripts.FuncoesCadastro;
import br.com.mundotigre.scripts.FuncoesMT;
import br.com.mundotigre.scripts.InteracoesNavegador;

public class CasoComplemento {
	
	@Test 
	public void testarComplemento(WebDriver driver, Logger logger, Usuario usuario, String link, InteracoesNavegador interacoesNavegador, FuncoesMT funcoesMT, FuncoesCadastro funcoesCadastro){		 
		 
		long tempoInicio = System.currentTimeMillis(); 
		String nomeCampo = "Complemento";
		System.out.println("\n-----------------------------Teste "+nomeCampo+"-------------------------------");
		
		int i = 0; 
		int max = 7;	

		int quantidadeAcertos = 0;
		int quantidadeErros = 0;	
		int acertosSemJS = 0;
		int errosSemJS = 0;	
		
		while(i<=max){
			
			
			if(i==7){
				interacoesNavegador.desativarJSFirefox(driver, logger, nomeCampo);
			}
					 
			if(i==0 || i==7){
				  usuario.setComplemento("");
			}
			
			if(i==1 || i==8){
				usuario.setComplemento("Teste");
			}
			
			if(i==2 || i==9){
				usuario.setComplemento("Teste67890");
			}
			
			if(i==3 || i==10){
				usuario.setComplemento("!@#$%+=-");	  
			}
			
			if(i==4 || i==11){
				usuario.setComplemento("Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde");
			}
			
			if(i==5 || i==12){
				usuario.setComplemento("Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou");
			}
			
			if(i==6 || i==13){
				usuario.setComplemento("Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer um livro de modelos de tipos. Lorem Ipsum sobreviveu não só a cinco séculos, como também ao salto para a");
			}
			
			funcoesCadastro.cadastroCompleto(driver, usuario, link, i);
			
			if(funcoesCadastro.errosValidacao(driver)){
				System.out.println("------Erro de validação dos campos com o campo Complemento: " + usuario.getComplemento());
			}
			
			/* --------------------Impressao de log----------------------*/
			if(funcoesCadastro.cadastroRealizado(driver)) {	
				
				funcoesMT.logCampoOK(driver, logger, nomeCampo, usuario.getComplemento());
				quantidadeAcertos++;
			}else {				  
					funcoesMT.logCampoErro(driver, logger, nomeCampo, usuario.getComplemento());
					quantidadeErros++;		
				}
			
			if(i==max){
				funcoesMT.logInformacoesExecucao(driver, logger, nomeCampo, quantidadeAcertos, quantidadeErros, acertosSemJS, errosSemJS, tempoInicio);
			}
			
			interacoesNavegador.AguardarCarregamento(driver);  
		i++;
		} 
	}		
}
