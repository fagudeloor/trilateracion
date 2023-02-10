Esta API esta desarrollada para dada la ubicación de 3 satelites, triangular la posición de una petición de ayuda de una nave nave quen envia una petición de ayuda y tomando como referencia la distancia a la que se encuentra de los satelites.

Para poder implementar una solución se uso la técnica de la trilateración, después de investigar varias fuentes se tomo parte del código de stack overflow https://stackoverflow.com/questions/24761658/trilateration-method-android-java) dado que así permitia modificarlo y fue la fuente que más proximidad tuvo según las pruebas.

Como tecnólogias se usaron: java 8 (se compilo sobre java 17), spring boot, hybernate, mysql, aws, lombok, mapstruck, maven, swagger y Junit.

Para llevar a cabo la API se crearon los siguientes servicios:

Para cargar las ubicaciones recibidas por cada satelite:
/topsecret_split/kenobi 
/topsecret_split/skywalker 
/topsecret_split/sato 

Para solicitar la ubiación calculada apartir de los mensajes recibidos por estos servicios:
/topsecret_split/

Para enviar un json con la ubicación de todos los satelites y al mismo tiempo recibir una respuesta:
/topsecret/

Para actualizar la ubicación de los satelites:
/trilateration_satellite/save

Para consultar la ubicación de los satelites:
/trilateration_satellite/get_all
-----------------------------
A nivel de código su uso el diseño controller-service-repository recomendado por Spring, así mismo para el manejo de POJOs se trabajo del lado de la base de datos con objetos "dominios" y para el lado del controlador DTOs usando mappers entre puente para convertir los objetos.

A nivel de base de datos se crearon las entidades:

called_help: almacena las llamadas de ayuda recibidas por cada satelite.
response_called_help: almacena las respuestas calculadas.
satellite: almacena los satelites.
satellite_location: almacena las ubicaciones de los satelites.

------------------------------
AWS - URL API
http://melichallengetrilaterationenv-env.eba-bspgcyqp.us-east-1.elasticbeanstalk.com/

-------------------------------
Postman Collection
nube:
https://elements.getpostman.com/redirect?entityId=8417226-9744d637-9ccb-4d82-894f-150f1b0ae714&entityType=collection
local:
https://elements.getpostman.com/redirect?entityId=8417226-82e3c31a-a88b-4249-a30c-281e7d0e55c5&entityType=collection


