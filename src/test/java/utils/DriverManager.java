package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
	private static WebDriver driver; //Variable que contiene la única instancia.
	private DriverManager() {}; // Constructor privado para evitar la creación de múltiples instancias.
	
	public static WebDriver getDriver(){
		if(driver==null) {
			System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
			driver = new ChromeDriver();
		}
		return driver;
	}
	
	public static void quitDriver(){
		if(driver!=null) {
			driver.quit();
			driver=null;
		}
	}
}
