package runner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.io.File;
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

    private void launchFirefox() throws Exception {

        System.setProperty("webdriver.gecko.driver", "./src/test/resources/drivers/geckodriver");
        FirefoxOptions options = new FirefoxOptions();
        options.setBinary("/home/sterlite/Downloads/firefox/firefox");
        options.addArguments("--no-sandbox");
        options.addArguments("--headless");
        options.setProfile(new FirefoxProfile());
        WebDriver driver = new FirefoxDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public void test() throws Exception {

        //launchChrome();
        launchFirefox();
    }
}
