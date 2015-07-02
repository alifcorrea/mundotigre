package br.com.mundotigre.funcoesprincipais.cadastro;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

import br.com.mundotigre.objetos.Usuario;
import br.com.mundotigre.scripts.FuncoesCadastro;
import br.com.mundotigre.scripts.InteracoesNavegador;

public class CasoNovidades {

	 @Test 
	 public void testarNovidades(WebDriver driver, Usuario usuario, InteracoesNavegador interacoesNavegador, FuncoesCadastro funcoesCadastro){		 
		 System.out.println("\n-----------------------------Teste Novidades-------------------------------");
		 long tempoInicio = System.currentTimeMillis(); 
		 
		 String campo = "Novidades";
		 
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
			  
			  funcoesCadastro.cadastroCompleto(driver, usuario, "http://www.mundotigre.com.br/cadastro/new", i);
			  
			  if(funcoesCadastro.errosValidacao(driver)){
				  System.out.println("------Erro de validação dos campos com o campo "+campo+": " + valorCampo);
			  }
			  

			  /* --------------------Impressao de log----------------------*/
			  if(funcoesCadastro.cadastroRealizado(driver)) {	
				  
				  funcoesCadastro.logCampoOK(driver, campo, valorCampo);
					quantidadeAcertos++;
			
				  	}else {				  
						  funcoesCadastro.logCampoErro(driver, campo, valorCampo);
						  quantidadeErros++;		
				  	}
			  
			  if(i==max){
				  funcoesCadastro.logInformacoesExecucao(driver, campo, quantidadeAcertos, quantidadeErros, acertosSemJS, errosSemJS, tempoInicio);
			  }
		  
			  interacoesNavegador.AguardarCarregamento(driver);  
			  i++;
		} 
	}			
}
