FROM openjdk:netcat
RUN mkdir -p /usr/local/customerservice
ADD @project.build.finalName@.jar /usr/local/customerservice/
ADD run.sh run.sh
RUN chmod +x run.sh
CMD ./run.sh
