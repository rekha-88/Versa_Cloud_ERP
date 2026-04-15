# Versa Cloud ERP Automation Framework

## Project Overview
This project is an end-to-end automation framework developed for the Versa Cloud ERP application.

It automates business workflows including:
- Login functionality
- Sales order creation
- Product selection
- Shipment process

## Tech Stack
- Java
- Selenium WebDriver
- Cucumber (BDD)
- TestNG
- Maven

## Framework Design
The framework follows the Page Object Model (POM) design pattern:
- Pages → Contains all page classes
- Steps → Step definitions for Cucumber
- Features → Gherkin feature files
- Hooks → Setup and teardown
- LibraryFiles → Utility and DriverFactory

## Features Implemented
- Explicit waits for dynamic elements
- Screenshot capture on test failure
- Reusable methods and clean structure
- End-to-end workflow automation

## Screenshot Handling
Screenshots are captured automatically on test failure and stored in:
./ScreenShots/
