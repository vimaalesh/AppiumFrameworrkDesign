package org.vimaleshrajavel;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.vimaleshrajavel.Pageobjects.Android.FormPage;
import org.vimaleshrajavel.TestUtils.EcommBaseTest;

import io.appium.java_client.AppiumBy;

public class EcommerceTestCase_01 extends EcommBaseTest {
	@Test(dataProvider="getData")
	public void fillForm(HashMap<String,String> input) throws InterruptedException {

		FormPage form =new FormPage(driver);
		form.setNameField(input.get("name"));
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/radioFemale")).click();
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		driver.findElement( 
				AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"))"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();

	}
	 
	@DataProvider
	public Object [][]	getData() throws IOException{
		
		List<HashMap<String,String>> data = getJsonData(System.getProperty("user.dir")+"//src//test//java//org//vimaleshrajavel//TestData//TestData.json");
		return new Object[][]	{{data.get(0)},{data.get(1)}};
	}

}
