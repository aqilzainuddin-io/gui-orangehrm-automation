# OrangeHRM Automation Framework

This project contains an automation framework for **OrangeHRM** web application using **Selenium WebDriver** and **TestNG**. The framework is designed with the **Page Object Model (POM)** pattern for maintainability and scalability.

---

## Project Structure
```text
src/
├── main/
│   └── java/
│       └── com/
│           └── orangehrm/
│               ├── pages/        
│               │   ├── dashboard/
│               │   │   └── DashboardPage.java
│               │   ├── login/
│               │   │   └── LoginPage.java
│               │   └── pim/
│               │       ├── AddEmpPage.java
│               │       ├── EditEmpPage.java
│               │       ├── PIMPage.java
│               │       └── BasePage.java
│               └── setup/
│                   ├── DriverFactory.java
│                   └── EnvReader.java
└── test/
    └── java/
        └── com/
            └── orangehrm/
                ├── setup/
                │   └── BaseTest.java
                └── tests/
                    ├── Dashboard/
                    │   └── DashboardTest.java
                    ├── Login/
                    │   └── LoginTest.java
                    └── PIM/
                        ├── AddEmpTest.java
                        ├── DeleteEmpTest.java
                        ├── EditEmpTest.java
                        └── SearchEmpTest.java
```

---

## Technologies
- Java 17+
- Selenium WebDriver
- TestNG
- Maven
- ChromeDriver
- dotenv-java (for environment variables)

---

## Setup

1. **Clone the repository**
```bash
git clone <repo_url>
```

2. **Install dependencies**
```bash
mvn clean install
```

3. **Set environment variables in .env file**
```text
BASE_URL=https://opensource-demo.orangehrmlive.com
VALID_USERNAME=Admin
VALID_PASSWORD=admin123
INVALID_USERNAME=test
INVALID_PASSWORD=test123
HEADLESS=false
```

4. **ChromeDriver please use the same as your Chrome version**

---

## Running Tests

1. **Run all tests via Maven**
```bash
mvn clean test
```

2. **Run specific TestNG test suite**
```bash
mvn test -DsuiteXmlFile=testng.xml
```

---

## Test Cases Covered

1. **Login**
```text
[x] Empty username and/or password
[x] Invalid credentials
[x] Valid login
```

2. **Dashboard**
```text
[x] Verify dashboard header and title
[x] Check visibility of widgets
[x] Verify navigation links
```

3. **PIM**
```text
[x] Add Employee
[x] Edit Employee
[x] Delete Employee
[x] Search Employee by ID, Name, or both
```

---

## Notes
```text
- The framework uses Page Object Model to separate page locators and actions.
- DriverFactory handles WebDriver initialization.
- EnvReader loads environment variables from .env file.
- Test classes extend BaseTest for setup and teardown.
- All test assertions use TestNG assertions.
- Locators use XPath for simplicity; consider switching to more robust locators if app changes.
```