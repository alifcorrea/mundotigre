package br.com.MundoTigre.scripts;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

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
	public void clicarCampoPorID(FirefoxDriver driver, String idCampo){
		driver.findElement(By.id(idCampo)).click();
	}
	
	@Test
	public void clicarCampoPorNome(FirefoxDriver driver, String nomeCampo){
		driver.findElement(By.name(nomeCampo)).click();
	}
	
	@Test
	public void clicarCampoPorXpath(FirefoxDriver driver, String pathCampo){
		driver.findElement(By.xpath(pathCampo)).click();
	}
		
	@Test
	public void setarValorPorID(FirefoxDriver driver, String idCampo, String valorCampo){
		driver.findElement(By.id(idCampo)).sendKeys(valorCampo);
	}
	
	@Test
	public void setarValorPorNome(FirefoxDriver driver, String nomeCampo, String valorCampo){
		driver.findElement(By.name(nomeCampo)).sendKeys(valorCampo);
	}	
	
	@Test
	public void setarValorPorXpath(FirefoxDriver driver, String pathCampo, String valorCampo){
		driver.findElement(By.xpath(pathCampo)).sendKeys(valorCampo);
	}	
	
	
	@Test
	public void campoSelect(FirefoxDriver driver, String idCampo, String valorOption){
		
		Select select = new Select(driver.findElement(By.id(idCampo))); 
		select.selectByValue(valorOption);
	}
	
}
