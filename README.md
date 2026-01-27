[![Java CI with Gradle](https://github.com/lucformalmethodscourse/hello-jqwik-maven/actions/workflows/gradle.yml/badge.svg)](https://github.com/lucformalmethodscourse/hello-jqwik-maven/actions/workflows/gradle.yml)

## Initial Jqwik experiments

This project contains simple examples of using [jqwik](https://jqwik.net/) property-based testing in Java.

Please refer to the instructions for [this project](https://github.com/lucformalmethodscourse/hello-java-maven) for building and running the tests.

## Build System

This project has been migrated to Gradle while maintaining Maven compatibility. See [doc/GRADLE-MIGRATION.md](doc/GRADLE-MIGRATION.md) for complete migration details and command reference.

### Quick Start with Gradle

```bash
# Build the project
./gradlew build

# Run tests (including jqwik property-based tests)
./gradlew test

# Run the application
./gradlew run

# Create standalone JAR
./gradlew shadowJar
```
