package stepDefinition;


import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.TextContent;

public class HyperLinkvalidation {
	WebDriver driver;
	List<String>list;
	int totalUniqueLinks;
	int totalLinks;
	TextContent textContent;
	public Set<String> local_links =  new HashSet<String>();
	
	public HyperLinkvalidation(TextContent  textContent) {
		this.textContent=textContent;
	}
	
	
	// Retrieving all the hyperlinks recursively upto 2 cycles 
	
    
	public void RetrievedUrl(int n, String url) {
		
		
   if(n<2 ) {
		
   int j=0;
	 while(j<1)
		  {
			try { 
			  //Open the wiki home page
		        driver.get(url);
		        List<WebElement> links =  driver.findElements(By.tagName("a"));
		        
		        totalLinks=totalLinks+links.size();
		        //Store all the links of that page
                Set<WebElement> uniqueLinks = new HashSet<WebElement>(links);
                //Counting the total unique Links
                totalUniqueLinks=totalUniqueLinks+links.size();
	           // System.out.println("links in page1 " + links.size());

	              for (WebElement u : uniqueLinks ) {
	          
	                String hyperLink=u.getAttribute("href");
	                System.out.println("Link" +hyperLink);
		                if(hyperLink!=null) {
		
		                     if(hyperLink.contains("Wiki")) {
			 
			                     local_links.add(hyperLink);// adding all the wiki links into the set
	                              RetrievedUrl(n+1,hyperLink);
	                                      }
		                             }
	                }
			 }
	 
		        
		    catch(StaleElementReferenceException e) {
		        	e.printStackTrace();
		        	break;
		                }
		        j++;
		    }
		  
		  
		}
		}
		  
	   // Finding all thelinks and printing them in the Console and store them in a set
     @When("^Store them in a datastructure$")
     public void store_them_in_a_datastructure() throws Throwable {
         
     String url1="https://www.wikipedia.org/";
		 int n=0;
			             RetrievedUrl(n,url1);
			           
	             }
	        
	// printing all the links count
     @Then("^Print the count of total links$")
     public void print_the_count_of_total_links() throws Throwable {
      
    	 //System.out.println("No of wikipedia links are "+local_links.size() );
	        System.out.println("Total links are "+totalLinks);
	        System.out.println("Total  uniquelinks are "+totalUniqueLinks);
		   
	        
	        
	      driver.quit();
	    	
	   }
}



