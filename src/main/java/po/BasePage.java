package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {

    protected WebDriver driver;

    //Кнопка "Заказать" наверху страницы
    protected By topOrderButton = By.xpath(".//div[@class = 'Header_Nav__AGCXC']//button[text() = 'Заказать']");

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public void topOrderButtonClick () {
        driver.findElement(topOrderButton).click();
    }
}
