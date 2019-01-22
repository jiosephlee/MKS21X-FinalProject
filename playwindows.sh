
#!/bin/bash

printf '\e[8;90;90t'
javac -cp "lanterna.jar;." Tetris.java
java -cp "lanterna.jar;." Tetris
