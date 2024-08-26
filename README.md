# LibraryApp Integration Testing (Mockito)
![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![JUnit](https://img.shields.io/badge/JUnit-25A162?style=for-the-badge&logo=junit5&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)
![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)
[![Mockito](https://img.shields.io/badge/Mockito-5.12.0-brightgreen)](https://github.com/mockito/mockito)
![Issues](https://img.shields.io/github/issues/sancakerkan/LibraryApp-IntegrationTesting)
![License: MIT](https://img.shields.io/badge/License-MIT-blue.svg)

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Installation](#installation)
- [Usage](#usage)
- [Testing](#testing)
- [Call-Graph](#call-graph)
- [Contributing](#contributing)
- [License](#license)
- [Acknowledgements](#acknowledgements)

## Introduction

This repository contains integration tests for the LibraryApp, a Java-based application designed to manage library operations. The tests focus on verifying the interaction between various classes in the application, using Mockito for mocking dependencies.

## Features

- **Book Management:** Perform operations such as searching, checking out, and submitting books.
- **Integration Testing:** Comprehensive tests for interactions between the `LibraryApp` and `BookRepository` classes using JUnit and Mockito.

## Installation

### Prerequisites

- Java Development Kit (JDK) 8 or later
- An IDE with Maven support (IntelliJ IDEA, Eclipse, etc.)

### Cloning the Repository

1. **Using IntelliJ IDEA:** 
    - Go to `File` > `New` > `Project from Version Control`.
    - Enter the repository URL: `https://github.com/sancakerkan/LibraryApp-IntegrationTesting.git`.
    - Click `Clone`.

2. **Using Eclipse:**
    - Go to `File` > `Import...`.
    - Select `Git` > `Projects from Git` > `Clone URI`.
    - Enter the repository URL: `https://github.com/sancakerkan/LibraryApp-IntegrationTesting.git`.
    - Follow the prompts to complete the cloning process.
  
3. **OR Simply Download the ZIP file**
    - [ZIP File](https://github.com/sancakerkan/LibraryApp-IntegrationTesting/archive/refs/heads/main.zip)

## Usage

### Running the LibraryApp

1. **Using IntelliJ IDEA:**
    - Open the project.
    - Navigate to `src/main/java/Main.java`.
    - Right-click `Main.java` and select `Run .

2. **Using Eclipse:**
    - Open the project.
    - Navigate to `src/main/java/Main.java`.
    - Right-click `Main.java` and select `Run As` > `Java Application`.

## Testing

### Running Test Class

You can run individual test classes, particularly those testing integration scenarios:

1. **Using IntelliJ IDEA:**
    - Navigate to the specific test class (e.g., `LibraryAppTest.java`).
    - Right-click the class and select `Run 'LibraryAppTest'`.

2. **Using Eclipse:**
    - Navigate to the specific test class (e.g., `LibraryAppTest.java`).
    - Right-click the class and select `Run As` > `JUnit Test`.

 ### Test Structure
- `LibraryAppTest`: Tests the integration between `LibraryApp` and `BookRepository`, covering cases like book search, checkout, and submission.

## Call-Graph
<img src="https://github.com/sancakerkan/LibraryApp-IntegrationTesting/blob/44e9dbf56d60de05d2bb614f1777a62e93c538b7/.idea/callgraph.png" alt="Call Graph" width="500"/>

## Contributing

Contributions are welcome! If you have any suggestions or improvements, feel free to open an issue or submit a pull request.

1. Fork the repository
2. Create your feature branch 
3. Commit your changes 
4. Push to the branch 
5. Open a pull request

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for more details.

## Acknowledgements
- **Special thanks to the creators of Mockito and JUnit for providing the testing frameworks used in this project.**
