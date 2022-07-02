Feature: Login functionality for leaftaps application 

#Background:
#Given Open the Chrome Browser 
#Given Load application url as 'http://leaftaps.com/opentaps'

@Smoke @Sanity
Scenario Outline: Login with positive credential 


Given Enter username as <username>
And Enter password as <password>
When Click on Login button 
Then HomePage should be displayed 

Examples:

|username|password|
|'DemoSalesManager'|'crmsfa'|
|'DemoCSR'|'crmsfa'|

@Smoke @Sanity
Scenario Outline: Login with negative credential 
 

Given Enter username as <username>
And Enter password as <password>
When Click on Login button 
But Error message should be displayed 

Examples:
|username|password|
|'Demo'|'crmsfa'|
|'CSR'|'crmsfa'|
|'DemoCSR'|'crmsf'|

