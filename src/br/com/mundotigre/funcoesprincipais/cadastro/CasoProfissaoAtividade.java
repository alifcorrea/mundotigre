package br.com.mundotigre.funcoesprincipais.cadastro;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

import br.com.mundotigre.objetos.Usuario;
import br.com.mundotigre.scripts.FuncoesCadastro;
import br.com.mundotigre.scripts.InteracoesNavegador;

public class CasoProfissaoAtividade {
	
	 @Test 
	 public void testarProfissaoAtividade(WebDriver driver, Usuario usuario, InteracoesNavegador interacoesNavegador, FuncoesCadastro funcoesCadastro){
		 
       	  long tempoInicio = System.currentTimeMillis(); 		 
		  System.out.println("\n------------------------------Teste Profissao/Atividade--------------------------------");
		 
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
			  
			  funcoesCadastro.cadastroCompleto(driver, usuario, "http://www.mundotigre.com.br/cadastro/new", i);
			  
			  if(funcoesCadastro.errosValidacao(driver)){
				  System.out.println("------Erro de validação dos campos com o campo Profissao/Atividade: " + usuario.getProfissaoAtividade());
			  }
			  
			  /*--------------------Impressao de log----------------------*/
			  if(funcoesCadastro.cadastroRealizado(driver)) {
		
				  	funcoesCadastro.logCampoOK(driver, "Profissão/Atividade", usuario.getProfissaoAtividade());
					quantidadeAcertos++;
				
			  }else{
				  
				  	funcoesCadastro.logCampoErro(driver, "Profissão/Atividade", usuario.getProfissaoAtividade());
					quantidadeErros++;		
			  }
		
			  if(i==max){
				  funcoesCadastro.logInformacoesExecucao(driver, "Profissão/Atividade", quantidadeAcertos, quantidadeErros, acertosSemJS, errosSemJS, tempoInicio);
			} /*--------------------Fim Impressao de log----------------------*/	
		  
			i++;
		 } 
	 }
}
