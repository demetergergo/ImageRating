# ImageRating

ImageRating is a Spring Boot application designed for rating and managing images. This project includes features such as user authentication, image and post management, and more.

## Features
- User authentication and authorization
- Image upload and rating
- Post creation and management
- RESTful API endpoints

## Project Structure
The project follows a standard Spring Boot structure:
- `src/main/java`: Contains the main application code, organized into packages such as `controller`, `service`, `repository`, and `models`.
- `src/main/resources`: Contains configuration files, static assets, and templates.

## Prerequisites
- Java 17 or later
- Maven 3.8.1 or later
- Docker

## Getting Started

### Running with Docker
1. Clone the repository:
   ```bash
   git clone https://github.com/demetergergo/ImageRating.git
   ```
2. Navigate to the project directory:
   ```bash
   cd ImageRating
   ```
3. Run the Docker container:
   ```bash
   docker-compose up
   ```
   
## API Documentation
The application includes Swagger for API documentation. Once the application is running, you can access the Swagger UI at:
```
http://localhost:8080/swagger-ui/index.html#/
```

## Configuration
Application properties can be configured in `src/main/resources/application.properties` and in the `Dockerfile`

## License
This project is licensed under the MIT License.
