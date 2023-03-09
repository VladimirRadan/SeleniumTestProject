package pages;

import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import utils.Utils;

import java.security.Key;
import java.util.Locale;

public class RegisterPage extends BasePage{

    private By firstNameField = By.id("first_name");
    private By lastNameField = By.id("last_name");
    private By dobField = By.cssSelector("input[formcontrolname='dob']");
    private By addressField = By.id("address");
    private By postCodeField = By.id("postcode");
    private By cityField = By.id("city");
    private By stateField = By.id("state");
    private By countryDropdown = By.id("country");
    private By phoneCodeField = By.id("phone");
    private By emailField = By.id("email");
    private By passwordField = By.id("password");
    private By registerButton = By.cssSelector(".form-group.mb-3+button");

    private By signInLink = By.cssSelector("a[data-test='nav-sign-in']");
    private By goToRegisterFormLink = By.cssSelector("a[data-test='register-link']");

    private By myAccountPageTitle = By.cssSelector("h1[data-test='page-title']");
    private By myAccountMenuProfile = By.cssSelector("a[data-test='nav-profile']");

    private String username;
    private String password;

    private static final Logger log = LogManager.getLogger(RegisterPage.class.getName());

    Faker faker = new Faker(new Locale("en-US"));


    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @Step("Go to register page")
    public RegisterPage goToRegisterPage(){
        clickOnElement(signInLink);
        clickOnElement(goToRegisterFormLink);
        return this;
    }

    @Step("Registering user through register form")
    public RegisterPage registerUser(){
        username = faker.internet().emailAddress();
        password = faker.internet().password();
        log.info("Username: " + username);
        log.info("Password: " + password);

        typeIn(firstNameField, faker.name().firstName());
        typeIn(lastNameField, faker.name().lastName());
        typeIn(dobField,dob());
        typeIn(addressField, faker.address().fullAddress());
        typeIn(postCodeField, faker.number().digits(6));
        typeIn(cityField, faker.address().city());
        typeIn(stateField, faker.address().state());
        selectCountry();
        typeIn(phoneCodeField, faker.number().digits(10));
        typeIn(emailField, username);
        typeIn(passwordField, password);
        clickOnElement(registerButton);
        Utils.waitForSeconds(2);
        return this;
    }

    @Step("DOB entry")
    private String dob(){
        if (driver instanceof ChromeDriver){
            return "1212" + Keys.TAB + "1929";
        } else if (driver instanceof FirefoxDriver) {
            return "12/" + "12/" + "1229";
        } else if (driver instanceof EdgeDriver) {
            return "1212" + Keys.ARROW_RIGHT + "1929";
        }
        return null;
    }

    @Step("Country selection")
    private void selectCountry(){
        Select select = new Select(getElement(countryDropdown));
        select.selectByValue("RS");
    }

    @Step("Verifying user is successfully registered")
    public boolean isUserRegistered(){
        return matchesExpectedText(myAccountPageTitle, "My account") &&
                matchesExpectedText(myAccountMenuProfile, "Profile");
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

}
