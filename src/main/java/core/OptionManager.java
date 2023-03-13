package core;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.security.PublicKey;

public class OptionManager {

    public static ChromeOptions chromeOptions(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        //options.addArguments("--window-size=1920,1080");
        return options;
    }

//    public static FirefoxOptions firefoxOptions(){
//
//    }

}
