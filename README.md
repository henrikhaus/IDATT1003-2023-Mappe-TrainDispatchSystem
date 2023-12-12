# Portfolio project IDATA1003 - 2023
This file uses Mark Down syntax. For more information see [here](https://www.markdownguide.org/basic-syntax/).

STUDENT NAME = "Henrik Utistog Hausberg"  
STUDENT ID = "111774"

## Project description

This project is a solution to the final project of the subject IDATT1004 (Programmering 1) at NTNU.

It is a simple program that handles a system for managing train departures. 
With a simple command line interface, the user can perform a series of operations like viewing,
adding, removing, and editing train departures.

[//]: # (TODO: Write a short description of your project/product here.)

## Project structure

[//]: # (TODO: Describe the structure of your project here. How have you used packages in your structure. Where are all sourcefiles stored. Where are all JUnit-test classes stored. etc.)
The project is structured as follows:
```bash
README.md
src
├───main
│   └───java
│       └───edu
│           └───ntnu
│               └───stud
│                   ├───commands
│                   ├───constants
│                   ├───input
│                   ├───models
│                   └───utils
└───test
    └───java
        └───edu
            └───ntnu
                └───stud
                    └───models
```
## Link to repository

[//]: # (TODO: Include a link to your repository here.)

## How to run the project

[//]: # (TODO: Describe how to run your project here. What is the main class? What is the main method?
What is the input and output of the program? What is the expected behaviour of the program?)
The project is run from the Main class "TrainDispatchApp.java" located in the package 
"edu.ntnu.stud".
Alternatively, the project can be run using the compiled jar file found here:
"out/artifacts/TrainDispatchSystem.jar", located in the root folder.

The system is entirely command line-based, and the user is presented with a menu of commands
in the terminal when the program is run.

To use the project, the user simply chooses one of the commands
listed in the menu by typing the corresponding number or name in the console and pressing enter.
Then the user follows the instructions given by the program.

## How to run the tests

[//]: # (TODO: Describe how to run the tests here.)

To run the tests, the user can run the JUnit test classes "TrainDepartureTest.java"
and "TrainDepartureManagerTest" located in the package "test.java.edu.ntnu.stud.models".