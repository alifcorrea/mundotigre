package br.com.MundoTigre.funcoesPrincipais.cadastro;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.Select;

public class CadastroInicial {
	
	public FirefoxDriver driver;
	
	
	//Adiciono os id dos campos numa String, caso seja alterado e seja necessário refatoracao altero em um unico lugar
	public String campoCPF = "login-cpf";
	public String campoEmail = "login-senha";
	public String botaoEnviar = "//*[@value='Cadastrar']";
	
	
	
	//Valores dos campos, cada vez que executo o script alterar. Para que os dados não se repitam no cadastro
	public int cpfFim = 8;
	public String email = "abcd3";
	
	
	@Before
	public void Inicio(){
		driver = new FirefoxDriver();
	}
	
	
	@Test
	//InterruptedException é uma extensão para a execucao do metodo implicitlyWait
	public void testarCPF() throws InterruptedException{
						
		//variaveis de controle para o while com toda a instrução, para que fique se repetindo diversas vezes
		int i = 0;
		//variavel que controla o ultimo teste, para fechar o navegador (é necessario para depois executar os mesmos testes com o JS)
		int iUlt = 8;
		int max = 15;
		
		
		while(i<max){	
	
				//Na oitava execução (Executa todos as possibilidades novamente sem o JS) abre uma nova guia do navegador com o JS desativado
				if(i==iUlt){
					FirefoxProfile profileT = new FirefoxProfile();
					profileT.setPreference("javascript.enabled", false);
					//Abre uma guia do navegador
					driver = new FirefoxDriver(profileT);
				}
			

			//.get abre uma página web
			driver.get("http://www.mundotigre.com.br/cadastro/new");
			
			//aguarda o carregamento até carregar os elementos da página		
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
		
			/*-----------------------------CPF VAZIO---------------------------*/		
			if(i==0 || i==8){
			driver.findElement(By.id(campoCPF)).click();
			}
			
			
			/*-------------------------CPF com 10 numeros------------------------*/		
			if(i==1 || i==9){
				driver.findElement(By.id(campoCPF)).sendKeys("01234567"+cpfFim);
			}
			
			
			/*-----------------------CPF com mais de 12 numeros----------------*/
			if(i==2 || i==10){
				driver.findElement(By.id(campoCPF)).sendKeys("01234567"+cpfFim);
			}
			
			
			/*------------------------CPF com Pontuação------------------------*/
			if(i==3 || i==11){
				driver.findElement(By.id(campoCPF)).sendKeys("091.215.038."+cpfFim);
			}
		
			
			/*-------------------CPF sem Pontuação (Funciona melhor com JS desativado)-----------------------*/
			if(i==4 || i==12){
				driver.findElement(By.id(campoCPF)).sendKeys("091215038"+cpfFim);
			}
			
			
			/*-----------------------CPF com Vírgula (Funciona melhor com JS desativado)-----------------------*/
			if(i==5 || i==13){
				driver.findElement(By.id(campoCPF)).sendKeys("654,123,212,"+cpfFim);
			}
			
			
			/*--------------------------CPF com Letras (Funciona melhor com JS desativado)-------------------------*/
			if(i==6 || i==14){
				driver.findElement(By.id(campoCPF)).sendKeys("OnzeLETRASA");
			}
			
			
			/*-------------------------CPF com Caracteres especiais (Funciona melhor com JS desativado)----------------------*/
			if(i==7 || i==15){
				driver.findElement(By.id(campoCPF)).sendKeys("!@#$%¨&*()_");
			}
			
			
			driver.findElement(By.id(campoEmail)).sendKeys(email + i +"@teste.com.br");
			driver.findElement(By.xpath(botaoEnviar)).click();
			
			//Se a URL URL contem o texto abaixo, retorna a página anterior para a proxima execucao
			String URLAtual = driver.getCurrentUrl();			
			if(URLAtual.contains("http://www.mundotigre.com.br/cadastro?cpf")){
				System.out.println("Teste CPF Passou: " + i);
				driver.navigate().back();
			}
			
			//limpa o campo para o proximo teste
			driver.findElement(By.id(campoEmail)).clear();
			
			i++;
			
			if(i==max || i==iUlt){
				driver.close();
			}
		}			
}

	
	
		
	@Test
	public void testarEmail(){
		
		//variaveis de controle para o while com toda a instrução, para que fique se repetindo diversas vezes
		int i = 0;
		int iUlt = 17;
		int max = 33;
		
	while(i<max){
	
		//Na segunda execução abre uma nova guia do navegador com o JS desativado
		if(i==iUlt){
			FirefoxProfile profileT = new FirefoxProfile();
			profileT.setPreference("javascript.enabled", false);
			//Abre uma guia do navegador
			driver = new FirefoxDriver(profileT);
		}
		
	
		driver.get("http://www.mundotigre.com.br/cadastro/new");		
		
		//aguarda o carregamento até carregar os elementos da página		
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.id(campoCPF)).click();
		driver.findElement(By.id(campoCPF)).sendKeys("091.216.039.78");
		
		
		/*-------------------------Email Vazio------------------------*/	
		if(i==0 || i==17){
		driver.findElement(By.id("login-senha")).click();
		}
		
		/*-------------------------Email formato nome@mail------------------------*/		
		if(i==1 || i==18){
			driver.findElement(By.id(campoEmail)).sendKeys("nome@mail");
		}
		
		
		/*-----------------------Email formato nome@mail.com"----------------*/
		if(i==2 || i==19){
			driver.findElement(By.id(campoEmail)).sendKeys("nome@mail.com");
		}
		
		
		/*----------------------Email formato nome_!$#%@mail.com------------------------*/
		if(i==3 || i==20){
			driver.findElement(By.id(campoEmail)).sendKeys("nome_!$#%@mail.com");
		}
	
		
		/*--------------------Email formato nome.sobrenome@mail----------------------*/
		if(i==4 || i==21){
			driver.findElement(By.id(campoEmail)).sendKeys("nome.sobrenome@mail");
		}
		
		
		/*---------------------Email formato nome.sobrenome@mail.com-------------------------*/
		if(i==5 || i==22){
			driver.findElement(By.id(campoEmail)).sendKeys("nome.sobrenome@mail.com");
		}
		
		
		/*---------------------Email formato nome.sobrenome123@mail.com-----------------------------*/
		if(i==6 || i==23){
			driver.findElement(By.id(campoEmail)).sendKeys("nome.sobrenome123@mail.com");
		}
		
		
		/*--------------------Email formato nome.sobrenome@mail.com.br--------------------------*/
		if(i==7 || i==24){
			driver.findElement(By.id(campoEmail)).sendKeys("nome.sobrenome@mail.com.br");
		}
		
		
		/*--------------------Email formato nome_sobrenome@mail"---------------------------*/
		if(i==8 || i==25){
			driver.findElement(By.id(campoEmail)).sendKeys("nome_sobrenome@mail");
		}
		
		
		/*--------------------Email formato nome_sobrenome@mail.com---------------------------*/
		if(i==9 || i==26){
			driver.findElement(By.id(campoEmail)).sendKeys("nome_sobrenome@mail.com");	
		}
		
		
		/*--------------------Email formato nome_sobrenome123@mail.com---------------------------*/
		if(i==10 || i==27){
			driver.findElement(By.id(campoEmail)).sendKeys("nome_sobrenome123@mail.com");
		}

		
		/*--------------------Email formato nome_sobrenome@mail.com.br---------------------------*/	
		if(i==11 || i==28){
			driver.findElement(By.id(campoEmail)).sendKeys("nome_sobrenome@mail.com.br");
		}		
		
		
		/*--------------------Email formato nome_sobrenome_outrosobrenome@mail---------------------------*/
		if(i==12 || i==29){
			driver.findElement(By.id(campoEmail)).sendKeys("nome_sobrenome_outrosobrenome@mail");	
		}	
			
		
		/*--------------------Email formato nome_sobrenome_outrosobrenome@mail.com---------------------------*/
		if(i==13 || i==30){
			driver.findElement(By.id(campoEmail)).sendKeys("nome_sobrenome_outrosobrenome@mail.com");	
		}
				
		
		/*--------------------Email formato nome_sobrenome1!@23_outrosobrenome@mail.com---------------------------*/
		if(i==14 || i==31){
			driver.findElement(By.id(campoEmail)).sendKeys("nome_sobrenome1!@23_outrosobrenome@mail.com");
		}
				
		
		/*--------------------Email formato nome_sobrenome_outrosobrenome@mail.com.br---------------------------*/
		if(i==15 || i==32){
			driver.findElement(By.id(campoEmail)).sendKeys("nome_sobrenome_outrosobrenome@mail.com.br");	
		}
			
		
		/*--------------------Email formato nome_sobrenom!@e_outr¨&$%osobrenome@mail.com.br---------------------------*/
		if(i==16 || i==33){
			driver.findElement(By.id(campoEmail)).sendKeys("nome_sobrenom!@e_outr¨&$%osobrenome@mail.com.br");		
		}
		
		//Envia o form
		driver.findElement(By.xpath(botaoEnviar)).click();
		
		
		//Se a URLAtual contem o texto abaixo, retorna ate a página anterior para a proxima execução
		String URLAtual = driver.getCurrentUrl();			
		if(URLAtual.contains("http://www.mundotigre.com.br/cadastro?cpf")){
			System.out.println("Teste Email Passou: " + i);
			driver.navigate().back();
		}
		
		
		//Limpa os campos para o proximo teste
		driver.findElement(By.id(campoCPF)).click();
		driver.findElement(By.id(campoCPF)).clear();
		driver.findElement(By.id(campoEmail)).click();
		driver.findElement(By.id(campoEmail)).clear();
		
		//se a quantidade de execuções for igual a maxima delimitada ou igual a ultima (iUlt), fecha o browser
		if(i==max || i==iUlt){
			driver.close();
		}
		
		i++;
		
		}
	}
	
	
	
	@Test
	public void testarNome(){
		
		//Variaveis que controlam a quantidade de vezes que o script é executado
		int i = 0;
		int max = 8;
		
		//SEMPRE QUE FOR EXECUTAR OS SCRIPTS ALTERAR O VALOR DESTES CAMPOS, JÁ QUE NÃO PERMITE CADASTRAR COM O MESMO VALOR
		int cpf = 4061;
		String email = "gosd";
					
	while(i<=max){
					
			//.get abre uma página web
			driver.get("http://www.mundotigre.com.br/cadastro/new");
			
			
			//aguarda o carregamento até carregar os elementos da página		
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			driver.findElement(By.id("login-cpf")).click();
			driver.findElement(By.id("login-cpf")).sendKeys("091.219.2" + cpf);
			driver.findElement(By.id("login-senha")).sendKeys(email + i +"@tessste.com.br");
				
			driver.findElement(By.xpath("//*[@value='Cadastrar']")).click();
			HtmlUnitDriver htmlUnit = new HtmlUnitDriver(true);
			String url = htmlUnit.getPageSource();
			
			System.out.println(url);
			
			if(url.contains("/confirmacao")){
				//.get abre uma página web
				driver.get("http://www.mundotigre.com.br/cadastro/new");
				
				
				//aguarda o carregamento até carregar os elementos da página		
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				driver.findElement(By.id("login-cpf")).click();
				driver.findElement(By.id("login-cpf")).sendKeys("091.219.2" + cpf);
				driver.findElement(By.id("login-senha")).sendKeys(email + i +"@tessste.com.br");
				

				i++;
			    cpf++;
			}
			
			
			if(i==0){
				driver.findElement(By.name("mundo_tigre[mtg_nome]")).sendKeys("Teste"+i);
			}
			if(i==1){
				driver.findElement(By.name("mundo_tigre[mtg_nome]")).sendKeys("Teste123"+i);
			}
			if(i==2){
				driver.findElement(By.name("mundo_tigre[mtg_nome]")).sendKeys("Teste123!@#%#@#"+i);
			}
			if(i==3){
				driver.findElement(By.name("mundo_tigre[mtg_nome]")).sendKeys("TESTANDO");
			}
			if(i==4){
				driver.findElement(By.name("mundo_tigre[mtg_nome]")).sendKeys("TESTANDO.A2C.TEST");
			}
			if(i==5){
				driver.findElement(By.name("mundo_tigre[mtg_nome]")).sendKeys("TESTANDO A2C TEST");
			}
			if(i==6){
				driver.findElement(By.name("mundo_tigre[mtg_nome]")).sendKeys("TESTANDO A2C TEST");
			}
			if(i==7){
				driver.findElement(By.name("mundo_tigre[mtg_nome]")).sendKeys("Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sem");
			}
			if(i==8){
				driver.findElement(By.name("mundo_tigre[mtg_nome]")).sendKeys("Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer um livro de modelos de tipos. Lorem Ipsum sobreviveu ");
			}
			
			driver.findElement(By.id("cadastro-nascimento")).click();
			driver.findElement(By.id("cadastro-nascimento")).sendKeys("22/11/1994");
			
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
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
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
			driver.findElement(By.xpath("//*[@value='312945619']")).click();
			
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
			   
			   driver.findElement(By.id("email-confirme")).sendKeys(email+ i +"@tessste.com.br");
			   driver.findElement(By.id("cadastro-senha")).sendKeys("alif");
			   driver.findElement(By.id("cadastro-senha-confirme")).sendKeys("alif");
			   driver.findElement(By.cssSelector(".submit")).click();
			   
			   i++;
			   cpf++;
			   		 
		}
	}
	
	
	
	@Test	
	public void testarDataNasc(){		
		int i = 0;
		int max = 6;
		
		//SEMPRE QUE FOR EXECUTAR OS SCRIPTS ALTERAR O VALOR DESTES CAMPOS, JÁ QUE NÃO PERMITE CADASTRAR COM O MESMO VALOR
		int cpf = 1289;
		String email = "Josés";
		
		while(i<=max){
						
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
				
				if(i==0){
					driver.findElement(By.id("cadastro-nascimento")).sendKeys("");	
				}
				if(i==1){
					driver.findElement(By.id("cadastro-nascimento")).sendKeys("35/02/2015");
				}
				if(i==2){
					driver.findElement(By.id("cadastro-nascimento")).sendKeys("02/35/2015");
				}
				if(i==3){
					driver.findElement(By.id("cadastro-nascimento")).sendKeys("02/35/0918");
				}
				if(i==4){
					driver.findElement(By.id("cadastro-nascimento")).sendKeys("15/02/1900");
				}
				if(i==5){
					driver.findElement(By.id("cadastro-nascimento")).sendKeys("13/02/2015");
				}
				if(i==6){
					driver.findElement(By.id("cadastro-nascimento")).sendKeys("15/02/2015");
				}
				
				
				
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
				
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
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
				driver.findElement(By.xpath("//*[@value='312945619']")).click();
				
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
				   
				   driver.findElement(By.id("email-confirme")).sendKeys(email+ i +"@tessste.com.br");
				   driver.findElement(By.id("cadastro-senha")).sendKeys("alif");
				   driver.findElement(By.id("cadastro-senha-confirme")).sendKeys("alif");
				   driver.findElement(By.cssSelector(".submit")).click();
				   
				   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				   
				   i++;
				   cpf++;
				   		 
			}
		}
	
	
	
	
	
	
	@Test	
	public void testarSexo(){	
		
		//Variaveis que controlam a quantidade de vezes que o script é executado
		int i = 0;
		int max = 2;
		
		//SEMPRE QUE FOR EXECUTAR OS SCRIPTS ALTERAR O VALOR DESTES CAMPOS, JÁ QUE NÃO PERMITE CADASTRAR COM O MESMO VALOR
		int cpf = 1615;
		String email = "poiss";
		
		while(i<=max){
						
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
				
				if(i==1){
					//através do objeto selProf seleciona a opção 1 (Masculino)
					selSexo.selectByValue("M");
				}
				
				if(i==2){
					//através do objeto selProf seleciona a opção 2 (Feminino)
					selSexo.selectByValue("F");
				}
				
				
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
				
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
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
				driver.findElement(By.xpath("//*[@value='312945619']")).click();
				
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
				   
				   driver.findElement(By.id("email-confirme")).sendKeys(email+ i +"@tessste.com.br");
				   driver.findElement(By.id("cadastro-senha")).sendKeys("alif");
				   driver.findElement(By.id("cadastro-senha-confirme")).sendKeys("alif");
				   driver.findElement(By.cssSelector(".submit")).click();
				   
				   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				   
				   i++;
				   cpf++;
				   		 
			}
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Test	
	public void testarProfAtividade(){		

		//Variaveis que controlam a quantidade de vezes que o script é executado
			int i = 0;
			int max = 10;
			
			//SEMPRE QUE FOR EXECUTAR OS SCRIPTS ALTERAR O VALOR DESTES CAMPOS, JÁ QUE NÃO PERMITE CADASTRAR COM O MESMO VALOR
			int cpf = 6924;
			String email = "1822";
			
		
		//Na sexta execução abre uma nova guia do navegador com o JS desativado
		if(i>5){
			FirefoxProfile profileT = new FirefoxProfile();
			profileT.setPreference("javascript.enabled", false);
			//Abre uma guia do navegador
			driver = new FirefoxDriver(profileT);
		}
		
		while(i<=max){
						
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
				
				if(i==1 || i==6){
					driver.findElement(By.id("cadastro-telefone-ddd")).click();
					driver.findElement(By.id("cadastro-telefone-ddd")).sendKeys("0");
				}
				
				if(i==2 || i==7){
					driver.findElement(By.id("cadastro-telefone-ddd")).click();
					driver.findElement(By.id("cadastro-telefone-ddd")).sendKeys("04");
				}
				
				if(i==3 || i==8){
					driver.findElement(By.id("cadastro-telefone-ddd")).click();
					driver.findElement(By.id("cadastro-telefone-ddd")).sendKeys("0472");
				}
				
				if(i==4 || i==9){
					driver.findElement(By.id("cadastro-telefone-ddd")).click();
					driver.findElement(By.id("cadastro-telefone-ddd")).sendKeys("asd");
				}
				
				if(i==5 || i==10){
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
				driver.findElement(By.id("cadastro-cep")).click();
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
				Select selEstado = new Select(driver.findElement(By.id("mundo_tigre_mtg_id_est_emp")));
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
				   
				   driver.findElement(By.id("email-confirme")).sendKeys(email+ i +"@tessste.com.br");
				   driver.findElement(By.id("cadastro-senha")).sendKeys("alif");
				   driver.findElement(By.id("cadastro-senha-confirme")).sendKeys("alif");
				   driver.findElement(By.cssSelector(".submit")).click();
				   
				   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				   
				   i++;
				   cpf++;
				   
				 //aguarda o carregamento até carregar os elementos da página		
				   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						
				   driver.navigate().to("http://www.mundotigre.com.br/cadastro/new");
				   		 
			}
	}
	
	
	
	
	@Test	
	public void testarDDDTelResidencial(){		


		//Variaveis que controlam a quantidade de vezes que o script é executado
			int i = 0;
			int max = 10;
			
			//SEMPRE QUE FOR EXECUTAR OS SCRIPTS ALTERAR O VALOR DESTES CAMPOS, JÁ QUE NÃO PERMITE CADASTRAR COM O MESMO VALOR
			int cpf = 6924;
			String email = "1822";
			
		//Na sexta execução abre uma nova guia do navegador com o JS desativado
		if(i>5){
			FirefoxProfile profileT = new FirefoxProfile();
			profileT.setPreference("javascript.enabled", false);
			//Abre uma guia do navegador
			driver = new FirefoxDriver(profileT);
		}
		
		while(i<=max){
						
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
				
				if(i==1 || i==6){
					driver.findElement(By.id("cadastro-telefone-ddd")).click();
					driver.findElement(By.id("cadastro-telefone-ddd")).sendKeys("0");
				}
				
				if(i==2 || i==7){
					driver.findElement(By.id("cadastro-telefone-ddd")).click();
					driver.findElement(By.id("cadastro-telefone-ddd")).sendKeys("04");
				}
				
				if(i==3 || i==8){
					driver.findElement(By.id("cadastro-telefone-ddd")).click();
					driver.findElement(By.id("cadastro-telefone-ddd")).sendKeys("0472");
				}
				
				if(i==4 || i==9){
					driver.findElement(By.id("cadastro-telefone-ddd")).click();
					driver.findElement(By.id("cadastro-telefone-ddd")).sendKeys("asd");
				}
				
				if(i==5 || i==10){
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
				driver.findElement(By.id("cadastro-cep")).click();
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
				Select selEstado = new Select(driver.findElement(By.id("mundo_tigre_mtg_id_est_emp")));
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
				   
				   driver.findElement(By.id("email-confirme")).sendKeys(email+ i +"@tessste.com.br");
				   driver.findElement(By.id("cadastro-senha")).sendKeys("alif");
				   driver.findElement(By.id("cadastro-senha-confirme")).sendKeys("alif");
				   driver.findElement(By.cssSelector(".submit")).click();
				   
				   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				   
				   i++;
				   cpf++;
				   
				 //aguarda o carregamento até carregar os elementos da página		
				   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						
				   driver.navigate().to("http://www.mundotigre.com.br/cadastro/new");
				   		 
			}
	}

	   @AfterClass
	     public static void tearDown() {
	       // selenium.stop();
	     }
	}
