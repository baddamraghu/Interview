Feature: Application login


@positiveTestCase
Scenario Outline: Validating the Wekipedia url
Given Trigger the browser
When enter the url <URL>
Then Home page is populated

Examples:
|URL                      |
|https://wikipedia.org|

@NegativeTestCase
Scenario Outline: Validating the Wekipedia url
Given Trigger the browser
When enter the url <URL>
Then Error message on the console

Examples:
|URL                      |
|https://www.facebook.com/login/|

@hyperLinkValidation
Scenario: Validating wiki hyperlinks and count them
Given Trigger the browser
When Store them in a datastructure
Then Print the count of total links


@NumberValidation
Scenario: Validating Given number
Given Validate given Number is an integer
  