package br.com.mundotigre.funcoesprincipais.cadastro;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

import br.com.mundotigre.objetos.Usuario;
import br.com.mundotigre.scripts.FuncoesCadastro;
import br.com.mundotigre.scripts.InteracoesNavegador;

public class CasoTrabalhaEmpresa {

	 @Test 
	 public void testarTrabalhaEmpresa(WebDriver driver, Usuario usuario, InteracoesNavegador interacoesNavegador, FuncoesCadastro funcoesCadastro){		 
		 System.out.println("\n-----------------------------Teste Trabalha Empresa-------------------------------");
		 long tempoInicio = System.currentTimeMillis(); 
		 
		 String campo = "Trabalha Empresa";
		 
		  int i = 0; 
		  int max = 2;	

		  int quantidadeAcertos = 0;
		  int quantidadeErros = 0;	
		  int acertosSemJS = 0;
		  int errosSemJS = 0;	
		  
		  while(i<=max){				  
			
					 
			  if(i==0){
				  usuario.setEstado("24");
				  usuario.setCidade("420910");
				  usuario.setEmpresa("0030946290001");
				  usuario.setTrabalhaEmpresa("");
			  }
			  
			  if(i==1){
				  usuario.setEstado("24");
				  usuario.setCidade("420910");
				  usuario.setEmpresa("0030946290001");
				  usuario.setTrabalhaEmpresa("1");
			  }
			  
			  if(i==2){
				  usuario.setEstado("24");
				  usuario.setCidade("420910");
				  usuario.setEmpresa("0030946290001");
				  usuario.setTrabalhaEmpresa("0");
			  }
			  
			  String valorCampo = usuario.getTrabalhaEmpresa();
			  
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
