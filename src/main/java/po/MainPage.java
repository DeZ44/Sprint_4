package po;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static constants.url.WEBSITE_URL;

public class MainPage extends BasePage {

    //Кнопка "Заказать" внизу страницы
    private By downOrderButton = By.xpath(".//div[@class = 'Home_RoadMap__2tal_']//button[text() = 'Заказать']");

    //Кнопка для закрытия окна Cookie
    private By closeCookie = By.id("rcc-confirm-button");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void openMainPage(){
        driver.get(WEBSITE_URL);
    }

    public void clickOnDownOrderButton(){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(downOrderButton));
        driver.findElement(downOrderButton).click();
    }

    public void closeCookie(){
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(closeCookie));
        driver.findElement(closeCookie).click();
    }


    public String getTextFaqElementById(String id) {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.id("accordion__heading-" + id)));
        driver.findElement(By.id("accordion__heading-" + id)).click();
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(".//div[@id = 'accordion__panel-" + id + "']/p")));
        return driver.findElement(By.xpath(".//div[@id = 'accordion__panel-" + id + "']/p")).getText();
    }

}
