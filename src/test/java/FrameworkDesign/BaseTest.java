package FrameworkDesign;

import FrameworkDesignPOM.FormPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {

	public AndroidDriver driver;
	public FormPage formpage;
	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException, InterruptedException {

		UiAutomator2Options options = new UiAutomator2Options();


		options.setDeviceName("NewEmulator");   //this is for emulator congig
		//options.setDeviceName("SampleDevice");


		options.setChromedriverExecutable("C:\\Users\\nagar\\Downloads\\chromedriver_win32\\chromedriver.exe");

		options.setApp("C:\\Users\\nagar\\IdeaProjects\\AppiumTest\\src\\main\\resources\\General-Store.apk");

		options.setCapability("uiautomator2ServerInstallTimeout","6000");

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options); //for appium above version 2
		//driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);////for appium below version 2
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//Thread.sleep(5000);
		formpage = new FormPage(driver);
	}



	@AfterClass
	public void TearDown() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
		//service.stop();
	}
}
