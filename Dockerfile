FROM openjdk:17
ADD taget/jenkinsdemo.jar jenkinsdemo.jar
ENTRYPOINT [ "java","-jar","jenkinsdemo.jar" ]
