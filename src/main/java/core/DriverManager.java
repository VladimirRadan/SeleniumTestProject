package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import utils.Utils;

public class DriverManager {


    private static WebDriver driver;

    private static String browser = Utils.dotEnv().get("BROWSER", "chrome");

    public static WebDriver getDriver(){
        if (browser.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver(OptionManager.chromeOptions());
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        }
        Utils.waitForSeconds(3);
        driver.manage().window().maximize();
        return driver;
    }




}
