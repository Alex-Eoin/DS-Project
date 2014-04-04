CLS
DEL Chat /f /q
DEL *.class
idlj -fallTIE -oldimplbase Chat.idl
javac Chat/*.java
javac *.java
