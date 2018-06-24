# WhereIsMySon

WhereIsMySon is an application to notify the parents in the case that the child does not do the same path to back to home after school. If the child get any other path than the usually one, the server will send a notification to his/her parents telling about the path deviation.

## localization-service

This service aims to receive the POST requests about the child position and push it on our RabbitMQ. We want to ensure that we will receive all the positions sent by the child's mobile device. To guarantee high availability we decided to use an AMQP server between the `localization-service` and the `notification-service`.

Since we will receive more position POST requests than account creation requests, we decided to separate the `localization-service` and the `notification-service` because we can scale them separately. We can wait a bit more to send a notification to the child's parents, but we have to be sure about all the child positions. In that context, we can scale much more the `localization-service` avoiding some extra-costs and providing a good service for our clients.
