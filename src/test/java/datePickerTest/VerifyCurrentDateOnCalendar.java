package datePickerTest;

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
 * Created by Bigbubble on 08-Apr-17.
 */

@RunWith(value = Parameterized.class)
public class VerifyCurrentDateOnCalendar extends ParentTest {

    final private String Date_Today = String.valueOf(8);     //как передать дату!!!!!!!!!!!
                                                                        //если ввожу просто число все отрабатыват

    String login, pass;



    public VerifyCurrentDateOnCalendar(String browser, String login, String pass) {
        super(browser);
        this.login = login;
        this.pass = pass;
//        this.from = from;
//        this.toto = toto;
    }

    @Parameterized.Parameters
    public static Collection testData() throws IOException {
        InputStream spreadsheet = new FileInputStream(ConfigData.getCfgValue("DATA_FILE_PATH") + "testDataSuit.xls");
        return new SpreadsheetData(spreadsheet, "ValidLogOn").getData();      //2й параметр - указываем название листа в екселе
    }
    //хочу использовать второй Excel файл для ввода в поля From and To, но не знаю как
//    public static Collection testData2() throws IOException {
//        InputStream spreadsheet = new FileInputStream(ConfigData.getCfgValue("DATA_FILE_PATH") + "testData.xls");
//        return new SpreadsheetData(spreadsheet, "List1").getData();
//    }



    @Test
    public void verifyCurrentCalendarDate() {
        loginPage.loginUser(login, pass);
        checkAC("User is logged in", homePage.isAvatarPresent(), true);
        homePage.clickGoSearchScreenButton();
        searchPage.clickonCalendarPicker();
        searchPage.chooseTodayDate(Date_Today);
        searchPage.enterFromDestination("Kiev");
        searchPage.enterToDestination("Lviv");
        searchPage.clickOnSearchButton();
        searchPage.checkTitle("Поїздки Kyiv, місто Київ – Lviv");

    }


}
