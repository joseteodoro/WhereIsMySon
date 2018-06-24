#!/usr/bin/env bash

mvn clean compile package && java -jar register-service-0.0.1-SNAPSHOT.jar
