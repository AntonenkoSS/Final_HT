package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {

    @FindBy(xpath = "//a[@class='a-link-normal s-no-outline'][@href='/Apple-iPhone-11-128GB-Purple/dp/B08BHJGGLP/ref=sr_1_1?crid=2X0M0ZSA8RQ0I&keywords=iphone+11&qid=1642181946&sprefix=iphone11%2Caps%2C555&sr=8-1']")   //!
    private WebElement productSample;

    @FindBy(xpath = "//div[@class='a-row']//h2[text()='Customer reviews']")   //!
    private WebElement productPageVisible;

    @FindBy(xpath = "//input[@name='submit.add-to-cart']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//a[contains(text(),'Continue shopping')]")
    private WebElement continueShoppingButton;

    @FindBy(xpath = "//span[@class='a-button a-button-base attach-button-large']//input[@class='a-button-input']")
    private WebElement cartButton;

    @FindBy(xpath = "//span[@class='a-button-text']/span[@id='attach-accessory-proceed-to-checkout-text']")
    private WebElement addToCartPopupHeaderText;

    @FindBy(xpath = "//span[@class='a-size-medium-plus a-color-base sw-atc-text a-text-bold']")
    private WebElement addToCartPopupHeader;

    @FindBy(xpath = "//h1[@class='a-size-large']")
    private WebElement toComparePopupHeader;





    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public boolean isProductPageVisible() {
        return productPageVisible.isDisplayed();
    }

    public WebElement getProductPageVisible() {
        return productPageVisible;
    }

    public void clickAddToCartButton() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addToCartButton);
    }

    public WebElement getAddToCartButton() {
        return addToCartButton;
    }

    public boolean isAddToCartPopupVisible() {
        return addToCartPopupHeader.isDisplayed();
    }

    public void isContinueShoppingButtonVisible() {
        continueShoppingButton.isDisplayed();
    }

    public String getAddToCartPopupHeaderText() {
        return addToCartPopupHeaderText.getText();
    }

    public void isCartButtonVisible() {
        cartButton.isDisplayed();
    }

    public void clickContinueToCartButton() {
        cartButton.click();
    }

    public WebElement getAddToCartPopupHeader() {
        return addToCartPopupHeader;
    }

    public WebElement getComparePopupHeader() {
        return toComparePopupHeader;
    }

    public boolean isComparePopupVisible() {
        return toComparePopupHeader.isDisplayed();
    }


}
