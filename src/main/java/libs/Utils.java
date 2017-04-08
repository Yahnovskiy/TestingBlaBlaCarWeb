package libs;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Utils {
    private Logger log;

    public Utils(){
        log = Logger.getLogger(getClass());
    }

    /**
     * Taking screenshot into .//target// + pathToScreenShot
     * @param pathToScreenShot
     * @param driver
     */
    public void screenShot(String pathToScreenShot, WebDriver driver){
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File(pathToScreenShot));
            log.info("ScreenShot: " + pathToScreenShot);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static int Day;
    int Month;
    int Year;


    public static void main(String args[]){
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formattedDate = new SimpleDateFormat("dd.MM.yyyy");

        Day = calendar.get(Calendar.DAY_OF_MONTH);

        System.out.print("Daye " + Day
        );
//        Month = calendar.get(Calendar.MONTH);
//        Year = calendar.get(Calendar.YEAR);



    }


}
