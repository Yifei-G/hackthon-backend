# Spring Boot Application

This document provides setup instructions for running this Spring Boot application. You can either set it up locally or run it within a Docker container.

## Local Setup (Non-Docker)

To run the application locally, you'll need to have Java 17 and Gradle installed on your system.

### Java 17 Installation

Depending on your OS, the installation process may vary.

```bash
# For macOS:
brew install openjdk@17
```

If you have multiple versions of Java installed, you can use the following command to switch between them:

```bash
# For macOS:
brew link openjdk@17
```

To find where are the JDKs installed, you can use the following command:
```bash
# For macOS:
brew --prefix openjdk@17
```

## IMPORTANT: Application Database
To Run this application Locally you first need to set up the database, you can just run the
matrix_api_database_container service inside the docker-compose.yml file using your IDE, or
run:
```bash
docker-compose -f docker-compose.yaml up -d matrix_api_database_container
```


## IntelliJ IDEA Setup

If you are using IntelliJ IDEA, you can import the project directly into the IDE:

1. Open IntelliJ IDEA and navigate to `File -> Open`. Then select the project directory from your file system.

2. Once the project is imported into IntelliJ IDEA, go to `File -> Project Structure -> Project`.

3. Within the Project settings, make sure the Project SDK is set to `17 (OpenJDK 17)`. If not, add the SDK by pointing to the installation directory of JDK 17 on your local system.

4. To build and run the application, navigate to `Run -> Run 'Application'`.

Please replace the word 'Application' with the actual name of your application's main class in IntelliJ IDEA.


## Start the App

To start the application, use the following command:

```bash
gradle clean bootRun
```


## Docker Setup

You can also run the app within a Docker container. To do this, use the following command:

```bash
bash install.sh
```

NOTE: If you are behind a proxy, you will need to set up the proxy in the Dockerfile and docker-compose.yml file.
To do this, uncomment the following lines in the Dockerfile:

```
#ENV https_proxy=$PROXY
```

And update the proxy values in the docker-compose.yml file:

```
 - PROXY=https://username:password@proxy-hostname:port/
```

## Cleanup Docker Environment

If for any reason you need to clear up Docker resources associated with this app, run:

```bash
bash clean.sh
```