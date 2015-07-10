package br.com.mundotigre.funcoesprincipais.cadastro;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import br.com.mundotigre.objetos.Usuario;
import br.com.mundotigre.scripts.FuncoesCadastro;
import br.com.mundotigre.scripts.InteracoesNavegador;

public class CasoEstado {
	
	 @Test 
	 public void testarEstado(WebDriver driver, Logger logger, Usuario usuario, String link, InteracoesNavegador interacoesNavegador, FuncoesCadastro funcoesCadastro){	
		
		 long tempoInicio = System.currentTimeMillis();
		 
		 String nomeCampo = "Estado";
		 String valorCampo = usuario.getEstado();	
		 
		 System.out.println("\n-----------------------------Teste "+nomeCampo+"-------------------------------");
		 

		  int quantidadeAcertos = 0;
		  int quantidadeErros = 0;	
		  int acertosSemJS = 0;
		  int errosSemJS = 0;	
		  
		  int i = 0; 
		  int max = 2;	
		  
		  while(i<=max){				  
					 
			  if(i==0){
				  usuario.setEstado("");
				  usuario.setCidade("");
				  usuario.setEmpresa("");
			  }
			  
			  if(i==1){
				  usuario.setEstado("28");
			  }
			  
			  if(i==2){
				  usuario.setEstado("23");
				  usuario.setCidade("430047");
				  usuario.setEmpresa("-1");
			  }		  
			  
			  funcoesCadastro.cadastroCompleto(driver, usuario, link, i);
			  
			  if(funcoesCadastro.errosValidacao(driver)){
				  System.out.println("------Erro de validação dos campos com o campo "+nomeCampo+": " + valorCampo);
			  }
			  

			  /* --------------------Impressao de log----------------------*/
			  if(funcoesCadastro.cadastroRealizado(driver)) {	
				  
				  funcoesCadastro.logCampoOK(driver, logger, nomeCampo, valorCampo);
				  quantidadeAcertos++;

				  	}else {				  
						  funcoesCadastro.logCampoErro(driver, logger, nomeCampo, valorCampo);
						  quantidadeErros++;		
				  	}
			  
			  if(i==max){
				  funcoesCadastro.logInformacoesExecucao(driver, logger, nomeCampo, quantidadeAcertos, quantidadeErros, acertosSemJS, errosSemJS, tempoInicio);
			  }
		  
			  interacoesNavegador.AguardarCarregamento(driver);  
			  i++;
		} 
	}		
}
