package br.com.mundotigre.scripts;

import static org.monte.media.FormatKeys.EncodingKey;
import static org.monte.media.FormatKeys.FrameRateKey;
import static org.monte.media.FormatKeys.KeyFrameIntervalKey;
import static org.monte.media.FormatKeys.MIME_AVI;
import static org.monte.media.FormatKeys.MediaTypeKey;
import static org.monte.media.FormatKeys.MimeTypeKey;
import static org.monte.media.VideoFormatKeys.CompressorNameKey;
import static org.monte.media.VideoFormatKeys.DepthKey;
import static org.monte.media.VideoFormatKeys.ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE;
import static org.monte.media.VideoFormatKeys.QualityKey;

import java.awt.AWTException;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.monte.media.Format;
import org.monte.media.FormatKeys.MediaType;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class GravarExecucao {
	
	private static ScreenRecorder screenRecorder;
	
	@Test
	public void iniciarGravacao(WebDriver driver, Logger logger) throws IOException, AWTException {  
		
		GraphicsConfiguration gconfig = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
	      
	    screenRecorder = new ScreenRecorder(gconfig,new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
	    CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
	    DepthKey, (int)24, FrameRateKey, Rational.valueOf(15),
	    QualityKey, 1.0f, KeyFrameIntervalKey, (int) (15 * 60)),	    		  
	    new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey,"black", FrameRateKey, Rational.valueOf(30)), null);
	    
	    screenRecorder.start();
	    
	    FuncoesMT funcoesMT = new FuncoesMT();	      
	    File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(screenshot, new File("C:/Users/alif.correa/Workspace/MundoTigre/arquivosexecucao/screenshots/"+funcoesMT.numerosAleatorios()+".jpeg"));
	    
	}
	   
	@Test
	public void finalizarGravacao(WebDriver driver, Logger logger) throws IOException, AWTException{ 
	    System.out.println("O video foi gravado com sucesso!");
	    logger.info("O video foi gravado com sucesso!");
	    screenRecorder.stop();
	}
	
	   
}
