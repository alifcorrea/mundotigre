package br.com.mundotigre.scripts;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.mundotigre.objetos.Usuario;


public class FuncoesCadastro {

/*################################################################################# INTERACAO COM ELEMENTOS #############################################################################################*/
	
	@Test
	public void botaoCadastro(WebDriver driver){
		
		driver.findElement(By.xpath("//*[@value='Cadastrar']")).click();
	}
	
	
	@Test
	public void clicarBotaoCadastreSe(WebDriver driver){
		
		driver.findElement(By.xpath("//*[@href='/cadastro/new']")).click();
	}
	
	
	@Test
	public void fecharBanner(WebDriver driver){
		
		driver.findElement(By.xpath("//*[@class='fancybox-item fancybox-close close-palpite']")).click();
	}
	
	
	@Test
	public void botaoParticiparBanner(WebDriver driver){
		
		driver.findElement(By.xpath("//*[@class='fancybox-image']")).click();
	}
	
	
	@Test
	public void marcarAtividadesFisicas(WebDriver driver){
		
		InteracoesNavegador funcoes =  new InteracoesNavegador();
		
		funcoes.marcarCheckboxPorCssSelector(driver, "input[id='mundo_tigre_atividade_fisica_list_5']");
		funcoes.marcarCheckboxPorCssSelector(driver, "input[id='mundo_tigre_atividade_fisica_list_3']");
		funcoes.marcarCheckboxPorCssSelector(driver, "input[id='mundo_tigre_atividade_fisica_list_4']");
		funcoes.marcarCheckboxPorCssSelector(driver, "input[id='mundo_tigre_atividade_fisica_list_6']");
		funcoes.marcarCheckboxPorCssSelector(driver, "input[id='mundo_tigre_atividade_fisica_list_1']");
		funcoes.marcarCheckboxPorCssSelector(driver, "input[id='mundo_tigre_atividade_fisica_list_8']");
		funcoes.marcarCheckboxPorCssSelector(driver, "input[id='mundo_tigre_atividade_fisica_list_13']");
		funcoes.marcarCheckboxPorID(driver, "mundo_tigre_atividade_fisica_list_12");
		funcoes.marcarCheckboxPorID(driver, "mundo_tigre_atividade_fisica_list_7");
		funcoes.marcarCheckboxPorID(driver, "mundo_tigre_atividade_fisica_list_2");
	}
	
	
	@Test
	public void receberNovidades(WebDriver driver){
		
		InteracoesNavegador funcoes =  new InteracoesNavegador();
		funcoes.clicarCampoPorID(driver, "cadastro-novidade");
	}
	
	
	@Test
	public void receberSms(WebDriver driver){
		
		InteracoesNavegador funcoes =  new InteracoesNavegador();
		funcoes.clicarCampoPorID(driver, "cadastro-sms");  
	}
	
	
	@Test
	public void marcarAreasInteresse(WebDriver driver){
		
		InteracoesNavegador funcoes =  new InteracoesNavegador();
		
		funcoes.marcarCheckboxPorID(driver, "mundo_tigre_area_interesse_list_1");
		funcoes.marcarCheckboxPorID(driver, "mundo_tigre_area_interesse_list_14");
		funcoes.marcarCheckboxPorID(driver, "mundo_tigre_area_interesse_list_2");  
		funcoes.marcarCheckboxPorID(driver, "mundo_tigre_area_interesse_list_3");
	}
	
	
/*###################################################################################### VALIDACAO URL's ###############################################################################################*/	
	
	@Test
	public boolean cadastroRealizado(WebDriver driver){
		
		String URLAtual = driver.getCurrentUrl();			
		
		if(URLAtual.contains("/confirmacao") || URLAtual.contains("cadastro/confirmacao")){	
			driver.navigate().back();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 			
			return true;
		}
		
		return false;
	}
	
	
	@Test
	public boolean passouCadastroCompleto(WebDriver driver){
		
		String URLAtual = driver.getCurrentUrl();			
		
		if(URLAtual.contains("http://www.mundotigre.com.br/cadastro?cpf") || URLAtual.contains("/cadastro/confirmacao/")){
			driver.navigate().back();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 			
 			return true;
		}
		
		return false;
	}
	
	
	@Test
	public boolean errosValidacao(WebDriver driver){
		
		String URLAtual = driver.getCurrentUrl();			
		
		if(URLAtual.contains("/create")){
			driver.navigate().back();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			return true;
		}
		
		return false;
	}
	
	
/*###################################################################################### DADOS CADASTRO ################################################################################################*/	
	
