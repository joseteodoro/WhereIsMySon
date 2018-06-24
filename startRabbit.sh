#!/usr/bin/env bash

docker run -d -p 8888:15672 -p 5672:5672  rabbitmq:3-management
sleep 30
