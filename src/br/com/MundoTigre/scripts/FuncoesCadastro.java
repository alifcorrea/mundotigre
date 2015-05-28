package br.com.MundoTigre.scripts;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FuncoesCadastro {

	@Test
	public void botaoCadastro(FirefoxDriver driver){
		driver.findElement(By.xpath("//*[@value='Cadastrar']")).click();
	}	
	
	@Test
	public void botaoCadastreSe(FirefoxDriver driver){
		driver.findElement(By.xpath("//*[@href='/cadastro/new']")).click();
	}	
	
	@Test
	public void fecharBanner(FirefoxDriver driver){
		driver.findElement(By.xpath("//*[@class='fancybox-item fancybox-close close-palpite']")).click();
	}
	
	@Test
	public void botaoParticiparBanner(FirefoxDriver driver){
		driver.findElement(By.xpath("//*[@class='fancybox-image']")).click();
	}
	
	
}
