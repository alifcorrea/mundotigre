package br.com.mundotigre.funcoesprincipais.cadastro;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import br.com.mundotigre.objetos.Usuario;
import br.com.mundotigre.scripts.FuncoesCadastro;
import br.com.mundotigre.scripts.InteracoesNavegador;

public class CasoDDD {
	
	public InteracoesNavegador funcoes;
	public FuncoesCadastro funcoesCadastro;

	@Before
	public void Inicio() {
		funcoes = new InteracoesNavegador();
		funcoesCadastro = new FuncoesCadastro();	
	}
	
	 @Test 
	 public void testarDDD(WebDriver driver, Usuario usuario){		 
		 
		  long tempoInicio = System.currentTimeMillis(); 		 
		  System.out.println("\n-----------------------------Teste DDD-------------------------------");
		 
		  int i = 0; 
		  int max = 7;	

		  int quantidadeAcertos = 0;
		  int quantidadeErros = 0;	
		  int acertosSemJS = 0;
		  int errosSemJS = 0;	
		  
		  while(i<=max){	
			  
			  String cpf = usuario.getCpf()+i;
			  String email = usuario.getEmail()+i+"@teste.com.br";
			  
			  if (i == 6) {
					FirefoxProfile profile = new FirefoxProfile();
					profile.setPreference("javascript.enabled", false);
					driver = new FirefoxDriver(profile);
					System.out.println("\n------------------DDD com Javascript desabilitado--------------------");
				}
			  
			  funcoes.abrirLink(driver, "http://www.mundotigre.com.br/cadastro/new");
			  funcoes.AguardarCarregamento(driver);	  
			  funcoes.clicarESetarPorID(driver, "login-cpf", cpf);
			  funcoes.clicarESetarPorID(driver, "login-senha", email);
			  funcoes.clicarCampoPorXpath(driver, "//*[@value='Cadastrar']");			  
			  
			  //Se o CPF ou email já estiver cadastrado, retorna e tenta outro
			  funcoes.AguardarCarregamento(driver);
			  if(funcoesCadastro.CadastroJaRealizado(driver));

			  funcoes.clicarESetarPorNome(driver, "mundo_tigre[mtg_nome]", usuario.getNome());
			  funcoes.clicarESetarPorID(driver, "cadastro-nascimento", "22/11/1994");	  
			  funcoes.campoSelectValuePorID(driver, "cadastro-sexo",usuario.getSexo()); 
			  funcoes.campoSelectValuePorID(driver,"mundo_tigre_mtg_id_prs", usuario.getProfissaoAtividade());	  
			  funcoes.AguardarCarregamento(driver);	   
			  funcoes.campoSelectValuePorID(driver, "cadastro-atuacao", usuario.getTempoAtuacao());
			  
			  if(i==0 || i==6){
				  usuario.setDDD("");
			  }
			  
			  if(i==1 || i==7){
				  usuario.setDDD("4");
			  }
			  
			  if(i==2 || i==8){
				  usuario.setDDD("47");
			  }
			  
			  if(i==3 || i==9){
				  usuario.setDDD("479");	  
			  }			  
			
			  if(i==4 || i==10){
				  usuario.setDDD("te");
			  }
			
			  if(i==5 || i==11){
				  usuario.setDDD("#$%");
			  }
			  
			  funcoes.clicarESetarPorID(driver, "cadastro-telefone-ddd", usuario.getDDD()); 
			  funcoes.clicarESetarPorID(driver, "cadastro-telefone", usuario.getTelefone()); 
			  funcoes.clicarESetarPorID(driver,"cadastro-celular-ddd", usuario.getDDD());
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
			  funcoes.clicarESetarPorID(driver, "email-confirme", email);
			  funcoes.clicarESetarPorID(driver, "cadastro-senha", usuario.getSenha());
			  funcoes.clicarESetarPorID(driver, "cadastro-senha-confirme", usuario.getConfirmaSenha());	  
			  funcoes.clicarCampoPorCssSelector(driver, ".submit");
			  
			  if(funcoesCadastro.errosValidacao(driver)){
				  System.out.println("------Erro de validação dos campos com o campo DDD: " + usuario.getDDD());
			  }
			  
			  /*--------------------Impressao de log----------------------*/
			  if(funcoesCadastro.CadastroJaRealizado(driver)) {	
				  
				  funcoesCadastro.logCampoOK(driver, "DDD", usuario.getDDD());
					quantidadeAcertos++;
		
			  }else {				  
				  funcoesCadastro.logCampoErro(driver, "DDD", usuario.getDDD());
					quantidadeErros++;
			  }
			  
			  if(i==max){
				  funcoesCadastro.logInformacoesExecucao(driver, "DDD", quantidadeAcertos, quantidadeErros, acertosSemJS, errosSemJS, tempoInicio);
			  }
		  
			funcoes.AguardarCarregamento(driver);  
			i++;
		 } 
	 }	
}
