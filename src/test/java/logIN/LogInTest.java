package logIN;

import libs.ConfigData;
import libs.SpreadsheetData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import parentTest.ParentTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

/**
 * Created by Bigbubble on 18-Mar-17.
 */

@RunWith(value = Parameterized.class)
public class LogInTest extends ParentTest{
    String login, pass;

    public LogInTest(String browser, String login, String pass) {
        super(browser);
        this.login = login;
        this.pass = pass;
    }

    @Parameterized.Parameters
    public static Collection testData() throws IOException {
        InputStream spreadsheet = new FileInputStream(ConfigData.getCfgValue("DATA_FILE_PATH") + "testDataSuit.xls");
        return new SpreadsheetData(spreadsheet, "ValidLogOn").getData();      //2й параметр - указываем название листа в екселе
    }

    @Test
    public void invalidLogIn(){
        loginPage.openLoginPage();
        loginPage.clickToShownPopupLoginWindow();
        loginPage.enterLogin(login);
        loginPage.enterPass(pass);
        loginPage.clickButtonLogin();
        checkAC("User is logged in", homePage.isAvatarPresent(),true);
    }

    @Test
    public void userLogIn_oneStep(){
        loginPage.loginUser(login, pass);
        checkAC("User is logged in", homePage.isAvatarPresent(),true);
    }

}
