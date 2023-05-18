package FrameworkDesign;

import FrameworkDesignPOM.FormPage;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

public class BaseTest {

	public AndroidDriver driver;
	public FormPage formpage;
	@BeforeClass(alwaysRun = true)
	@Parameters({"deviceName", "udid","platformVersion", "portNumber"})
	public void ConfigureAppium(String deviceName, String udid, String platformVersion, String portNumber) throws MalformedURLException, InterruptedException {
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName(deviceName);   //this is for emulator congig
		//options.setDeviceName("SampleDevice");
		options.setUdid(udid);
		options.setPlatformVersion(platformVersion);
		//options.setChromedriverExecutable("C:\\Users\\nagar\\Downloads\\chromedriver_win32\\chromedriver.exe");
		options.setApp(System.getProperty("user.dir")+"\\src\\main\\resources\\resources\\ApiDemos-debug.apk");
		//options.setApp(System.getProperty("user.dir")+"\\src\\main\\resources\\resources\\General-Store.apk");
		options.setCapability("uiautomator2ServerInstallTimeout","6000");
		//driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options); //for appium above version 2
		driver = new AndroidDriver(new URL("http://127.0.0.1:"+portNumber+"/wd/hub"), options);////for appium below version 2
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//Thread.sleep(5000);
		formpage = new FormPage(driver);
	}



	@AfterClass(alwaysRun = true)
	public void TearDown() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
		//service.stop();
	}


	public List<HashMap<String, String>> getJsonData(String jsonFilePath) throws IOException {
//System.getProperty("user.dir")+"//src//test//java//org//rahulshettyacademy//testData//eCommerce.json"
		// conver json file content to json string
		String jsonContent = FileUtils.readFileToString(new File(jsonFilePath),StandardCharsets.UTF_8);

		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String, String>>>() {
				});

		return data;

	}

	public String getScreenshotPath(String testCaseName, AppiumDriver driver) throws IOException {
		File source = driver.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"//reports//reports"+testCaseName+".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
	}
}
