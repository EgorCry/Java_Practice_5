FROM adoptopenjdk/openjdk16:latest
COPY out/artifacts/springboot_fileupload_filedownload_jar/springboot-fileupload-filedownload.jar demo.jar
RUN mkdir -p /files
CMD ["java", "-jar", "demo.jar"]