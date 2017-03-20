package logIN;

import org.junit.Test;
import parentTest.ParentTest;

/**
 * Created by Bigbubble on 18-Mar-17.
 */
public class LogInTest extends ParentTest{


    public LogInTest(String browser) {
        super(browser);
    }

    @Test
    public void validLogIn(){
        loginPage.openLoginPage();
        loginPage.clickToShownPopupLoginWindow();
        loginPage.enterLogin("Login");
        loginPage.enterPass("Pass");
        loginPage.clickButtonLogin();
        loginPage.checkTitleWrongMailMessage("Невірна електронна адреса або пароль. Спробуйте ще раз.");
      //checkAC("Title not expected", loginPage.checkTitleWrongMailMessage(), "   Невірна електронна адреса або пароль. Спробуйте ще раз. ");
    }
}
