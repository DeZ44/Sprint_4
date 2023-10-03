import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import po.MainPage;
import po.OrderPage;
import java.util.concurrent.TimeUnit;
import static org.hamcrest.CoreMatchers.containsString;


@RunWith(Parameterized.class)
public class CheckOrderTest extends BaseTest {

    private final String orderButton;
    private final String name;
    private final String surname;
    private final String address;
    private final String metro;
    private final String phone;
    private final String date;
    private final String period;
    private final String color;
    private final String comment;

    public CheckOrderTest(String orderButton, String name, String surname, String address, String metro, String phone,
                          String date, String period, String color, String comment) {
        this.orderButton = orderButton;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metro = metro;
        this.phone = phone;
        this.date = date;
        this.period = period;
        this.color = color;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] getOrder() {
        return new Object[][]{
                {/*orderButton*/ "top",/*name*/ "Иван", /*surname*/ "Иванов", /*address*/ "Московская улица д.56", /*metro*/ "Сходненская", /*phone*/ "+79998887766",
                        /*date*/ "28", /*period*/ "трое суток", /*color*/ "grey", /*comment*/ "Мой комментарий для курьера"},
                {"down", "Артем", "Артемов", "Мой адрес", "Алексеевская", "+71254846696", "15", "четверо суток", "", ""},
                {"dsfg", "Иван", "Сергеев", "Адрес", "Медведково", "+71254846696", "25", "сутки", "black", ""},

        };
    }


    @Test
    public void checkOrderTest() {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.closeCookie();
        mainPage.clickOnOrderButton(orderButton);
        OrderPage orderPage = new OrderPage(driver);
        orderPage.setOrderUserInfo(name, surname, address, metro, phone);
        orderPage.setOrderPlaceOfDelivery(date, period, color, comment);

        MatcherAssert.assertThat("Модальное окно об оформлении заказа не появилось",
                orderPage.checkOrder(),
                containsString("Заказ оформлен"));
    }
}
