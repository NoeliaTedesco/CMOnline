package ar.com.osde.cmonline.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Prestadores {
	
	private WebDriver driver;	
	private WebDriverWait wait;
	
	@CacheLookup	    
	@FindBy(name = "user")	    
	private WebElement cUsuario;

	@FindBy(name = "password")	    
	private WebElement cContrasena;
	
	@FindBy(xpath = "//button[@type='submit']")	    
	private WebElement bEnviar;
	
	

}
