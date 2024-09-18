# SocialTest

SocialTest is an automated testing project designed for a social media web application where users can post content with descriptions. This project leverages automation tools to ensure that the core functionalities of posting, editing, and interacting with content are working as expected.
Table of Contents

  - Project Overview
  - Technologies Used
  - Installation
  - Test Structure
  - Running the Tests

Project Overview:

System under test name: String
1. **System Under Test Repository:**
    ```bash
    git clone https://github.com/CodecoolGlobal/el-proyecte-grande-sprint-1-java-keszegroland
    ```

SocialTest automates the testing of key functionalities in a social media platform, such as:

   - Posting content with a description
   - Editing and deleting posts
   - Validating the appearance and order of posts
   - Ensuring proper behavior when interacting with posts

The goal of this project is to provide a scalable and maintainable test suite for regression testing and to continuously verify that the platform works as expected after any code changes.
Technologies Used

  - Java – The programming language used to implement the automation tests.
  - Selenium/WebDriver – Used for browser automation.
  - JUnit – Test framework for organizing and running tests.
  - Maven – Build automation tool to manage dependencies and execute tests.
  - Page Object Model (POM) – Design pattern used to create reusable and maintainable test components.

Installation

  Clone the repository:

2. **Clone the repository:**
    ```bash
    git clone https://github.com/attis82/SocialTest
    cd socialtest
    ```
3. **Install dependencies:**
    ```bash
    mvn clean install
    ```
Configure your browser driver (e.g., ChromeDriver) for Selenium:
      Download the appropriate driver for your browser from Selenium.
      Place the driver in your system's PATH or specify its location in the test setup.

Test Structure

The tests are organized using the Page Object Model (POM) to ensure that UI elements and interactions are separated from the test logic. This structure helps in maintaining and scaling the test suite.

Pages: Contains page object classes representing different pages/screens of the social media platform.
Tests: Contains test classes that perform various actions and assertions on the platform's features.


Running the Tests

To execute the test suite, you can use one of the following commands:

Maven:

4. **Run tests:**
    ```bash
    mvn test
    ```


You can also run individual test classes or methods if needed.
Contributing

Contributions are welcome! If you'd like to contribute to this project, feel free to submit a pull request or open an issue. Please follow the existing coding style and ensure that all tests pass before submitting your PR.
License

