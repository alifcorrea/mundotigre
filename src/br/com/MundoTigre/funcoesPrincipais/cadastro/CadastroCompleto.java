package br.com.MundoTigre.funcoesPrincipais.cadastro;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.com.MundoTigre.objetos.Usuario;
import br.com.MundoTigre.scripts.FuncoesCadastro;
import br.com.MundoTigre.scripts.FuncoesFirefox;


public class CadastroCompleto {
	
	public FirefoxDriver driver;
	
	@Before
	public void Inicio(){
		driver = new FirefoxDriver();
	}	
	
	@Test
	//InterruptedException = Extensão para a execução do metodo implicitlyWait
	public void cadastroCompleto() throws InterruptedException{
		
		int i = 1;
		int max = 6;		
		int UltimosDigitos = 56;	
		
		FuncoesFirefox funcoes =  new FuncoesFirefox();
		FuncoesCadastro funcoesCadastro = new FuncoesCadastro();		
		Usuario usuario = new Usuario();
		
		usuario.setCpf("435678956"+UltimosDigitos);
		usuario.setEmail("Testes"+ i +"@teste.com.br");
		usuario.setNome("Teste"+i);
		usuario.setDataNascimento("22/11/19"+UltimosDigitos);
		usuario.setSexo("M");
		usuario.setProfissaoAtividade("61");
		usuario.setTempoAtuacao(2);
		usuario.setDDD("047");
		usuario.setTelefone("988091642");
		usuario.setCelular("987654321");
		usuario.setCep("89235735222");
		usuario.setEndereco("Rua cidade de Maracajá");
		usuario.setNumero("155");
		usuario.setComplemento("Próximo ao mercado Renascer");
		usuario.setEstado(24);
		usuario.setCidade("420910");
		usuario.setBairro("Parque Guarani");
		usuario.setTrabalhaEmpresa(1);
		usuario.setTimeCoracao("100");
		usuario.setConfirmaEmail("Testes"+ i +"@teste.com.br");
		usuario.setSenha("alif");
		usuario.setConfirmaSenha("alif");	
		
	
	try{	
		
		while(i<max){
		funcoes.abrirLink(driver,"http://www.mundotigre.com.br/");		
		funcoes.AguardarCarregamento(driver);	
		
		funcoesCadastro.fecharBanner(driver);		
		funcoesCadastro.botaoCadastreSe(driver);
		
		funcoes.AguardarCarregamento(driver);
		
		funcoes.clicarESetarPorID(driver, "login-cpf", usuario.getCpf());
		funcoes.clicarESetarPorID(driver, "login-senha", usuario.getEmail());		
		funcoesCadastro.botaoCadastro(driver);
		
		funcoes.AguardarCarregamento(driver);		

		funcoes.clicarESetarPorNome(driver, "mundo_tigre[mtg_nome]", usuario.getNome());		
		funcoes.clicarESetarPorID(driver, "cadastro-nascimento", usuario.getDataNascimento());		
		funcoes.campoSelectValuePorID(driver, "cadastro-sexo", usuario.getSexo());		
		funcoes.campoSelectValuePorID(driver,"mundo_tigre_mtg_id_prs", usuario.getProfissaoAtividade());
		
		funcoes.AguardarCarregamento(driver);
		
		funcoes.campoSelectIndexPorID(driver, "cadastro-atuacao", usuario.getTempoAtuacao());
		
		
		/*--------------------------Telefone--------------------------*/		
		funcoes.clicarESetarPorID(driver, "cadastro-telefone-ddd", usuario.getDDD());
		funcoes.clicarESetarPorID(driver, "cadastro-telefone", usuario.getTelefone());
		funcoes.clicarESetarPorID(driver, "cadastro-celular-ddd", usuario.getDDD());
		funcoes.clicarESetarPorID(driver, "cadastro-celular", usuario.getCelular());	
		
		
		/*------------------ Dados residenciais -----------------------*/	
		funcoes.clicarESetarPorID(driver, "cadastro-cep", usuario.getCep());	
		funcoes.clicarESetarPorID(driver, "cadastro-endereco", usuario.getEndereco());
		funcoes.clicarESetarPorID(driver, "cadastro-numero", usuario.getNumero());	
		funcoes.clicarESetarPorID(driver, "cadastro-complemento", usuario.getComplemento());			
		funcoes.campoSelectIndexPorID(driver, "mundo_tigre_mtg_id_est", usuario.getEstado());		
		funcoes.campoSelectValuePorID(driver, "mundo_tigre_mtg_cidade", usuario.getCidade());
		funcoes.clicarESetarPorID(driver, "cadastro-bairro", usuario.getBairro());
		
		
		
		/*--------------Empresa em que trabalha ou costuma comprar produtos Tigre------------*/
		funcoes.campoSelectIndexPorID(driver, "mundo_tigre_mtg_id_est_emp", usuario.getEstado());
		funcoes.campoSelectValuePorID(driver, "mundo_tigre_mtg_cidade_emp", usuario.getCidade());
		funcoes.clicarCampoPorXpath  (driver, "//*[@id='mundo_tigre_mtg_cnpj_emp']");
		funcoes.clicarCampoPorXpath  (driver, "//*[@value='-1']");
		funcoes.campoSelectIndexPorID(driver, "cadastro-mtg_trabalha_empresa", usuario.getTrabalhaEmpresa());
			/*Checkbox Atividade Fisica Preferida*/
			funcoes.MarcarCheckboxPorCssSelector(driver, "input[id='mundo_tigre_atividade_fisica_list_5']");
			funcoes.MarcarCheckboxPorCssSelector(driver, "input[id='mundo_tigre_atividade_fisica_list_3']");
			funcoes.MarcarCheckboxPorCssSelector(driver, "input[id='mundo_tigre_atividade_fisica_list_4']");
			funcoes.MarcarCheckboxPorCssSelector(driver, "input[id='mundo_tigre_atividade_fisica_list_6']");
			funcoes.MarcarCheckboxPorCssSelector(driver, "input[id='mundo_tigre_atividade_fisica_list_1']");
			funcoes.MarcarCheckboxPorCssSelector(driver, "input[id='mundo_tigre_atividade_fisica_list_8']");
			funcoes.MarcarCheckboxPorCssSelector(driver, "input[id='mundo_tigre_atividade_fisica_list_13']");
			funcoes.MarcarCheckboxPorID(driver, "mundo_tigre_atividade_fisica_list_12");
			funcoes.MarcarCheckboxPorID(driver, "mundo_tigre_atividade_fisica_list_7");
			funcoes.MarcarCheckboxPorID(driver, "mundo_tigre_atividade_fisica_list_2");
			/*Fim Atividade Fisica Preferida-----*/
		funcoes.campoSelectValuePorID(driver, "cadastro-mtg_time_coracao", usuario.getTimeCoracao());    
		
		
		
		/*--------------------------Informações complementares---------------------*/
		funcoes.clicarCampoPorID(driver, "cadastro-novidade");
		funcoes.clicarCampoPorID(driver, "cadastro-sms");   
			funcoes.MarcarCheckboxPorID(driver, "mundo_tigre_area_interesse_list_1");
			funcoes.MarcarCheckboxPorID(driver, "mundo_tigre_area_interesse_list_14");
			funcoes.MarcarCheckboxPorID(driver, "mundo_tigre_area_interesse_list_2");  
			funcoes.MarcarCheckboxPorID(driver, "mundo_tigre_area_interesse_list_3");
		funcoes.clicarESetarPorID(driver, "email-confirme", usuario.getConfirmaEmail());
		funcoes.clicarESetarPorID(driver, "cadastro-senha", usuario.getSenha());
		funcoes.clicarESetarPorID(driver, "cadastro-senha-confirme", usuario.getConfirmaSenha());	
		funcoes.clicarCampoPorCssSelector(driver, ".submit");		
		
		/*--------------------------------------------Fim Cadastro----------------------------------------------*/
	
		   i++;
		   UltimosDigitos++;
		   
		   if(i==max){
			   driver.close();
		   }
		     
		}//while
		 
		System.out.println(usuario);
		   
		}catch(Exception e){
			e.printStackTrace();
			//driver.quit();	
		}
		
	}//metodo cadastroCompleto
}//classe
