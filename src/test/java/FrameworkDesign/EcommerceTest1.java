package FrameworkDesign;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import org.openqa.selenium.By;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EcommerceTest1 extends BaseTest{
//    @BeforeMethod
//    public void preSetup() throws InterruptedException {
//        Activity activity = new Activity("com.androidsample.generalstore", "com.androidsample.generalstore/.SplashActivity");
//        driver.startActivity(activity);
//    }

    @Test
    public void FillForm_ErrorValidation() throws InterruptedException
    {
//       driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Nagaraj");
//        driver.hideKeyboard();
        driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
        driver.findElement(By.id("android:id/text1")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
        driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        String toastMessage = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
        AssertJUnit.assertEquals(toastMessage,"Please enter your namee");
    }

    @Test
    public void FillForm_PositiveFlow() throws InterruptedException
    {
        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Rider");
        driver.hideKeyboard();
        driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
        driver.findElement(By.id("android:id/text1")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
        driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        AssertJUnit.assertTrue(driver.findElements(By.xpath("(//android.widget.Toast)[1]")).size()<1);
    }

}
