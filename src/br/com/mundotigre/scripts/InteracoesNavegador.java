package br.com.mundotigre.scripts;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class InteracoesNavegador {
	
	@Test
	public void abrirLink(WebDriver driver, String link){
		driver.get(link);
	}
	
	
	@Test
	public void AguardarCarregamento(WebDriver driver){
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}	
	
	
	@Test
	public void desativarJSFirefox(WebDriver driver, Logger logger, String nomeCampo){
		
		System.out.println("\n------------------ "+nomeCampo+" com Javascript desabilitado --------------------");
		
		logger.info("");		
		logger.info("------------------------------------------------------------------------------------------"
		+nomeCampo+" com Javascript desabilitado "
				  + " -----------------------------------------------------------------------------------------");
	}	
	
	
/*############################################################################################ SOMENTE CLIQUE ###########################################################################################*/
	
	@Test
	public void clicarCampoPorID(WebDriver driver, String idCampo){
		
		driver.findElement(By.id(idCampo)).click();
	}
	
	
	@Test
	public void clicarCampoPorNome(WebDriver driver, String nomeCampo){
		
		driver.findElement(By.name(nomeCampo)).click();
	}
	
	
	@Test
	public void clicarCampoPorXpath(WebDriver driver, String pathCampo){
		
		driver.findElement(By.xpath(pathCampo)).click();
	}
	
	
	@Test
	public void clicarCampoPorCssSelector(WebDriver driver, String cssSelector){
		
		driver.findElement(By.cssSelector(cssSelector)).click();
	}	
	
	
/*########################################################################################## SOMENTE SETAR VALOR #######################################################################################*/
	
	@Test
	public void setarValorPorID(WebDriver driver, String idCampo, String valorCampo){
		
		driver.findElement(By.id(idCampo)).sendKeys(valorCampo);
	}
	
	
	@Test
	public void setarValorPorNome(WebDriver driver, String nomeCampo, String valorCampo){
		
		driver.findElement(By.name(nomeCampo)).sendKeys(valorCampo);
	}
	
	
	@Test
	public void setarValorPorXpath(WebDriver driver, String pathCampo, String valorCampo){
		
		driver.findElement(By.xpath(pathCampo)).sendKeys(valorCampo);
	}	
	
	
/*###################################################################################### CLICAR E SETAR VALOR ###########################################################################################*/
	
	@Test
	public void clicarESetarPorID(WebDriver driver, String idCampo, String valorCampo){
		
		driver.findElement(By.id(idCampo)).click();
		driver.findElement(By.id(idCampo)).sendKeys(valorCampo);
	}
	
	
	@Test
	public void clicarESetarPorNome(WebDriver driver, String nomeCampo, String valorCampo){
		
		driver.findElement(By.name(nomeCampo)).click();
		driver.findElement(By.name(nomeCampo)).sendKeys(valorCampo);
	}
	
	
	@Test
	public void clicarESetarPorXpath(WebDriver driver, String pathCampo, String valorCampo){
		
		driver.findElement(By.xpath(pathCampo)).click();
		driver.findElement(By.xpath(pathCampo)).sendKeys(valorCampo);
	}
	
	
/*##################################################################################### CLICAR E LIMPAR #################################################################################################*/
	
	@Test
	public void clicarELimparPorID(WebDriver driver, String idCampo){
		
		driver.findElement(By.id(idCampo)).click();
		driver.findElement(By.id(idCampo)).clear();
	}
	
	
	@Test
	public void clicarELimparPorNome(WebDriver driver, String nomeCampo){
		
		driver.findElement(By.name(nomeCampo)).click();
		driver.findElement(By.name(nomeCampo)).clear();
	}
	
	
	@Test
	public void clicarELimparPorXPath(WebDriver driver, String pathCampo){
		
		driver.findElement(By.xpath(pathCampo)).click();
		driver.findElement(By.xpath(pathCampo)).clear();
	}	
	
	
/*#################################################################################### CAMPOS SELECT ####################################################################################################*/
	
	@Test
	public void campoSelectValuePorID(WebDriver driver, String idCampo, String valorOption){
		
		Select select = new Select(driver.findElement(By.id(idCampo))); 
		select.selectByValue(valorOption);	
	}
	
	
	@Test
	public void campoSelectValuePorNome(WebDriver driver, String NomeCampo, String valorOption){
		
		Select select = new Select(driver.findElement(By.name(NomeCampo))); 
		select.selectByValue(valorOption);
	}
	
	
	@Test
	public void campoSelectIndexPorID(WebDriver driver, String idCampo, int valorOption){
		
		Select select = new Select(driver.findElement(By.id(idCampo))); 
		select.selectByIndex(valorOption);
	}
	
	
	@Test
	public void campoSelectIndexPorNome(WebDriver driver, String NomeCampo, int valorOption){
		
		Select select = new Select(driver.findElement(By.name(NomeCampo))); 
		select.selectByIndex(valorOption);
	}	
	
	
/*################################################################################# CAMPOS CHECKBOX #####################################################################################################*/
	
	@Test
	public void marcarCheckboxPorID(WebDriver driver, String idCampo){
		
		WebElement checkbox;
		
		checkbox = driver.findElement(By.id(idCampo));	

	    if(!checkbox.isSelected()){
	    	checkbox.click();
	    }
	}
	
	
	@Test
	public void marcarCheckboxPorNome(WebDriver driver, String NomeCampo){
		
		WebElement checkbox;
		
		checkbox = driver.findElement(By.name(NomeCampo));	

	    if(!checkbox.isSelected()){
	    	checkbox.click();
	    }
	}
	
	
	@Test
	public void marcarCheckboxPorCssSelector(WebDriver driver, String SeletorCampo){
		
		WebElement checkbox;
		
		checkbox = driver.findElement(By.cssSelector(SeletorCampo));	

	    if(!checkbox.isSelected()){
	    	checkbox.click();
	    }
	}	
}
