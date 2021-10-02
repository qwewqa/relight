# Relive Simulator
A damage calculator for smartphone game Revue Starlight Re LIVE

## Building
Run the server.
```
./gradlew :relive-simulator-server:run
```

GraalVM Native image.
```
native-image -jar relive-simulator-server-0.0.1-all.jar
```
