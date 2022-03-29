package ru.rshb.intech.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.rshb.intech.steps.MainSteps;

public class RshbPage extends BasePage {

    @FindBy(id = "ibank")
    private WebElement ibankButton;

    public RshbPage(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }

    public iBankPage clickIBankButton(){
        ibankButton.click();
        return new iBankPage(MainSteps.getDriver());
    }

    public void waitPageLoaded(){
        new WebDriverWait(MainSteps.getDriver(), LOAD_TIMEOUT).until(ExpectedConditions.visibilityOf(ibankButton));
    }

}
