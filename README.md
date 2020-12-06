# Car Factory

A virtual car factory application written in Spring Boot.

It gives 'x car has produced' message with entered parameter. For example, if parameter is Cabrio, result says `Cabrio Car has produced.`

Application currently supports three types of cars: Cabrio, Sedan, and Hatchback. You can specify car type by entering this after the URL:

```
/?type=sedan
```

and resulting response is a JSON string such as 

```
{
  "result": "Sedan Car has produced."
}
```

To run the code, you must have Java JDK 11 and Maven 3+. Then you can run it by using an IDE (e.g. IntelliJ IDEA) or by command line with:

```
mvn clean install
java -jar target/cars-0.1.0.jar
```

When application is running, it can be accessed on http://localhost:8080/ and you can add type parameter after ending slash like http://localhost:8080/?type=hatchback
