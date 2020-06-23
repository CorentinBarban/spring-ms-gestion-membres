FROM java:8
LABEL maintainer="corentin.barban@toulouse.miage.fr"
VOLUME /tmp
EXPOSE 8088
ADD target/gestionmembre-0.0.1-SNAPSHOT.jar gestionmembre-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","gestionmembre-0.0.1-SNAPSHOT.jar"]
