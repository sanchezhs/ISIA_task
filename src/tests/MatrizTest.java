package tests;

import matrices.Matriz;
import matrices.DimensionesIncompatibles;
import org.junit.jupiter.api.Test;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import static org.junit.jupiter.api.Assertions.*;



public class MatrizTest {

    @Test
    public void testMultiplicarDimensionesIncompatibles() {
        Matriz a = new Matriz(2, 3, true);
        Matriz b = new Matriz(4, 2, true);
        
        assertThrows(DimensionesIncompatibles.class, () -> {
            Matriz.multiplicarDosMatrices(a, b);
        });
    }

    @Test
    public void testMultiplicarMatrices3x3() {
        Matriz a = new Matriz(3, 3, false);
        Matriz b = new Matriz(3, 3, false);
        
        int[][] a_datos = new int[][]{{-2, 1}, {0, 4}};
        a.setDatos(a_datos);

        int[][] b_datos = new int[][]{{6, 5}, {-7, 1}};
        b.setDatos(b_datos);

        Matriz resultadoEsperado = new Matriz(3, 3, false);
        resultadoEsperado.setDatos(new int[][]{{-19, -9}, {-28, 4}});

        try {
            Matriz resultado = Matriz.multiplicarDosMatrices(a, b);
            assertArrayEquals(resultadoEsperado.getDatos(), resultado.getDatos());
        } catch (DimensionesIncompatibles e) {
            fail("No se esperaba una excepción de dimensiones incompatibles");
        }
    }

    @Test
    public void testTransponerMatriz3x3() {
        Matriz a = new Matriz(3, 3, false);
        
        int[][] a_datos = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        a.setDatos(a_datos);

        Matriz resultadoEsperado = new Matriz(3, 3, false);
        resultadoEsperado.setDatos(new int[][]{{1, 4, 7}, {2, 5, 8}, {3, 6, 9}});

        Matriz resultado = Matriz.transponerMatriz(a);
        assertArrayEquals(resultadoEsperado.getDatos(), resultado.getDatos());
    }

    @Test
    public void testTraspuestaDeTraspuestaEsOriginal() {
        Matriz a = new Matriz(3, 3, false);
        
        int[][] a_datos = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        a.setDatos(a_datos);

        Matriz traspuesta = Matriz.transponerMatriz(a);
        Matriz traspuestaDeTraspuesta = Matriz.transponerMatriz(traspuesta);

        assertArrayEquals(a.getDatos(), traspuestaDeTraspuesta.getDatos());
    }

    @Test
    public void testTraspuestaDeProductoEsProductoDeTraspuestas() {
        Matriz a = new Matriz(3, 3, false);
        Matriz b = new Matriz(3, 3, false);
        
        int[][] a_datos = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        a.setDatos(a_datos);

        int[][] b_datos = new int[][]{{9, 8, 7}, {6, 5, 4}, {3, 2, 1}};
        b.setDatos(b_datos);

        try {
            Matriz producto = Matriz.multiplicarDosMatrices(a, b);
            Matriz traspuestaDelProducto = Matriz.transponerMatriz(producto);

            Matriz traspuestaA = Matriz.transponerMatriz(a);
            Matriz traspuestaB = Matriz.transponerMatriz(b);

            Matriz productoDeTraspuestas = Matriz.multiplicarDosMatrices(traspuestaB, traspuestaA);

            assertArrayEquals(traspuestaDelProducto.getDatos(), productoDeTraspuestas.getDatos());
        } catch (DimensionesIncompatibles e) {
            fail("No se esperaba una excepción de dimensiones incompatibles");
        }
    }
}
