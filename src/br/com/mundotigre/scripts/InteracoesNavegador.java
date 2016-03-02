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
	public void desativarJSFirefox(WebDriver driver, Logger logger, String fieldName){
		
		System.out.println("\n------------------ "+fieldName+" com Javascript desabilitado --------------------");
		
		logger.info("");		
		logger.info("------------------------------------------------------------------------------------------"
		+fieldName+" com Javascript desabilitado "
				  + " -----------------------------------------------------------------------------------------");
	}	
	
	
/*############################################################################################ SOMENTE CLIQUE ###########################################################################################*/
	
	@Test
	public void clicarCampoPorID(WebDriver driver, String FieldID){
		
		driver.findElement(By.id(FieldID)).click();
	}
	
	
	@Test
	public void clicarCampoPorNome(WebDriver driver, String fieldName){
		
		driver.findElement(By.name(fieldName)).click();
	}
	
	
	@Test
	public void clicarCampoPorXpath(WebDriver driver, String fieldXPath){
		
		driver.findElement(By.xpath(fieldXPath)).click();
	}
	
	
	@Test
	public void clicarCampoPorCssSelector(WebDriver driver, String cssSelector){
		
		driver.findElement(By.cssSelector(cssSelector)).click();
	}	
	
	
/*########################################################################################## SOMENTE SETAR VALOR #######################################################################################*/
	
	@Test
	public void setarValorPorID(WebDriver driver, String FieldID, String fieldValue){
		
		driver.findElement(By.id(FieldID)).sendKeys(fieldValue);
	}
	
	
	@Test
	public void setarValorPorNome(WebDriver driver, String fieldName, String fieldValue){
		
		driver.findElement(By.name(fieldName)).sendKeys(fieldValue);
	}
	
	
	@Test
	public void setarValorPorXpath(WebDriver driver, String fieldXPath, String fieldValue){
		
		driver.findElement(By.xpath(fieldXPath)).sendKeys(fieldValue);
	}	
	
	
/*###################################################################################### CLICAR E SETAR VALOR ###########################################################################################*/
	
	@Test
	public void clicarESetarPorID(WebDriver driver, String FieldID, String fieldValue){
		
		driver.findElement(By.id(FieldID)).click();
		driver.findElement(By.id(FieldID)).sendKeys(fieldValue);
	}
	
	
	@Test
	public void clicarESetarPorNome(WebDriver driver, String fieldName, String fieldValue){
		
		driver.findElement(By.name(fieldName)).click();
		driver.findElement(By.name(fieldName)).sendKeys(fieldValue);
	}
	
	
	@Test
	public void clicarESetarPorXpath(WebDriver driver, String fieldXPath, String fieldValue){
		
		driver.findElement(By.xpath(fieldXPath)).click();
		driver.findElement(By.xpath(fieldXPath)).sendKeys(fieldValue);
	}
	
	
/*##################################################################################### CLICAR E LIMPAR #################################################################################################*/
	
	@Test
	public void clicarELimparPorID(WebDriver driver, String FieldID){
		
		driver.findElement(By.id(FieldID)).click();
		driver.findElement(By.id(FieldID)).clear();
	}
	
	
	@Test
	public void clicarELimparPorNome(WebDriver driver, String fieldName){
		
		driver.findElement(By.name(fieldName)).click();
		driver.findElement(By.name(fieldName)).clear();
	}
	
	
	@Test
	public void clicarELimparPorXPath(WebDriver driver, String fieldXPath){
		
		driver.findElement(By.xpath(fieldXPath)).click();
		driver.findElement(By.xpath(fieldXPath)).clear();
	}	
	
	
/*#################################################################################### CAMPOS SELECT ####################################################################################################*/
	
	@Test
	public void campoSelectValuePorID(WebDriver driver, String FieldID, String optionValue){
		
		Select select = new Select(driver.findElement(By.id(FieldID))); 
		select.selectByValue(optionValue);	
	}
	
	
	@Test
	public void campoSelectValuePorNome(WebDriver driver, String fieldName, String optionValue){
		
		Select select = new Select(driver.findElement(By.name(fieldName))); 
		select.selectByValue(optionValue);
	}
	
	
	@Test
	public void campoSelectIndexPorID(WebDriver driver, String FieldID, int optionValue){
		
		Select select = new Select(driver.findElement(By.id(FieldID))); 
		select.selectByIndex(optionValue);
	}
	
	
	@Test
	public void campoSelectIndexPorNome(WebDriver driver, String fieldName, int optionValue){
		
		Select select = new Select(driver.findElement(By.name(fieldName))); 
		select.selectByIndex(optionValue);
	}	
	
	
/*################################################################################# CAMPOS CHECKBOX #####################################################################################################*/
	
	@Test
	public void marcarCheckboxPorID(WebDriver driver, String FieldID){
		
		WebElement checkbox;
		
		checkbox = driver.findElement(By.id(FieldID));	

	    if(!checkbox.isSelected()){
	    	checkbox.click();
	    }
	}
	
	
	@Test
	public void marcarCheckboxPorNome(WebDriver driver, String fieldName){
		
		WebElement checkbox;
		
		checkbox = driver.findElement(By.name(fieldName));	

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
