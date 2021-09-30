# Relive Simulator
A damage calculator for smartphone game Revue Starlight Re LIVE

## Building
Run the server.
```
./gradlew :relive-simulator-server:run
```

GraalVM Native image.
```
native-image --no-fallback --report-unsupported-elements-at-runtime --install-exit-handlers --allow-incomplete-classpath --initialize-at-build-time=kotlinx,kotlin,org.slf4j,ch.qos.logback -H:+ReportUnsupportedElementsAtRuntime -H:+ReportExceptionStackTraces -jar relive-simulator-server-0.0.1-all.jar
```
