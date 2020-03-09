#!/bin/bash
if [ "$1" == "gt" ] || [ "$1" == "tifa" ] || [ "$1" == "tli" ] || [ "$1" == "prod" ]; then
	export JAVA_HOME="/usr/lib/jvm/java-11-openjdk-amd64" && mvn clean --settings /home/finch/.m2/settings_logger.xml spring-boot:run -Dspring-boot.run.profiles=$1
else
	mvn clean spring-boot:run -Dspring-boot.run.profiles=$1
fi
