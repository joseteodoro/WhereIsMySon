#!/usr/bin/env bash
docker pull mysql/mysql-server:5.7
echo "update mysql.user set host='%' where user='root';
FLUSH PRIVILEGES;
" > /tmp/command.sh
chmod +x /tmp/command.sh
container=$(docker run --rm -e MYSQL_ALLOW_EMPTY_PASSWORD=yes -d -p 3306:3306 -v /tmp/:/tmp/loaded/ mysql/mysql-server:5.7)
echo "Starting mysql ...."
sleep 30
echo "Configuring database access"
docker exec -it $container bash -c "mysql < /tmp/loaded/command.sh"
echo "Done!"
