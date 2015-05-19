package br.com.MundoTigre.funcoesPrincipais.cadastro;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.Select;

import br.com.MundoTigre.scripts.FuncoesCadastro;
import br.com.MundoTigre.scripts.FuncoesGerais;


public class CadastroCompleto {
	
	public FirefoxDriver driver;
	
	/*--------------------------------------------------------Página Finalizada------------------------------------------------------*/
	
	@Before
	public void Inicio(){
		
		driver = new FirefoxDriver();
	}
	
	
	@Test
	//InterruptedException é uma extensão para a execucao do metodo implicitlyWait
	public void cadastroCompleto() throws InterruptedException{
		
		
		FuncoesGerais funcoes =  new FuncoesGerais();
		FuncoesCadastro funcoesCadastro = new FuncoesCadastro();		
		
		
		//variaveis de controle para o while com toda a instrução, para que fique se repetindo diversas vezes
		int i = 0;
		int max = 2;
		
		//variaveis de controle dos campos 
		int cpfFim = 67;	
		int fimNasc = 67;
		
		while(i<max){
			
			//Desabilitar JS	
			FirefoxProfile p = new FirefoxProfile();
			p.setPreference("javascript.enabled", false);
		
	
		String link = "http://www.mundotigre.com.br/";
		
		funcoes.abrirLink(driver, link);	
		funcoes.AguardarCarregamento(driver);		 
		funcoesCadastro.fecharBanner(driver);
		funcoesCadastro.botaoCadastreSe(driver);		
		funcoes.AguardarCarregamento(driver);
		
		funcoes.clicarCampoPorID(driver,"login-cpf");
		funcoes.setarValorPorID(driver, "login-cpf", "091215139"+ cpfFim);
		
		funcoes.clicarCampoPorID(driver, "login-senha");
		funcoes.setarValorPorID(driver, "login-senha", "Teste"+ i +"@teste.com.br");
		
		funcoesCadastro.botaoCadastro(driver);
		funcoes.AguardarCarregamento(driver);
		
		driver.findElement(By.name("mundo_tigre[mtg_nome]")).sendKeys("Teste"+i);
		funcoes.clicarCampoPorID(driver,"cadastro-nascimento");
		driver.findElement(By.id("cadastro-nascimento")).sendKeys("221119"+fimNasc);
		
		//Campo Sexo
		String idCampo = "cadastro-sexo";
		String valorOption = "M";		
		funcoes.campoSelect(driver, idCampo, valorOption);
		
		
		//cria um objeto selSexo do tipo select para selecionar um sexo
		//Select selSexo = new Select(driver.findElement(By.id("cadastro-sexo"))); 
		//através do objeto selProf seleciona a opção 1 (Masculino)
		//selSexo.selectByIndex(1);
		
		//cria um objeto selprof do tipo select para selecionar uma profissão
		Select selProf = new Select(driver.findElement(By.id("mundo_tigre_mtg_id_prs")));
		//seleciona a opção da oitava posição
		selProf.selectByIndex(8);
		
		funcoes.AguardarCarregamento(driver);
		
		Select profDetalhe = new Select(driver.findElement(By.id("mundo_tigre_mtg_id_prs_det")));
		profDetalhe.selectByIndex(2);
		
		Select selTempoAtuacao = new Select(driver.findElement(By.id("cadastro-atuacao")));
		selTempoAtuacao.selectByIndex(2);
	
		driver.findElement(By.id("cadastro-telefone-ddd")).click();
		driver.findElement(By.id("cadastro-telefone-ddd")).sendKeys("047");
		driver.findElement(By.id("cadastro-telefone")).click();
		driver.findElement(By.id("cadastro-telefone")).sendKeys("988091642");
		driver.findElement(By.id("cadastro-celular-ddd")).click();
		driver.findElement(By.id("cadastro-celular-ddd")).sendKeys("47");
		driver.findElement(By.id("cadastro-celular")).click();
		driver.findElement(By.id("cadastro-celular")).sendKeys("987654321");
		
		/*------------------ Dados residenciais-----------------------*/
		driver.findElement(By.id("cadastro-cep")).click();
		driver.findElement(By.id("cadastro-cep")).sendKeys("89235735222");
		driver.findElement(By.id("cadastro-endereco")).sendKeys("Rua cidade de Maracajá");
		driver.findElement(By.id("cadastro-numero")).sendKeys("155");
		driver.findElement(By.id("cadastro-complemento")).sendKeys("Próximo ao mercado Renascer");
		
		Select estado = new Select(driver.findElement(By.id("mundo_tigre_mtg_id_est")));
		estado.selectByIndex(24);
		
		Select cidade = new Select(driver.findElement(By.id("mundo_tigre_mtg_cidade")));
		cidade.selectByValue("420910");
			
		driver.findElement(By.id("cadastro-bairro")).sendKeys("Parque Guarani");
		
		/*---------------Empresa em que trabalha ou costuma comprar produtos Tigre------------*/
		Select selEstado = new Select(driver.findElement(By.id("mundo_tigre_mtg_id_est_emp")));
		selEstado.selectByIndex(24);
		
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Select selCidade = new Select(driver.findElement(By.id("mundo_tigre_mtg_cidade_emp")));
		selCidade.selectByValue("420910");
		
		driver.findElement(By.xpath("//*[@id='mundo_tigre_mtg_cnpj_emp']")).click();
		driver.findElement(By.xpath("//*[@value='-1']")).click();
		
		Select selTrabalhaEmpresa = new Select(driver.findElement(By.id("cadastro-mtg_trabalha_empresa")));
		selTrabalhaEmpresa.selectByIndex(1);
		
		
		funcoesCadastro.AtividadeFisicaEsportiva(driver);
		
		    
		   Select timeCoracao = new Select(driver.findElement(By.id("cadastro-mtg_time_coracao")));
		   timeCoracao.selectByValue("100");
		   
		   driver.findElement(By.id("cadastro-novidade")).click();
		   driver.findElement(By.id("cadastro-sms")).click();
		   
		   WebElement receberInf1;
		   WebElement receberInf2;
		   WebElement receberInf3;
		   WebElement receberInf4;
		   
		   receberInf1 = driver.findElement(By.id("mundo_tigre_area_interesse_list_1"));
		   receberInf2 = driver.findElement(By.id("mundo_tigre_area_interesse_list_14"));
		   receberInf3 = driver.findElement(By.id("mundo_tigre_area_interesse_list_2"));
		   receberInf4 = driver.findElement(By.id("mundo_tigre_area_interesse_list_3"));
		   
		   
		   if(!receberInf1.isSelected()){
			   receberInf1.click();
		   }
		   
		   if(!receberInf2.isSelected()){
			   receberInf2.click();
		   }
		   
		   if(!receberInf3.isSelected()){
			   receberInf3.click();
		   }
		   
		   if(!receberInf4.isSelected()){
			   receberInf4.click();
		   }
		   
		   driver.findElement(By.id("email-confirme")).sendKeys("Teste"+ i +"@teste.com.br");
		   driver.findElement(By.id("cadastro-senha")).sendKeys("alif");
		   driver.findElement(By.id("cadastro-senha-confirme")).sendKeys("alif");
		   driver.findElement(By.cssSelector(".submit")).click();
		   
		   //Acrescenta mais 1 a variavel i que repete toda a instrução de comandos dentro do while
		   i++;
		   System.out.println(i);
		   //acrescenta mais 1 ao fim dos digitos do CPF para fazer o loop
		   cpfFim++;
		   //acrescenta mais 1 a data de nascimento
		   fimNasc++;
		   
		   if(i==max){
			   driver.close();
		   }
		}	
		   
	}
	
	
}
