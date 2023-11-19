FROM openjdk:latest
EXPOSE 8080
WORKDIR /usr/src/app
ARG JAR_FILE=target/*.jar
COPY ./target/dataGenerator-spring-api-example-1.0-SNAPSHOT.jar demo.jar
COPY ./target/classes/trFootballTeams.yaml trFootballTeams.yaml
COPY ./target/classes/trCars.yaml trCars.yaml
COPY ./target/classes/trCities.yaml trCities.yaml
COPY ./target/classes/trJobs.yaml trJobs.yaml
COPY ./target/classes/trMovies.yaml trMovies.yaml
COPY ./target/classes/trNames.yaml trNames.yaml
COPY ./target/classes/trSurnames.yaml trSurnames.yaml
ENTRYPOINT ["java", "-jar", "demo.jar"]