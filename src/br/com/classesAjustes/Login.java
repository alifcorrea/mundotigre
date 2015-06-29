package br.com.MundoTigre.funcoesPrincipais.cadastro;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.com.MundoTigre.objetos.Usuario;

public class Login {

	public FirefoxDriver driver;
	
	@Before
	public void Inicio(){
		driver = new FirefoxDriver();
	}
	
	@Test
	public void loginSite(){
		
		Usuario usuario = new Usuario();
		usuario.setCpf("12312312312");
		
		logar();
		
		driver.findElement(By.id("login-cpf")).click();
		driver.findElement(By.id("login-cpf")).sendKeys(usuario.getCpf());
		
		driver.findElement(By.xpath("//*[@value='OK']")).submit();
		
		if(driver.getCurrentUrl().contains("/login2/resp/1")){
			System.out.println("CPF não encontrado!");
		}
	}
	
	@Test
	public void LogarFacebook(){
		logar();
		
		Usuario usuario = new Usuario();
		
		usuario.setEmail("alif.correa");
		usuario.setSenha("alif2012");
		
		driver.findElement(By.xpath("//*[@class='fb-button fb-login button']")).click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String URLDeslogado = "https://www.facebook.com/login.php?skip_api_login=";
		String URLLogado = "https://www.facebook.com/dialog/oauth?scope=";
		String salvarNavegador = "https://www.facebook.com/checkpoint/?next=";
		String contaNaoAssociada = "/cadastro/login/resp/3#_=_";
		
		if(driver.getCurrentUrl().contains(URLLogado)){
			driver.findElement(By.name("__CONFIRM__")).click();
		}
		
		
		if(driver.getCurrentUrl().contains(URLDeslogado)){
			driver.findElement(By.id("email")).sendKeys(usuario.getEmail());
			driver.findElement(By.id("pass")).sendKeys(usuario.getSenha());
			driver.findElement(By.id("u_0_2")).submit();
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			if(driver.getCurrentUrl().contains(salvarNavegador)){
				driver.findElement(By.id("checkpointSubmitButton"));				
			}
			
			if(driver.getCurrentUrl().contains(contaNaoAssociada)){
				System.out.println("Sua conta no Facebook não está vinculada a nenhuma conta do Mundo Tigre.");
			}
		}
		
	}
	
	@Test
	public void logar(){
		
		driver.get("http://www.mundotigre.com.br/");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//*[@class='fancybox-image']")).click();
	}
	
	
	@Test
	public void linksMenu(){
		driver.get("http://www.mundotigre.com.br/");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//*[@class='fancybox-item fancybox-close close-palpite']")).click();
	
		driver.findElement(By.xpath("//*[@href='/o-que-e']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//*[@href='/como-participar']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//*[@href='/images/../uploads/regulamentos/Regulamento_Geral_Programa.pdf']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		fecharNovaJanela();
		
		driver.findElement(By.xpath("//*[@href='/como-pontuar']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//*[@href='/premios']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//*[@href='/ganhadores']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//*[@href='/marcaemidia']")).click();
		driver.navigate().back();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//*[@href='/cpdv']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	}
	
	@Test
	public void fecharNovaJanela(){
		
		String mainHandle = driver.getWindowHandle();
		String[] handles = driver.getWindowHandles().toArray(new String[0]);
		driver.switchTo().window(handles[handles.length - 1]);
		
		driver.close();
		driver.switchTo().window(mainHandle);
	}
	
	
	
}
