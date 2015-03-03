Universidad Simon Bolivar
Departamento de Computacion y Tecnologia de la Informacion
Laboratorio de Algoritmos y Estructuras III (CI2693)
Profesores: Saul Hidalgo y Carlos Gomez
Nombres: 
	Alejandra Cordero / Carnet: 12-10645
	Pablo Maldonado   / Carnet: 12-10561

Instrucciones para correr el proyecto de algoritmos:

1) En caso de tener el archivo en el mismo directorio:

	1.1) Ejecutar el comando "make all" para compilar los archivos.
	1.2) Ejecutar el comando "agrupar [-q] nombrearchivo"
	1.3) Si desea eliminar los archivos .class generados
	ejecute el comando "make clean"

Nota: El flag "-q" es opcional. En caso de no estar, se generara una grafica
que muestra los clusters.

2) En caso de tener el archivo en un subdirectorio: 

	2.1) Ejecutar el comando "make all" para compilar los archivos.
	2.2) Ejecutar el comando "agrupar [-q] rutaArchivo"
	donde rutaArchivo debe iniciar sin  "/". Ejemplo: data/puntos1.dat
	2.3) Si desea eliminar los archivos .class generados
        ejecute el comando "make clean"

Observaciones de implementacion:

- Para el uso de las librerias externas necesarias para la graficacion, 
se anexan los archivos .jar correspondientes a Jfreechart y Jcommon.

- La representacion del grafo se implemento con dos ArrayLists (Nodos y 
Aristas) 

Fuentes electronicas consultadas: 

1) http://www.cs.swarthmore.edu/~newhall/unixhelp/javamakefiles.html

2) http://www.cs.swarthmore.edu/~newhall/unixhelp/howto_makefiles.html

3) http://w3facility.org/question/changing-the-shapes-of-points-in-scatter-plot/

4) https://github.com/lebedov/markovapplet/blob/f5f58d6dd52c3631fdba620f6bd5098c94c6cfbc/Makefile

5) http://www.softwero.com/2014/07/solucionar-javalangnoclassdeffounderror.html
