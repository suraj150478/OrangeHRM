package runner;
import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

/*
 * Test Runner Class for running OrangeHRM test using Cucumber Feature
 * Created By = Suraj Singh
 * Reveiwed By = Roopanand Naidu Kommi
 * */
@RunWith(Cucumber.class)
@CucumberOptions(features={"src\\test\\resources\\myInfo"})
public class MyInfoRunner extends AbstractTestNGCucumberTests 
{

	@Override
	@DataProvider(parallel=false)
	public Object[][] scenarios(){
		return super.scenarios();
	}
	
}