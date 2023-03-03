package runner;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import com.demo.OrangeHRM.PageFactoryOrangeHRM;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyInfoStepDefinition {
	WebDriver driver = null;
	
	
	/* Created By = Suraj Singh
	 * Modified By = 
	 * Reviewed By = Roopanand Kommi Naidu 
	 * Method is loading the OrangeHRM URL in Chrome Browser
	 * */
	@Given("User opens OrangeHRM URL")
	public void user_opens_OrangeHRM_URL() throws InterruptedException {
	    System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
	    ChromeOptions options = new ChromeOptions();
	    options.addArguments("start-maximized");
	    options.addArguments("--lang=en-ca");
	    driver = new ChromeDriver(options);
	    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	    Thread.sleep(4000);
	    String title = driver.getTitle();
	    Assert.assertEquals(title, "OrangeHRM");
	}

	/* Created By = Suraj Singh
	 * Modified By = 
	 * Reviewed By = Roopanand Kommi Naidu 
	 * Method is used to enter Username and Password
	 * */
	@When("^User enters username as Admin and password as admin123$")
	public void user_enters_username_as_Admin_and_password_as_admin123(DataTable userCred) {
	    PageFactoryOrangeHRM pf = new PageFactoryOrangeHRM(driver);
	    List<List<String>> data = userCred.asLists(String.class);
	    pf.uname.sendKeys(data.get(0).get(0));
	    pf.pwd.sendKeys(data.get(0).get(1));
	}
	
	/* Created By = Suraj Singh
	 * Modified By = 
	 * Reviewed By = Roopanand Kommi Naidu 
	 * Method is used to click on login button
	 * */
	@When("Click on login")
	public void click_on_login() {
		PageFactoryOrangeHRM pf = new PageFactoryOrangeHRM(driver);
		pf.btn.click();
	}
	
	/* Created By = Suraj Singh
	 * Modified By = 
	 * Reviewed By = Roopanand Kommi Naidu 
	 * Method is Check whether the user is in Dashboard
	 * */
	@Given("User is on Dashboard page")
	public void user_is_on_Dashboard_page() throws InterruptedException {
		Thread.sleep(4000);
		String dashboard = driver.findElement(By.xpath("//h6[text()='Dashboard']")).getText();
	    Assert.assertEquals(dashboard, "Dashboard");
	}

	/* Created By = Suraj Singh
	 * Modified By = 
	 * Reviewed By = Roopanand Kommi Naidu 
	 * Method is used to click on My Info link in Left navigation section
	 * */
	@When("User clicks on the My Info link")
	public void user_clicks_on_the_My_Info_link() throws InterruptedException {
		Thread.sleep(2000);
		PageFactoryOrangeHRM pf = new PageFactoryOrangeHRM(driver);
		pf.myinfo.click();
	}

	/* Created By = Suraj Singh
	 * Modified By = 
	 * Reviewed By = Roopanand Kommi Naidu 
	 * Method is will check the heading as PIM
	 * */
	@When("User should see my info section")
	public void user_should_see_my_info_section() throws InterruptedException {
		Thread.sleep(4000);
	    String myinfoHead = driver.findElement(By.xpath("//h6[text()='PIM']")).getText();
	    Assert.assertEquals(myinfoHead, "PIM");
	}
	
	/* Created By = Suraj Singh
	 * Modified By = 
	 * Reviewed By = Roopanand Kommi Naidu 
	 * Method is taking user to Change profile picture section on clicking the image
	 * */
	@When("User clicks on Image")
	public void user_clicks_on_Image() throws InterruptedException {
		Thread.sleep(2000);
	    driver.findElement(By.className("employee-image")).click();
	}
	
	/* Created By = Suraj Singh
	 * Modified By = 
	 * Reviewed By = Roopanand Kommi Naidu 
	 * Method is used to check whether user is in Change profile section
	 * */
	@Then("User can see the Change profile picture section")
	public void user_can_see_the_Change_profile_picture_section() throws InterruptedException {
		Thread.sleep(2000);
		String chngePicture = driver.findElement(By.xpath("//div[@class='orangehrm-edit-employee-content']/div/h6")).getText();
		Assert.assertEquals(chngePicture, "Change Profile Picture");
	    
	}
	
	/* Created By = Suraj Singh
	 * Modified By = 
	 * Reviewed By = Roopanand Kommi Naidu 
	 * Method is used to click on Personal Information section
	 * */
	@Given("user is in Personal Information section")
	public void user_is_in_Personal_Information_section() throws InterruptedException {
		Thread.sleep(2000);
		PageFactoryOrangeHRM pf = new PageFactoryOrangeHRM(driver);
	    pf.personalDet.click();
	    Thread.sleep(2000);
	}

	/* Created By = Suraj Singh
	 * Modified By = 
	 * Reviewed By = Roopanand Kommi Naidu 
	 * Method is used to update the fields in Personal Information section
	 * */
	@When("user update the fields with new input")
	public void user_update_the_fields_with_new_input() throws InterruptedException {
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

	/* Created By = Suraj Singh
	 * Modified By = 
	 * Reviewed By = Roopanand Kommi Naidu 
	 * Method is used to click on Save buttons in OrangeHRM
	 * */
	@When("user clicks on the Save button")
	public void user_clicks_on_the_Save_button() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(4000);
	}

	/* Created By = Suraj Singh
	 * Modified By = 
	 * Reviewed By = Roopanand Kommi Naidu 
	 * Method is used to give invalid input in Required fields of Personal Information section
	 * */
	@When("user update the required fields with spaces")
	public void user_update_the_required_fields_with_spaces() throws InterruptedException {
	    Thread.sleep(2000);		
		PageFactoryOrangeHRM pf = new PageFactoryOrangeHRM(driver);
		
		pf.clearField(pf.firstName);		
		pf.firstName.sendKeys(" ");
		
		pf.clearField(pf.lastName);		
		pf.lastName.sendKeys(" ");
	}
	
	/* Created By = Suraj Singh
	 * Modified By = 
	 * Reviewed By = Roopanand Kommi Naidu 
	 * Method is used to check the error message for Invalid fields
	 * */
	@When("it should show me error message")
	public void it_should_show_me_error_message() {
		String firstNameError = driver.findElement(By.xpath("//div/div[1]/span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']")).getText();
		if(firstNameError.equalsIgnoreCase("Required")) {
			Assert.assertEquals(firstNameError, "Required");			
		}else {
			Assert.assertEquals(firstNameError, "Invalid Input");						
		}
	}

	/* Created By = Suraj Singh
	 * Modified By = 
	 * Reviewed By = Roopanand Kommi Naidu 
	 * Method is used to give invalid input in Required fields of Personal Information section
	 * */
	@When("user update the required fields with numbers")
	public void user_update_the_required_fields_with_numbers() throws InterruptedException {
		Thread.sleep(2000);		
		PageFactoryOrangeHRM pf = new PageFactoryOrangeHRM(driver);
		
		pf.clearField(pf.firstName);		
		pf.firstName.sendKeys("123");
		
		pf.clearField(pf.lastName);		
		pf.lastName.sendKeys("456");
	}

	/* Created By = Suraj Singh
	 * Modified By = 
	 * Reviewed By = Roopanand Kommi Naidu 
	 * Method redirectst user to Dependents section
	 * */
	@Given("user is in Dependents section")
	public void user_is_in_Dependents_section() throws InterruptedException {
		Thread.sleep(2000);		
		PageFactoryOrangeHRM pf = new PageFactoryOrangeHRM(driver);
		pf.dependant.click();
	}

	/* Created By = Suraj Singh
	 * Modified By = 
	 * Reviewed By = Roopanand Kommi Naidu 
	 * Method is used to click add button in Dependents section
	 * */
	@Given("user click on the Add button")
	public void user_click_on_the_Add_button() throws InterruptedException {
		Thread.sleep(2000);		
		PageFactoryOrangeHRM pf = new PageFactoryOrangeHRM(driver);
		pf.dependantAddBtn.click();
	}

	/* Created By = Suraj Singh
	 * Modified By = 
	 * Reviewed By = Roopanand Kommi Naidu 
	 * Method is used to fill all the Input fields in Dependents section
	 * */
	@Given("user fill in the required fields {string} {string} {string} {string} for the new dependent")
	public void user_fill_in_the_required_fields_for_the_new_dependent(String name, String relation, String others, String dob) throws InterruptedException {
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

	/* Created By = Suraj Singh
	 * Modified By = 
	 * Reviewed By = Roopanand Kommi Naidu 
	 * Method is used to check for Dependent in Dependents section
	 * */
	@When("user search for an {string} dependent")
	public void user_search_for_an_dependent(String name) throws InterruptedException {
		Thread.sleep(2000);
		String dependentName = driver.findElement(By.xpath("//div[text()='"+name+"']")).getText();
		Assert.assertEquals(dependentName, name);
	}

	/* Created By = Suraj Singh
	 * Modified By = 
	 * Reviewed By = Roopanand Kommi Naidu 
	 * Method is used to click on Edit button in Dependents section
	 * */
	@When("user click on the dependent Edit button")
	public void user_click_on_the_dependent_Edit_button() {
		WebElement editBtn = driver.findElement(By.xpath("//div[text()='Saket']/parent::div/following-sibling::div[3]/div/button[2]"));
		editBtn.click();
	}
	
	/* Created By = Suraj Singh
	 * Modified By = 
	 * Reviewed By = Roopanand Kommi Naidu 
	 * Method is used to click on Delete button in Dependents section
	 * */
	@When("user click on the Dependents Delete button")
	public void user_click_on_the_Dependents_Delete_button() throws InterruptedException {
		Thread.sleep(3000);
		WebElement deleteBtn = driver.findElement(By.xpath("//div[@class='oxd-table']/div[2]/div[2]/div/div[5]/div/button[1]/i"));
		deleteBtn.click();
	}

	/* Created By = Suraj Singh
	 * Modified By = 
	 * Reviewed By = Roopanand Kommi Naidu 
	 * Method is used to click the confirmation option in the Dial
	 * */
	@Then("user confirm the deletion")
	public void user_confirm_the_deletion() {
		
		WebElement confirmBtn = driver.findElement(By.xpath("//div[@class='oxd-dialog-container-default--inner']/div/div[3]/button[2]/i"));
		confirmBtn.click();
	}
	
	@After
	public void closeBrowser() {
		driver.close();
	}

}
