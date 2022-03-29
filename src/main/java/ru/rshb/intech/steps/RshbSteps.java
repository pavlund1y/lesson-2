package ru.rshb.intech.steps;

import io.qameta.allure.Step;
import ru.rshb.intech.pages.RshbPage;

public class RshbSteps {

    @Step("открыта страница РСХБ")
    public void openRshbPage() {
        new RshbPage(MainSteps.getDriver()).waitPageLoaded();
        MainSteps.attachtext("current title", MainSteps.getDriver().getTitle());
    }

    @Step("выполнить нажатие на Интернет-Банк")
    public void clickIBankButton() {
        new RshbPage(MainSteps.getDriver()).clickIBankButton();
    }
}
