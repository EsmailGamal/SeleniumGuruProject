# 🧪 Guru99 Demo Test Automation Framework

This repository contains an automated testing framework built using **Selenium WebDriver**, **TestNG**, and **Java (Maven)**.  
It follows the **Page Object Model (POM)** design pattern to ensure clean separation between test logic and UI interactions.

---

## 📘 Overview

The goal of this framework is to provide a structured, maintainable, and scalable setup for automating regression and sanity testing of the **Guru99 Telecom demo application**.

The framework supports:
- **POM structure** for better readability and reusability.
- **Data-driven testing** using JSON and properties files.
- **Environment configuration** via `.properties` files.
- **Retry mechanism** for flaky test handling.
- **TestNG annotations & grouping** for flexible test execution.
- **Maven integration** for easy build and run management.

---

## 🏗️ Project Structure

Below is the structure of the project. You can copy this section directly to visualize folder layout:

```bash
demo-project
├── .idea/                          # IDE settings
├── .vscode/                        # VS Code settings
├── pom.xml                         # Maven dependencies and build config
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── config
│   │   │   │   └── ConfigManager.java
│   │   │   ├── core
│   │   │   │   ├── BasePage.java
│   │   │   │   ├── ElementActions.java
│   │   │   │   └── Waits.java
│   │   │   ├── drivers
│   │   │   │   ├── DriverFactory.java
│   │   │   │   └── DriverHolder.java
│   │   │   ├── pages
│   │   │   │   ├── AddCustomerPage.java
│   │   │   │   ├── AddTariffPlanPage.java
│   │   │   │   ├── GuruHomePage.java
│   │   │   │   └── ResultPage.java
│   │   │   └── utilities
│   │   │       ├── models
│   │   │       │   └── CustomerData.java
│   │   │       └── CustomerDataManager.java
│   │   └── resources
│   │       └── config
│   │           ├── config.dev.properties
│   │           ├── config.qa.properties
│   │           └── config.properties
│   └── test
│       ├── java
│       │   ├── support
│       │   │   ├── models
│       │   │   │   └── JsonDataReader.java
│       │   │   ├── RetryAnalyzer.java
│       │   │   ├── TestListeners.java
│       │   │   └── UserInfo.java
│       │   └── testcases
│       │       ├── AddCustomerFlowTest.java
│       │       ├── AddTariffToCustomerFlowTest.java
│       │       └── TestBase.java
│       └── resources
│           ├── info.json
│           └── testng.xml
└── target/                         # Generated reports & build artifacts

⚙️ Setup & Installation
🔧 Prerequisites
Java 17+
Maven 3.9+
Chrome Browser
IDE: IntelliJ IDEA, VS Code, or Eclipse


Steps : 
1- Clone repository git clone https://github.com/EsmailGamal/SeleniumGuruProject.git
2- Install Dependencies => mvn clean install
3- Run All tests => mvn clean test
4- Run Test Sutite From Testng.xml => mvn clean test -DsuiteXmlFile=src/test/resources/testng.xml

