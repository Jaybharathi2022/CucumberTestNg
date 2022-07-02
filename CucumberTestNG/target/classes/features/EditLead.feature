Feature: Edit Lead Functionality

@Sanity 
Scenario Outline: Positive flow for Edit Lead

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
When Enter firstName as <firstName>
And Click on 'Find Leads' button
Then Lead List should be displayed
When Click on first lead
Then 'View Lead' Page should be displayed
When Click on 'Edit' link
Then 'Edit Lead' edit Page should be displayed
When Clear company name
Then Company name should be cleared
When Update company name to <newCompName>
And Click on update 'Update' button
Then 'View Lead' Page should be displayed
Then Verify <newCompName>  is updated


 Examples:

|username|password|firstName|newCompName|
|'DemoSalesManager'|'crmsfa'|'a'|'TestLeaf'|