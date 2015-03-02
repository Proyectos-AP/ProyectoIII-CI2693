all:
	javac -classpath "jcommon-1.0.0.jar:jfreechart-1.0.1.jar" *.java

clean:
	rm *.java~
	rm *.class


