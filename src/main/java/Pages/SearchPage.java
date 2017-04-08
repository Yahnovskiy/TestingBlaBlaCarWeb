package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Bigbubble on 08-Apr-17.
 */
public class SearchPage extends ParentPage {

    @FindBy(xpath = ".//*[@class='search-date date-picker hasDatepicker']")
    WebElement CalendarPickerbutton;

    @FindBy(xpath = ".//*[@id='search_from_name']")
    WebElement search_from_field;

    @FindBy(xpath = ".//*[@id='search_to_name']")
    WebElement search_to_field;

    @FindBy(xpath = ".//*[@id='search-form']/input")
    WebElement SearchButton;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void clickonCalendarPicker() {
        actionsWithElements.clickOnElement(CalendarPickerbutton);
    }

    public void chooseTodayDate(String date_Today) {
        actionsWithElements.clickOnElementXpathDate(".//*[@class='ui-datepicker-calendar']//a[. ='" + date_Today + "']");
    }


    public void enterFromDestination(String from_destination) {
        actionsWithElements.enterText(search_from_field, from_destination);
    }

    public void enterToDestination(String to_destination) {
        {
            actionsWithElements.enterText(search_to_field, to_destination);
        }
    }

    public void clickOnSearchButton() {
        actionsWithElements.clickOnElement(SearchButton);
    }

}
