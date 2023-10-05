import org.junit.Test;
import po.MainPage;
import po.OrderPage;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class CheckDownButtonTest extends BaseTest {


    @Test
    public void checkDownOrderButton() {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.closeCookie();
        mainPage.clickOnDownOrderButton();
        OrderPage orderPage = new OrderPage(driver);
        assertEquals("Окно для оформления заказа не появилось",
                "Для кого самокат",
                orderPage.getTextFromOpenedOrderWindow());

    }
}
