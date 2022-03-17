package ru.rshb.intech.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RshbPage extends BasePage {

    @FindBy(id = "ibank")
    private WebElement ibankButton;

    public RshbPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public iBankPage clickIBankButton(){
        ibankButton.click();
        return new iBankPage(driver);
    }

    public void waitPageLoaded(){
        new WebDriverWait(driver, LOAD_TIMEOUT).until(ExpectedConditions.visibilityOf(ibankButton));
    }

}
