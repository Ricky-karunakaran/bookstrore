Requirement:
1. JDK 17 or later (https://www.oracle.com/java/technologies/downloads/#jdk17-windows)
2. localhost mysql database active and created database bookstore 
	or 
   modify file src/main/resource/application.properties 

How to run:
1. In project directory, use command './mvnw spring-boot:run ' to run
2. Building will fail if database connection fail as we use autowiring.