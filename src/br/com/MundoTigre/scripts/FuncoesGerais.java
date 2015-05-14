package br.com.MundoTigre.scripts;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FuncoesGerais {
	
	
	@Test
	public void abrirLink(FirefoxDriver driver, String link){
		driver.get(link);
	}
	
	@Test
	public void AguardarCarregamento(FirefoxDriver driver){
		//aguarda o carregamento até carregar os elementos da página		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
