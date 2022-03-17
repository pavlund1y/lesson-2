package ru.rshb.intech.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class iBankPage extends BasePage {

    @FindBy(id = "textfield")
    private WebElement login;

    @FindBy(id = "passwordfield")
    private WebElement password;

    @FindBy(xpath = "//*[text()='ВХОД В ИНТЕРНЕТ-БАНК']")
    private WebElement singInTab;

    @FindBy(name = "field")
    private WebElement checkbox;

    @FindBy(xpath = "//*[text()='Войти']")
    private WebElement submit;

    private final String ERROR_MSG_XPATH = "//*[@id='loginForm']/*[@class='t-error']//*[text()]";
    @FindBy(xpath = ERROR_MSG_XPATH)
    private WebElement errorMsg;

    public iBankPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void typeToField(String name, String value) {
        switch(name) {
            case "Логин" : typeToField(login, value);
                break;
            case "Пароль" : typeToField(password, value);
                break;
            case "Чекбокс" : checkbox.click();
                break;
        }
    }

    public void checkFieldText(String name, String value) {
        switch (name) {
            case "Логин" : checkFieldValue(login, value);
                break;
            case "Пароль" : checkFieldValue(password, value);
                break;
            case "Ошибка" : checkFieldValue(errorMsg, value);
                break;
        }
    }

    public void clickSubmitButton(){
        clickField(submit);
    }

    public void waitPageLoaded(){
        new WebDriverWait(driver, LOAD_TIMEOUT).until(ExpectedConditions.visibilityOf(singInTab));
        new WebDriverWait(driver, LOAD_TIMEOUT).until(ExpectedConditions.elementToBeClickable(login));
    }

    public void waitErrorMsgVisible(){
        new WebDriverWait(driver, LOAD_TIMEOUT).until(ExpectedConditions.presenceOfElementLocated(By.xpath(ERROR_MSG_XPATH)));
    }

    public String getCurrentTitle(){
        return this.driver.getTitle();
    }


}
