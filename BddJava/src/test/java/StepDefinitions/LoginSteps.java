package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	
	WebDriver driver = null;
	@Given("browser is open")
	public void browser_is_open() throws InterruptedException {
		
		System.out.println("Inside Step-browser is open");
		
		String projectPath = System.getProperty("user.dir");
		System.out.println("Project path is:"+projectPath);
		System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/drivers/chromedriver.exe");
			driver = new ChromeDriver();
			//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			//driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	    Thread.sleep(5000);
	    driver.manage().window().maximize();
	}

	@And("user is on login page")
	public void user_is_on_login_page() {
		
		
		driver.navigate().to("https://accounts.google.com/ServiceLogin/identifier?service=mail&passive=1209600&osid=1&continue=https%3A%2F%2Fmail.google.com%2Fmail%2Fu%2F0%2F&followup=https%3A%2F%2Fmail.google.com%2Fmail%2Fu%2F0%2F&emr=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
	    
	}

	@When("user enters username and password")
	public void user_enters_username_and_password() throws InterruptedException {
		
		Thread.sleep(2000);
		//Entering Email ID
		driver.findElement(By.xpath("//input[@name='identifier']")).sendKeys("xxxxx@gmail.com");
		Thread.sleep(2000);
		//Clicking on Next
	   driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
	   Thread.sleep(2000);
	   //Entering password
	   driver.findElement(By.xpath("//input[@name='password']")).sendKeys("xxxxxxx");
	   
		
	}
	
	@When("user clicks on login")
	public void user_clicks_on_login() throws InterruptedException {
		Thread.sleep(4000);
		//Clicking on Login 
		driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
		
	    
	}

	@Then("user is navigated to the home page")
	public void user_is_navigated_to_the_home_page() throws InterruptedException {
		
		Thread.sleep(2000);
		System.out.println("Page title is : " + driver.getTitle());
		System.out.println("Inside Step-user is navigated to the home page");
	    
	}


}
