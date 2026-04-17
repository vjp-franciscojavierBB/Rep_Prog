# ALERTA DE SISTEMA - PROYECTO CORELINK

Se ha detectado un intento de borrado masivo de la base de datos de personal.

## RECONSTRUCCIÓN DE EMERGENCIA REQUERIDA
Debéis programar manualmente una nueva clase Java para filtrar al personal crítico.

## ESPECIFICACIONES DEL PROTOCOLO

Origen: Leer el archivo plano datos_empleados.txt.

Criterio: Aislar UNICAMENTE los registros cuya columna 'Ubicacion' sea exactamente: Zona Cero.

Destino: Escribir los resultados completos (Nombre, Teléfono, Ubicación, Rol) en un nuevo archivo llamado sospechosos_zona_cero.txt.

NOTA: Solo aislando a los que operan desde el epicentro podremos identificar las terminales que están saboteando el núcleo.

P.D: Muestra el número de empleados ubicados en la zona cero. Ese número es clave para seguir avanzando en la investigación.