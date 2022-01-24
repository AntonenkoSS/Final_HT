package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TodayDealsPage extends BasePage {

    @FindBy(xpath = "//h1[@class='a-size-extra-large a-spacing-micro']")     //!
    private WebElement todayDealsTitle;                                      //!

    public TodayDealsPage(WebDriver driver) {     //конструктор
        super(driver);
    }

    public WebElement getTodayDealsTitle() {
        return todayDealsTitle;
    }  //!

    public boolean isTodayDealsTitleVisible() {
        return todayDealsTitle.isDisplayed();
    }    //!

}
