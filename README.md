# Drugstore

Ejemplo de farmacias de turno en la región metropolitana

## Pre-requisitos

Java 8 +
```
https://www.oracle.com/technetwork/java/javase/downloads/index.html
```

gradle 6 + 
```
https://gradle.org/install/
```

Clonar proyecto

```
git clone https://github.com/lisbethGS/drugstore.git
```

Ir al directorio del proyecto

```
cd drugstore
```

## Ejecutar a través de Docker

Instalar Docker 

```
https://docs.docker.com/installation/#installation
```

Construir imagen

```
docker build -t springio/drugstore .
```

Ejecutar imagen
```
docker run -p 8080:8080 -t springio/drugstore
```


## Contrucción y ejecución local

Ejecutar
```
./gradlew build && java -jar build/libs/drugstore-0.0.1.jar
```

### Prueba local

Ejecutar en navegador

```
http://localhost:8080/drugstore?locationName=BUIN&drugstoreName=AHUMADA
```

Ejecutar en terminal 
```
curl -X GET 'http://localhost:8080/drugstoreTest?locationName=BUIN&drugstoreName=AHUMADA'
```
### Interfaz gráfica

Ir al directorio frontApp

```
cd frontApp
```

Seguir las instrucciones
```
https://github.com/lisbethGS/drugstore/tree/master/frontApp
```