package br.com.liandro.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Driver {

    protected static WebDriver driver;
    protected static WebDriverWait waitDriver;
    protected final static int SHORT_TIMEOUT = 15;
    protected final static int LONG_TIMEOUT = 30;

    public static String browser;

    public static void startDriver() {

        browser = System.getProperty("browser").toUpperCase();

        switch (browser) {
            case "CHROME":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("headless");
                driver = new ChromeDriver(chromeOptions);
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(SHORT_TIMEOUT));
                waitDriver = new WebDriverWait(driver, Duration.ofSeconds(LONG_TIMEOUT));
                break;
            case "FIREFOX":
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(SHORT_TIMEOUT));
                waitDriver = new WebDriverWait(driver, Duration.ofSeconds(LONG_TIMEOUT));
                break;
            case "EDGE":
                driver = new EdgeDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(SHORT_TIMEOUT));
                waitDriver = new WebDriverWait(driver, Duration.ofSeconds(LONG_TIMEOUT));
                break;
            case "SAFARI":
                driver = new SafariDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(SHORT_TIMEOUT));
                waitDriver = new WebDriverWait(driver, Duration.ofSeconds(LONG_TIMEOUT));
                break;
            default:
                throw new RuntimeException("Browser not supported: " + browser);
        }

    }

    public static WebDriver getDriver() {
        if (driver != null) {
            return driver;
        }
        throw new RuntimeException("You must call Utils.startDriver() before using the driver");
    }

    public static WebDriverWait getWaitDriver() {
        if (driver != null) {
            return waitDriver;
        }
        throw new RuntimeException("You must call Utils.startDriver() before using the waitDriver");
    }

    public static void stopApp() {
        if (driver != null) {
            driver.quit();
        }
    }

}
