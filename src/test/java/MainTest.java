import org.junit.*;
import ru.rshb.intech.pages.RshbPage;
import ru.rshb.intech.pages.iBankPage;

public class MainTest extends BaseTest {

    public MainTest(){
        super();
    }

    @Before
    public void init() {
        driver.get("http://www.rshb.ru/");
    }


    @Test
    public void testMethod() {
        RshbPage rshbPage = new RshbPage(driver);
        rshbPage.waitPageLoaded();
        iBankPage ibankPage = rshbPage.clickIBankButton();
        Assert.assertEquals(ibankPage.getCurrentTitle(), "Интернет-банк РСХБ");
        ibankPage.waitPageLoaded();
        ibankPage.typeToField("Логин", "туст");
        ibankPage.typeToField("Пароль", "туст2");
        ibankPage.typeToField("Чекбокс", "false");
        ibankPage.checkFieldText("Логин", "туст");
        ibankPage.checkFieldText("Пароль", "туст2");
        ibankPage.clickSubmitButton();
        ibankPage.waitErrorMsgVisible();
        ibankPage.checkFieldText("Ошибка", "Логин или пароль введены неверно.");
    }


    @After
    public void terminate(){
        //driver.close();
    }
}
