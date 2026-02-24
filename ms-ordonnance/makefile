run:
	- ./mvnw clean compile
	- ./mvnw spring-boot:run
micro:
	- ./mvnw clean compile
		./mvnw spring-boot:run -Dspring-boot.run.arguments=--server.port=8081 &
		./mvnw spring-boot:run -Dspring-boot.run.arguments=--server.port=8082 &
		./mvnw spring-boot:run -Dspring-boot.run.arguments=--server.port=8083 &
		./mvnw spring-boot:run -Dspring-boot.run.arguments=--server.port=8084 
