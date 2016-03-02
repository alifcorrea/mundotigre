package br.com.mundotigre.scripts;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class FuncoesMT {

	@Test
	public void fecharBanner(WebDriver driver){
		
		driver.findElement(By.xpath("//*[@class='fancybox-item fancybox-close close-palpite']")).click();
	}
	
	
	@Test
	public void botaoParticiparBanner(WebDriver driver){
		
		driver.findElement(By.xpath("//*[@class='fancybox-image']")).click();
	}
	
	
/*##################################################################################### RELATORIOS ######################################################################################################*/
	
	@Test
	public void logInicio(WebDriver driver, Logger logger, String fieldName){

		System.out.println("\n-----------------------------Teste "+fieldName+"-------------------------------");
		logger.info("--------------------------------------"
					+ "------------------------------------Teste "+fieldName+"-------------------------------"
					+ "--------------------------------------------------------------------------------------");
	}
	
	
	@Test
	public void logCampoOK(WebDriver driver, Logger logger, String fieldName, String fieldValue){	
		
		System.out.println("Teste "+ fieldName +" [+Passou]: " + fieldValue);
		logger.info("Teste "+ fieldName +" [+Passou]: " + fieldValue);
	}
	
	
	@Test
	public void logCampoErro(WebDriver driver, Logger logger, String fieldName, String fieldValue){
		
		System.out.println("Teste "+ fieldName +" [-Não Passou]: " + fieldValue);
		logger.info("Teste "+ fieldName +" [-Não Passou]: " + fieldValue);
	}
	
	
	@Test
	public void logInformacoesExecucao(WebDriver driver, Logger logger, String field, int hits, int errors, int hitsWithJS, int errorsWithoutJS, long startTime){
		
		long EndTime = System.currentTimeMillis(); 
		
		/*######################################### Imprimir no Console #####################################*/
		System.out.println("\n-------------------------Resultados do teste de "+field+"--------------------------\n"
				+ "Total de vezes que enviou com Javascript habilitado: " + hits + "\n"
				+ "Total de vezes que não enviou com Javascript habilitado: " + errors);
		
		
		System.out.println("\nTotal de vezes que enviou com Javascript desabilitado: " + hitsWithJS + "\n"
				+ "Total de vezes que não enviou com Javascript desabilitado: " + errorsWithoutJS);
		
		
		int submited = hits + hitsWithJS;
		int notSubmited = errors + errorsWithoutJS;
		
		
		System.out.println("\nTotal de vezes que enviou: " + submited + "\n"
				+ "Total de vezes que não enviou: "	+ notSubmited + "\n\n" 							
				+ "Tempo total de execução: " + new SimpleDateFormat("mm:ss").format(new Date(EndTime - startTime))+"\n"	
				+ "----------------------------------------------------------------------------");
		
		
		/*########################################### Imprimir no Log #######################################*/
		logger.info("");
		logger.info("------------------------------------------------------------------------------Resultados do teste de "+field+"----------------------------------------------------------------------------------------------------------------------");
		logger.info("Total de vezes que enviou com Javascript habilitado: " + hits);
		logger.info("Total de vezes que não enviou com Javascript habilitado: " + errors);
		
		logger.info("");
		
		logger.info("Total de vezes que enviou com Javascript desabilitado: " + hitsWithJS);
		logger.info("Total de vezes que não enviou com Javascript desabilitado: " + errorsWithoutJS);
		
		logger.info("");	
		logger.info("Total de vezes que enviou: " + submited);
		logger.info("Total de vezes que não enviou: "	+ notSubmited);  	
		
		logger.info("");		
		logger.info("Tempo total de execução: " + new SimpleDateFormat("mm:ss").format(new Date(EndTime - startTime)));
		logger.info("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
	}	
	
	
	@Test
	public static void relatorioFinal(WebDriver driver, Logger logger, long startTime){
		
		long EndTime = System.currentTimeMillis(); 		
		Date dataExecucao = GregorianCalendar.getInstance().getTime();  
        SimpleDateFormat format = new SimpleDateFormat();        
        
		System.out.println("\nData da execução: "+ format.format(dataExecucao) +"\n"
							+"Tempo total de execução de todos os testes: " + new SimpleDateFormat("mm:ss").format(new Date(EndTime - startTime))+"\n");		
		
		logger.info("Data da execução: "+ format.format(dataExecucao));
		logger.info("Tempo total de execução de todos os testes: " + new SimpleDateFormat("mm:ss").format(new Date(EndTime - startTime)));
		logger.info("####################################################################################################################################################################################################################");
	}
	
	
/*############################################################################### GERAÇÃO DE CARACTERES #################################################################################################*/	
	
	@Test
	public String caracteresAleatorios(){
		
		Random random = new Random();	
		
		String string = "ABCDEFGHIJKLMNOPQRSTUVYWXZ";
		String randomString = "";  
		int index = -1;  
	
		for( int i = 0; i < 9; i++ ) {  
		   index = random.nextInt( string.length() );  
		   randomString += string.substring( index, index + 1 );  
		}  
		
		return randomString;
	}
	
	
	@Test
	public String numerosAleatorios(){

		  Random randomCPF = new Random();
		  
		  for (int iCPF = 0; iCPF < 10; iCPF++);
		  
		  String cpf = Integer.toString(randomCPF.nextInt(2147483647));	
		  String cpfFim = cpf+22;	 
		  
		  return cpfFim;	  
	}	
	
	
/*############################################################################### CONTAR ELEMENTOS #################################################################################################*/	
	
	@Test
	public void contarElementosPorXpath(WebDriver driver, String fieldValue){
		
		List<WebElement> listOfElements = driver.findElements(By.xpath(fieldValue));
		
		int count = listOfElements.size();
		
		System.out.println("O campo "+ fieldValue +" contém "+ count +" elementos");
	}
}
