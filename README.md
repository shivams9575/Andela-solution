# 🕒 British Spoken Time Converter (Spring Boot Project)

A Spring Boot application that converts 24-hour time format (HH:mm) into British spoken time.

## Examples
| Input | Output |
|--------|---------|
| `07:30` | half past seven |
| `10:45` | quarter to eleven |
| `00:00` | midnight |
| `12:00` | noon |

---

## ⚙️ Requirements
- Java 17+
- Maven or mvnd (Maven Daemon)
- Internet connection (for dependency downloads)

---

## Build Instructions

#### Build using mvnd
```bash
mvnd clean install
```
---

#### 🚀 Run the Application
To start the Spring Boot application:
```bash
mvnd spring-boot:run
```

#### Sample POST Request
```bash
http://localhost:8080/api/v1//britishSpokenTime

Request Body:
{
"time": "07:30",
"locale": "british"
}
```

#### Response
```bash
half past seven
```

### 🧪 Running Tests and Code Checks
#### Run Unit and Integration Tests
```bash
mvnd test
```

### Generate JaCoCo Code Coverage Report
```bash
mvnd jacoco:report

➡️ Report generated at:
target/site/jacoco/index.html
```
### Run Checkstyle Validation
```bash
mvnd checkstyle:checkstyle
```

## ⚙️ Continuous Integration (CI/CD)

### This project uses GitHub Actions for automated CI pipelines that include:
```bash
✅ Code compilation
✅ Unit & integration tests
✅ JaCoCo test coverage
✅ Checkstyle validation
✅ SonarCloud static code analysis
```

### Workflow Details :-
```bash

Triggered automatically on every push and pull request.
Fails the build if:
❌ Code coverage is below 95%
❌ Any Sonar quality gate fails
❌ Checkstyle rules are violated
```

## 📊 Code Quality Dashboard (SonarCloud)
### Public Dashboard:
```bash
https://sonarcloud.io/summary/new_code?id=shivams9575_British-Spoken-Time-Project
```
## 🧠 Design Highlights
```bash
✅ Follows SOLID principles
✅ Implements Strategy Pattern for locale-based time formatting
✅ Clear layered architecture: Controller → Service → Formatter
✅ Proper exception handling and structured logging using SLF4J
✅ Includes unit + integration tests
✅ Integrated SonarCloud, JaCoCo, and Checkstyle
```

## Folder Structure
```bash
src/
 └── main/
      └── java/
           └── com/andela/british_time_in_words/
                ├── controller/       # REST Controller
                ├── service/          # Time conversion service
                ├── factory/          # Formatter factory (Strategy pattern)
                ├── formatter/        # Locale-based formatters
 └── test/
      └── java/                      # Unit & integration tests
```

## Developer Tools
```bash
| Tool               | Purpose                         | Configuration                      |
| ------------------ | ------------------------------- | ---------------------------------- |
| JaCoCo             | Measures code coverage          | `pom.xml`                          |
| Checkstyle         | Enforces code quality standards | `config/checkstyle/checkstyle.xml` |
| SonarCloud         | Static analysis & code quality  | `.github/workflows/ci.yml`         |
| GitHub Actions     | CI/CD automation                | `.github/workflows/ci.yml`         |
```

## 👤 Author
```bash

Shivam Sharma
Senior Software Engineer
📧 GitHub Profile:- https://github.com/shivams9575
```