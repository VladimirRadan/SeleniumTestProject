package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.LoginPageHeroku;
import pages.RegisterPage;
import utils.Utils;

public class LoginHerokuTest extends BaseTest{

    LoginPageHeroku login;


    @BeforeMethod
    public void localSetup(){
        login = new LoginPageHeroku(driver);
    }

    @Test(dataProvider = "dpLoginTest", dataProviderClass = Utils.class)
    public void loginUserInvalidDataTest(String username, String password){
        driver.get("https://the-internet.herokuapp.com/login");
        login.loginUser(username, password);
        Assert.assertTrue(login.isErrorMessagePresent());
    }


}
