Feature: Omayo Page 1

Scenario: Multiple select option
Given User navigate to provided url
When User select a dropdown from given multiple selector


Scenario: Selecting dropdown using selector
Given User navigate to provided url
When User select a dropdown using select method


Scenario: Text box with preloaded text
Given User navigate to provided url
Then User clears the data present in the text box
And  Add text Using JavascriptExecutor

Scenario: User navigate to new window
Given User navigate to provided url
When User click on the link 
Then User navigate to new window 

Scenario: Handle enable button
Given User navigate to provided url
Then User handle enbale button

Scenario: Handle disable button
Given User navigate to provided url
Then User handle disable button

Scenario: Handle disabled text box
Given User navigate to provided url
Then User handle disabled box


Scenario: Handle button with same attribute
Given User navigate to provided url
Then User handle submit button
Then User handle Login button
And User handle Register button

