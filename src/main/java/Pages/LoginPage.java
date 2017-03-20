package Pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage {

    @FindBy(xpath = ".//*[@class='Header-navigationText dropdown-toggle']")
    WebElement popupLoginWindow;

    @FindBy(name = "_username")
    WebElement loginInput;

    @FindBy(name = "_password")
    WebElement passInput;

    @FindBy(name = "_submit")
    WebElement buttonLogin;

    @FindBy (xpath = ".//*[@class='u-overflowHidden']")
    WebElement WrongMailMessage;


    public LoginPage(WebDriver driver) {
        super(driver);

    }



    public void openLoginPage(){
        open("https://www.blablacar.com.ua/");
    }

    public void clickToShownPopupLoginWindow() {
        actionsWithElements.clickOnElement(popupLoginWindow);
    }


    public void enterLogin(String login) {
        try {

            loginInput.clear();
            loginInput.sendKeys(login);
            logger.info(login + " was entered in input ");
        } catch (Exception e) {
            logger.error("Cannot work with input login");
            Assert.fail("Cannot work with input login");
        }
    }

    public void enterPass(String pass) {

        actionsWithElements.enterText(passInput, pass);
    }

    public void clickButtonLogin() {
        actionsWithElements.clickOnElement(buttonLogin);
    }


    public void loginUser(String login, String pass){
        openLoginPage();
        //checkTitle("Account of spare:Авторизация");
        enterLogin(login);
        enterPass(pass);
        clickButtonLogin();

    }


public void checkTitleWrongMailMessage(String expectedText) {
    actionsWithElements.checkTextInElementOne(WrongMailMessage, expectedText);


}

}
