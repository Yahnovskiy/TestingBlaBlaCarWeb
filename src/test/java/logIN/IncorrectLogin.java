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
 * Created by Bigbubble on 26-Mar-17.
 */

    /**
     * Created by Bigbubble on 18-Mar-17.
     */
    @RunWith(value = Parameterized.class)
    public class IncorrectLogin extends ParentTest {
        String login, pass;

        public IncorrectLogin(String browser, String login, String pass) {
            super(browser);
            this.login = login;
            this.pass = pass;
        }

        @Parameterized.Parameters
        public static Collection testData() throws IOException {
            InputStream spreadsheet = new FileInputStream(ConfigData.getCfgValue("DATA_FILE_PATH") + "testDataSuit.xls");
            return new SpreadsheetData(spreadsheet, "ValidLogOn").getData();      //2й параметр - указываем название листа в екселе
        }

//    public LogInTest(String browser) {
//        super(browser);
//    }

        @Test
        public void invalidLogIn(){
            loginPage.openLoginPage();
            loginPage.clickToShownPopupLoginWindow();
            //  loginPage.enterLogin("Login");
            loginPage.enterLogin(login);
            //  loginPage.enterPass("Pass");
            loginPage.enterPass(pass);
            loginPage.clickButtonLogin();
            loginPage.checkTitleWrongMailMessage("Невірна електронна адреса або пароль. Спробуйте ще раз.");
            //checkAC("Title not expected", loginPage.checkTitleWrongMailMessage(), "   Невірна електронна адреса або пароль. Спробуйте ще раз. ");
        }

        @Test
        public void userLogIn_oneStep(){
            loginPage.loginUser(login, pass);
            //loginPage.checkIsUserLoggedIn();
            checkAC("Title is not present", loginPage.checkIsUserLoggedIn(),true);


        }

    }
