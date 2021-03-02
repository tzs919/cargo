FROM openjdk:netcat
RUN mkdir -p /usr/local/cargoservice
ADD @project.build.finalName@.jar /usr/local/cargoservice/
ADD run.sh run.sh
RUN chmod +x run.sh
CMD ./run.sh
