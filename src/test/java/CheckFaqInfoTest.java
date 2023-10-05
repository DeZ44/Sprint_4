import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import po.MainPage;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class CheckFaqInfoTest extends BaseTest{

    private final String id;
    private final String expected;


    public CheckFaqInfoTest(String id, String expected) {
        this.id = id;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getFaqInfo() {
        return new Object[][]{
                {/*id*/ "0",/*expected*/ "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {/*id*/ "1",/*expected*/ "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {/*id*/ "2",/*expected*/ "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {/*id*/ "3",/*expected*/ "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {/*id*/ "4",/*expected*/ "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {/*id*/ "5",/*expected*/ "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {/*id*/ "6",/*expected*/ "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {/*id*/ "7",/*expected*/ "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
        };
    }


    @Test
    public void checkFaqInfoTest() {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.closeCookie();
        String actual = mainPage.getTextFaqElementById(id);
        assertEquals("Текст не совпадает",expected, actual);
    }

}
