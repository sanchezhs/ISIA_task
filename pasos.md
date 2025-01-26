Autor: Samuel Sánchez.

1. Creamos la rama **Sanchez_Multiplicar** a partir de **master**
```bash
git checkout -b Sanchez_Multiplicar
```
Ahora implementamos la función **multiplicar** en el archivo **Matriz.java**.


2. Creamos la rama **Sanchez_Invertir** a partir de **master**
```bash
git checkout -b Sanchez_Invertir
```

Ahora implementamos la función **invertir** en el archivo **Matriz.java**.


3. Creamos la rama **Sanchez_Fusion** a partir de **master**
```bash
git checkout -b Sanchez_Fusion
```

Fusionamos las ramas **Sanchez_Multiplicar** y **Sanchez_Invertir** en **Sanchez_Fusion**.
Desde la rama **Sanchez_Fusion** ejecutamos:

```bash
git merge Sanchez_Multiplicar
git merge Sanchez_Invertir
```
