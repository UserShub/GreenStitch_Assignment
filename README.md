
# Steps to Run the Project

Make sure Java version 17 or above is installed in order to run this spring boot application.

## Getting Started

1. **Clone the Repository:**

   ```bash
   git clone https://github.com/UserShub/GreenStitch_Assignment.git

2. **Open the Porject Folder in some IDE**
   ```bash
   cd GreenStitch_Assignment

3. **Build the project**
   ```bash
   mvn clean install

4. **Run the server**
   ```bash
   mvn spring-boot:run

5. **Access the application**
    
    The Spring Boot server will be accessible at http://localhost:8080. You can test the endpoints or integrate this server with your front-end or other services.

## Authentication Token and APIs

1) Use some API tester tool like Postman to check the api endpoints and messages.

2) Only the register(http://localhost:8080/api/v1/register-user) and login(http://localhost:8080/api/v1/login) APIs are permitted directly to anyone. The Hello API can only be used when the user is authenticated.

3) Add the token in Authorization part of the Postman with the field "Bearer Token" after login is successful.

4) Finally, test the endpoint http://localhost:8080/api/v1/hello 

**Register (Sample) and Login (Sample)** 
```bash
    Register :
    {
        "name" : "Shubhankar",
        "email" : "admin1@gmail.com",
        "password" : "12345678",
        "role" : "ADMIN"
    }


    Login :
    {
        "email" : "admin1@gmail.com",
        "password" : "12345678"
    }
