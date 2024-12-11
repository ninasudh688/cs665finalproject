
| CS-665       | Software Design & Patterns |
|--------------|----------------------------|
| Name         | NINA SUDHEESH              |
| Date         | 12/3/2024                  |
| Course       | Fall                       |
| Assignment # | final project              |

# Assignment Overview
THe goal of the assignment is to create an idea and use class design apttern and junits 
and one new design pattern.
# GitHub Repository Link:
https://github.com/ninasudh688/cs665finalproject
# Implementation Description 


For each assignment, please answer the following:

- Explain the level of flexibility in your implementation, including how new object types can
be easily added or removed in the future.
- Discuss the simplicity and understandability of your implementation, ensuring that it is
easy for others to read and maintain.
- Describe how you have avoided duplicated code and why it is important.
- If applicable, mention any design patterns you have used and explain why they were
chosen.

- The implementation has been kept simple and easy to understand by organizing the code.
  - The state and command interface helps to organize the code logically, ensuring a clean
    separation of concerns.
  - This decoupling makes the system flexible and easy to extend, as new features 
can be added without disrupting existing functionality.
  - - Each class serves a distinct job making it easy for others to read and maintain.
  - This separation of the classes' roles helps make the code more readable.
  - Also, all the code is documented with doc-blocks that explain each method/class's purpose.


CLasses I used:
- I chose builder pattern  
  - The Builder pattern centralizes the logic for creating pet objects, so there is no need to duplicate
    construction logic across multiple places in the code. 
  - By using the Builder, we avoid bloated mutiple long constructors  and ensure that
    consistent object creation is done in a modular and clean manner,making it  DRY.
- Here is how I set up the classes:.
  - Pet.js: Model of  name, type, age, energy level, state). 
    - The builder pattern simplifies its creation without requiring numerous constructors.
  - PetBuilder.js (interface Builder):
    -  Declares the methods for setting each attribute of a Pet object (e.g., setPetName, setPetType).
  - StandardPetBuilder.js (Concrete Builder):
    - Implements the methods from PetBuilder to assemble a standard pet.
  - PetDirector.js = builderDirector:
    - Oversees the construction process and ensures all necessary steps are executed in the right order. 
  - Adding new attributes (e.g., color, size) or pet types requires minimal changes which makes it easier to maintain. 
  - The design pattern allows the system to handle future variations of pets or attributes without
  - modifying the core logic. Developers can create variations like ExoticPetBuilder or 
  SeaPet without altering the existing builder logic. 
   - In all it makes the code more readable and flexible.
 

- I chose Command pattern  
  - Command Pattern: Decouples actions, making it flexible and enabling the reuse of commands. 
    - It allows for change in one place so that so if the behavior of the pet or commands needs to change, 
only the relevant command classes or the state handling logic needs to be updated, without requiring changes 
in the Pet class or the Invoker. This prevents duplication which makes the system easier to maintain.
    - The design pattern allows adding new actions like TrainCommand, PlayWithToyCommand without modifying the existing 
code, since you just need to create new concrete command classes. It also enables easily incorporating features 
like undo/redo for actions,
- Here is how I set up the classes:.
  - Command.js (CommandInterface):
    - Declares the execute and undo method that all commands implement.
  - Concrete Commands:
    - FeedCommand.js,PlayCommand.js,WalkCommand.js,HealCommand.js,SLeepCommand.js: 
       - They implement state-specific actions that change the pet's state or attributes. 
      - Each command performs a different task (e.g., feeding increases energy, playing changes mood) 
  and delegates to the pet’s current state.
  - PetActionInvoker.js = Invoker:
    - Executes commands on pets and allows for future features like undo or redo command.
  - Pet.js is receiver in the command pattern but 
    - also the Holds a reference to its current State object, delegating behavior to it.
 
- I chose State pattern  
  - The State pattern allows the Pet object to change its behavior based on its current state.
    If you have state-speciific behaviors in separate classes, you avoid using complex if else conditionals 
in the Pet class.
   - Each state class implements specific behaviors like feeding, playing, or healing, 
ensuring that the pet’s actions are dynamically altered depending on its current state. 
   - The state object can be changed to reflect changes in the pet’s condition 
     - Ex: transitioning from HappyState to TiredState when the pet is overexerted after walk
   - This makes it easy to update pet’s behavior as its state changes and maintain it.
  -This pattern allows for easy additions of new states (e.g., HyperactiveState) in the future without 
messing up the existing code. 
   - Here is how I set up the classes:
    - State.js (Interface):
      - Declares methods for state-specific behaviors, such as heal, play, or feed.
    - The Pet.js class holds a reference to its current state, delegating behavior to that state.
    - Concrete States:
      - HappyState.js: Defines state behaviors when the pet is happy
      - TiredState.js: defines state behaviors when the pet is tired
      - HungerState.js: Defines state behaviors when the pet is hungry
      - ActiveState.js: defines stare behaviors when the pet is ready to exercise or walk 
      - BoredomState.js defines state behaviors when pet is bored/wants to do soemthing
      - SickState.js deines state behaviors when pet is not feeling well

