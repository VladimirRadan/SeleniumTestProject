package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageHeroku extends BasePage{


    By usernameField = By.cssSelector("input[type='text']");
    By passwordField = By.cssSelector("input[name='password']");
    By loginButton = By.cssSelector(".radius");

    By errorMessage = By.cssSelector(".flash.error");

    public LoginPageHeroku(WebDriver driver) {
        super(driver);
    }

    public LoginPageHeroku loginUser(String username, String password){
        typeIn(usernameField, username);
        typeIn(passwordField, password);
        clickOnElement(loginButton);
        return this;
    }

    public boolean isErrorMessagePresent(){
        String actual[] = getTextFromElement(errorMessage).split("(?<=!)");
        String actualText = actual[0];
        String expectedText = "Your username is invalid!";
        return actualText.equals(expectedText);
    }






}
