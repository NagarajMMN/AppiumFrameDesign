package FrameworkDesignPOM;

import Utils.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormPage extends AndroidActions {
    AndroidDriver driver;

    public FormPage(AndroidDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    //driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Nagaraj");
    @FindBy(id="com.androidsample.generalstore:id/nameField")
    private WebElement nameField;


    //driver.findElement(By.xpath("//android.widget.RadioButton[@text='Male']")).click();
    @FindBy(xpath = "//android.widget.RadioButton[@text='Male']")
    private WebElement maleOption;
    @FindBy(xpath = "//android.widget.RadioButton[@text='Female']")
    private WebElement femaleOption;


    //driver.findElement(By.id("android:id/text1")).click();
    @FindBy(id="android:id/text1")
    private WebElement countrySelection;

    //driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
    @FindBy(id="com.androidsample.generalstore:id/btnLetsShop")
    private WebElement shopButton;


    //driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
    @FindBy(xpath = "(//android.widget.Toast)[1]")
    public WebElement alert;

    public void setNameField(String name){
        nameField.sendKeys(name);
        driver.hideKeyboard();
    }
    public void selectGender(String gender){
        if (gender.contains("male")){
        maleOption.click();}
        else {
            femaleOption.click();
        }
    }
    public void setCountrySelection(String countryName){
        countrySelection.click();
        ScrolltoText(countryName);
        driver.findElement(By.xpath("//android.widget.TextView[@text='"+countryName+"']")).click();
    }
    public void submitForm(){
        shopButton.click();
    }
    public ProductCatalogue alertMessage() throws InterruptedException {
        try {
            String toastMessage = alert.getAttribute("name");
            System.out.println("message appears");
            Thread.sleep(1000);
            driver.quit();
        }catch (Exception e){
            System.out.println("There is no alert message appears you can continue further");
        }
        return new ProductCatalogue(driver);

    }

}
