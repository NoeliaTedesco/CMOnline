package ar.com.osde.cmonline.testng;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ar.com.osde.cmonline.selenium.Base_Test;
import ar.com.osde.cmonline.selenium.Prestadores;
	

public class Test_Prestadores {
	
	private Base_Test driver;
	private Prestadores prestador;
	
	@Parameters({"rol", "ipNodo"})
	@BeforeClass
	public void startUp(String rol, String ipNodo) throws InterruptedException {
		driver = new Base_Test(rol, ipNodo);
		driver.ingresarPagina();			
	}
	
	@Parameters ({"usuario", "contrasena"})
	@Test
	public void invitaciones(String usuario, String contrasena) {
		prestador = new Prestadores(driver.getDriver());
		prestador.IniciarSesion(usuario, contrasena);
		prestador.IngresarGestionPractica();
		prestador.AbrirEnviarInvitacion();
		prestador.esVisibleFormularioInvitacion();
	}

}
