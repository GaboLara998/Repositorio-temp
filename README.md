# Repositorio-temp

#   Función de limitar BandWidth a Host

A continuación se explicará el funcionamiento de limitar el BandWidth a un Host

## Funcionamiento del limitador de Evil Limiter:

Utiliza la herramienta **TC (traffic control)** para la gestión de las políticas de tráfico y límites de anchos de banda. En este caso se está realizando un proceso similar a **ARP Spoofing**, el cual el programa envía mensajes ARP falsos a la red conectada para asociar la dirección **MAC** con la dirección **IP**, para poder interceptar el tráfico de la red, y de este modo poder manipularlo. Sin embargo, el límite está vigente  *siempre y cuando* el programa esté en ejecución. 

## Funcionamiento de ARP Spoofing:

Como se mencionó, **ARP Spoofing** funciona mediante el envio de **paquetes ARP Falsos** a todos los dispositivos conectados a la red. Estos paquetes contienen **información falta de la tabla ARP**, lo que provoca que los dispositivos afectados envien sus paquetes de red al programa que realiza el **ARP Spoofing**, en lugar de enviar los paquetes a su destino original. Estas **tablas de ARP** sirven para determinar las **direcciones MAC** del dispositivo de destino, por lo que mapea la **dirección IP** con su respectiva **dirección MAC**. Por lo tanto **Evillimiter** utiliza esta información para posteriormente realizar **manipulaciones en el tráfico de la red** de los dispositivos. 

## Funcionamiento de la Clase Limiter en nuestro proyecto

Utilizamos e importamos la biblioteca **pexpect** que trabaja sobre **Linux**. Este programa nos permite **enviar comandos** hacia otros programas, levantamos una instancia del programa Evillimter, con el comando **spawn**, la respuesta recibida determina que el programa está corriendo.

Funcionamiento del comando **spawn** para ejecutar el programa de **pexpect** para levantar una instancia del programa **Evillimiter** junto con su respuesta.

![Funcionamiento del comando **spawn** para ejecutar el programa de **pexpect** para levantar una instancia del programa **Evillimiter** junto con su respuesta.](https://github.com/GaboLara998/Repositorio-temp/blob/main/Imagenes/Expect1.2%20-%20Imgur.png)

Mediante el comando **send** junto con **\r**, enviamos los comandos.

Funcionamiento del comando **send** junto con el argumento a ejecutar junto con **\r**.

![Funcionamiento del comando send junto con el argumento a ejecutar junto con \r.](https://github.com/GaboLara998/Repositorio-temp/blob/main/Imagenes/expect%201.4%20-%20Imgur.png)


Con **expect** muestra lo que hace la aplicación.

![Funcionamiento del comando send junto con el argumento a ejecutar junto con \r.](https://github.com/GaboLara998/Repositorio-temp/blob/main/Imagenes/Expect1.5%20-%20Imgur.png)

 
De manera que levantamos una instancia de **Evillimter**, le definimos un **TimeOut** de **1 hora**, esto se hace porque se limita mientras la aplicación se esté ejecutando, el límite de **BandWidth** que se haya realizado hacia un host estará activo, por lo que el **TimeOut** nos ayuda a que si no hay respuesta de vuelta, tras una hora de limitación, lo quita. 


## Uso de Thereads

Usamos thereads, ya que no se puede tener una aplicación siempre corriendo en el **kernel principal**, por lo tanto, lo mandamos en un hilo de ejecución o un thread. La ejecución se realiza mediante la llamada a la instancia de la clase junto con **thread.run()** para su ejecución. Y se detiene mediante el método **Stop()**, por lo que la limitación hacia algún host se detiene. 


## Manejo de Datos

Utilizamos un primer **Diccionario** para la conversión de las escalas de velocidades a las cuales queremos limitar. De igual manera, un segundo **Diccionario** con el **Id el host** que buscamos limitar, que es el primer par, y el segundo par es un **array** que contiene la **velocidad** a la cual se le va a limitar al host,  junto con la **unidad de velocidad** a la que se está limitando.


## Funcion de la Clase para Bloquear a todos los hosts

Similar a la función de limitar la red, tenemos nuestra clase Blocker, que recibe el ID del host que se busca bloquear. Y de igual manera usamos **thread.run()** para su ejecución.

