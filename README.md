# e-commerce
An E-commerce Platform

**Overview**

This Java-based e-commerce Program is designed to manage online shop's operations. The application provides controllers for managing these entities effectively. We use the H2 database for data storage, ensuring lightweight and efficient database management. The project also includes comprehensive unit and integration tests to ensure the reliability and correctness of the application.

**Features**

Category Controller: Manage category information, including getting, adding, updating, and deleting categories records.

User Controller: Manage user details, including getting, creating, updating, and deleting users.

Order Controller: Manage order data, including getting, creating, updating orders information, and managing enrollments.

Product Controller: Manage product information, including getting, adding, updating and deleting products.

**Requirements**

Java Development Kit (JDK) 21 Maven (for building the project) Setup and Installation

**Clone the Repository:**

`git clone https://github.com/maryammokhtari/e-commerce`

`cd ecommerce`

**Build the Project:**

`mvn clean install`

**Run the Application:**

`java -jar target/ecommerce-0.0.1-SNAPSHOT.jar`

**Swagger:**

You can find the restful Api endpoints in swagger: http://localhost:8080/swagger-ui/index.html#/

**Actuator:**

You can find the actuator endpoints here: http://localhost:8080/actuator/health

**Configuration**

The application uses different configuration files for various environments:

* application.yml: Default configuration.
* application-tst.yml: Testing environment configuration.
* application-prd.yml: Production environment configuration.

**Testing**

Unit Tests

To run unit tests, use the following command:

`mvn test`

Unit tests cover individual components and ensure that each part of the application works as expected in isolation.

Integration Tests

To run integration tests, use the following command:

`mvn integration-test`

Integration tests check how different parts of the application work together, ensuring overall system reliability and correctness.

**Contact**

If you have any questions or feedback, please contact us at maryam.mokhtari.f@gmail.com
