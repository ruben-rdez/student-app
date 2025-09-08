# Students Management Application

This is a Spring Boot application for managing student information. The application provides a web interface for performing CRUD (Create, Read, Update, Delete) operations on student records.

## Technologies Used

- Java 21
- Spring Boot 3.5.3
- Spring Data JPA
- Spring MVC
- Thymeleaf
- Maven
- HTML/CSS
- Lombok

## Features

- View list of all students
- Add new students
- Edit existing student information
- Delete students
- Student data persistence using JPA

## Prerequisites

- Java Development Kit (JDK) 21 or later
- Maven 3.x
- Your preferred IDE (e.g., Visual Studio Code, IntelliJ IDEA, Eclipse)

## Getting Started

1. Clone the repository:
```bash
git clone [your-repository-url]
cd student-app
```

2. Build the project:
```bash
mvn clean install
```

3. Run the application:
```bash
mvn spring-boot:run
```

The application will be accessible at `http://localhost:8080`

## Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── org/
│   │       └── student/
│   │           └── app/
│   │               ├── controller/
│   │               ├── model/
│   │               ├── repository/
│   │               ├── service/
│   │               └── StudentAppApplication.java
│   └── resources/
│       ├── static/
│       │   └── css/
│       └── templates/
└── test/
    └── java/
```

## API Endpoints

- `GET /students` - Get list of all students
- `GET /students/add` - Display add student form
- `POST /students/add` - Add a new student
- `GET /students/edit/{id}` - Display edit form for a student
- `POST /students/edit/{id}` - Update a student
- `GET /students/delete/{id}` - Delete a student

## Development

This project uses:
- Lombok for reducing boilerplate code
- Spring Data JPA for database operations
- Thymeleaf for server-side templating
- Spring MVC for web layer

## Building for Production

To build the application for production:

```bash
mvn clean package
```

This will create a JAR file in the `target` directory.

## Running the Tests

```bash
mvn test
```

## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License

[Add your license here]

## Contact

[Add your contact information here]
