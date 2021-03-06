package br.com.mundotigre.funcoesprincipais.cadastro;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import br.com.mundotigre.objetos.Usuario;
import br.com.mundotigre.scripts.FuncoesCadastro;
import br.com.mundotigre.scripts.FuncoesMT;
import br.com.mundotigre.scripts.InteracoesNavegador;

public class CasoProfissaoAtividade {
	
	@Test 
	public void testarProfissaoAtividade(WebDriver driver, Logger logger, Usuario usuario, String link, InteracoesNavegador interacoesNavegador, FuncoesMT funcoesMT, FuncoesCadastro funcoesCadastro){
		
		long tempoInicio = System.currentTimeMillis(); 
		String nomeCampo = "Profissao/Atividade";
		
		System.out.println("\n------------------------------Teste "+nomeCampo+"--------------------------------");
		
		int i = 0; 
		int max = 2;
		
		int quantidadeAcertos = 0;
		int quantidadeErros = 0;	
		int acertosSemJS = 0;
		int errosSemJS = 0;
		
		while(i<=max){
			
			if(i==0){
				usuario.setProfissaoAtividade("");
			}
			
			if(i==1){
				usuario.setProfissaoAtividade("4");
			}
			  
			if(i==2){
				usuario.setProfissaoAtividade("39");
			}
			
			if(i==3){
				usuario.setProfissaoAtividade("99");
			}			  
			  
			funcoesCadastro.cadastroCompleto(driver, usuario, link, i);
			
			if(funcoesCadastro.errosValidacao(driver)){
				System.out.println("------Erro de valida��o dos campos com o campo Profissao/Atividade: " + usuario.getProfissaoAtividade());
			}
			
			/*--------------------Impressao de log----------------------*/
			if(funcoesCadastro.cadastroRealizado(driver)) {
				
				funcoesMT.logCampoOK(driver, logger, nomeCampo, usuario.getProfissaoAtividade());
				quantidadeAcertos++;
				
			}else{
				
					funcoesMT.logCampoErro(driver, logger, nomeCampo,  usuario.getProfissaoAtividade());
					quantidadeErros++;		
				}
		
			if(i==max){
				funcoesMT.logInformacoesExecucao(driver, logger, nomeCampo, quantidadeAcertos, quantidadeErros, acertosSemJS, errosSemJS, tempoInicio);
			} /*--------------------Fim Impressao de log----------------------*/	
		i++;
		} 
	}
}