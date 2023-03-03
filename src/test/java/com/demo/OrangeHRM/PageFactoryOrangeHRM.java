package com.demo.OrangeHRM;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageFactoryOrangeHRM {
	WebDriver driver = null;
	
	/*Xpath Login Page Section:
	 * All the xpath are selected for each type of field present in
	 * Login Page section.*/
	@FindBy(xpath="//input[@name='username']")
	public WebElement uname;
	
	@FindBy(xpath="//input[@type='password']")
	public WebElement pwd;
	
	@FindBy(xpath="//button[@type='submit']")
	public WebElement btn;
	
	@FindBy(xpath="//ul[@class='oxd-main-menu']/li[6]/a")
	public WebElement myinfo;
	
	/*Xpath Personal Details Section:
	 * All the xpath are selected for each type of field present in
	 * Personal Details section.*/
	@FindBy(xpath="//div[@class='orangehrm-tabs']/div[1]/a")
	public WebElement personalDet;
	
	@FindBy(xpath="//input[@name='firstName']")
	public WebElement firstName;
	
	@FindBy(xpath="//input[@name='middleName']")
	public WebElement middleName;
	
	@FindBy(xpath="//input[@name='lastName']")
	public WebElement lastName;
	
	@FindBy(xpath="//form[@class='oxd-form']/div[1]/div[2]/div/div/div[2]/input")
	public WebElement nickName;
	
	@FindBy(xpath="//form[@class='oxd-form']/div[2]/div[1]/div[1]/div/div[2]/input")
	public WebElement EmpId;
	
	@FindBy(xpath="//form[@class='oxd-form']/div[2]/div[1]/div[2]/div/div[2]/input")
	public WebElement otherId;
	
	@FindBy(xpath="//form[@class='oxd-form']/div[2]/div[2]/div[1]/div/div[2]/input")
	public WebElement driverlicense;
	
	@FindBy(xpath="//form[@class='oxd-form']/div[2]/div[2]/div[2]/div/div[2]/div/div/input")
	public WebElement liceseExp;
	
	@FindBy(xpath="//form[@class='oxd-form']/div[2]/div[3]/div[1]/div/div[2]/input")
	public WebElement ssn;
	
	@FindBy(xpath="//form[@class='oxd-form']/div[2]/div[3]/div[2]/div/div[2]/input")
	public WebElement sin;
	
	@FindBy(xpath="//form[@class='oxd-form']/div[3]/div[1]/div[1]/div/div[2]/div/div/div[1]")
	public WebElement country;
	
	@FindBy(xpath="//form[@class='oxd-form']/div[3]/div[1]/div[2]/div/div[2]/div/div/div[1]")
	public WebElement marritial;
	
	@FindBy(xpath="//form[@class='oxd-form']/div[3]/div[2]/div[1]/div/div[2]/div/div/input")
	public WebElement dob;
	
	@FindBy(xpath="//form[@class='oxd-form']/div[4]/div/div[1]/div/div[2]/input")
	public WebElement mililtary;
	
	@FindBy(xpath="//label[text()='Yes']")
	public WebElement smoker;
	
	
	/*Xpath Contact Details Section:
	 * All the xpath are selected for each type of field present in
	 * Contact Details section.*/
	@FindBy(xpath="//div[@class='orangehrm-tabs']/div[2]/a")
	public WebElement contactSec;
	
	@FindBy(xpath="//div[@class='orangehrm-tabs']/div[3]/a")
	public WebElement emergency;
	
	/*Xpath Dependents Section:
	 * All the xpath are selected for each type of field present in
	 * Dependents section.*/
	@FindBy(xpath="//div[@class='orangehrm-tabs']/div[4]/a")
	public WebElement dependant;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/div/button")
	public WebElement dependantAddBtn;
	
	@FindBy(xpath="//form[@class='oxd-form']/div[1]/div/div[1]/div/div[2]/input")
	public WebElement dependentName;
	
	@FindBy(xpath="//form[@class='oxd-form']/div[1]/div/div[2]/div/div[2]/div/div/div[1]")
	public WebElement dependentRel;
	
	@FindBy(xpath="//div[text()='-- Select --']")
	public WebElement dependentRelChild;
	
	@FindBy(xpath="//div[text()='-- Select --']")
	public WebElement dependentRelOther;
	
	@FindBy(xpath="//form/div[1]/div/div[3]/div/div[2]/input")
	public WebElement dependentOthers;
	
	@FindBy(xpath="//form[@class='oxd-form']/div[2]/div/div/div/div[2]/div/div/input")
	public WebElement dependentDob;
	
	@FindBy(xpath="//div[@class='orangehrm-tabs']/div[10]/a")
	public WebElement qualification;
	
	@FindBy(xpath="//div[@class='orangehrm-tabs']/div[11]/a")
	public WebElement membership;
	
	public void clearField(WebElement ele) throws InterruptedException {
		ele.click();
		ele.sendKeys(Keys.CONTROL+"a");
		ele.sendKeys(Keys.DELETE);
		Thread.sleep(2000);
	}
	
	public PageFactoryOrangeHRM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
