# DataHub

DataHub is a full-stack web application that provides functionalities for managing user data. It includes features for user authentication, user management, and searching for users based on different criteria.

## Technologies Used

- **Backend:** Java Spring Boot
- **Frontend:** HTML, CSS, JavaScript
- **Database:** MySQL
- **Security:** Spring Security with JWT authentication

## Getting Started

To run the application locally, follow these steps:

1. Clone this repository to your local machine.
2. Navigate to the `frontend` directory and open the `index.html` file in your web browser to access the login page.
3. Log in with the following credentials:
   - Username: user
   - Password: 0000
4. Once logged in, you can access other functionalities provided by the application.

## Features

- **User Authentication:** Users can log in using their credentials.
- **User Management:** Admin users can add, update, and delete user information.
- **Search Functionality:** Users can search for other users based on different criteria such as city, phone, first name, or email.

## Setup

Make sure you have MySQL installed on your system. Update the `application.properties` file in the backend directory with your MySQL database credentials:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/sunbase?createTableIfNotExists=true
spring.datasource.username=root
spring.datasource.password=_Aniket@123
spring.jpa.hibernate.ddl-auto=update.

##Usage
After setting up the database configuration, run the application. You can access the frontend by opening the index.html file in your web browser and logging in with the provided credentials.


##Contributing
Contributions are welcome! If you'd like to contribute to this project, please fork the repository and create a pull request.

##License
This project is licensed under the MIT License. See the LICENSE file for details.
