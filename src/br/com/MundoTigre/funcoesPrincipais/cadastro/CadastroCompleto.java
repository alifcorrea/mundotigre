package br.com.MundoTigre.funcoesPrincipais.cadastro;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


public class CadastroCompleto {
	
	public FirefoxDriver driver;
	
	
	
	@Before
	public void Inicio(){
		
		driver = new FirefoxDriver();
	}
	
	
	@Test
	//InterruptedException é uma extensão para a execucao do metodo implicitlyWait
	public void cadastroCompleto() throws InterruptedException{
						
		//variaveis de controle para o while com toda a instrução, para que fique se repetindo diversas vezes
		int i = 0;
		int max = 2;
		
		//variaveis de controle dos campos 
		int cpfFim = 67;	
		int fimNasc = 67;
		
		while(i<max){
			
			//Desabilitar JS	
			//FirefoxProfile p = new FirefoxProfile();
			//p.setPreference("javascript.enabled", false);
			
		//.get abre uma página web
		driver.get("http://www.mundotigre.com.br/");
		
		//aguarda o carregamento até carregar os elementos da página		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//*[@class='fancybox-item fancybox-close close-palpite']")).click();
		driver.findElement(By.xpath("//*[@href='/cadastro/new']")).click();
		
		//aguarda o carregamento até carregar os elementos da página		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.id("login-cpf")).click();
		driver.findElement(By.id("login-cpf")).sendKeys("091215139"+cpfFim);
		driver.findElement(By.id("login-senha")).sendKeys("Teste"+ i +"@teste.com.br");
		
		driver.findElement(By.xpath("//*[@value='Cadastrar']")).click();
		
		//aguarda o execução até carregar os elementos da página		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.name("mundo_tigre[mtg_nome]")).sendKeys("Teste"+i);
		driver.findElement(By.id("cadastro-nascimento")).sendKeys("221119"+fimNasc);
		
		//cria um objeto selSexo do tipo select para selecionar um sexo
		Select selSexo = new Select(driver.findElement(By.id("cadastro-sexo"))); 
		//através do objeto selProf seleciona a opção 1 (Masculino)
		selSexo.selectByIndex(1);
		
		//cria um objeto selprof do tipo select para selecionar uma profissão
		Select selProf = new Select(driver.findElement(By.id("mundo_tigre_mtg_id_prs")));
		//seleciona a opção da oitava posição
		selProf.selectByIndex(8);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
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
		
		/*-----------------------Atividade física/esportiva------------------------*/

		//Cria os objetos checkbox
		 WebElement checkBox1;
		 WebElement checkBox2;
		 WebElement checkBox3;
		 WebElement checkBox4;
		 WebElement checkBox5;
		 WebElement checkBox6;
		 WebElement checkBox7;
		 WebElement checkBox8;
		 WebElement checkBox9;
		 WebElement checkBox10;

		 	//passa os parametros para os objetos, pegando o id dos elementos
		    checkBox1 = driver.findElement(By.cssSelector("input[id='mundo_tigre_atividade_fisica_list_5']"));
		    checkBox2 = driver.findElement(By.cssSelector("input[id='mundo_tigre_atividade_fisica_list_3']"));
		    checkBox3 = driver.findElement(By.cssSelector("input[id='mundo_tigre_atividade_fisica_list_4']"));
		    checkBox4 = driver.findElement(By.cssSelector("input[id='mundo_tigre_atividade_fisica_list_6']"));
		    checkBox5 = driver.findElement(By.cssSelector("input[id='mundo_tigre_atividade_fisica_list_1']"));
		    checkBox6 = driver.findElement(By.cssSelector("input[id='mundo_tigre_atividade_fisica_list_8']"));
		    checkBox7 = driver.findElement(By.cssSelector("input[id='mundo_tigre_atividade_fisica_list_13']"));
		    checkBox8 = driver.findElement(By.id("mundo_tigre_atividade_fisica_list_12"));
		    checkBox9 = driver.findElement(By.id("mundo_tigre_atividade_fisica_list_7"));
		   checkBox10 = driver.findElement(By.id("mundo_tigre_atividade_fisica_list_2"));
		   
		    //se o checkBox1 for diferente de selecionado
		    if(!checkBox1.isSelected()){
		    	//clique no checkBox1
		        checkBox1.click();
		    }

		    if(!checkBox2.isSelected()){
		        checkBox2.click();
		    }
		    
		    if(!checkBox3.isSelected()){
		    	checkBox3.click();
		    }
		    
		    if(!checkBox4.isSelected()){
		    	checkBox4.click();
		    }
		    
		    if(!checkBox5.isSelected()){
		    	checkBox5.click();
		    }
		    
		    if(!checkBox6.isSelected()){
		    	checkBox6.click();
		    }
		    
		    if(!checkBox7.isSelected()){
		    	checkBox7.click();
		    }
		    
		    if(!checkBox8.isSelected()){
		    	checkBox8.click();
		    }
		    
		    if(!checkBox9.isSelected()){
		    	checkBox9.click();
		    }
		    
		    if(!checkBox10.isSelected()){
		    	checkBox10.click();
		    }
		    
		   //Fim dos checkBox
		    
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
