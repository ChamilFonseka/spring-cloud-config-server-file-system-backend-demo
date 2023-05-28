# Spring Cloud Config Server - File System Backend

1. **Create a new Spring Boot project**: Create a new Spring Boot project with the Config Server dependency.

2. **Annotate @EnableConfigServer**: Spring Cloud Config Server provides an HTTP resource-based API for external configuration (name-value pairs or equivalent YAML content). The server is embeddable in a Spring Boot application, by using the @EnableConfigServer annotation. Consequently, the following application is a config server:

	```java
	@SpringBootApplication
	@EnableConfigServer
	public class ConfigServer {
	  public static void main(String[] args) {
		SpringApplication.run(ConfigServer.class, args);
	  }
	}
	```

3. **Configure the application properties**: Open the `application.properties` (or `application.yml`) file and add the following properties:

   ```properties
	spring.application.name=config-server
	server.port=8191
	spring.profiles.active=native
	#Commented below property because I have added configuration files in a default location (resources/config)
	#spring.cloud.config.server.native.searchLocations=file:///${user.home}/config-repo
   ```
   The default value of the searchLocations is identical to a local Spring Boot application (that is, [classpath:/, classpath:/config, file:./, file:./config]). This does not expose the application.properties from the server to all clients, because any property sources present in the server are removed before being sent to the client.
   
 4. **Add configuration files for services**: I'm adding hello-service.properties file and bye-service.properties file.
	```properties
	#hello-service.properties
	greeting.message=Hello !, this is hello service.
	```
	```properties
	#bye-service.properties
	greeting.message=GoodBye !, this is bye service.
	```	
	
 5. **Run the application and access the endpoint**: We can access the endpoints as below.
	```
	http://localhost:8191/hello-service/default
	http://localhost:8191/bye-service/default
	```