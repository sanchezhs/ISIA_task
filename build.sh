#!/bin/bash

# Directorios
SRC_DIR="src"
OUT_DIR="bin"
LIB_DIR="lib"

set -xe

mkdir -p $OUT_DIR

echo "Compilando clases de matrices..."
javac -d $OUT_DIR $SRC_DIR/matrices/*.java

echo "Compilando clases de tests..."
javac -cp $OUT_DIR:$LIB_DIR/junit-platform-console-standalone-1.9.2.jar -d $OUT_DIR $SRC_DIR/tests/*.java

echo "Compilación completada."

echo "Para ejecutar los tests, usa el comando:"
echo "java -cp $OUT_DIR:$LIB_DIR/junit-platform-console-standalone-1.9.2.jar org.junit.platform.console.ConsoleLauncher --scan-class-path"
