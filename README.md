# CODE_ANTICHEAT
Project version 1.0

To start use this repo you should have already installed Java 21 version (21.0.2 for example), Gradle 8.11.1, JavaFX 21.0.2.

As default location useful file&directory i specify disk E:\\, but you can also change location of JavaDataBase directory and text.txt in public methods: getPathToFile() & getPathToDB(). 

You can use EXAMPLE.txt to check programm. (Test.txt is WORKING FILE, not for example!)

To open JAR file from shell use command with FX parametres. 

For example: java --module-path /path/to/javafx-sdk-21.0.2/lib --add-modules javafx.controls,javafx.fxml,javafx.web -jar build/libs/your-project-1.0-SNAPSHOT.jar

Also, you can find JavaDoc files in appropriate directory.

To build project use Gradle commands in IDEA.

For example: ./gradlew clean build

Author: Sabirullov Bulat
