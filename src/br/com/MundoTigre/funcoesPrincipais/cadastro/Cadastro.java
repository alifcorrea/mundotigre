package br.com.MundoTigre.funcoesPrincipais.cadastro;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import br.com.MundoTigre.objetos.Usuario;

public class Cadastro {
	
	public FirefoxDriver driver;

	@Before
	public void Inicio(){
		
		//Abre o navegador com o JS desativado
		
	}


	@Test
	public void TelaInicial (){
	
		Usuario usuario = new Usuario();
		
		usuario.setCpf("testando");
		usuario.setEmail("esse aqui");		
		
		try{
			
			driver.get("http://www.mundotigre.com.br");
			
			//aguarda o carregamento até carregar os elementos da página		
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);			

			/*driver.findElement(By.id("login-cpf")).click();
			driver.findElement(By.id("login-cpf")).sendKeys(usuario.getCpf());
			driver.findElement(By.id("login-senha")).sendKeys(usuario.getEmail());
			driver.findElement(By.id("login-senha")).submit();*/
			
			//driver.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}		
	
	}
	
	
	@Test
	public void fecharBanner(){
		driver.findElement(By.xpath("//*[@class='fancybox-item fancybox-close close-palpite']")).click();
	}
	
	@Test
	public void botaoParticiparBanner(){
		driver.findElement(By.xpath("//*[@class='fancybox-image']")).click();
	}
	
}
