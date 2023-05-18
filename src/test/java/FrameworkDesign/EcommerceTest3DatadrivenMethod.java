package FrameworkDesign;

import FrameworkDesignPOM.CartPage;
import FrameworkDesignPOM.ProductCatalogue;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class EcommerceTest3DatadrivenMethod extends BaseTest {



    @Test(dataProvider = "getData")
    public void FillForm(String name,String gender,String country) throws InterruptedException {
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    formpage.setNameField(name);
    formpage.selectGender(gender);
    formpage.setCountrySelection(country);
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
    @BeforeMethod
    public void preSetup(){
        formpage.setActivity();
    }
    @DataProvider
    public Object[][] getData(){
        return new Object [] []{{"Nagaraj","male","Angola"},{"Abi","female","Angola"}};
    }


}
