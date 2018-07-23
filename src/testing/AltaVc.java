package testing;

import static org.testng.Assert.fail;
import java.util.concurrent.TimeUnit; 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AltaVc {
	
	
	private WebDriver driver;

    private String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();

    @Test
    public void testJava() throws Exception {

                    // Comienzo con el despachador
                    driver.get(baseUrl + "/prestadores/signin");
                    driver.manage().window().maximize();
                    driver.findElement(By.name("password")).clear();
                    driver.findElement(By.name("password")).sendKeys("cmotest2");
                    driver.findElement(By.name("user")).clear();
                    driver.findElement(By.name("user")).sendKeys("cmotest2@cmo.com");
                    driver.findElement(By.xpath("//button[@type='submit']")).click();
                    driver.findElement(By.xpath("//button[@type='button']")).click();
                    driver.findElement(By.name("valorIdentificacion")).clear();
                    driver.findElement(By.name("valorIdentificacion")).sendKeys("01227871809");
                    driver.findElement(By.id("phone")).click();
                    driver.findElement(By.id("phone")).clear();         
                    driver.findElement(By.id("phone")).sendKeys("1130170508");
                    driver.findElement(By.id("email")).click();
                    driver.findElement(By.id("email")).clear();
                    //driver.findElement(By.id("email")).sendKeys("salvatierra.fabian@gmail.com");
                    driver.findElement(By.id("email")).sendKeys("ntedesco@sms-latam.com");
                    driver.findElement(By.id("clinica")).click();
                    new Select(driver.findElement(By.id("motivo"))).selectByVisibleText("Seleccione un motivo");
                    driver.findElement(By.cssSelector("option[value=\"35\"]")).click();
                    driver.findElement(By.xpath("//div[@id='main']/div/div/div/div/div/div/div[2]/form/div/div/div[6]/div/textarea")).click();
                    driver.findElement( By.xpath("//div[@id='main']/div/div/div/div/div/div/div[2]/form/div/div/div[6]/div/textarea")).clear();
                    driver.findElement(By.xpath("//div[@id='main']/div/div/div/div/div/div/div[2]/form/div/div/div[6]/div/textarea")).sendKeys("Ojos Rojos");
                    driver.findElement(By.id("nombre")).clear();
                    driver.findElement(By.id("nombre")).sendKeys("Noelia");
                    driver.findElement(By.id("apellido")).clear();
                    driver.findElement(By.id("apellido")).sendKeys("Tedesco");
                    driver.findElement(By.id("id_servicio")).clear();
                    driver.findElement(By.id("id_servicio")).sendKeys("1234567890");
                    esperarLuegoClick(By.xpath("//button[@type='submit']"));
                    System.out.println("Salir");
                    esperarLuegoClick(By.id("btSalir"));
    }

    private void esperarLuegoClick(By by) throws InterruptedException {
                    WebDriverWait wait = new WebDriverWait(driver, 30);
                    Thread.sleep(1000);
                    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
                    wait.until(ExpectedConditions.elementToBeClickable(by));
                    driver.findElement(by).click();
    }


    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
                    System.setProperty("webdriver.chrome.driver", "C://ChromeDriver/chromedriver.exe");
                    driver = new ChromeDriver();
                    baseUrl = "https://tconsultamedica.osde.com.ar";
                    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }


    @AfterClass(alwaysRun = true)

    public void tearDown() throws Exception {
                    driver.quit();
                    String verificationErrorString = verificationErrors.toString();
                    if (!"".equals(verificationErrorString)) {
                                    fail(verificationErrorString);
                    }

    }


}
