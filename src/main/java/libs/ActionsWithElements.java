package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.hamcrest.Matchers.is;   //manually written


public class ActionsWithElements{
    private WebDriver driver;
    private Logger logger;
    private WebDriverWait webDriverWait10 ;
    private WebDriverWait webDriverWait15;
    //  private WebDriverWait webDriverWait20 ;

    public ActionsWithElements(WebDriver driver) {
        this.driver = driver;
        logger = Logger.getLogger(getClass());
        webDriverWait10 = new WebDriverWait(driver, 10);
        webDriverWait15 = new WebDriverWait(driver,15);
    }

    public void enterText(String xpathLocator, String text) {
        try {

            driver.findElement(By.xpath(xpathLocator)).clear();
            driver.findElement(By.xpath(xpathLocator)).sendKeys(text);
            logger.info(text + " was inputed");

        } catch (Exception e) {
            logger.error("Can not work with input");
            Assert.fail("Can not work with input");
        }
    }

    public void enterText(WebElement element, String text){
        try {
            webDriverWait10.until(ExpectedConditions.visibilityOf(element));
            element.clear();
            element.sendKeys(text);
            logger.info(text + " was inputed");

        } catch (Exception e) {
            logger.error("Can not work with input");
            Assert.fail("Can not work with input");
        }
    }



    /**
     * Method checked is element present on page
     * @param xpathLocator
     * @return
     */
    public boolean isElementPresent(String xpathLocator) {
        try {
            WebElement webElement = driver.findElement(By.xpath(xpathLocator));
            return webElement.isDisplayed(); //&& webElement.isEnabled();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickOnElement(WebElement element) {
        try {
            webDriverWait10.until(ExpectedConditions.elementToBeClickable(element));
            webDriverWait10.until(ExpectedConditions.not(
                    ExpectedConditions.invisibilityOf(element)));
            element.click();
            logger.info("Element was clicked");

        } catch (Exception e) {
            logger.error("Can not work with button");
            Assert.fail("Can not work with button");
        }
    }

    public boolean isElementPresent(WebElement element) {
        try {
            return element.isDisplayed() && element.isEnabled();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickOnElementXpathDate(String xpathLocator) {
        try {

            driver.findElement(By.xpath(xpathLocator)).click();
            logger.info("Element was clicked");

        } catch (Exception e) {
            logger.error("Can not work with button");
            Assert.fail("Can not work with button");
        }
    }



    public void checkTextInElement(String locator, String expectedText) {
        try{
            String textFromElement = driver.findElement(By.xpath(locator)).getText();
            Assert.assertThat("Text in element not matched",textFromElement
                    ,is(expectedText));
        }catch (Exception e) {
            logger.error("Can not work with element");
            Assert.fail("Can not work with element");
        }

    }
    public void checkTextInElementOne( WebElement element, String expectedText) {
        try{

            String textFromElement = element.getText();

            Assert.assertThat("Text in element not matched",textFromElement
                    ,is(expectedText));

    }catch (Exception e) {
        logger.error("Can not work with element");
        Assert.fail("Can not work with element");
    }

    }

    public String getTextFromElement(WebElement element) {

        String textFromElement = element.getText();
        try {
            textFromElement = webDriverWait15.until(ExpectedConditions.visibilityOf(element)).getText();
        } catch (Exception e) {
            logger.error("Can not work with element");
            Assert.fail("Can not work with element");
        }
        return textFromElement;
    }



//    public boolean isErrorLoginPresent(String expectedText) {
//        return actionsWithElements.isElementPresent(
//                WrongMailMessage, expectedText);
//    }
}
