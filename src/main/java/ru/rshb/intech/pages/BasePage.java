package ru.rshb.intech.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

    WebDriver driver;

    protected final int LOAD_TIMEOUT = 10;

    public void typeToField(WebElement field, String text){
        field.clear();
        field.sendKeys(text);
    }

    public void clickField(WebElement field) {
        field.click();
    }

    public void checkFieldValue(WebElement field, String expected){
        String actual = field.getText();
        if(actual == null || (actual.isEmpty() && !expected.isEmpty())) {
             actual = field.getAttribute("value");
        }
        Assert.assertEquals(expected,actual);
    }

}
