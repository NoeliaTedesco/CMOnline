package ar.com.osde.cmonline.testng;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import ar.com.osde.cmonline.selenium.Base_Test;
	

public class Test_Prestadores {
	
	private Base_Test driver;
	
	@Parameters({"rol", "ipNodo"})
	@BeforeClass
	public void startUp(String rol, String ipNodo) throws InterruptedException {
		driver = new Base_Test(rol, ipNodo);
		driver.ingresarPagina();
		
		
	}

}
