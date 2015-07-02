package br.com.mundotigre.funcoesprincipais.cadastro;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

import br.com.mundotigre.objetos.Usuario;
import br.com.mundotigre.scripts.FuncoesCadastro;
import br.com.mundotigre.scripts.InteracoesNavegador;

public class CasoProfissaoDetalhe {
		
	 @Test 
	 public void testarProfissaoDetalhe(WebDriver driver, Usuario usuario, InteracoesNavegador interacoesNavegador, FuncoesCadastro funcoesCadastro){
		 
       	  long tempoInicio = System.currentTimeMillis(); 		 
		  System.out.println("\n------------------------------Teste Profissao/Detalhe--------------------------------");
		 
		  int i = 0; 
		  int max = 1;
		  
		  int quantidadeAcertos = 0;
		  int quantidadeErros = 0;	
		  int acertosSemJS = 0;
		  int errosSemJS = 0;
		  
		  while(i<=max){
			  		  
			  if(i==0){
				  usuario.setProfissaoDetalhe("");
			  } 
			  
			  if(i==1){
				  usuario.setProfissaoDetalhe("13");
			  }
			  
			  funcoesCadastro.cadastroCompleto(driver, usuario, "http://www.mundotigre.com.br/cadastro/new", i);			
			
			  if(funcoesCadastro.errosValidacao(driver)){
				  System.out.println("------Erro de validação dos campos com o campo Profissao/Atividade: " + usuario.getProfissaoDetalhe());
			  }
			  
			  /*--------------------Impressao de log----------------------*/
			  if(funcoesCadastro.cadastroRealizado(driver)) {
		
				  funcoesCadastro.logCampoOK(driver, "Profissão/Detalhe", usuario.getProfissaoDetalhe());
					quantidadeAcertos++;
				
			  }else{
				  funcoesCadastro.logCampoErro(driver, "Profissão/Detalhe", usuario.getProfissaoDetalhe());
					quantidadeErros++;		
			  }
		
			  if(i==max){
				  funcoesCadastro.logInformacoesExecucao(driver, "Nome", quantidadeAcertos, quantidadeErros, acertosSemJS, errosSemJS, tempoInicio);
			} /*--------------------Fim Impressao de log----------------------*/	
			
			i++;
		 } 
	 }
}
