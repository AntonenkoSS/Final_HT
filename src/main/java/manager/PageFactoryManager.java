package manager;

import org.openqa.selenium.WebDriver;
import pages.*;

public class PageFactoryManager {

    WebDriver driver;

    public PageFactoryManager(WebDriver driver){
        this.driver = driver;
    }

    public HomePage getHomePage(){ return new HomePage(driver);}

    public TodayDealsPage getTodayDealsPage(){ return new TodayDealsPage(driver);}

    public CustomerServicePage getCustomerServicePage(){ return new CustomerServicePage(driver);}

    public ShoppingCartPage getShoppingCartPage(){ return new ShoppingCartPage(driver);}

    public SearchResultsPage getSearchResultsPage(){ return new SearchResultsPage(driver);}

    public ProductPage getProductPage(){ return new ProductPage(driver);}

    public CreateAccountAmazonPage getCreateAccountAmazonPage() {
        return new CreateAccountAmazonPage(driver);
    }

    public CheckoutPage getCheckoutPage(){ return new CheckoutPage(driver);}

}
