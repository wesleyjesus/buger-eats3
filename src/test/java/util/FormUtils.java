package util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FormUtils {
	
	private WebDriver driver;

    public FormUtils(WebDriver driver) {
        this.driver = driver;
    }
    
    public void selecionarMetodoEntrega(String opcaoEscolha) {
        driver.findElement(By.cssSelector("li:nth-child(" +opcaoEscolha+ ") > img")).click();
    }
    
    public WebElement capturaMensagem(By locator) {
        
        WebElement element = driver.findElement(locator);
        return element;
    }
    

}
