package FrameworkDesign;

import FrameworkDesignPOM.CartPage;
import FrameworkDesignPOM.ProductCatalogue;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

public class EcommerceTest4DDMjson extends BaseTest {



    @Test(dataProvider = "getData")
    public void FillForm(HashMap<String,String> input) throws InterruptedException {
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    formpage.setNameField(input.get("name"));
    formpage.selectGender(input.get("gender"));
    formpage.setCountrySelection(input.get("Country"));
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
    public Object[][] getData() throws IOException {
        List<HashMap<String,String>> data=getJsonData(System.getProperty("user.dir")+"\\src\\main\\java\\TestData\\eCommerce.json");
//        return new Object [] []{{data.get(0)},{data.get(1)}};
        return new Object [] []{{data.get(0)}};
    }


}
