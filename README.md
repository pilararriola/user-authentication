User authentication - Backend
===

Server side application for user authentication.
REST API.
* Programming language: Java
* Frameworks: Spring, Spring-boot
* Database: h2
* Java version: 1.8

### Contact

* [Maria Del Pilar Arriola](https://github.com/pilararriola) : [pilararriola1@gmail.com](mailto:{pilararriola1@gmail.com})

### Description

This app contains two services:
- /authenticate: Authenticate a user via POST. Receives a username and a password and returns the user id when the validation is correct or an error when it is not.
- /users/{id}: Get user information via GET. It returns personal information of the user which id matches with the user id is passed as a path variable.

### Persistence

The database included in this project is h2 (embedded db) because it is portable and easy to use.
Two users are inserted to it every time the app starts:
- username: pilararriola, password: 123456
- username: demouser, password: myPassword123

### Execution
- 1- To build this app run this maven command in the root directory of the project: mvn clean install. The 'target' folder will be created.
- 2- Run with java the executable file: user-authentication-0.0.1.jar (located within 'target').
