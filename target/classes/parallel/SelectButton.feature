Feature: Select Button function

Scenario: Bootstrap of orderlist
Given User navigate to provided url
Then User select required data and print on console

Scenario: Bootstrap of unorderlist
Given User navigate to provided url
Then User select required data from unorder list

Scenario: Display for time being and disappear
Given User navigate to provided url page
Then User print the text before it disappear
Then User click on disappear button

Scenario: Wait before printing text
Given User navigate to provided url page
Then User wait for the text to be appear 

Scenario: Handle PopUp window
Given User navigate to provided url page
When User click on popup link
Then User will navigate to new popup window

Scenario: Upload a file
Given User navigate to provided url page
Then User upload a file using sendkeys

Scenario: Upload a files
Given User navigate to provided url page
Then user upload a file using robot class

Scenario: Time enbale button
Given User navigate to provided url page
Then User wait for the button to enable to click

Scenario: Make button disable
Given User navigate to provided url page
When  User click on try it butoon to diable the button
Then  User check for the button to be disabled

Scenario: User click on the double button
Given User navigate to provided url page
Then User use action class to double click on a button

Scenario: enable button
Given User navigate to provided url page
Then User will click on check it button 
And User make sure checkbox is enabled



