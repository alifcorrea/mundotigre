package br.com.MundoTigre.scripts;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.Select;

public class FuncoesFirefox {
	
	
	
	/*-----------------------Interações com navegador--------------------------*/
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
	public void desativarJS(FirefoxDriver driver){
		FirefoxProfile p = new FirefoxProfile();
		p.setPreference("javascript.enabled", false);
	}
	

	
	/*-----------------------Somente clique--------------------------*/
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
	public void clicarCampoPorCssSelector(FirefoxDriver driver, String cssSelector){
		driver.findElement(By.cssSelector(cssSelector)).click();
	}	
	
	

	/*-----------------------Somente setar valor--------------------------*/
	@Test
	public void setarValorPorID(FirefoxDriver driver, String idCampo, String valorCampo){
		driver.findElement(By.id(idCampo)).sendKeys(valorCampo);
	}
	
	@Test
	public void setarValorPorNome(FirefoxDriver driver, String NomeCampo, String valorCampo){
		driver.findElement(By.name(NomeCampo)).sendKeys(valorCampo);
	}	
	
	@Test
	public void setarValorPorXpath(FirefoxDriver driver, String pathCampo, String valorCampo){
		driver.findElement(By.xpath(pathCampo)).sendKeys(valorCampo);
	}	
	
	
	
	/*-----------------------Clicar e setar valor--------------------------*/
	@Test
	public void clicarESetarPorID(FirefoxDriver driver, String idCampo, String valorCampo){
		driver.findElement(By.id(idCampo)).click();
		driver.findElement(By.id(idCampo)).sendKeys(valorCampo);
	}
	
	@Test
	public void clicarESetarPorNome(FirefoxDriver driver, String idCampo, String valorCampo){
		driver.findElement(By.name(idCampo)).click();
		driver.findElement(By.name(idCampo)).sendKeys(valorCampo);
	}
	
	@Test
	public void clicarESetarPorXpath(FirefoxDriver driver, String pathCampo, String valorCampo){
		driver.findElement(By.xpath(pathCampo)).click();
		driver.findElement(By.xpath(pathCampo)).sendKeys(valorCampo);
	}
	
	
	
	/*----------------------------Campos Select------------------------------*/
	@Test
	public void campoSelectValuePorID(FirefoxDriver driver, String idCampo, String valorOption){
		Select select = new Select(driver.findElement(By.id(idCampo))); 
		select.selectByValue(valorOption);
	}
	
	@Test
	public void campoSelectValuePorNome(FirefoxDriver driver, String NomeCampo, String valorOption){
		Select select = new Select(driver.findElement(By.name(NomeCampo))); 
		select.selectByValue(valorOption);
	}
	
	@Test
	public void campoSelectIndexPorID(FirefoxDriver driver, String idCampo, int valorOption){
		Select select = new Select(driver.findElement(By.id(idCampo))); 
		select.selectByIndex(valorOption);
	}
	
	@Test
	public void campoSelectIndexPorNome(FirefoxDriver driver, String NomeCampo, int valorOption){
		Select select = new Select(driver.findElement(By.name(NomeCampo))); 
		select.selectByIndex(valorOption);
	}
	
	
	
	/*----------------------------Campos Checkbox------------------------------*/
	@Test
	public void MarcarCheckboxPorID(FirefoxDriver driver, String idCampo){
		WebElement checkbox;
		checkbox = driver.findElement(By.id(idCampo));	

	    if(!checkbox.isSelected()){
	    	checkbox.click();
	    }
	}
	
	@Test
	public void MarcarCheckboxPorNome(FirefoxDriver driver, String NomeCampo){
		WebElement checkbox;
		checkbox = driver.findElement(By.name(NomeCampo));	

	    if(!checkbox.isSelected()){
	    	checkbox.click();
	    }
	}
	
	@Test
	public void MarcarCheckboxPorCssSelector(FirefoxDriver driver, String SeletorCampo){
		WebElement checkbox;
		checkbox = driver.findElement(By.cssSelector(SeletorCampo));	

	    if(!checkbox.isSelected()){
	    	checkbox.click();
	    }
	}
	
}
