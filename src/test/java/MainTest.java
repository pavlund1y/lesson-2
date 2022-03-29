import io.qameta.allure.junit4.DisplayName;
import io.qameta.allure.junit4.Tag;
import org.junit.*;
import ru.rshb.intech.pages.RshbPage;
import ru.rshb.intech.pages.iBankPage;
import ru.rshb.intech.steps.MainSteps;
import ru.rshb.intech.steps.RshbSteps;
import ru.rshb.intech.steps.iBankSteps;

public class MainTest extends BaseTest {

    public MainTest(){
        super();
    }

    @Before
    public void init() {
        driver.get("http://www.rshb.ru/");
        MainSteps.setDriver(driver);
    }


    @DisplayName("успешный тест")
    @Tag("attr1")
    @Test
    public void testMethod() {

        MainSteps mainSteps = new MainSteps();
        RshbSteps rshbSteps = new RshbSteps();
        iBankSteps iSteps = new iBankSteps();

        rshbSteps.openRshbPage();
        rshbSteps.clickIBankButton();

        iSteps.openIBankPage();
        Assert.assertEquals(MainSteps.getDriver().getTitle(), "Интернет-банк РСХБ");

        iSteps.typeToField("Логин", "фывфывфы");
        iSteps.checkFieldText("Логин", "фывфывфы");
        iSteps.typeToField("Пароль", "фывфывфы");
        iSteps.checkFieldText("Пароль", "фывфывфы");
//        RshbPage rshbPage = new RshbPage(driver);
//        rshbPage.waitPageLoaded();
//        iBankPage ibankPage = rshbPage.clickIBankButton();

//        ibankPage.waitPageLoaded();
//        ibankPage.typeToField("Логин", "туст");
//        ibankPage.typeToField("Пароль", "туст2");
//        ibankPage.typeToField("Чекбокс", "false");
//        ibankPage.checkFieldText("Логин", "туст");
//        ibankPage.checkFieldText("Пароль", "туст2");
//        ibankPage.clickSubmitButton();
//        ibankPage.waitErrorMsgVisible();
//        ibankPage.checkFieldText("Ошибка", "Логин или пароль введены неверно.");
    }

    @Ignore
    @DisplayName("неуспешный тест")
    @Tag("attr1")
    @Test
    public void testMethod2() {

        MainSteps mainSteps = new MainSteps();
        RshbSteps rshbSteps = new RshbSteps();
        iBankSteps iSteps = new iBankSteps();

        rshbSteps.openRshbPage();
        rshbSteps.clickIBankButton();

        iSteps.openIBankPage();
        Assert.assertEquals(MainSteps.getDriver().getTitle(), "Интернет-банк РСХБ");

        iSteps.typeToField("Логин", "фывфывфы");
        iSteps.checkFieldText("Логин", "фывфывфы22");
        iSteps.typeToField("Пароль", "фывфывфы");
        iSteps.checkFieldText("Пароль", "фывфывфы");
//        RshbPage rshbPage = new RshbPage(driver);
//        rshbPage.waitPageLoaded();
//        iBankPage ibankPage = rshbPage.clickIBankButton();

//        ibankPage.waitPageLoaded();
//        ibankPage.typeToField("Логин", "туст");
//        ibankPage.typeToField("Пароль", "туст2");
//        ibankPage.typeToField("Чекбокс", "false");
//        ibankPage.checkFieldText("Логин", "туст");
//        ibankPage.checkFieldText("Пароль", "туст2");
//        ibankPage.clickSubmitButton();
//        ibankPage.waitErrorMsgVisible();
//        ibankPage.checkFieldText("Ошибка", "Логин или пароль введены неверно.");
    }


    @After
    public void terminate(){
        //driver.close();
    }
}
