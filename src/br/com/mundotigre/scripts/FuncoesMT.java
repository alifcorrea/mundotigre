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
	public void logInicio(WebDriver driver, Logger logger, String nomeCampo){

		System.out.println("\n-----------------------------Teste "+nomeCampo+"-------------------------------");
		logger.info("--------------------------------------"
					+ "------------------------------------Teste "+nomeCampo+"-------------------------------"
					+ "--------------------------------------------------------------------------------------");
	}
	
	
	@Test
	public void logCampoOK(WebDriver driver, Logger logger, String nomeCampo, String valorCampo){	
		
		System.out.println("Teste "+ nomeCampo +" [+Passou]: " + valorCampo);
		logger.info("Teste "+ nomeCampo +" [+Passou]: " + valorCampo);
	}
	
	
	@Test
	public void logCampoErro(WebDriver driver, Logger logger, String nomeCampo, String valorCampo){
		
		System.out.println("Teste "+ nomeCampo +" [-Não Passou]: " + valorCampo);
		logger.info("Teste "+ nomeCampo +" [-Não Passou]: " + valorCampo);
	}
	
	
	@Test
	public void logInformacoesExecucao(WebDriver driver, Logger logger, String campo, int quantidadeAcertos, int quantidadeErros, int acertosSemJS, int errosSemJS, long tempoInicio){
		
		long tempoFim = System.currentTimeMillis(); 
		
		/*######################################### Imprimir no Console #####################################*/
		System.out.println("\n-------------------------Resultados do teste de "+campo+"--------------------------\n"
				+ "Total de vezes que enviou com Javascript habilitado: " + quantidadeAcertos + "\n"
				+ "Total de vezes que não enviou com Javascript habilitado: " + quantidadeErros);
		
		
		System.out.println("\nTotal de vezes que enviou com Javascript desabilitado: " + acertosSemJS + "\n"
				+ "Total de vezes que não enviou com Javascript desabilitado: " + errosSemJS);
		
		
		int envios = quantidadeAcertos + acertosSemJS;
		int naoEnvios = quantidadeErros + errosSemJS;
		
		
		System.out.println("\nTotal de vezes que enviou: " + envios + "\n"
				+ "Total de vezes que não enviou: "	+ naoEnvios + "\n\n" 							
				+ "Tempo total de execução: " + new SimpleDateFormat("mm:ss").format(new Date(tempoFim - tempoInicio))+"\n"	
				+ "----------------------------------------------------------------------------");
		
		
		/*########################################### Imprimir no Log #######################################*/
		logger.info("");
		logger.info("------------------------------------------------------------------------------Resultados do teste de "+campo+"----------------------------------------------------------------------------------------------------------------------");
		logger.info("Total de vezes que enviou com Javascript habilitado: " + quantidadeAcertos);
		logger.info("Total de vezes que não enviou com Javascript habilitado: " + quantidadeErros);
		
		logger.info("");
		
		logger.info("Total de vezes que enviou com Javascript desabilitado: " + acertosSemJS);
		logger.info("Total de vezes que não enviou com Javascript desabilitado: " + errosSemJS);
		
		logger.info("");	
		logger.info("Total de vezes que enviou: " + envios);
		logger.info("Total de vezes que não enviou: "	+ naoEnvios);  	
		
		logger.info("");		
		logger.info("Tempo total de execução: " + new SimpleDateFormat("mm:ss").format(new Date(tempoFim - tempoInicio)));
		logger.info("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
	}	
	
	
	@Test
	public static void relatorioFinal(WebDriver driver, Logger logger, long tempoInicio){
		
		long tempoFim = System.currentTimeMillis(); 		
		Date dataExecucao = GregorianCalendar.getInstance().getTime();  
        SimpleDateFormat format = new SimpleDateFormat();        
        
		System.out.println("\nData da execução: "+ format.format(dataExecucao) +"\n"
							+"Tempo total de execução de todos os testes: " + new SimpleDateFormat("mm:ss").format(new Date(tempoFim - tempoInicio))+"\n");		
		
		logger.info("Data da execução: "+ format.format(dataExecucao));
		logger.info("Tempo total de execução de todos os testes: " + new SimpleDateFormat("mm:ss").format(new Date(tempoFim - tempoInicio)));
		logger.info("####################################################################################################################################################################################################################");
	}
	
	
/*############################################################################### GERAÇÃO DE CARACTERES #################################################################################################*/	
	
	@Test
	public String caracteresAleatorios(){
		
		Random random = new Random();	
		
		String letras = "ABCDEFGHIJKLMNOPQRSTUVYWXZ";
		String armazenaChaves = "";  
		int index = -1;  
	
		for( int i = 0; i < 9; i++ ) {  
		   index = random.nextInt( letras.length() );  
		   armazenaChaves += letras.substring( index, index + 1 );  
		}  
		
		return armazenaChaves;
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
	public void contarElementosPorXpath(WebDriver driver, String valorCampo){
		
		List<WebElement> listaDeElementos = driver.findElements(By.xpath(valorCampo));
		
		int count = listaDeElementos.size();
		
		System.out.println("O campo "+ valorCampo +" contém "+ count +" elementos");
	}
}
