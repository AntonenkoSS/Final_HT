package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultsPage extends BasePage {

    @FindBy(xpath = "//a//img[@class='s-image']")
    private List<WebElement> searchResultsProductsListButton;



    @FindBy(xpath = "//a[@class='a-link-normal s-no-outline'][@href='/Apple-iPhone-11-128GB-Purple/dp/B08BHJGGLP/ref=sr_1_1?crid=2X0M0ZSA8RQ0I&keywords=iphone+11&qid=1642181946&sprefix=iphone11%2Caps%2C555&sr=8-1']")   //!
    private WebElement productSample;

    @FindBy(xpath = "//div[@class='a-row']//h2[text()='Customer reviews']")   //!
    private WebElement productPageVisible;

    @FindBy(xpath = "//span[text()='Customer Reviews']")   //!
    private WebElement customerReviews;

    @FindBy(xpath = "//span[text()='Cell Phone Price']")   //!
    private WebElement cellPhonePrice;
    @FindBy(xpath = "//span[@class='a-size-base a-color-base s-bold-weight-text'][text() = 'Shelf Width']")
    private WebElement productWidth;

    @FindBy(xpath = "//span[@class='a-size-base a-color-base s-bold-weight-text'][text() = 'Furniture Material']")
    private WebElement productFurnitureMaterial;

    @FindBy(xpath = "//span[@class='a-size-base a-color-base s-bold-weight-text'][text() = 'Shelf Depth']")
    private WebElement productDepth;

    @FindBy(xpath = "//span[@class='a-size-base a-color-base s-bold-weight-text'][text() = 'Shelf Height']")
    private WebElement productHeigh;

    @FindBy(xpath = "//span[@class='a-size-base a-color-base s-bold-weight-text'][text() = 'Price']")
    private WebElement productPrice;

    @FindBy(xpath = "//a[@class='a-link-normal s-navigation-item']/span[text()='$100 to $200']")
    private WebElement clickPriceButton;

    @FindBy(xpath = "//span[@class='a-size-base a-color-base s-bold-weight-text'][text() = 'Brand']")
    private WebElement productBrand;

    @FindBy(xpath = "//a[@class='a-link-normal s-navigation-item'][@href='/s?k=bookshelf&rh=n%3A1055398%2Cp_89%3ASauder&dc&crid=4HPNLS8PRL98&qid=1642242147&rnid=2528832011&sprefix=book%2Caps%2C321&ref=sr_nr_p_89_3']//input[@type='checkbox']")
    private WebElement clickBrandVisible;

    @FindBy(xpath = "//h1[@class='a-carousel-heading a-inline-block a-text-normal'][text()='Frequently bought together']")
    private WebElement frequentlyBoughtTogether;

    @FindBy(xpath = "//input[@name='submit.addToCart']")
    private List<WebElement> addToCartSecondProduct;




    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getSearchResultsList() {
        return searchResultsProductsListButton;
    }

    public int getSearchResultsCount() {
        return getSearchResultsList().size();
    }

    public void clickFirstOfListProductSample() {
        getSearchResultsList().get(0).click();
    }



    public boolean isCustomerReviewsVisible() {
        return customerReviews.isDisplayed();
    }

    public boolean isCellPhonePriceVisible() {
        return cellPhonePrice.isDisplayed();
    }

    public boolean isProductWidthVisible() {
        return productWidth.isDisplayed();
    }

    public boolean isFurnitureMaterialVisible() {
        return productFurnitureMaterial.isDisplayed();
    }

    public boolean  isDepthVisible() {
        return productDepth.isDisplayed();
    }

    public boolean  isHeightVisible() {
        return productHeigh.isDisplayed();
    }

    public boolean  isPriceVisible() {
        return productPrice.isDisplayed();
    }

    public boolean  isBrandVisible() {
        return productBrand.isDisplayed();
    }

    public void clickPriceButton(){
        clickPriceButton.click();
    }


    public boolean isFrequentlyBoughtTogetherVisible() {
        return frequentlyBoughtTogether.isDisplayed();
    }

    public List<WebElement> getSearchResultsButtonAddToCart() {
        return addToCartSecondProduct;
    }

    public void clickAddToCartSecondProduct(){
        addToCartSecondProduct.get(2).click();
    }


}
