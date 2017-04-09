package Pages;


import libs.ActionsWithElements;
import libs.Utils;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.Matchers.is;

public class ParentPage {
    WebDriver driver;
    WebDriverWait webDriverWait;
    Logger logger;
    ActionsWithElements actionsWithElements;


    public ParentPage(WebDriver driver){
        this.driver = driver;
        logger = Logger.getLogger(getClass());
        actionsWithElements = new ActionsWithElements(driver);
        PageFactory.initElements(driver,this);
        webDriverWait = new WebDriverWait(driver, 20);
    }

    /**
     * Method for open page with url
     * @param url
     */
    public void open(String url){
        try {
            driver.get(url);
            logger.info("Page was opened with url " + url);
        } catch (Exception e){
            logger.error("Can not open " + url);
            Assert.fail("Can not open " + url);
        }
    }

    public void checkTitle(String expectedTitle){
        try {
            webDriverWait.until(ExpectedConditions.titleIs(expectedTitle));
            Assert.assertThat("Title not match", driver.getTitle(),
                    is(expectedTitle));
        } catch (Exception e){
            logger.error("Can not work with page " );
            Assert.fail("Can not work with page " );
        }
    }


    public String getTitle() {
       return driver.getTitle();
    }

    public String getText() {
        return driver.findElement(By.xpath(".//*[@class='u-overflowHidden']")).getText();

    }



//    public void checkTitleWrongMailMessage(String expectedText) {
//        actionsWithElements.checkTextInElement(".//*[@class='u-overflowHidden']",expectedText);
//    }


}
