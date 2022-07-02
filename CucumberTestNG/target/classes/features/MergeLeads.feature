Feature: Merge Leads Functionality

@Regression @Sanity
Scenario Outline: Positive flow for Merge Leads

Given Enter username as <username>
And Enter password as <password>
When Click on Login button 
Then HomePage should be displayed
When Click on 'CRM/SFA' link
Then 'My Home' Page should be displayed
When Click on 'Leads' link
Then 'My Leads' Page should be displayed
When Click on 'Merge Leads' link
Then 'Merge Leads' Page should be displayed
When Click From lead
Then Find Leads page should open in new window
When Select '1' lead
Then 'Merge Leads' Page should be displayed
When Click To lead
Then Find Leads page should open in new window
When Select '2' lead
Then 'Merge Leads' Page should be displayed
When Click on 'Merge' link
Then Confirmation alert should be displayed
When Click ok in alert
Then 'View Lead' Page should be displayed

 Examples:

|username|password|
|'DemoSalesManager'|'crmsfa'|