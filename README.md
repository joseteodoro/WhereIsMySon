# WhereIsMySon

WhereIsMySon is an application to notify the parents in the case that the child does not do the same path to back to home after school. If the child get any other path than the usually one, the server will send a notification to his/her parents telling about the path deviation.

On the mobile device side, we can have an application to push the geolocation time-by-time and on the server side we check if there is any anomaly on that position. Like, for example, if the mobile device is getting far from home instead of getting closer. (The machine learning component is mocked because I don't have time enough to train the model, make the tests and benchmarks).

## Requirements

- You have to have jdk8+ on your machine;
- You have to have a RabbitMQ running on `localhost:5672` and mysql running on `localhost:3306` with the schema `whereismyson` already created. You can use the scripts `startRabbit.sh` and `exposeMySql.sh` to start them, but you need the docker running in our machine.

The services are independent, so you can make them up in any order. These are the ports after run:
- `register-service` runs on `http://localhost:8900`;
- `localization-service` runs on `http://localhost:8700`.
- `notification-service` runs on background getting the messages from Rabbit and sending the notifications by email.

## Running the application

If you have docker on you machine, you can use the command `startServers.sh` to start all the servers and dependencies at once.

## register-service

The `register-service` is the service where the user do the sign up to start the device notification. This service receives much less requests than others, so we can provision few instances of that.

You can access the Swagger (API documentation) on `http://localhost:8900/swagger-ui.html`.

## localization-service

This service aims to receive the POST requests about the child position and push it on our RabbitMQ. We want to ensure that we will receive all the positions sent by the child's mobile device. To guarantee high availability we decided to use an AMQP server between the `localization-service` and the `notification-service`.

Since we will receive more position POST requests than account creation requests, we decided to separate the `localization-service` and the `notification-service` because we can scale them separately. We can wait a bit more to send a notification to the child's parents, but we have to be sure about all the child positions. In that context, we can scale much more the `localization-service` and keep less instances of the `notification-service` to avoiding some extra-costs and continue providing a good availability service for our clients.

You can access the Swagger (API documentation) on `http://localhost:8700/swagger-ui.html`.

## notification-service

The `notification-service` is the service aimed to read the messages from RabbitMQ and dispatch an email notification if there is any anomaly. This service must have much more instances than `register-service`, but we can have less than `localization-service`.
