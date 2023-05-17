package FrameworkDesignPOM;

import Utils.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductCatalogue extends AndroidActions {
    AndroidDriver driver;
    public ProductCatalogue(AndroidDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    //    driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"));"));



    //    driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
    @FindBy(xpath="//android.widget.TextView[@text='ADD TO CART']")
    public List<WebElement> addToCart;


    //    driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
    @FindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
    public WebElement cart;

    public void addItemtoCartbyIndex(int Index){
        addToCart.get(Index).click();
    }
    public CartPage gotoCart() throws InterruptedException {
        cart.click();
        Thread.sleep(3000);
        return new CartPage(driver);
    }
}
