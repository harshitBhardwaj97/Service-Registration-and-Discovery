# Service Registration & Discovery

This project demonstrates how to implement **Service Registration and Discovery** using **Spring Cloud Eureka**.

It consists of three separate microservices:

1. **Eureka Server**: The service registry where all other services register themselves.
2. **Service A**: A simple service that exposes a `/helloWorld` endpoint.
3. **Service B**: A client service that discovers **Service A** using Eureka and calls its `/helloWorld` endpoint.

## Architecture Overview

- **Eureka Server**: Acts as a service registry for **Service A** and **Service B**.
- **Service A**: Registers with Eureka and exposes an endpoint `/helloWorld` that returns a simple message.
- **Service B**: Discovers **Service A** through Eureka and makes a REST call to the `/helloWorld` endpoint of **Service A**.

## Running the Application

1. Start the **Eureka Server** application on port `8761`.
2. Start **Service A** on port `8081`. It will register itself with Eureka.
3. Start **Service B** on port `8082`. It will discover **Service A** via Eureka and call its `/helloWorld` endpoint when you access `/helloEureka`.

## Endpoints

- **Eureka Server**: [http://localhost:8761](http://localhost:8761) (Access the Eureka dashboard).
- **Service A**: [http://localhost:8081/helloWorld](http://localhost:8081/helloWorld) (Returns "Hello world from Service A!").
- **Service B**: [http://localhost:8082/helloEureka](http://localhost:8082/helloEureka) (Discovers **Service A** and returns the message from `http://localhost:8081/helloWorld`.

## Notes

- Ensure that you have all three applications running: **Eureka Server**, **Service A**, and **Service B**.
- This project is based on the [Service Registration & Discovery](https://spring.io/guides/gs/service-registration-and-discovery) guide, offered by Spring Team.
- You can explore the Eureka Dashboard at [http://localhost:8761](http://localhost:8761) to see the registered services.
