package FrameworkDesign;

import FrameworkDesignPOM.CartPage;
import FrameworkDesignPOM.ProductCatalogue;
import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class EcommerceTest2 extends BaseTest {



    @Test()
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




}


}
