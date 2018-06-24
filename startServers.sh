#!/usr/bin/env bash

./exposeMySql.sh
./startRabbit.sh

./register-service/startServer.sh
./localization-service/startServer.sh
./notification-service/startServer.sh

echo "To stop the processes, please kill the java processes"
