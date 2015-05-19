package br.com.MundoTigre.scripts;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
	public void AtividadeFisicaEsportiva(FirefoxDriver driver){

		//Cria os objetos checkbox
		 WebElement checkBox1;
		 WebElement checkBox2;
		 WebElement checkBox3;
		 WebElement checkBox4;
		 WebElement checkBox5;
		 WebElement checkBox6;
		 WebElement checkBox7;
		 WebElement checkBox8;
		 WebElement checkBox9;
		 WebElement checkBox10;

		 	//passa os parametros para os objetos, pegando o id dos elementos
		    checkBox1 = driver.findElement(By.cssSelector("input[id='mundo_tigre_atividade_fisica_list_5']"));
		    checkBox2 = driver.findElement(By.cssSelector("input[id='mundo_tigre_atividade_fisica_list_3']"));
		    checkBox3 = driver.findElement(By.cssSelector("input[id='mundo_tigre_atividade_fisica_list_4']"));
		    checkBox4 = driver.findElement(By.cssSelector("input[id='mundo_tigre_atividade_fisica_list_6']"));
		    checkBox5 = driver.findElement(By.cssSelector("input[id='mundo_tigre_atividade_fisica_list_1']"));
		    checkBox6 = driver.findElement(By.cssSelector("input[id='mundo_tigre_atividade_fisica_list_8']"));
		    checkBox7 = driver.findElement(By.cssSelector("input[id='mundo_tigre_atividade_fisica_list_13']"));
		    checkBox8 = driver.findElement(By.id("mundo_tigre_atividade_fisica_list_12"));
		    checkBox9 = driver.findElement(By.id("mundo_tigre_atividade_fisica_list_7"));
		   checkBox10 = driver.findElement(By.id("mundo_tigre_atividade_fisica_list_2"));
		   
		    //se o checkBox1 for diferente de selecionado
		    if(!checkBox1.isSelected()){
		    	//clique no checkBox1
		        checkBox1.click();
		    }

		    if(!checkBox2.isSelected()){
		        checkBox2.click();
		    }
		    
		    if(!checkBox3.isSelected()){
		    	checkBox3.click();
		    }
		    
		    if(!checkBox4.isSelected()){
		    	checkBox4.click();
		    }
		    
		    if(!checkBox5.isSelected()){
		    	checkBox5.click();
		    }
		    
		    if(!checkBox6.isSelected()){
		    	checkBox6.click();
		    }
		    
		    if(!checkBox7.isSelected()){
		    	checkBox7.click();
		    }
		    
		    if(!checkBox8.isSelected()){
		    	checkBox8.click();
		    }
		    
		    if(!checkBox9.isSelected()){
		    	checkBox9.click();
		    }
		    
		    if(!checkBox10.isSelected()){
		    	checkBox10.click();
		    }
		    
		   //Fim dos checkBox    
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
