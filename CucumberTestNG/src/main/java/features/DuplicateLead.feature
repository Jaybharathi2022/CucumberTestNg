Feature: Duplicate Lead Functionality

@Regression
Scenario Outline: Positive flow for Duplicate Lead

Given Enter username as <username>
And Enter password as <password>
When Click on Login button 
Then HomePage should be displayed
When Click on 'CRM/SFA' link
Then 'My Home' Page should be displayed
When Click on 'Leads' link
Then 'My Leads' Page should be displayed
When Click on 'Find Leads' link
Then 'Find Leads' Page should be displayed
When Click on Email
Then Email field should be displayed
When Enter email as <email>
And Click on 'Find Leads' button
Then Lead List should be displayed
When Click on first lead
Then 'View Lead' Page should be displayed
And Capture the name of the lead
When Click on 'Duplicate Lead' link
Then 'Duplicate Lead' Page should be displayed
When Click on Create Lead button
Then 'View Lead' Page should be displayed
And Verify duplicated lead




Examples:

|username|password|email|
|'DemoSalesManager'|'crmsfa'|'s'|