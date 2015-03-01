CLASSPATH=./JavaLibraries/jcommon-1.0.23.jar: jfreechart-1.0.19.jar

all:
	cd ProyectoAlgo
	java -classpath $(CLASSPATH) Main
	javac *.java

clean:
	rm *.java~
