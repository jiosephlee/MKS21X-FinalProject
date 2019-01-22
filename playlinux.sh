
#!/bin/bash

printf '\e[8;50;100t'
javac -cp lanterna.jar:. Tetris.java
java -cp lanterna.jar:. Tetris
