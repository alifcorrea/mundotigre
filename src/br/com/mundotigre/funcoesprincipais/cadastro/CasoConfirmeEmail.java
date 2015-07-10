package br.com.mundotigre.funcoesprincipais.cadastro;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import br.com.mundotigre.objetos.Usuario;
import br.com.mundotigre.scripts.FuncoesCadastro;
import br.com.mundotigre.scripts.FuncoesMT;
import br.com.mundotigre.scripts.InteracoesNavegador;

public class CasoConfirmeEmail {
	
//############################################################################################## CONFIGURACOES INICIAIS #################################################################################//		

	 @Test 
	 public void testarConfirmeEmail(WebDriver driver, Logger logger, Usuario usuario, String link, InteracoesNavegador interacoesNavegador, FuncoesMT funcoesMT, FuncoesCadastro funcoesCadastro){		 
		 
		long tempoInicio = System.currentTimeMillis(); 
		String nomeCampo = "Confirme Email";
		String valorCampo = usuario.getConfirmaEmail();
		
		int i = 0; 
		int max = 1;	

		int quantidadeAcertos = 0;
		int quantidadeErros = 0;	
		int acertosSemJS = 0;
		int errosSemJS = 0;	
		
		
//################################################################################################ INICIO DA EXECUCAO ###################################################################################//	

		funcoesMT.logInicio(driver, logger, nomeCampo);

		while(i<=max){				  
			
			if(i==17){
				
				interacoesNavegador.desativarJSFirefox(driver, logger, nomeCampo);
				System.out.println("\n-----------------"+nomeCampo+ "com Javascript desabilitado--------------------");
			}
			
			
//################################################################################################## VALORES DO TESTE ###################################################################################//	
					 
			if(i == 0 || i == 17) {
				
				usuario.setConfirmaEmail("");
			}
	
			if (i == 1 || i == 18) {
				
				usuario.setConfirmaEmail("nome@mail");
			}
	
			if (i == 2 || i == 19) {
				
				usuario.setConfirmaEmail("nome@mail.com");
			}
	
			if (i == 3 || i == 20) {
				
				usuario.setConfirmaEmail("nome_!$#%@mail.com");
			}
	
			if (i == 4 || i == 21) {
				
				usuario.setConfirmaEmail("nome.sobrenome@mail");
			}
	
			if (i == 5 || i == 22) {
				
				usuario.setConfirmaEmail("nome.sobrenome@mail.com");
			}
	
			if (i == 6 || i == 23) {
				
				usuario.setConfirmaEmail("nome.sobrenome123@mail.com");
			}
	
			if (i == 7 || i == 24) {
				
				usuario.setConfirmaEmail("nome.sobrenome@mail.com.br");
			}
	
			if (i == 8 || i == 25) {
				
				usuario.setConfirmaEmail("nome_sobrenome@mail");
			}
	
			if (i == 9 || i == 26) {
				
				usuario.setConfirmaEmail("nome_sobrenome@mail.com");
			}
	
			if (i == 10 || i == 27) {
				
				usuario.setConfirmaEmail("nome_sobrenome123@mail.com");
			}
	
			if (i == 11 || i == 28) {
				
				usuario.setConfirmaEmail("nome_sobrenome@mail.com.br");
			}
	
			if (i == 12 || i == 29) {
				
				usuario.setConfirmaEmail("nome_sobrenome_outrosobrenome@mail");
			}
	
			if (i == 13 || i == 30) {
				
				usuario.setConfirmaEmail("nome_sobrenome_outrosobrenome@mail.com");
			}
	
			if (i == 14 || i == 31) {
				
				usuario.setConfirmaEmail("nome_sobrenome1!@23_outrosobrenome@mail.com");
			}
	
			if (i == 15 || i == 32) {
				
				usuario.setConfirmaEmail("nome_sobrenome_outrosobrenome@mail.com.br");
			}
	
			if (i == 16 || i == 33) {
				
				usuario.setConfirmaEmail("nome_sobrenom!@e_outr¨&$%osobrenome@mail.com.br");
			}
	
			funcoesCadastro.cadastroCompleto(driver, usuario, link, i);
			  
			if(funcoesCadastro.errosValidacao(driver)){
				System.out.println("------Erro de validação dos campos com o campo "+nomeCampo+": " + valorCampo);
			}


//################################################################################################## IMPRESSAO DE lOG ###################################################################################//	

			if(funcoesCadastro.cadastroRealizado(driver)) {	
				
				funcoesMT.logCampoOK(driver,logger, nomeCampo, valorCampo);
				quantidadeAcertos++;
			}else{				  
					funcoesMT.logCampoErro(driver, logger, nomeCampo, valorCampo);
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
