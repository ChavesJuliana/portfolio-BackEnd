FROM openjdk:17
MAINTAINER juliana
ADD target/portfolio-0.0.1-SNAPSHOT.jar portfolio-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/portfolio-0.0.1-SNAPSHOT.jar"]

