package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    private By emailField = By.cssSelector("input[data-test='email']");
    private By passwordField = By.id("password");
    private By loginButton = By.cssSelector("input[data-test='login-submit']");

    private By signInLink = By.cssSelector("a[data-test='nav-sign-in']");
    private By userNameInMenu = By.id("user-menu");

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public LoginPage goToLoginForm(){
        clickOnElement(signInLink);
        return this;
    }

    @Step("Filling in login form with username and password")
    public LoginPage loginUser(String username, String password){
        typeIn(emailField, username);
        typeIn(passwordField, password);
        clickOnElement(loginButton);
        return this;
    }

    public boolean isUserLoggedIn(){
        return matchesExpectedText(userNameInMenu, "Archie Bogan");
    }


}
