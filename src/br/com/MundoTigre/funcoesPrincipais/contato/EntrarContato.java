package br.com.MundoTigre.funcoesPrincipais.contato;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import br.com.MundoTigre.objetos.Contato;

public class EntrarContato {
	
	public FirefoxDriver driver; 	

	   
	@Before
	public void Inicio(){
		
		//Abre o navegador com o JS desativado
		FirefoxProfile profileT = new FirefoxProfile();
		profileT.setPreference("javascript.enabled", false);
		driver = new FirefoxDriver(profileT);
	}
	
	@Test
	public void testarTudo(Contato contato){
		
		entrarContato(contato);
	}
	
	@Test
	public void entrarContato(Contato contato){
	
		int inicio = 1;
		int valorMax = 3;
		
	while(inicio < valorMax){		
		
		String nome = null;
		String email = null;
		String cpf = null;
		String telefone = null;
		String assunto = null;
		String mensagem = null;
		
		
		if(inicio == 1){
			nome = "Alif";
			email = "alif@alif";
			cpf = "0846846";
			telefone = "10923801923";
			assunto = "teste";
			mensagem = "asdsadsa";
			
		}
		
		if(inicio == 2){
			nome = "Alif2";
			email = "alif@alif2";
			cpf = "0846846";
			telefone = "10923801923";
			assunto = "teste";
			mensagem = "asdsadsa";
			
		}
		
		if(inicio == 3){
			nome = "Alif3";
			email = "alif@alif2";
			cpf = "0846846";
			telefone = "10923801923";
			assunto = "teste";
			mensagem = "asdsadsa";
			
		}	
		
		System.out.println("Valores do teste" +inicio+"\r\n" 
				+"Nome: "+ nome +"\r\n"
				+ "Email: "+ email +"\r\n"
				+ "CPF: " + cpf +"\r\n"
				+ "Telefone: "+ telefone +"\r\n"
				+ "Assunto: " + assunto +"\r\n"
				+ "Mensagem: " + mensagem +"\r\n");
		
		contato.setNome(nome);
		contato.setEmail(email);
		contato.setCpf(cpf);
		contato.setTelefone(telefone);
		contato.setAssunto(assunto);
		contato.setMensagem(mensagem);
	
		
		try{
		
			driver.get("http://www.mundotigre.com.br/contato");
			
			//aguarda o carregamento até carregar os elementos da página		
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);			

			driver.findElement(By.id("fale_conosco_fcn_nome")).sendKeys(contato.getNome());
			driver.findElement(By.id("fale_conosco_fcn_email")).sendKeys(contato.getEmail());
			driver.findElement(By.id("fale_conosco_fcn_cpf")).sendKeys(contato.getCpf());
			driver.findElement(By.id("fale_conosco_fcn_fone")).sendKeys(contato.getTelefone());
			driver.findElement(By.id("fale_conosco_fcn_assunto_id")).sendKeys(contato.getAssunto());
			driver.findElement(By.id("fale_conosco_fcn_mensagem")).sendKeys(contato.getMensagem());
			driver.findElement(By.xpath("//*[@type='submit']")).submit();
			
			//aguarda o carregamento até carregar os elementos da página		
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			if(driver.getCurrentUrl().contains("/send")){
				System.out.println("O Teste " + inicio + " retornou erros");
			}else{
				System.out.println("O Teste " + inicio + " passou!");
			}
			
			inicio++;
			
		}catch(Exception e){
			e.printStackTrace();
			}
		}
	}
	
}
