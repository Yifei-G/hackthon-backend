FROM openjdk:17-jdk-slim
ARG PROXY
#ENV https_proxy=$PROXY
WORKDIR /app
COPY . .
CMD ["./gradlew", "bootRun"]
EXPOSE 8085
