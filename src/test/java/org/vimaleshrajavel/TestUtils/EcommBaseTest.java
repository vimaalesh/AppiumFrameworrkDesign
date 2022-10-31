package org.vimaleshrajavel.TestUtils;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.vimaleshrajavel.Utils.JsonDataExtractUtil;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class EcommBaseTest extends JsonDataExtractUtil{

	public AppiumDriverLocalService service;
	public AndroidDriver driver;

	@BeforeTest
	public void configureAppium() throws MalformedURLException {

		service = new AppiumServiceBuilder()
				.withAppiumJS(
						new File("C://Users//vimal//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();

		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Pixel 4");
		options.setApp(
				"C://Users//vimal//eclipse-workspace//frameworkdesign//src//main//java//org//vimaleshrajavel//resources//General-Store.apk");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	}

	@AfterTest
	public void tearDown() {
		driver.quit();
		service.close();

	}

}
