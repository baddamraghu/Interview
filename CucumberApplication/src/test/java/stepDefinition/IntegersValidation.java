package stepDefinition;
import io.cucumber.java.en.Given;

public class IntegersValidation {
	
	private void validateGiven(int n){
		
		
		if(n>0&&n<20) {
			System.out.println("Given number is valid" +n);
		}
			else {
				System.out.println("Given number is notvalid" +n);
				
			}
			
		}
	

    @Given("^Validate given Number is an integer$")
    public void validate_given_number_is_an_integer() throws Throwable {
        int n=10;
    validateGiven(n);
	    }

 }
	
	 

	


