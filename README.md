# Employee Reimbursement System

## Project Description
This is the Employee Reimbursement System Application provided from the Kemo_Allen_P1 Java Application. In this app a user can sign up as either a Employee or Manager, these two types of users will have different functionalities. An employee user has the ability to create and submit a reimbursement. This reimbursement has information on the type of reimbursement, the amount, and a description. The employee can also view the status and the history of their reimbursements.

For a manager, this type of user can approve or deny employee reimbursement requests. A manager can also view the reimbursement history of any of the employees.

## Technologies Used

* Java 8
* HTML 
* CSS
* Bootstrap
* JavaScript
* Apache Tomcat 8.5
* AWS RDS with PostgreSQL

> Maven Dependencies
* Jackson 2.12.3
* Jackson Datatype JSR310 2.12.3
* Java Servlet 4.0.1
* JUnit 3.7.7
* Mockito 4.11
* Tomcat Catalina 9.0.45
* PostgreSQL 42.2.18

## Features

List of features ready and TODOs for future development
* An employee can create and send reimbursements.
* An employee can view their pending and resolved reimbursements.
* An employee can update their profile page.
* A manager can accept or deny a reimbursement.
* A manager can view the reimbursement history of all or a specific employee.

To-do list:
* Add functionality for an employee to upload an image of their receipt.
* An employee can recieve emails about the status of their reimbursements.
* Launch application to the web using AWS.

## Getting Started
   
* git clone https://github.com/Kallen15/EmployeeReimbursementSystem
* Open this application in an IDE like Eclipse or Visual Studio Code. Eclipse was primarily used for this project.
* Create a pom.xml file and import the dependencies listed in Maven Dependencies of  the Technologies Used section.
* Tomcat can be finicky, so an embedded installation into Eclipse is recommended. 
* There is a database schema script called ERS_Script included in this Repository. This can be used to instantiate the database tables used in this application.
* The ERSConnection.java class defined in the src/main/java/com/revature/util folder requires some environment variables to be set: aws_password, aws_username, aws_url. These will have to be setup for the database connection to work.
* At this point the application should be ready to be launched on Tomcat on port 8080 of localhost.
* The app will launch at http://localhost:8080.

## Usage

* On the homepage the option to either register or login is available.
* After going through either portal a user will either be shown an Employee page or an Manager page.
* Click the buttons that are on the respective pages to execute the desired functionality.
* When a user logs out their session will be invalidated and the information associated with them will no longer be accessible unless they log back in.
