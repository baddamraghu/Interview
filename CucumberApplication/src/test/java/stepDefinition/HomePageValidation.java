package stepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.TextContent;




public class HomePageValidation {
	
	WebDriver driver;
    public TextContent textContent;
	
	public HomePageValidation( TextContent textContent) {
		this.textContent= textContent;
	}
	@Given("^Trigger the browser$")
    public void trigger_the_browser() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "\\CucumberApplication\\Drivers\\ChromeDriver\\chromedriver.exe");
		
    	 textContent.driver= new ChromeDriver();
    	 
	    }

    @When("^enter the url (.+)$")
    public  void enter_the_url(String url) throws Throwable {
    
    if(url.contains("wikipedia")) {
    	
			 textContent.driver.get(url);
			 textContent.driver.manage().window().maximize();
			
			 
    }
		 else
		 {
			 
			return; 
		 }
    }

    @Then("^Home page is populated$")
    public void home_page_is_populated() throws Throwable {
        System.out.println("Landing on the WIKI home page");
    }

   
    @Then("^Error message on the console$")
    public void error_message_on_the_console() throws Throwable {
    	System.out.println("not a valid link");
        
    }
	
}
	    

	
	 