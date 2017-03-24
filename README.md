# Character-Sheet
Character sheet for D&D 3.5 Edition

## Technologies ##
Currently the Character Sheet project is configured using Spring Boot and the services and components are autowired. The UI itself is coded in the `GUI` classes, and we use the Nimbus flavour of Swing to render the components into something a little more shiny.

## Running the Application ##
Navigate to the root project directory in your favourite terminal. Run

    mvn clean install
    java -jar Character-Sheet-0.0.1-SNAPSHOT.jar jar
    
This will boot the application.

## Getting Setup in IntelliJ ##
Open the Project Structure window to see the settings for the Character-Sheet project. Then select Artifacts from the list on the left. From here, you can select the plus at the top to add a new artifact. Select Jar -> "From modules with dependencies…"

In the new window, set the following information

* Module: Character-Sheet
* Main Class: org.moss.charactersheet.CharacterSheet
* JAR files from libraries: "extract to the target JAR" is selected
* Directory for META-INF: $MODULE_DIR$/src/main/java
* Include tests: should not be selected i.e. set to false

Then open the "Run Configurations…" window and create a new configuration for a JAR Application. Set the following details for the configuration

* Name: CharacterSheet
* Path to JAR: $MODULE_DIR$/target/Character-Sheet-0.0.1-SNAPSHOT.jar
* Working Directory: $MODULE_DIR$
* JRE: 1.8
* Search sources: Character-Sheet

* Before launch:
    * Run MVN Goal: clean install
    * Run MVN Gaol jar:jar
