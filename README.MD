# Waste Manager Service

### Instrucciones para inicializar este servicio:

- Ejecutar este servicio luego de arrancar el <b>naming-service</b> y <b>cloud-config-server</b>
- Abrir una terminal en la raíz del servicio y ejecutar la siguiente instrucción
 ``mvn spring-boot:run``

### Rutas que expone:
 * Este servicio expone las rutas correspondientes a la gestión de la entidad waste-manager:
   1. `/manager/{id}` Obtener un waste manager por id <b>GET</b>
   2. `/manager/create` Crear un waste manager <b>POST</b>
   2. `/manager/update` Actualizar un waste manager <b>POST</b>