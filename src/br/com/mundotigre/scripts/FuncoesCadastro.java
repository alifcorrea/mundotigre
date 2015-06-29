package br.com.mundotigre.scripts;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class FuncoesCadastro {

	@Test
	public void botaoCadastro(WebDriver driver){
		driver.findElement(By.xpath("//*[@value='Cadastrar']")).click();
	}	
	
	@Test
	public void clicarBotaoCadastreSe(WebDriver driver){
		driver.findElement(By.xpath("//*[@href='/cadastro/new']")).click();
	}	
	
	@Test
	public void fecharBanner(WebDriver driver){
		driver.findElement(By.xpath("//*[@class='fancybox-item fancybox-close close-palpite']")).click();
	}
	
	@Test
	public void botaoParticiparBanner(WebDriver driver){
		driver.findElement(By.xpath("//*[@class='fancybox-image']")).click();
	}
	
	@Test
	public void marcarAtividadesFisicas(WebDriver driver){
		InteracoesNavegador funcoes =  new InteracoesNavegador();
		
		funcoes.marcarCheckboxPorCssSelector(driver, "input[id='mundo_tigre_atividade_fisica_list_5']");
		funcoes.marcarCheckboxPorCssSelector(driver, "input[id='mundo_tigre_atividade_fisica_list_3']");
		funcoes.marcarCheckboxPorCssSelector(driver, "input[id='mundo_tigre_atividade_fisica_list_4']");
		funcoes.marcarCheckboxPorCssSelector(driver, "input[id='mundo_tigre_atividade_fisica_list_6']");
		funcoes.marcarCheckboxPorCssSelector(driver, "input[id='mundo_tigre_atividade_fisica_list_1']");
		funcoes.marcarCheckboxPorCssSelector(driver, "input[id='mundo_tigre_atividade_fisica_list_8']");
		funcoes.marcarCheckboxPorCssSelector(driver, "input[id='mundo_tigre_atividade_fisica_list_13']");
		funcoes.marcarCheckboxPorID(driver, "mundo_tigre_atividade_fisica_list_12");
		funcoes.marcarCheckboxPorID(driver, "mundo_tigre_atividade_fisica_list_7");
		funcoes.marcarCheckboxPorID(driver, "mundo_tigre_atividade_fisica_list_2");
	}
	
	
	@Test
	public void receberNovidades(WebDriver driver){
		InteracoesNavegador funcoes =  new InteracoesNavegador();
		funcoes.clicarCampoPorID(driver, "cadastro-novidade");
	}
	
	@Test
	public void receberSms(WebDriver driver){
		InteracoesNavegador funcoes =  new InteracoesNavegador();
		funcoes.clicarCampoPorID(driver, "cadastro-sms");  
	}
	
	
	@Test
	public void marcarAreasInteresse(WebDriver driver){
		InteracoesNavegador funcoes =  new InteracoesNavegador();
		
		funcoes.marcarCheckboxPorID(driver, "mundo_tigre_area_interesse_list_1");
		funcoes.marcarCheckboxPorID(driver, "mundo_tigre_area_interesse_list_14");
		funcoes.marcarCheckboxPorID(driver, "mundo_tigre_area_interesse_list_2");  
		funcoes.marcarCheckboxPorID(driver, "mundo_tigre_area_interesse_list_3");
	}
	
	@Test
	public boolean CadastroJaRealizado(WebDriver driver){
		
		//Se a URLAtual contem o texto abaixo, retorna ate a página anterior para a proxima execução
		String URLAtual = driver.getCurrentUrl();			
		
		if(URLAtual.contains("/confirmacao") || URLAtual.contains("cadastro/confirmacao")){
			System.out.println("Cadastro já realizado");
			driver.navigate().back();
			return true;
		}
		return false;
	}
	
	@Test
	public boolean passouCadastroCompleto(WebDriver driver){
		
		//Se a URLAtual contem o texto abaixo, retorna ate a página anterior para a proxima execução
		String URLAtual = driver.getCurrentUrl();			
		
		if(URLAtual.contains("http://www.mundotigre.com.br/cadastro?cpf") || URLAtual.contains("/cadastro/confirmacao/")){
			driver.navigate().back();
 			return true;
		}
		return false;
	}
	
	@Test
	public boolean errosValidacao(WebDriver driver){
		
		//Se a URLAtual contem o texto abaixo, retorna ate a página anterior para a proxima execução
		String URLAtual = driver.getCurrentUrl();			
		
		if(URLAtual.contains("/create")){
			driver.navigate().back();
			return true;
		}
		return false;
	}
	
	
	@Test
	public void logCampoOK(WebDriver driver, String nomeCampo, String valorCampo){
		
		System.out.println("Teste "+ nomeCampo +" [+OK]: " + valorCampo);
	}
	
	
	@Test
	public void logCampoErro(WebDriver driver, String nomeCampo, String valorCampo){
		
		System.out.println("Teste "+ nomeCampo +" [-ERRO]: " + valorCampo);
	
	}
	
	
	@Test
	public void logInformacoesExecucao(WebDriver driver, String campo, int quantidadeAcertos, int quantidadeErros, int acertosSemJS, int errosSemJS, long tempoInicio){
		
		Date d = GregorianCalendar.getInstance().getTime();  
        SimpleDateFormat format = new SimpleDateFormat();
		
		System.out.println("\n-------------------------Resultados do teste de "+campo+"--------------------------\n"
				+ "Total de vezes que enviou com Javascript habilitado: " + quantidadeAcertos + "\n"
				+ "Total de vezes que não enviou com Javascript habilitado: " + quantidadeErros);
		
		
		System.out.println("\nTotal de vezes que enviou com Javascript desabilitado: " + acertosSemJS + "\n"
				+ "Total de vezes que não enviou com Javascript desabilitado: " + errosSemJS);

		int envios = quantidadeAcertos + acertosSemJS;
		int naoEnvios = quantidadeErros + errosSemJS;

		long tempoFim = System.currentTimeMillis(); 
		System.out.println("\nTotal de vezes que enviou: " + envios + "\n"
				+ "Total de vezes que não enviou: "	+ naoEnvios + "\n\n" 
				+ "Data da execução: "+ format.format(d) +"\n"							
				+ "Tempo total de execução: " + new SimpleDateFormat("mm:ss").format(new Date(tempoFim - tempoInicio))+"\n"	
				+ "----------------------------------------------------------------------------");
	}
	
	
	
	
	
}
