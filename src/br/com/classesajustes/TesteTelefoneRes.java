package br.com.classesajustes;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class TesteTelefoneRes {
	
	public FirefoxDriver driver;
	


	//Variaveis que controlam a quantidade de vezes que o script é executado
		int i = 0;
		int max = 6;
		
		//SEMPRE QUE FOR EXECUTAR OS SCRIPTS ALTERAR O VALOR DESTES CAMPOS, JÁ QUE NÃO PERMITE CADASTRAR COM O MESMO VALOR
		int cpf = 8312;
		String email = "aqtwr";
		

		@Before
		public void Inicio(){
			
			driver = new FirefoxDriver();
		}
		
	@Test	
	public void testarProfAtividade(){		
		

		//Na sexta execução abre uma nova guia do navegador com o JS desativado
	
			FirefoxProfile profileT = new FirefoxProfile();
			profileT.setPreference("javascript.enabled", false);
			//Abre uma guia do navegador
			driver = new FirefoxDriver(profileT);
	
		
		/*while(i<=max){
						
				//.get abre uma página web
				driver.get("http://www.mundotigre.com.br/cadastro/new");
					
				//aguarda o carregamento até carregar os elementos da página		
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					
				driver.findElement(By.id("login-cpf")).click();
				driver.findElement(By.id("login-cpf")).sendKeys("091.219.2" + cpf);
				driver.findElement(By.id("login-senha")).sendKeys(email + i +"@tessste.com.br");
					
				driver.findElement(By.xpath("//*[@value='Cadastrar']")).click();
				
				driver.findElement(By.name("mundo_tigre[mtg_nome]")).click();
				driver.findElement(By.name("mundo_tigre[mtg_nome]")).sendKeys("Teste"+i);
				
				
				driver.findElement(By.id("cadastro-nascimento")).click();
				driver.findElement(By.id("cadastro-nascimento")).sendKeys("13/02/2015");
				
				//cria um objeto selSexo do tipo select para selecionar um sexo
				Select selSexo = new Select(driver.findElement(By.id("cadastro-sexo")));
				
				//através do objeto selProf seleciona a opção 1 (Masculino)
				selSexo.selectByValue("M");
				
				//cria um objeto selprof do tipo select para selecionar uma profissão
				Select selProf = new Select(driver.findElement(By.id("mundo_tigre_mtg_id_prs")));
				
		
				//seleciona a opção da oitava posição
				selProf.selectByIndex(7);
				
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				Select selTempoAtuacao = new Select(driver.findElement(By.id("cadastro-atuacao")));

				selTempoAtuacao.selectByValue("1");				
				
				driver.findElement(By.id("cadastro-telefone-ddd")).click();
				
				if(i==1){
					driver.findElement(By.id("cadastro-telefone-ddd")).click();
					driver.findElement(By.id("cadastro-telefone-ddd")).sendKeys("0");
				}
				
				if(i==2){
					driver.findElement(By.id("cadastro-telefone-ddd")).click();
					driver.findElement(By.id("cadastro-telefone-ddd")).sendKeys("04");
				}
				
				if(i==3){
					driver.findElement(By.id("cadastro-telefone-ddd")).click();
					driver.findElement(By.id("cadastro-telefone-ddd")).sendKeys("047");
				}
				
				if(i==4){
					driver.findElement(By.id("cadastro-telefone-ddd")).click();
					driver.findElement(By.id("cadastro-telefone-ddd")).sendKeys("asd");
				}
				
				if(i==5){
					driver.findElement(By.id("cadastro-telefone-ddd")).click();
					driver.findElement(By.id("cadastro-telefone-ddd")).sendKeys("%#$");
				}
				
				
				driver.findElement(By.id("cadastro-telefone")).click();
				driver.findElement(By.id("cadastro-telefone")).sendKeys("988091642");
				
				driver.findElement(By.id("cadastro-celular-ddd")).click();
				driver.findElement(By.id("cadastro-celular-ddd")).sendKeys("47");
				
				driver.findElement(By.id("cadastro-celular")).click();
				driver.findElement(By.id("cadastro-celular")).sendKeys("987654321");
				
				/*------------------ Dados residenciais-----------------------*/
				/*driver.findElement(By.id("cadastro-cep")).click();
				driver.findElement(By.id("cadastro-cep")).sendKeys("89235735222");
				driver.findElement(By.id("cadastro-endereco")).sendKeys("Rua cidade de Maracajá");
				driver.findElement(By.id("cadastro-numero")).sendKeys("155");
				driver.findElement(By.id("cadastro-complemento")).sendKeys("Próximo ao mercado Renascer");
				
				Select estado = new Select(driver.findElement(By.id("mundo_tigre_mtg_id_est")));
				estado.selectByIndex(24);
				
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				Select cidade = new Select(driver.findElement(By.id("mundo_tigre_mtg_cidade")));
				cidade.selectByValue("420910");
					
				driver.findElement(By.id("cadastro-bairro")).sendKeys("Parque Guarani");
				
				/*---------------Empresa em que trabalha ou costuma comprar produtos Tigre------------*/
			/*	Select selEstado = new Select(driver.findElement(By.id("mundo_tigre_mtg_id_est_emp")));
				selEstado.selectByIndex(24);
				
				//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				Select selCidade = new Select(driver.findElement(By.id("mundo_tigre_mtg_cidade_emp")));
				selCidade.selectByValue("420910");
				
				driver.findElement(By.xpath("//*[@id='mundo_tigre_mtg_cnpj_emp']")).click();
				driver.findElement(By.xpath("//*[@value='312945619']")).click();
				
				Select selTrabalhaEmpresa = new Select(driver.findElement(By.id("cadastro-mtg_trabalha_empresa")));
				selTrabalhaEmpresa.selectByIndex(1);
				
				/*-----------------------Atividade física/esportiva------------------------*/

				//Cria os objetos checkbox
			/*	 WebElement checkBox1;
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
				   
				   driver.findElement(By.id("email-confirme")).sendKeys(email+ i +"@tessste.com.br");
				   driver.findElement(By.id("cadastro-senha")).sendKeys("alif");
				   driver.findElement(By.id("cadastro-senha-confirme")).sendKeys("alif");
				   driver.findElement(By.cssSelector(".submit")).click();
				   
				   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				   
				   i++;
				   cpf++;
				   		 
			}*/
	}
}
