package br.com.mundotigre.classesincompletas;


import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class CadastroPeloFacebook {

	public FirefoxDriver driver;
	
	@Before
	public void Inicio(){
		driver = new FirefoxDriver();
		
	}
	
	@Test
	//InterruptedException é uma extensão para a execucao do metodo implicitlyWait
	public void CadastroFacebook() throws InterruptedException{
		
		int i=0;
		int max = 1;
		
		int i2=11;
		
		while(i<max){
			
			
			//.get abre uma página web
			driver.get("http://www.mundotigre.com.br/cadastro/new");
			
			WebElement cpf = driver.findElement(By.id("login-cpf"));
			cpf.click();
			cpf.sendKeys("091.215.139."+i2);
			
			if(i==max){
				driver.close();
			}
			
			driver.findElement(By.id("login-senha")).sendKeys("Teste"+i+"@a2c.com.br");
			driver.findElement(By.xpath("//*[@value='Cadastrar']")).click();

			//aguarda o carregamento até carregar os elementos da página		
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			//clica no botão do facebook
			driver.findElement(By.xpath("//button[@class='fb-button button']")).click();
	
			
			//aguarda o carregamento até carregar os elementos da página		
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			String parentHandle = driver.getWindowHandle(); // get the current window handle
			driver.findElement(By.xpath("//*[@id='someXpath']")).click(); // click some link that opens a new window
	
			for (String winHandle : driver.getWindowHandles()) {
			    driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
			}
			
			
			//Se loga no Facebook
			driver.findElement(By.id("email")).click();
			driver.findElement(By.id("email")).sendKeys("alif.correa");
			driver.findElement(By.id("pass")).sendKeys("22111994");
			driver.findElement(By.id("u_0_1")).click();
		
			i++;
			i2++;
		}	
	}		
	
}


