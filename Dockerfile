FROM java:8-jdk-alpine

COPY ./target/expose-git-information-actuator.jar /usr/app/

WORKDIR /usr/app

RUN sh -c 'touch expose-git-information-actuator.jar'

ENTRYPOINT ["java", "-jar", "expose-git-information-actuator.jar"]
