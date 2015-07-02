package br.com.mundotigre.scripts;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.mundotigre.funcoesprincipais.cadastro.CasoAreaDesejaReceberInfo;
import br.com.mundotigre.objetos.Usuario;


public class FuncoesCadastro {

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
	
	@Test
	public boolean cadastroRealizado(WebDriver driver){
		
		//Se a URLAtual contem o texto abaixo, retorna ate a página anterior para a proxima execução
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
		
		//Se a URLAtual contem o texto abaixo, retorna ate a página anterior para a proxima execução
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
		
		//Se a URLAtual contem o texto abaixo, retorna ate a página anterior para a proxima execução
		String URLAtual = driver.getCurrentUrl();			
		
		if(URLAtual.contains("/create")){
			driver.navigate().back();
			return true;
		}
		return false;
	}
	
	
	@Test
	public void logCampoOK(WebDriver driver, String nomeCampo, String valorCampo){
		
		System.out.println("Teste "+ nomeCampo +" [+OK]: " + valorCampo);
	}
	
	
	@Test
	public void logCampoErro(WebDriver driver, String nomeCampo, String valorCampo){
		
		System.out.println("Teste "+ nomeCampo +" [-ERRO]: " + valorCampo);
	}
	
	
	
	@Test
	public void cadastroCompleto(WebDriver driver, Usuario usuario, String link, int contador){		
			  
			  InteracoesNavegador funcoes = new InteracoesNavegador();
		
			  String email = caracteresAleatorios()+contador+"@teste.com.br";
			  String cpf = numerosAleatorios();
			  
			  funcoes.abrirLink(driver, link);
			  funcoes.AguardarCarregamento(driver);	
			  funcoes.clicarESetarPorID(driver, "login-cpf", cpf);	
			  funcoes.clicarESetarPorID(driver, "login-senha", email);
			  funcoes.clicarCampoPorXpath(driver, "//*[@value='Cadastrar']");			  
			  
			  //Se o CPF ou email já estiver cadastrado, retorna e tenta outro
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
			  funcoes.clicarESetarPorID(driver,"cadastro-endereco", "Rua cidade de Maracajá"); 
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
			
			  funcoes.AguardarCarregamento(driver);  
	 } 
	
	
	@Test
	public void logInformacoesExecucao(WebDriver driver, String campo, int quantidadeAcertos, int quantidadeErros, int acertosSemJS, int errosSemJS, long tempoInicio){
		
		System.out.println("\n-------------------------Resultados do teste de "+campo+"--------------------------\n"
				+ "Total de vezes que enviou com Javascript habilitado: " + quantidadeAcertos + "\n"
				+ "Total de vezes que não enviou com Javascript habilitado: " + quantidadeErros);
		
		
		System.out.println("\nTotal de vezes que enviou com Javascript desabilitado: " + acertosSemJS + "\n"
				+ "Total de vezes que não enviou com Javascript desabilitado: " + errosSemJS);

		int envios = quantidadeAcertos + acertosSemJS;
		int naoEnvios = quantidadeErros + errosSemJS;

		long tempoFim = System.currentTimeMillis(); 
		System.out.println("\nTotal de vezes que enviou: " + envios + "\n"
				+ "Total de vezes que não enviou: "	+ naoEnvios + "\n\n" 							
				+ "Tempo total de execução: " + new SimpleDateFormat("mm:ss").format(new Date(tempoFim - tempoInicio))+"\n"	
				+ "----------------------------------------------------------------------------");
	}
	
	
	@Test
	public String caracteresAleatorios(){
		
		String letras = "ABCDEFGHIJKLMNOPQRSTUVYWXZ";
		Random random = new Random(); 

		String armazenaChaves = "";  
		int index = -1;  
		for( int i = 0; i < 9; i++ ) {  
		   index = random.nextInt( letras.length() );  
		   armazenaChaves += letras.substring( index, index + 1 );  
		}  
		
		return armazenaChaves;
	}
	
	
	@Test
	public String numerosAleatorios(){
		
		  Random randomCPF = new Random();
		  for (int iCPF = 0; iCPF < 10; iCPF++);				
		  String cpf = Integer.toString(randomCPF.nextInt(2147483647));	
		  String cpfFim = cpf+22;	 
		  
		  return cpfFim;	  
	}	
}