	@Test
	public void cadastroCompleto(WebDriver driver, Usuario usuario, String link, int counter){		
			  
	  InteracoesNavegador funcoes = new InteracoesNavegador();
	  FuncoesMT funcoesMT = new FuncoesMT();

	  String email = funcoesMT.caracteresAleatorios()+counter+"@teste.com.br";
	  String cpf = funcoesMT.numerosAleatorios();
	  
	  funcoes.abrirLink(driver, link);
	  funcoes.AguardarCarregamento(driver);	
	  
	  funcoes.clicarESetarPorID(driver, "login-cpf", cpf);	
	  funcoes.clicarESetarPorID(driver, "login-senha", email);	  
	  funcoes.clicarCampoPorXpath(driver, "//*[@value='Cadastrar']");			  
	  
	  //Se o CPF ou email j� estiver cadastrado, retorna e tenta outro
	  funcoes.AguardarCarregamento(driver);
	  cadastroRealizado(driver);
	  
	  funcoes.clicarESetarPorNome(driver, "mundo_tigre[mtg_nome]", usuario.getNome());
	  funcoes.clicarESetarPorID(driver, "cadastro-nascimento", "22/11/1994");	  
	  funcoes.campoSelectValuePorID(driver, "cadastro-sexo",usuario.getSexo()); 
	  funcoes.campoSelectValuePorID(driver,"mundo_tigre_mtg_id_prs", usuario.getProfissaoAtividade());	 	  
	  funcoes.AguardarCarregamento(driver);		  
	  funcoes.campoSelectValuePorID(driver, "cadastro-atuacao", usuario.getTempoAtuacao()); 
	  funcoes.clicarESetarPorID(driver, "cadastro-telefone-ddd", usuario.getDDD()); 
	  funcoes.clicarESetarPorID(driver, "cadastro-telefone", usuario.getTelefone()); 
	  funcoes.clicarESetarPorID(driver,"cadastro-celular-ddd", usuario.getDDD());
	  funcoes.clicarESetarPorID(driver, "cadastro-celular", usuario.getCelular());			 
	  
	  
	 /*------------------ Dados residenciais-----------------------*/	
	  funcoes.clicarESetarPorID(driver,"cadastro-cep", "89235735222");
	  funcoes.clicarESetarPorID(driver,"cadastro-endereco", "Rua cidade de Maracaj�"); 
	  funcoes.clicarESetarPorID(driver,"cadastro-numero", usuario.getNumero());
	  funcoes.clicarESetarPorID(driver,"cadastro-complemento", usuario.getEndereco()); 
	  funcoes.campoSelectValuePorID(driver,"mundo_tigre_mtg_id_est", usuario.getEstado());		  
	  funcoes.AguardarCarregamento(driver);	
	  funcoes.campoSelectValuePorID(driver, "mundo_tigre_mtg_cidade", usuario.getCidade()); 
	  funcoes.clicarESetarPorID(driver,"cadastro-bairro", usuario.getBairro());
	  
	  
	 /*---------------Empresa em que trabalha ou costuma comprar produtos Tigre------------*/	
	  funcoes.campoSelectValuePorID(driver, "mundo_tigre_mtg_id_est_emp", usuario.getEstado());	  
	  funcoes.AguardarCarregamento(driver);	  
	  funcoes.campoSelectValuePorID(driver,"mundo_tigre_mtg_cidade_emp", usuario.getCidade());	  
	  funcoes.AguardarCarregamento(driver);	  
	  funcoes.campoSelectValuePorID(driver, "mundo_tigre_mtg_cnpj_emp", usuario.getEmpresa());	  	  
	  funcoes.campoSelectValuePorID(driver, "cadastro-mtg_trabalha_empresa", usuario.getTrabalhaEmpresa());
	  
	  
	  /*-----------------------Atividade f�sica/esportiva------------------------*/	
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
	  
	  System.out.println("------CPF: " + usuario.getCpf());
	  System.out.println("------Email: " + usuario.getEmail());
	  System.out.println("------Senha: " + usuario.getSenha());
	  funcoes.AguardarCarregamento(driver);  
	} 	
}
