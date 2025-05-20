package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.DriverManager;

public class PlatanitosHomePage {
	WebDriver driver=DriverManager.getDriver();
	
	public PlatanitosHomePage() {
		PageFactory.initElements(driver, this); //Inicialilzar los elementos @FindBy
	}
	
	
	@FindBy(id="search-input-header")
	WebElement campoBusqueda;
	
	@FindBy(className="nd-icon-search")
	WebElement botonBuscar;
	
	public void ingresarTextoBuscar(String texto) {
		campoBusqueda.sendKeys(texto);
	}
	
	public void clickBotonBuscar() {
		botonBuscar.click();
	}
}
