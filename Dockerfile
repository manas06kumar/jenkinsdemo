FROM openjdk:17
ADD target/*.jar jenkinsdemo.jar
ENTRYPOINT [ "java","-jar","jenkinsdemo.jar" ]
