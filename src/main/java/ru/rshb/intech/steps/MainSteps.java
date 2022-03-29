package ru.rshb.intech.steps;

import io.qameta.allure.Attachment;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainSteps {

    static WebDriver driver;

    public static WebDriver getDriver(){
        return driver;
    }

    public static void setDriver(WebDriver drv) {
       driver = drv;
    }

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

    @Attachment(value = "{0}", type="image/png")
    public static byte[] takeScreenshot(String name) {
        return ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "{0}", type="text/plain")
    public static String attachtext(String name, String value) {
        return value;
    }
}
