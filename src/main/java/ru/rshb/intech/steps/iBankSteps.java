package ru.rshb.intech.steps;

import io.qameta.allure.Step;
import ru.rshb.intech.pages.iBankPage;

public class iBankSteps extends MainSteps {

    @Step("Открыта страница Интернет-Банка")
    public void openIBankPage() {
        new iBankPage(MainSteps.getDriver()).waitPageLoaded(MainSteps.getDriver());
    }

    @Step("заполнить поле {0} значением {1}")
    public void typeToField(String name, String value) {
        iBankPage page = new iBankPage(MainSteps.getDriver());
        switch(name) {
            case "Логин" : typeToField(page.getLogin(), value);
                break;
            case "Пароль" : typeToField(page.password, value);
                break;
            case "Чекбокс" : page.checkbox.click();
                break;
        }
}
    @Step("проверим значение поля \"{0}\" равно: \"{1}\"")
    public void checkFieldText(String name, String value) {
        iBankPage page = new iBankPage(MainSteps.getDriver());
        switch (name) {
            case "Логин" : checkFieldValue(page.getLogin(), value);
                break;
            case "Пароль" : checkFieldValue(page.password, value);
                break;
            case "Ошибка" : checkFieldValue(page.errorMsg, value);
                break;
        }
    }
}
