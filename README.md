# ScreenService
#### Requirements:

>  - JDK 1.8+
>  - Maven

 #### Dependencies:  

> [pom.xml](https://github.com/johnsanthosh/screen-service/blob/master/pom.xml)

## Steps to setup

 1.  Navigate to screen-service.

 2.  Run	**`mvn clean install`**
 3.  Run **`mvn spring-boot:run`**
 

> Spins up the spring-boot application on `http://localhost:8080/`

## Rest Endpoints

 1. GET : **`http://localhost:8080/screen-service/`**
 

> response : Spring Boot Application Running.

 3. GET : **`http://localhost:8080/screen-service/screens`**
 

> response : **`[{"id":"1","content":"Screen1"},{"id":"2","content":"Screen1"}]`**

 5. GET : **`http://localhost:8080/screen-service/screens/1`**

> response : `[{"id":"1","content":"Screen1"}]`

 7. POST : **`http://localhost:8080/screen-service/screens`**

> request body : `{'id' : string, 'content' : string}`

    

 


