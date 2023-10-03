package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class OrderPage extends BasePage {
    public OrderPage(WebDriver driver) {
        super(driver);
    }

    //Поле для ввода имени
    private By nameField = By.xpath(".//div[@class = 'Order_Form__17u6u']//input[@placeholder = '* Имя']");
    //Поле для ввода фамилии
    private By surnameField = By.xpath(".//div[@class = 'Order_Form__17u6u']//input[@placeholder = '* Фамилия']");
    //Поле для ввода адреса
    private By addressField = By.xpath(".//div[@class = 'Order_Form__17u6u']//input[@placeholder = '* Адрес: куда привезти заказ']");
    //Поле для выбора метро
    private By metroList = By.cssSelector(".select-search__input");
    //Поле для ввода номера телефона
    private By phoneField = By.xpath(".//div[@class = 'Order_Form__17u6u']//input[@placeholder = '* Телефон: на него позвонит курьер']");
    //Кнопка "Далее" для перехода на вторую страницу оформления заказа
    private By nextButton = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");
    //Поле для выбора даты
    private By dateField = By.xpath(".//div[@class = 'react-datepicker__input-container']/input");
    //Поле для периода проката
    private By rentalPeriodField = By.className("Dropdown-placeholder");
    //Чек-бокс для чёрного самоката
    private By blackColor = By.id("black");
    //Чек-бокс для серого самоката
    private By greyColor = By.id("grey");
    //Поле для комментария
    private By commentField = By.xpath(".//input[@placeholder = 'Комментарий для курьера']");
    //Кнопка "Заказать"
    private By orderButton = By.xpath(".//div[@class = 'Order_Buttons__1xGrp']/button[text() = 'Заказать']");
    //Кнопка "Да" для подтверждения заказа
    private By yesButton = By.xpath(".//div[@class = 'Order_Buttons__1xGrp']/button[text() = 'Да']");
    //Текст об успешном заказе
    private By successfulOrderWindow = By.xpath(".//div[@class = 'Order_Text__2broi']/parent::div");



    public void setName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    public void setSurname(String surname) {
        driver.findElement(surnameField).sendKeys(surname);
    }

    public void setAddress(String address) {
        driver.findElement(addressField).sendKeys(address);
    }

    public void setMetro(String metro) {
        driver.findElement(metroList).click();
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(".//div[@class = 'select-search__select']//*[text() = '" + metro + "']")));
        driver.findElement(By.xpath(".//div[@class = 'select-search__select']//*[text() = '" + metro + "']")).click();
    }

    public void setPhone(String phone) {
        driver.findElement(phoneField).sendKeys(phone);
    }

    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }

    public void setOrderUserInfo(String name, String surname, String address, String metro, String phone) {
        setName(name);
        setSurname(surname);
        setAddress(address);
        setMetro(metro);
        setPhone(phone);
        clickNextButton();
    }

    public void setDate (String date) {
        driver.findElement(dateField).click();
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector(".react-datepicker__day.react-datepicker__day--0" + date)));
        driver.findElement(By.cssSelector(".react-datepicker__day.react-datepicker__day--0" + date)).click();
    }

    public void setRentalPeriod (String period) {
        driver.findElement(rentalPeriodField).click();
        driver.findElement(By.xpath(".//div[@class = 'Dropdown-option' and text() = '" + period + "']")).click();
    }

    public By getColor (String color) {
        switch (color) {
            case "black":
                return blackColor;
            case "grey":
                return greyColor;
        }
        return blackColor;
    }

    public void setColor (String color) {
        if (color.equals("grey") || color.equals("black")) {
            driver.findElement(getColor(color)).click();
        }
    }

    public void setComment(String comment) {
        driver.findElement(commentField).sendKeys(comment);
    }

    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }

    public void clickYesButton() {
        driver.findElement(yesButton).click();
    }

    public String checkOrder() {
        return driver.findElement(successfulOrderWindow).getText();

    }

    public void setOrderPlaceOfDelivery(String date, String period, String color, String comment) {
        setDate(date);
        setRentalPeriod(period);
        setColor(color);
        setComment(comment);
        clickOrderButton();
        clickYesButton();
    }

}

