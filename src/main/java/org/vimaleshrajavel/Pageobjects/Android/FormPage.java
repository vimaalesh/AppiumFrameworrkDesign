package org.vimaleshrajavel.Pageobjects.Android;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.vimaleshrajavel.Utils.JsonDataExtractUtil;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class FormPage extends JsonDataExtractUtil{
	
	AndroidDriver driver;

	public FormPage(AndroidDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
	private WebElement nameField;

	public void setNameField(String name) {
		nameField.sendKeys(name);
		this.driver.hideKeyboard();
	}


}
