package ru.rshb.intech.listener;

import io.qameta.allure.junit4.AllureJunit4;
import org.junit.runner.Description;
import ru.rshb.intech.steps.MainSteps;

public class MyCustomListener extends AllureJunit4 {

    @Override
    public void testFinished(Description description) {
        MainSteps.takeScreenshot("title");
        super.testFinished(description);
    }
}
