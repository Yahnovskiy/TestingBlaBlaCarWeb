package Pages;

import org.junit.Assert;
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

    @FindBy(xpath = "//a[@href='/poshuk-poyizdki']")
    WebElement SearchButton;

    @FindBy(xpath = ".//*[@class='search-date date-picker hasDatepicker']")
    WebElement CalendarPickerbutton;

    @FindBy(xpath = ".//*[@id='search_from_name']")
    WebElement search_from_field;


    public HomePage(WebDriver driver) {
        super(driver);
    }





    public boolean isAvatarPresent() {
        return actionsWithElements.isElementPresent(LoggedInnavigationAvatar);
    }

    public void clickOnAvatar() {actionsWithElements.clickOnElement(LoggedInnavigationAvatar);}


    public void clickLogOutButton() {actionsWithElements.clickOnElement(LogOutButton);}


    public void clickonCalendarPicker() {
        actionsWithElements.clickOnElement(CalendarPickerbutton);
    }

    public void clickGoSearchScreenButton() {
        actionsWithElements.clickOnElement(SearchButton);
    }

    public void chooseTodayDate(String date_Today) {
        actionsWithElements.clickOnElementXpathDate(".//*[@class='ui-datepicker-calendar']//a[. ='"+date_Today+"']");
    }



        public void enterFromDestination(String from_destination) {
            actionsWithElements.enterText(search_from_field, from_destination);
        }
}
