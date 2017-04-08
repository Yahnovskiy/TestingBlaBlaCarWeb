package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Bigbubble on 02-Apr-17.
 */
public class HomePage extends ParentPage {

    @FindBy (xpath = ".//span[@class = 'Header-navigationAvatar']")
    WebElement LoggedInnavigationAvatar;

    @FindBy(xpath = "//a[@href='/viyti']")
    WebElement LogOutButton;


    public HomePage(WebDriver driver) {
        super(driver);
    }





    public boolean isAvatarPresent() {
        return actionsWithElements.isElementPresent(LoggedInnavigationAvatar);
    }

    public void clickOnAvatar() {actionsWithElements.clickOnElement(LoggedInnavigationAvatar);}


    public void clickLogOutButton() {actionsWithElements.clickOnElement(LogOutButton);}

}
