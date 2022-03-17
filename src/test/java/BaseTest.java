import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.rshb.intech.TestProperties;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {
    static WebDriver driver = null;
    static TestProperties props = TestProperties.getInstance();

    @BeforeClass
    public static void initDriver() {

        switch (props.get("browser")){
            case "firefox":
                System.setProperty("webdriver.gecko.driver", props.get("webdriver.gecko.driver.path"));
                driver = new FirefoxDriver();
                break;
            case "chrome":
                System.setProperty("webdriver.chrome.driver", props.get("webdriver.chrome.driver.path"));
                driver = new ChromeDriver();
                break;
            default:

        }

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void closeDrvier(){
        driver.quit();
    }

}
