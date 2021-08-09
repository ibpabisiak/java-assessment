## Java Assessment task
The Java web application written in Java/SpringBoot and Thymeleaf

### Requirements
- Java 11

### How to run the application
- Open command line and go to the project root directory
- Build the application using following command for Unix: `./gradlew build`, for Windows: `gradlew.bat build` 
- Use following command to run the application `java -jar ./build/libs/BooksWebApp-0.0.1-SNAPSHOT.jar`
- Open your web browser and open the `http://localhost:8080`

### H2 Database
The application uses H2 embedded database. 
Database is created automatically in `data` folder.
You can open the administration panel in your web browser on `http://localhost:8080/h2`.
Username and password are stored in `/src/main/resources/application.yml`. 
Default username is `admin` and password is `admin`.

### Author
Bartlomiej Pabisiak <bartlomiej.pabisiak@gmail.com>

