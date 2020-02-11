# # Drugstore

Ejemplo de farmacias de turno en la región metropolitana

## Pre-requisitos

Java 8
Gradle 6.1.1

### Ejecución local

Clonar proyecto

```
git clone https://github.com/lisbethGS/drugstore.git
```

Ir al directorio del proyecto

```
cd drugstore
```

Construir proyecto

```
gradle build
```

Ejecutar proyeto

```
gradle bootRun
```


## Prueba local

Probar a tráves de algún cliente rest o utilizando comando

```
curl -X GET 'http://localhost:8080/drugstoreTest?locationName=BUIN&drugstoreName=AHUMADA'
```
