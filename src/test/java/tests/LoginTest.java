package tests;

import io.qameta.allure.*;
import listeners.TestListener;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.RegisterPage;
@Listeners(TestListener.class)
public class LoginTest extends BaseTest{

    LoginPage loginPage;

    @BeforeMethod
    public void localSetup(){
        loginPage = new LoginPage(driver);
    }

    @Test()
    @Description("Login user: Expected result - User is logged in, text is present on the page")
    @Epic("Login epic")
    @Story("Happy path login story")
    @Severity(SeverityLevel.BLOCKER)
    public void loginUserTest(){
        loginPage.goToLoginForm()
                .loginUser("chantell.thompson@hotmail.com", "irccqirl3s");
        Assert.assertTrue(loginPage.isUserLoggedIn());
    }


}
