package FrameworkDesign;

import FrameworkDesignPOM.CartPage;
import FrameworkDesignPOM.FormPage;
import FrameworkDesignPOM.ProductCatalogue;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class EcommerceTest1 extends BaseTest {



@Test
    public void FillForm() throws InterruptedException {

    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    formpage.setNameField("Nagaraj");
    formpage.selectGender("male");
    formpage.setCountrySelection("Angola");
    formpage.submitForm();
    ProductCatalogue productCatalogue= formpage.alertMessage();
    productCatalogue.addItemtoCartbyIndex(0);
    productCatalogue.addItemtoCartbyIndex(0);
   CartPage cartPage = productCatalogue.gotoCart();
    double totalSum = cartPage.getProductsSum();
    double displayFormattedSum = cartPage.getTotalAmountDisplayed();
    AssertJUnit.assertEquals(totalSum, displayFormattedSum);
    //cartPage.acceptTermsConditions();
    cartPage.submitOrder();



//    driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"));"));
//    int productCount = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
//    for (int i = 0; i < productCount; i++) {
//        String productName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
//        if (productName.equalsIgnoreCase("Jordan 6 Rings")) {
//            driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
//        }
//    }
//    driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
//    driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
//
//    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//    ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart");
//
//    String lastPageProduct = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
//    try {
//        Assert.assertEquals(lastPageProduct, "Jordan 6 Rings");
//        System.out.println("Values are equal");
//    } catch (Exception e) {
//        System.out.println("Values are not equal");
//    }

//    List<WebElement> productPrices =driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
//    int count = productPrices.size();
//    double totalSum =0;
//    for(int i =0; i< count; i++)
//    {
//        String amountString =productPrices.get(i).getText();
//        System.out.println(i+1+" value   "+amountString);
//        Double price = getFormattedAmount(amountString);
//        totalSum = totalSum + price;  //160.97 + 120 =280.97
//
//    }
//    String displaySum =driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
//    Double displayFormattedSum = getFormattedAmount(displaySum);
//    Assert.assertEquals(totalSum, displayFormattedSum);
//    System.out.println("Total sum is"+totalSum);
//    System.out.println("Display sum is"+displaySum);
//    WebElement ele = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
//    longPressAction(ele);
//    driver.findElement(By.id("android:id/button1")).click();
//    driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
//    driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
//    Thread.sleep(6000);
//    Set<String> contexts =driver.getContextHandles();
//    for(String contextName :contexts)
//    {
//        System.out.println(contextName);
//    }
//
//    driver.context("WEBVIEW_com.androidsample.generalstore");//chrome driver
//    driver.findElement(By.name("q")).sendKeys("Nagaraj");
//    driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
//    driver.pressKey(new KeyEvent(AndroidKey.BACK));
//    driver.context("NATIVE_APP");

}

}