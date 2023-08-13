main.class:
	javac -Xlint  *.java
	
run:
	java -Xmx64m MainClass

clean:
	rm -f *.class