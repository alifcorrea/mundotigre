package br.com.MundoTigre.funcoesPrincipais.contato;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LinksMenu {
	
public FirefoxDriver driver;
	
	@Before
	public void Inicio(){
		System.setProperty("webdriver.chrome.driver", "C:/Users/alif.correa/Documents/eclipse/chromedriver.exe");
		driver = new FirefoxDriver();
	}
	
	@Test
	public void linksMenu(){
		
		driver.get("http://www.mundotigre.com.br/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//*[@class='fancybox-item fancybox-close close-palpite']")).click();
	
		driver.findElement(By.xpath("//*[@href='/o-que-e']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		//---------------------COMO PARTICIPAR----------------------------//	
		driver.findElement(By.xpath("//*[@href='/como-participar']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@href='/images/../uploads/regulamentos/Regulamento_Geral_Programa.pdf']")).click();
		fecharNovaJanela();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@href='/images/../uploads/regulamentos/Dia_Da_Profissao.pdf']")).click();
		
		fecharNovaJanela();
		
		driver.findElement(By.xpath("//*[@href='/images/../uploads/regulamentos/Premiacao_Aniversariante.pdf']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		fecharNovaJanela();
		
		driver.findElement(By.xpath("//*[@href='http://www.mundotigre.com.br/uploads/regulamentos/CED.pdf']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		fecharNovaJanela();
		
		driver.findElement(By.xpath("//*[@href='	http://www.mundotigre.com.br/uploads/regulamentos/SUSEP.pdf']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		fecharNovaJanela();	
		//---------------------COMO PARTICIPAR FIM----------------------------//	
		
		
		driver.findElement(By.xpath("//*[@href='/como-pontuar']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//*[@href='/premios']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//*[@href='/ganhadores']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//*[@href='/marcaemidia']")).click();
		driver.navigate().back();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//*[@href='/cpdv']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	@Test
	public void fecharNovaJanela(){
		
		String mainHandle = driver.getWindowHandle();
		String[] handles = driver.getWindowHandles().toArray(new String[1]);
		driver.switchTo().window(handles[handles.length - 1]);
		
		driver.close();
		driver.switchTo().window(mainHandle);
	}
	
}
