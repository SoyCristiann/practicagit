import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.By.ByTagName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import utils.DriverManager;
/*
public class BuscarGoogle {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/ChromeDriver.exe");
		WebDriver driver = DriverManager.getDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Abrir Google
		driver.get("https://google.com.co");
		driver.manage().window().maximize();

		// Encontrar el campo de busqueda
		// WebElement campoBusqueda = driver.findElement(By.name("q"));

		// Encontrar campo de búsqueda por ID
		WebElement campoBusqueda = driver.findElement(By.id("APjFqb"));

		// Escribir y buscar en el campo de busqueda
		campoBusqueda.sendKeys("Selenium");

		// Encontrar botón buscar por classname
		WebElement btnBuscar = driver.findElement(By.className("gNO89b"));
		btnBuscar.click();

		// campoBusqueda.submit();

	}

*/
