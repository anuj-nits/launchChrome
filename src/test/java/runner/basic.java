package runner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.util.Collections;

public class basic {


    private void launchChrome() throws Exception {

        System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--start-maximized");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-dev-shm-usage");
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        options.setExperimentalOption("useAutomationExtension", false);
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability(ChromeOptions.CAPABILITY, options);
        WebDriver driver = new ChromeDriver(dc);
        driver.get("https://google.com");
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test() throws Exception {

        launchChrome();
    }
}
