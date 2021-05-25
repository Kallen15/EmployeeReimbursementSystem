# Employee Reimbursement System

## Project Description


## Technologies Used

* Java 8
* HTML 
* CSS
* Bootstrap
* JavaScript
* AWS RDS with PostgreSQL

> Maven Dependencies
* Apache Tomcat 8.5
* Jackson 2.12.3
* Jackson Datatoye JSR310 2.12.3
* Java Servlet 4.0.1
* JUnit 3.7.7
* Mockito 4.11
* Tomcat Catalina 8.5
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
* Launch application to the web using AWS.

## Getting Started
   
(include git clone command)
(include all environment setup steps)

> Be sure to include BOTH Windows and Unix command  
> Be sure to mention if the commands only work on a specific platform (eg. AWS, GCP)

- All the `code` required to get started
- Images of what it should look like

## Usage

> After Instatlling this application, be sure to have the dependencies listed in Maven Dependencies of Technologies Used installed in a pom.xml file.
> Tomcat can be finicky, so an embedded installation into Eclipse is recommended. 
> There is a database schema script called ERS_Script included in this Repository. This can be used to instantiate the database tables used in this application.
> The ERSConnection.java class defined in the src/main/java/com/revature/util folder requires some environment variables to be set: aws_password, aws_username, aws_url. These will have to be setup for the database connection to work.
> At this point the application should be ready to be launched on Tomcat on port 8080 of localhost.
> The app will launch at http://localhost:8080.
> On the homepage the option to either register or login is available.
> After going through either portal a user will either be shown an Employee page or an Manager page.
> Click the buttons that are on the respective pages to execute the desired functionality.
> When a user logs out their session will be invalidated and the information associated with them will no longer be accessible unless they log back in.
