# inventarios-rest
Repositorio para el servidor rest.

# Despliegue

## Heroku

El repositorio ya contiene el archivo Procfile de Heroku, solo es necesario crear el recurso de base de datos Postgresql desde la consola de Heroku y configurar el dyno para desplegar desde este repositorio.

* Sin embargo hay una configuracion de seguridad (CORS) que es necesaria modificar en el archivo application-heroku.yml ya que solo se permiten origenes CORS desde https://inventarios-ng.herokuapp.com en el ambiente de producción*

## Docker

Se puede hacer todo el proceso usando el script build_start.bat, el servidor debería quedar funcionando por el puerto 8080.

Si se desea hacer por pasos primero es necesario compilar usando el siguiente comando:

`./mvnw -DskipTests install`

Para iniciar el proyecto se puede usar docker compose:

`docker-compose up -d`



# Base de datos

El esquema de base de datos se crea automáticamente y los datos de prueba también ya que se está usando liquibase.


