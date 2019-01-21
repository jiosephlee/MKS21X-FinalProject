
#!/bin/bash

printf '\e[8;80;80t'
javac -cp lanterna.jar:. Tetris.java
java -cp lanterna.jar:. Tetris
