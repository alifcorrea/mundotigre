package br.com.mundotigre.funcoesprincipais.cadastro;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import br.com.mundotigre.objetos.Usuario;
import br.com.mundotigre.scripts.FuncoesCadastro;
import br.com.mundotigre.scripts.FuncoesMT;
import br.com.mundotigre.scripts.InteracoesNavegador;

public class CasoNovidades {

	@Test 
	public void testarNovidades(WebDriver driver, Logger logger, Usuario usuario, String link, InteracoesNavegador interacoesNavegador, FuncoesMT funcoesMT, FuncoesCadastro funcoesCadastro){		 
		
		long tempoInicio = System.currentTimeMillis(); 
		String nomeCampo = "Novidades";
		
		System.out.println("\n-----------------------------Teste "+nomeCampo+"-------------------------------");
		
		int i = 0; 
		int max = 1;	
		
		int quantidadeAcertos = 0;
		int quantidadeErros = 0;	
		int acertosSemJS = 0;
		int errosSemJS = 0;	
		
		while(i<=max){
			
			
			if(i==0){
				usuario.setNovidades("");
			}
			
			if(i==1){
				usuario.setNovidades("1");
			}
			
			
			String valorCampo = usuario.getNovidades();
			
			funcoesCadastro.cadastroCompleto(driver, usuario, link, i);
			
			if(funcoesCadastro.errosValidacao(driver)){
				System.out.println("------Erro de validação dos campos com o campo "+nomeCampo+": " + valorCampo);
			}
			
			
			/* --------------------Impressao de log----------------------*/
			if(funcoesCadastro.cadastroRealizado(driver)) {	
				
				funcoesMT.logCampoOK(driver, logger, nomeCampo, valorCampo);
				quantidadeAcertos++;
			}else {				  
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