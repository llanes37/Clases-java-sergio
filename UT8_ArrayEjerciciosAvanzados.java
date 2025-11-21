/*
 * UT8_ArrayEjerciciosAvanzados.java
 * Ejercicios avanzados de arrays para practicar lógica y manipulación en Java.
 * Cada método tiene ENUNCIADO, EXPLICACIÓN y PARA TI.
 */

import java.util.Arrays;

public class UT8_ArrayEjerciciosAvanzados {

    /**
     * ENUNCIADO: Método que devuelve verdadero si una secuencia está en el array.
     * Ejemplo: 456 está en 234873545645458
     * EXPLICACIÓN: Busca si todos los elementos de la secuencia aparecen consecutivos en el array principal.
     * PARA TI: Hazlo para arrays de int y para arrays de char.
     */
    public static boolean contieneSecuencia(int[] array, int[] secuencia) {
        if (array == null || secuencia == null || secuencia.length == 0 || array.length < secuencia.length) return false;
        for (int i = 0; i <= array.length - secuencia.length; i++) {
            boolean igual = true;
            for (int j = 0; j < secuencia.length; j++) {
                if (array[i + j] != secuencia[j]) {
                    igual = false;
                    break;
                }
            }
            if (igual) return true;
        }
        return false;
    }

    /**
     * ENUNCIADO: Método para eliminar un valor del array (solo la primera aparición).
     * EXPLICACIÓN: Crea un nuevo array sin el valor, manteniendo el orden.
     * PARA TI: Hazlo para eliminar todas las apariciones del valor.
     */
    public static int[] eliminarValor(int[] array, int valor) {
        if (array == null) return null;
        int pos = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == valor) {
                pos = i;
                break;
            }
        }
        if (pos == -1) return Arrays.copyOf(array, array.length);
        int[] nuevo = new int[array.length - 1];
        for (int i = 0, j = 0; i < array.length; i++) {
            if (i != pos) nuevo[j++] = array[i];
        }
        return nuevo;
    }

    /**
     * ENUNCIADO: Método para compactar el array moviendo ceros al final.
     * Ejemplo: 2 9 0 2 3 4 -> 2 9 2 3 4 0
     * EXPLICACIÓN: Recorre el array, copia los no ceros al principio y los ceros al final.
     * PARA TI: Hazlo para cualquier valor (no solo ceros).
     */
    public static void compactarCeros(int[] array) {
        if (array == null) return;
        int idx = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) array[idx++] = array[i];
        }
        while (idx < array.length) array[idx++] = 0;
    }

    /**
     * ENUNCIADO: Método para eliminar repeticiones en el array.
     * EXPLICACIÓN: Devuelve un nuevo array solo con los elementos únicos, manteniendo el orden.
     * PARA TI: Hazlo para arrays de String.
     */
    public static int[] eliminarRepetidos(int[] array) {
        if (array == null) return null;
        int[] temp = new int[array.length];
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            boolean repetido = false;
            for (int j = 0; j < count; j++) {
                if (array[i] == temp[j]) {
                    repetido = true;
                    break;
                }
            }
            if (!repetido) temp[count++] = array[i];
        }
        return Arrays.copyOf(temp, count);
    }

    /**
     * ENUNCIADO: Inserción en posición: insertar un valor en una posición dada.
     * Ejemplo: insertar 4 en pos 2 en 1 9 8 7 -> 1 9 4 8 7
     * EXPLICACIÓN: Crea un nuevo array con el valor insertado en la posición indicada.
     * PARA TI: Hazlo para arrays de String.
     */
    public static int[] insertarEnPosicion(int[] array, int valor, int pos) {
        if (array == null || pos < 0 || pos > array.length) return array;
        int[] nuevo = new int[array.length + 1];
        for (int i = 0, j = 0; i < nuevo.length; i++) {
            if (i == pos) {
                nuevo[i] = valor;
            } else {
                nuevo[i] = array[j++];
            }
        }
        return nuevo;
    }

    /**
     * ENUNCIADO: Método que devuelve true si el array está ordenado de menor a mayor.
     * EXPLICACIÓN: Recorre el array y compara cada elemento con el siguiente.
     * PARA TI: Hazlo para orden descendente.
     */
    public static boolean estaOrdenado(int[] array) {
        if (array == null || array.length < 2) return true;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) return false;
        }
        return true;
    }

    // Puedes añadir un main() para probar cada método si lo deseas.
}
