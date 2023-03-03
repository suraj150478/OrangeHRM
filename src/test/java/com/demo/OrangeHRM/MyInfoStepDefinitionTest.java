package com.demo.OrangeHRM;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MyInfoStepDefinitionTest {
	WebDriver driver = null;
	
	 @Test
	  public void user_opens_OrangeHRM_URLTest() throws InterruptedException {
		  System.setProperty("Webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
		  ChromeOptions options = new ChromeOptions();
		  options.addArguments("start-maximized");
		  options.addArguments("--lang=en-ca");
		  driver = new ChromeDriver(options);
		  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		  Thread.sleep(4000);
		  String title = driver.getTitle();
		  Assert.assertEquals(title, "OrangeHRM");
	 }
	 
  @Test
  public void click_on_loginTest() {
	PageFactoryOrangeHRM pf = new PageFactoryOrangeHRM(driver);
	pf.btn.click();
  }

  @Test
  public void closeBrowserTest() {
		driver.close();
  }

  @Test
  public void it_should_show_me_error_messageTest() {
		String firstNameError = driver.findElement(By.xpath("//div/div[1]/span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']")).getText();
		if(firstNameError.equalsIgnoreCase("Required")) {
			Assert.assertEquals(firstNameError, "Required");			
		}else {
			Assert.assertEquals(firstNameError, "Invalid Input");						
		}
  }

  @Test
  public void user_can_see_the_Change_profile_picture_sectionTest() throws InterruptedException {
	Thread.sleep(2000);
	String chngePicture = driver.findElement(By.xpath("//div[@class='orangehrm-edit-employee-content']/div/h6")).getText();
	Assert.assertEquals(chngePicture, "Change Profile Picture");
  }

  @Test
  public void user_click_on_the_Add_buttonTest() throws InterruptedException {
		Thread.sleep(2000);		
		PageFactoryOrangeHRM pf = new PageFactoryOrangeHRM(driver);
		pf.dependantAddBtn.click();
  }

  @Test
  public void user_click_on_the_Dependents_Delete_buttonTest() throws InterruptedException {
		Thread.sleep(3000);
		WebElement deleteBtn = driver.findElement(By.xpath("//div[@class='oxd-table']/div[2]/div[2]/div/div[5]/div/button[1]/i"));
		deleteBtn.click();
  }

  @Test
  public void user_click_on_the_dependent_Edit_buttonTest() {
		WebElement editBtn = driver.findElement(By.xpath("//div[@class='oxd-table']/div[2]/div[2]/div/div[5]/div/button[2]/i"));
		editBtn.click();
  }

  @Test
  public void user_clicks_on_ImageTest() throws InterruptedException {
	Thread.sleep(2000);
	driver.findElement(By.className("employee-image")).click();
  }

  @Test
  public void user_clicks_on_the_My_Info_linkTest() throws InterruptedException {
	Thread.sleep(2000);
	PageFactoryOrangeHRM pf = new PageFactoryOrangeHRM(driver);
	pf.myinfo.click();
  }

  @Test
  public void user_clicks_on_the_Save_buttonTest() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(4000);
  }

  @Test
  public void user_confirm_the_deletionTest() {
		WebElement confirmBtn = driver.findElement(By.xpath("//div[@class='oxd-dialog-container-default--inner']/div/div[3]/button[2]/i"));
		confirmBtn.click();
  }

  @Test
  @Parameters({"username","password"})
  public void user_enters_username_as_Admin_and_password_as_admin123Test(String username, String password) {
	  PageFactoryOrangeHRM pf = new PageFactoryOrangeHRM(driver);
	  pf.uname.sendKeys(username);
	  pf.pwd.sendKeys(password);
  }

  @Test
  public void user_fill_in_the_required_fields_for_the_new_dependentTest(String name, String relation, String others, String dob) throws InterruptedException {
		Thread.sleep(2000);		
		PageFactoryOrangeHRM pf = new PageFactoryOrangeHRM(driver);
		pf.clearField(pf.dependentName);
		pf.dependentName.sendKeys(name);
		pf.dependentRel.click();
//		pf.dependentRel.sendKeys(relation);
		System.out.println(relation);
		if(relation.equalsIgnoreCase("o")) {
			driver.findElement(By.xpath("//span[text()='Other']")).click();
			Thread.sleep(2000);	
			pf.clearField(pf.dependentOthers);
			pf.dependentOthers.sendKeys(others);
			pf.clearField(pf.dependentDob);
			pf.dependentDob.sendKeys(dob);
		}else
		{
			driver.findElement(By.xpath("//span[text()='Child']")).click();
			pf.clearField(pf.dependentDob);
			pf.dependentDob.sendKeys(dob);			
		}
  }

  @Test
  public void user_is_in_Dependents_sectionTest() throws InterruptedException {
		Thread.sleep(2000);		
		PageFactoryOrangeHRM pf = new PageFactoryOrangeHRM(driver);
		pf.dependant.click();
  }

  @Test
  public void user_is_in_Personal_Information_sectionTest() throws InterruptedException {
	Thread.sleep(2000);
	PageFactoryOrangeHRM pf = new PageFactoryOrangeHRM(driver);
	pf.personalDet.click();
	Thread.sleep(2000);
  }

  @Test
  public void user_is_on_Dashboard_pageTest() throws InterruptedException {
	  Thread.sleep(4000);
	  String dashboard = driver.findElement(By.xpath("//h6[text()='Dashboard']")).getText();
	  Assert.assertEquals(dashboard, "Dashboard");
  }

  @Test
  public void user_search_for_an_existing_dependentTest() throws InterruptedException {
		Thread.sleep(2000);
		String dependentName = driver.findElement(By.xpath("//div[text()='Sumit']")).getText();
		Assert.assertEquals(dependentName, "Sumit");
  }

  @Test
  public void user_should_see_my_info_sectionTest() throws InterruptedException {
	Thread.sleep(4000);
	String myinfoHead = driver.findElement(By.xpath("//h6[text()='PIM']")).getText();
	Assert.assertEquals(myinfoHead, "PIM");
  }

  @Test
  public void user_update_the_fields_with_new_inputTest() throws InterruptedException {
		Thread.sleep(2000);		
		PageFactoryOrangeHRM pf = new PageFactoryOrangeHRM(driver);
		
		pf.clearField(pf.firstName);		
		pf.firstName.sendKeys("Suraj");
		
		pf.clearField(pf.middleName);
		
		pf.clearField(pf.lastName);	
		pf.lastName.sendKeys("Singh");	
		
		pf.clearField(pf.nickName);
		pf.nickName.sendKeys("Suraj");		
			
		pf.clearField(pf.EmpId);
		pf.EmpId.sendKeys("0014");
			
		pf.clearField(pf.otherId);
		pf.otherId.sendKeys("1234");
		
		pf.clearField(pf.driverlicense);
		pf.driverlicense.sendKeys("2656487");	
		
		pf.clearField(pf.liceseExp);
		pf.liceseExp.sendKeys("2014-02-13");		
			
		pf.clearField(pf.ssn);
		pf.ssn.sendKeys("234566");	
		
		pf.clearField(pf.sin);
		pf.sin.sendKeys("7987987");		
		
		pf.country.click();
		pf.country.sendKeys("i");
		pf.country.sendKeys(Keys.DOWN);
		pf.country.sendKeys(Keys.DOWN);
		
		pf.marritial.click();
		pf.marritial.sendKeys("s");
		
		pf.clearField(pf.dob);
		pf.dob.sendKeys("1999-01-01");	
		
		driver.findElement(By.xpath("//label[text()='Male']")).click();
		
		pf.clearField(pf.mililtary);
		pf.mililtary.sendKeys("No");		

		driver.findElement(By.xpath("//label[text()='Yes']")).click();
  }

  @Test
  public void user_update_the_required_fields_with_numbersTest() throws InterruptedException {
		Thread.sleep(2000);		
		PageFactoryOrangeHRM pf = new PageFactoryOrangeHRM(driver);
		
		pf.clearField(pf.firstName);		
		pf.firstName.sendKeys("123");
		
		pf.clearField(pf.lastName);		
		pf.lastName.sendKeys("456");
  }

  @Test
  public void user_update_the_required_fields_with_spacesTest() throws InterruptedException {
	    Thread.sleep(2000);		
		PageFactoryOrangeHRM pf = new PageFactoryOrangeHRM(driver);
		
		pf.clearField(pf.firstName);		
		pf.firstName.sendKeys(" ");
		
		pf.clearField(pf.lastName);		
		pf.lastName.sendKeys(" ");
  }
}
