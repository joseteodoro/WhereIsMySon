#!/usr/bin/env bash

mvn clean compile package && java -jar notification-service-0.0.1-SNAPSHOT.jar
