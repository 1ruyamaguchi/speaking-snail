FROM openjdk:17

ARG jarFile="dummy.jar"
ARG jarFilePath="nob/server/jar"

RUN mkdir -p ${jarFilePath}

COPY ./jar/${jarFile} ${jarFilePath}

# CMD java -jar ${jarFilePath}/${jarFile}