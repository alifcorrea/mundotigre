package br.com.mundotigre.funcoesprincipais.cadastro;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import br.com.mundotigre.objetos.Usuario;
import br.com.mundotigre.scripts.FuncoesCadastro;
import br.com.mundotigre.scripts.InteracoesNavegador;

public class CasoDataNascimento {

	public InteracoesNavegador funcoes;
	public FuncoesCadastro funcoesCadastro;


	@Before
	public void Inicio() {
		funcoes = new InteracoesNavegador();
		funcoesCadastro = new FuncoesCadastro();
	}
	
	@Test 
	 public void testarDataNascimento(WebDriver driver, Usuario usuario){ 
		
		  long tempoInicio = System.currentTimeMillis(); 
		  System.out.println("\n-----------------------------Teste Data de Nascimento-------------------------------");
				 
		  int i = 0; 
		  int max = 13;
		  
		  int quantidadeAcertos = 0;
		  int quantidadeErros = 0;		
		  int acertosSemJS = 0;
		  int errosSemJS = 0;		
	  
		  while(i<=max){
			  			
			  //Desativa Javascript
			  if(i==7) {
				FirefoxProfile profile = new FirefoxProfile();
				profile.setPreference("browser.download.folderList", 2);
				profile.setPreference("javascript.enabled", false);
				driver = new FirefoxDriver(profile);
				System.out.println("\n------------------Data de Nascimento com Javascript desabilitado--------------------");
			  }
			  
			  funcoes.abrirLink(driver, "http://www.mundotigre.com.br/cadastro/new");
			  funcoes.AguardarCarregamento(driver);	  
			  funcoes.clicarESetarPorID(driver, "login-cpf", usuario.getCpf());
			  funcoes.clicarESetarPorID(driver, "login-senha", usuario.getEmail());
			  funcoes.clicarCampoPorXpath(driver, "//*[@value='Cadastrar']");	
			  
			  funcoes.AguardarCarregamento(driver);
			  
			  if(funcoesCadastro.CadastroJaRealizado(driver)){
				  i++;	
				  funcoes.clicarESetarPorID(driver, "login-cpf", usuario.getCpf());
				  funcoes.clicarESetarPorID(driver, "login-senha", usuario.getEmail());
				  funcoes.clicarCampoPorXpath(driver, "//*[@value='Cadastrar']");	
			  }

			  funcoes.AguardarCarregamento(driver);
			  
			  funcoes.clicarESetarPorID(driver, "cadastro-nome", usuario.getNome());
			  
			  if(i==0 || i==7){ 
				  usuario.setDataNascimento("");
			  }
			  
			  if(i==1 || i==8){
				  usuario.setDataNascimento("35/02/2015");
			  } 
			  
			  if(i==2 || i==9){
				  usuario.setDataNascimento("02/35/2015");
			  } 
			  
			  if(i==3 || i==10){
				  usuario.setDataNascimento("02/35/0918");
			  } 
			  
			  if(i==4 || i==11){
				  usuario.setDataNascimento("15/02/1900");
				  driver.findElement(By.id("cadastro-nascimento")).sendKeys();
			  }
			  
			  if(i==5 || i==12){
				  usuario.setDataNascimento("13/02/2015");
			  } 
			  
			  if(i==6 || i==13){
				  usuario.setDataNascimento("26/12/2015");
			  }

			  funcoes.clicarESetarPorID(driver, "cadastro-nascimento", usuario.getDataNascimento());
			  funcoes.campoSelectValuePorID(driver, "cadastro-sexo", usuario.getSexo());
			  funcoes.campoSelectValuePorID(driver, "mundo_tigre_mtg_id_prs", usuario.getProfissaoAtividade());
			  funcoes.campoSelectValuePorID(driver, "cadastro-atuacao", usuario.getTempoAtuacao());
			  funcoes.clicarESetarPorID(driver, "cadastro-telefone-ddd", usuario.getDDD());
			  funcoes.clicarESetarPorID(driver, "cadastro-telefone", usuario.getTelefone());
			  funcoes.clicarESetarPorID(driver, "cadastro-celular-ddd", usuario.getDDD());
			  funcoes.clicarESetarPorID(driver, "cadastro-celular", usuario.getCelular());
			  
			  /*------------------ Dados residenciais-----------------------*/	
			  funcoes.clicarESetarPorID(driver,"cadastro-cep", "89235735222");
			  funcoes.clicarESetarPorID(driver,"cadastro-endereco", "Rua cidade de Maracajá"); 
			  funcoes.clicarESetarPorID(driver,"cadastro-numero", usuario.getNumero());
			  funcoes.clicarESetarPorID(driver,"cadastro-complemento", usuario.getEndereco()); 
			  funcoes.campoSelectIndexPorID(driver,"mundo_tigre_mtg_id_est", usuario.getEstado());	  
			  funcoes.AguardarCarregamento(driver);	  
			  funcoes.campoSelectValuePorID(driver, "mundo_tigre_mtg_cidade", usuario.getCidade()); 
			  funcoes.clicarESetarPorID(driver,"cadastro-bairro", usuario.getBairro());
			  
			  
			 /*---------------Empresa em que trabalha ou costuma comprar produtos Tigre------------*/	
			  funcoes.campoSelectIndexPorID(driver, "mundo_tigre_mtg_id_est_emp", usuario.getEstado());
			  funcoes.AguardarCarregamento(driver);
			  funcoes.campoSelectValuePorID(driver,"mundo_tigre_mtg_cidade_emp", usuario.getCidade());
			  funcoes.AguardarCarregamento(driver); 	  
			  funcoes.campoSelectValuePorID(driver, "mundo_tigre_mtg_cnpj_emp", usuario.getEmpresa());	  	  
			  funcoes.campoSelectIndexPorID(driver, "cadastro-mtg_trabalha_empresa", usuario.getTrabalhaEmpresa());
			  
			  
			  /*-----------------------Atividade física/esportiva------------------------*/	
			  funcoes.marcarCheckboxPorCssSelector(driver,"input[id='mundo_tigre_atividade_fisica_list_5']");
			  funcoes.marcarCheckboxPorCssSelector(driver,"input[id='mundo_tigre_atividade_fisica_list_3']");
			  funcoes.marcarCheckboxPorCssSelector(driver,"input[id='mundo_tigre_atividade_fisica_list_4']");
			  funcoes.marcarCheckboxPorCssSelector(driver,"input[id='mundo_tigre_atividade_fisica_list_6']");
			  funcoes.marcarCheckboxPorCssSelector(driver,"input[id='mundo_tigre_atividade_fisica_list_1']");
			  funcoes.marcarCheckboxPorCssSelector(driver,"input[id='mundo_tigre_atividade_fisica_list_8']");
			  funcoes.marcarCheckboxPorCssSelector(driver,"input[id='mundo_tigre_atividade_fisica_list_13']");
			  funcoes.marcarCheckboxPorID(driver,"mundo_tigre_atividade_fisica_list_12");
			  funcoes.marcarCheckboxPorID(driver,"mundo_tigre_atividade_fisica_list_7");
			  funcoes.marcarCheckboxPorID(driver,"mundo_tigre_atividade_fisica_list_2");	  
			  funcoes.campoSelectValuePorID(driver,"cadastro-mtg_time_coracao", usuario.getTimeCoracao());
			  funcoes.clicarCampoPorID(driver,"cadastro-novidade"); 
			  funcoes.clicarCampoPorID(driver, "cadastro-sms");	  
			  funcoes.marcarCheckboxPorID(driver, "mundo_tigre_area_interesse_list_1");
			  funcoes.marcarCheckboxPorID(driver, "mundo_tigre_area_interesse_list_14");
			  funcoes.marcarCheckboxPorID(driver, "mundo_tigre_area_interesse_list_2");
			  funcoes.marcarCheckboxPorID(driver, "mundo_tigre_area_interesse_list_3");	  
			  funcoes.clicarESetarPorID(driver, "email-confirme", usuario.getEmail());
			  funcoes.clicarESetarPorID(driver, "cadastro-senha", usuario.getSenha());
			  funcoes.clicarESetarPorID(driver, "cadastro-senha-confirme", usuario.getConfirmaSenha());	  
			  funcoes.clicarCampoPorCssSelector(driver, ".submit");
			  
			  if(funcoesCadastro.errosValidacao(driver)){
				  System.out.println("------Erro de validação dos campos com a data de nascimento: " + usuario.getDataNascimento());
			  }
			  
			  /*--------------------Impressao de log----------------------*/
			  if(funcoesCadastro.CadastroJaRealizado(driver)) {
		
				  funcoesCadastro.logCampoOK(driver, "Data de Nascimento", usuario.getDataNascimento());
			
					if(i<=6) {
						quantidadeAcertos++;
					}
		
					if(i>6) {
						acertosSemJS++;
					}
		
			  }else {
				  
				  	funcoesCadastro.logCampoErro(driver, "Data de Nascimento", usuario.getDataNascimento());
					
					if(i<=6) {
						quantidadeErros++;
					}		
					
					if(i>6) {
						errosSemJS++;
					}
			  }
		
			if(i==max) {
				 funcoesCadastro.logInformacoesExecucao(driver, "Data de Nascimeto", quantidadeAcertos, quantidadeErros, acertosSemJS, errosSemJS, tempoInicio);
				 driver.close();
			
			}
		  
			funcoes.AguardarCarregamento(driver);			  
		  i++;
		 } 
	}	  
}	