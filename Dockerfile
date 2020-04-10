FROM adoptopenjdk/openjdk11:jdk-11.0.6_10-alpine-slim
COPY build/libs/vibroad-service-*-all.jar vibroad-service.jar
EXPOSE 8080
CMD java -Dcom.sun.management.jmxremote -noverify ${JAVA_OPTS} -jar vibroad-service.jar