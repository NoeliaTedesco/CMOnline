package ar.com.osde.cmonline.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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
	
	@FindBy(xpath = ("(.//*[normalize-space(text()) and normalize-space(.)='Gestión de prácticas'])[1]/following::h5[1]"))
	private WebElement menuGestionPractica;

	@FindBy(css = "button.btn.btn-success")
	private WebElement btnEnviarInvitacion;

	@FindBy(xpath = ("(.//*[normalize-space(text()) and normalize-space(.)='Enviar Invitacion'])[1]/following::div[3]"))
	private WebElement formularioInvitacion;

	@FindBy(name = "valorIdentificacion")
	private WebElement valorIdentificacion;
	
	@FindBy(id = "email")
	private WebElement campoEmail;

	@FindBy(id = "phone")
	private WebElement campoTelefono;
	
	@FindBy (id = "clinica")
	private WebElement especialidadClinica;
	
	@FindBy (id = "pediatria")
	private WebElement especialidadPedriatrica;

	@FindBy(name = "detalle")
	private WebElement campoDetalle;
	
	@FindBy(id = "apellido")
	private WebElement campoApellido;

	@FindBy(id = "nombre")
	private WebElement campoNombre;

	@FindBy(id = "fechaNacimiento")
	private WebElement campoFechaNacimiento;

	@FindBy(id = "id_servicio")
	private WebElement campoIdServicio;

	@FindBy (xpath= ("//*[@id=\"enviarInvitacionForm\"]/div/footer/div/div/div/div[2]/button"))
	private WebElement btnEnviar;
	
	@FindBy (css = "i.fa.fa-2x.fa-trash")
	private WebElement btnAnular;
	
	@FindBy (name = "detalleMotivo")
	private WebElement campoMotivoAnular;
	
	@FindBy (xpath = ("//button[2]"))
	private WebElement btnConfirmar;
	
	@FindBy (css ="i.fa.fa-2x.fa-mail-forward")
	private WebElement btnReenviarInvitacion;
	
	@FindBy (xpath = ("(.//*[normalize-space(text()) and normalize-space(.)='Exportar'])[1]/following::input[1]"))
	private WebElement checkSoloActivas;
	
	@FindBy (xpath = ("(.//*[normalize-space(text()) and normalize-space(.)='actualizado: 10:17:41 hs'])[1]/following::button[1]"))
	private WebElement btnExportarInv;
	
	@FindBy (name = "desde")
	private WebElement calendDesde;
	
	@FindBy (name = "hasta")
	private WebElement calendHasta;
	
	@FindBy (xpath = ("(.//*[normalize-space(text()) and normalize-space(.)='Salir'])[1]/following::button[1]"))
	private WebElement btnExportar;
	
	@FindBy (css = "div.toast-message")
	private WebElement alertas;
	
	@FindBy (xpath = ("//a[contains(text(),'Cambiar contraseña')]"))
	private WebElement menuCambiarContrasena;
	
	@FindBy (id = "newPassword")
	private WebElement cmpNuevaContrasena;
	
	@FindBy (id = "repeatNewPassword")
	private WebElement cmpRepNuevaContrasena;
	
	@FindBy (id = "btSalir")
	private WebElement btnSalir;
	
	public Prestadores(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver,this);		
	}
	
	public void IniciarSesion(String usuarioPrueba, String contrasena) {
		try {
			cUsuario.click();
			cUsuario.sendKeys(usuarioPrueba);
			cContrasena.clear();
			cContrasena.click();
			cContrasena.sendKeys(contrasena);
			bEnviar.click();
		} catch (Exception e) {
			System.out.println("Error al iniciar sesión");
		}

	}

	public void IngresarGestionPractica() {
		try {
			if (menuGestionPractica.isDisplayed()) {
				menuGestionPractica.click();
			} else {
				System.out.println("No se encuentra visible el botón para ingresar a la gestión de prácticas");
			}
		} catch (Exception e) {

		}

	}

	public void AbrirEnviarInvitacion() {
		btnEnviarInvitacion.click();
	}

	public boolean esVisibleFormularioInvitacion() {
		if (formularioInvitacion.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}
	
	
	public void crearInvitacion(String nroSocio, String celular, String email, String especialidad, String detalle,
			String nombre, String apellido,  String fechaNacimiento, String idServicio) {
		
		valorIdentificacion.sendKeys(nroSocio);
		campoTelefono.sendKeys(celular);
		campoEmail.sendKeys(email);
		switch (especialidad) {
		case "Clinica" : especialidadClinica.click();
		case "Pedriatria" : especialidadPedriatrica.click();
		}
		campoDetalle.sendKeys(detalle);
		campoNombre.sendKeys(nombre);
		campoApellido.sendKeys(apellido);
		campoFechaNacimiento.sendKeys(fechaNacimiento);
		campoIdServicio.sendKeys(idServicio);
		btnEnviar.click();
	}
	
	
}