# Running My Code And UML:

- I placed my UML diagram in cs665_finalproject_UMLDiagram_Sudheesh.PDF within this zipped folder
- I placed my code in package virtualpetsimulator under the edu.bu.met.cs665 package.
- The Main class is outside this package - Its acting as the Client class in Adapter pattern.
- I tested my code using junit tests by using a JUnit test class TestPetSimulator in the test package.
- The code compiles using mvn clean compile.

# Maven Commands

We'll use Apache Maven to compile and run this project. You'll need to install Apache Maven (https://maven.apache.org/) on your system. 

Apache Maven is a build automation tool and a project management tool for Java-based projects. Maven provides a standardized way to build, package, and deploy Java applications.

Maven uses a Project Object Model (POM) file to manage the build process and its dependencies. The POM file contains information about the project, such as its dependencies, the build configuration, and the plugins used for building and packaging the project.

Maven provides a centralized repository for storing and accessing dependencies, which makes it easier to manage the dependencies of a project. It also provides a standardized way to build and deploy projects, which helps to ensure that builds are consistent and repeatable.

Maven also integrates with other development tools, such as IDEs and continuous integration systems, making it easier to use as part of a development workflow.

Maven provides a large number of plugins for various tasks, such as compiling code, running tests, generating reports, and creating JAR files. This makes it a versatile tool that can be used for many different types of Java projects.

## Compile
Type on the command line: 

```bash
mvn clean compile
```



## JUnit Tests
JUnit is a popular testing framework for Java. JUnit tests are automated tests that are written to verify that the behavior of a piece of code is as expected.

In JUnit, tests are written as methods within a test class. Each test method tests a specific aspect of the code and is annotated with the @Test annotation. JUnit provides a range of assertions that can be used to verify the behavior of the code being tested.

JUnit tests are executed automatically and the results of the tests are reported. This allows developers to quickly and easily check if their code is working as expected, and make any necessary changes to fix any issues that are found.

The use of JUnit tests is an important part of Test-Driven Development (TDD), where tests are written before the code they are testing is written. This helps to ensure that the code is written in a way that is easily testable and that all required functionality is covered by tests.

JUnit tests can be run as part of a continuous integration pipeline, where tests are automatically run every time changes are made to the code. This helps to catch any issues as soon as they are introduced, reducing the need for manual testing and making it easier to ensure that the code is always in a releasable state.

To run, use the following command:
```bash
mvn clean test
```


## Spotbugs 

SpotBugs is a static code analysis tool for Java that detects potential bugs in your code. It is an open-source tool that can be used as a standalone application or integrated into development tools such as Eclipse, IntelliJ, and Gradle.

SpotBugs performs an analysis of the bytecode generated from your Java source code and reports on any potential problems or issues that it finds. This includes things like null pointer exceptions, resource leaks, misused collections, and other common bugs.

The tool uses data flow analysis to examine the behavior of the code and detect issues that might not be immediately obvious from just reading the source code. SpotBugs is able to identify a wide range of issues and can be customized to meet the needs of your specific project.

Using SpotBugs can help to improve the quality and reliability of your code by catching potential bugs early in the development process. This can save time and effort in the long run by reducing the need for debugging and fixing issues later in the development cycle. SpotBugs can also help to ensure that your code is secure by identifying potential security vulnerabilities.

Use the following command:

```bash
mvn spotbugs:gui 
```

For more info see 
https://spotbugs.readthedocs.io/en/latest/maven.html

SpotBugs https://spotbugs.github.io/ is the spiritual successor of FindBugs.


## Checkstyle 

Checkstyle is a development tool for checking Java source code against a set of coding standards. It is an open-source tool that can be integrated into various integrated development environments (IDEs), such as Eclipse and IntelliJ, as well as build tools like Maven and Gradle.

Checkstyle performs static code analysis, which means it examines the source code without executing it, and reports on any issues or violations of the coding standards defined in its configuration. This includes issues like code style, code indentation, naming conventions, code structure, and many others.

By using Checkstyle, developers can ensure that their code adheres to a consistent style and follows best practices, making it easier for other developers to read and maintain. It can also help to identify potential issues before the code is actually run, reducing the risk of runtime errors or unexpected behavior.

Checkstyle is highly configurable and can be customized to fit the needs of your team or organization. It supports a wide range of coding standards and can be integrated with other tools, such as code coverage and automated testing tools, to create a comprehensive and automated software development process.

The following command will generate a report in HTML format that you can open in a web browser. 

```bash
mvn checkstyle:checkstyle
```

The HTML page will be found at the following location:
`target/site/checkstyle.html`




