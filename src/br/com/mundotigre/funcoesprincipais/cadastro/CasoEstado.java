package br.com.mundotigre.funcoesprincipais.cadastro;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

import br.com.mundotigre.objetos.Usuario;
import br.com.mundotigre.scripts.FuncoesCadastro;
import br.com.mundotigre.scripts.InteracoesNavegador;

public class CasoEstado {
	
	 @Test 
	 public void testarEstado(WebDriver driver, Usuario usuario, InteracoesNavegador interacoesNavegador, FuncoesCadastro funcoesCadastro){	
		 System.out.println("\n-----------------------------Teste Estado-------------------------------");
		 long tempoInicio = System.currentTimeMillis(); 	
		 
		  String campo = "Estado";
		  String valorCampo = usuario.getEstado();	

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
