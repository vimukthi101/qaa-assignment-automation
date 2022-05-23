# qaa-assignment-automation
Automation assignment for Book Store

Test Design Specification : test-design/TestDesignSpecification-BookStoreApplication.pdf

Mind map : test-design/qaa-assignment-mindMap-V1.0.xmind

E2E Test cases, Issues, API matrix can be found from : https://docs.google.com/spreadsheets/d/1uUc4vpeM3et-SzRT9VK9H_6BUGP1CNYRSQtiHN7Tiyk/edit 

Postman + Newman Scripts for API : postman-scripts/BookStore-QaaAssignment.postman_collection.json 

How to Run

newman run postman-scripts/BookStore-QaaAssignment.postman_collection.json 

RestAssured API Scripts : com.qa.tests.api

Selenium UI Scripts : com.qa.tests.ui

How To Run

Run testng.xml
Generate Allure Report, run following command on terminal
  allure serve allure-results
