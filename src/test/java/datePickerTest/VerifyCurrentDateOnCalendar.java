package datePickerTest;

import libs.ConfigData;
import libs.SpreadsheetData;
import libs.Utils;
import org.apache.poi.ss.formula.functions.Today;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import parentTest.ParentTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import static libs.Utils.Day;


/**
 * Created by Bigbubble on 08-Apr-17.
 */

@RunWith(value = Parameterized.class)
public class VerifyCurrentDateOnCalendar extends ParentTest {

    final private String Date_Today = Utils.main(Day);     //как передать дату!!!!!!!!!!!


    String login, pass;



    public VerifyCurrentDateOnCalendar(String browser, String login, String pass) {
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
    public void verifyCurrentCalendarDate() {
        loginPage.loginUser(login, pass);
        checkAC("User is logged in", homePage.isAvatarPresent(), true);
        homePage.clickSearchButton();
        homePage.clickonCalendarPicker();
      //  homePage.chooseTodayDate(Date_Today);
//        homePage.enterFromDestination();
//        homePage.enterToDestination();
//        homePage.clickOnSearchButton();
//        homePage.checkTitle("Поїздки Kyiv, місто Київ – Lviv");

    }


}
