package br.com.classesajustes;


import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class EsqueciMinhaSenha {
	
	public FirefoxDriver driver;
	
	@Before
	public void Inicio(){

	driver = new FirefoxDriver();
	
	}
	
	@Test
	public void recuperarSenha() throws InterruptedException{
		driver.get("http://www.mundotigre.com.br/");
		
		if(driver.manage().timeouts().equals(30000)){
			System.out.println("A página atingiu mais de 30 segundos para carregar!");
		}
		
		//executa a proxima instrucao somente depois do carregamento de todos os elementos da página		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//Fecha o modal que abre no inicio do site
		driver.findElement(By.xpath("//*[@class='fancybox-item fancybox-close close-palpite']")).click();
		
		//executa a proxima instrucao somente depois do carregamento de todos os elementos da página		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		//clica no botão "Atualize seu cadastro" que abre a página
		driver.findElement(By.xpath("//*[@href='/cadastro/login']")).click();
		
		//executa a proxima instrucao somente depois do carregamento de todos os elementos da página		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//Clica no link "Esqueci minha senha" que abre a página
		driver.findElement(By.xpath("//*[@data-ar='esqueci-senha']")).click();
		
		//executa a proxima instrucao somente depois do carregamento de todos os elementos da página		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		WebElement cpf = driver.findElementByCssSelector(".cpf");
		cpf.sendKeys("09121203989");
		System.out.println(cpf);
	
	}
		
	@After
	public void fechar(){
		driver.close();
	}
}
