package StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ComposeEmailSteps {
	
	WebDriver driver = null;
	@Given("There is a user who visits gmail login page")
	public void there_is_a_user_who_visits_gmail_login_page() throws InterruptedException {
		System.out.println("Inside Step-There is a user who visits gmail login page");

		
		String projectPath = System.getProperty("user.dir");
		System.out.println("Project path is:"+projectPath);
		System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/drivers/chromedriver.exe");
			driver = new ChromeDriver();
			//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			//driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	    Thread.sleep(5000);
	    driver.manage().window().maximize();
	    driver.navigate().to("https://accounts.google.com/ServiceLogin/identifier?service=mail&passive=1209600&osid=1&continue=https%3A%2F%2Fmail.google.com%2Fmail%2Fu%2F0%2F&followup=https%3A%2F%2Fmail.google.com%2Fmail%2Fu%2F0%2F&emr=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
	    

	    }
	 
	
@And("User login with username and password")
	public void user_login_with_username_and_password() throws InterruptedException {
	
	Thread.sleep(2000);
	//Entering Email ID
	driver.findElement(By.xpath("//input[@name='identifier']")).sendKeys("shireeshamettupally");
	Thread.sleep(2000);
	//Clicking on Next
   driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
   Thread.sleep(2000);
   //Entering password
   driver.findElement(By.xpath("//input[@name='password']")).sendKeys("*******");
   
	
}
@When("User sends email to other email with Suject and body")
public void user_sends_email_to_other_email_with_suject_and_body() throws InterruptedException {
	
	Thread.sleep(3000);
	driver.findElement(By.xpath("//div[contains(text(),'Compose')]")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//input[@peoplekit-id='BbVjBd']")).sendKeys("*******@gmail.com");
	Thread.sleep(2000);
	driver.findElement(By.name("subjectbox")).sendKeys("Incubyte");
	Thread.sleep(1000);
	driver.findElement(By.xpath("//div[@class='Am Al editable LW-avf tS-tW']")).sendKeys("Automation QA for Incubytes");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//div[@data-tooltip='Send ‪(Ctrl-Enter)‬']")).click();
	
	System.out.println("Inside Steps-User sends email to other email with Suject and body");
   
}
@Then("email appears in the sent folder of gmail with subject and Body")
public void email_appears_in_the_sent_folder_of_gmail_with_subject_and_body() throws InterruptedException {
   
	Thread.sleep(2000);
	driver.findElement(By.xpath("//div[@class='TN bzz aHS-bnu']")).click();
System.out.println("Inside Steps-email appears in the sent folder of gmail with subject and Body");
}

}