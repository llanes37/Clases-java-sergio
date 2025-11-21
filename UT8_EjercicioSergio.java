/*
 * UT8_EjercicioSergio.java
 * ---------------------------------------------------------------------------
 * Guía didáctica de Arrays (nivel visto en clase) + Ejercicios similares.
 * Cada MÉTODO incluye bloques con:
 *   ? ENUNCIADO   -> Qué se pide / qué hace el método principal.
 *   * EXPLICACIÓN -> Cómo funciona la lógica paso a paso y conceptos clave.
 *   * DETALLE     -> Posibles mejoras, casos borde, complejidad.
 *   ! PARA TI     -> Un ejercicio similar. Se deja PLANTILLA del método alumno.
 * ---------------------------------------------------------------------------
 * Objetivo: El alumno lee teoría + ejemplo y luego implementa el método "PARA TI".
 * ---------------------------------------------------------------------------
 */

import java.util.Arrays;
import java.util.Random;

public class UT8_EjercicioSergio {

    /* ============================================================= */
    /* MAIN (PRUEBAS OPCIONALES)                                     */
    /* ============================================================= */
    public static void main(String[] args) {
        // Descomenta para probar métodos básicos.
        int[] demo = arrayAleatorioSimple(8); // genera 8 números aleatorios
        imprimirArray(demo);
        System.out.println("¿Está 50 en el array? " + contieneValor(50, demo));
        System.out.println("Índice de 50 (si existe): " + indicePrimeraOcurrencia(50, demo));
        System.out.println("Está 50 usando forma 2: " + contieneValorForma2(50, demo));
        System.out.println("¿Array ordenado? " + estaOrdenadoEstricto(demo));
        System.out.println("Comparación simple con copia: " + compararArraysIguales(demo, Arrays.copyOf(demo, demo.length)));

        // Compactar ceros ejemplo:
        int[] conCeros = {2, 0, 5, 0, 7, 0, 9};
        compactarValorAlFinal(conCeros, 0);
        imprimirArray(conCeros);

        // PARA TI: Descomenta y completa los métodos plantilla al implementarlos.
        // int r = aleatorioPar(10, 40);
        // imprimirArrayInvertido(demo);
        // int[] otro = arrayAleatorioRango(5, 10, 99);
        // int idxUltimo = indiceUltimaOcurrencia(50, demo);
        // boolean ordenDesc = estaOrdenadoDescendente(demo);
        // int[] sinRepetidos = eliminarRepetidosOrden(demo);
    }

    /* ============================================================= */
    /* 1. NÚMERO ALEATORIO EN RANGO                                 */
    /* ============================================================= */
    /**
     * ? ENUNCIADO: aleatorio(int desde, int hasta) devuelve un entero entre ambos límites (INCLUIDOS).
     * * EXPLICACIÓN: Usa Math.random() que genera [0,1). Escalamos al tamaño (hasta-desde+1) y sumamos 'desde'.
     * * DETALLE: Si desde > hasta sería un caso inválido (podrías intercambiar o lanzar excepción). Complejidad O(1).
     * ! PARA TI: Implementa aleatorioPar(int desde, int hasta) que garantice que el resultado sea PAR (reintenta si no).
     */
    public static int aleatorio(int desde, int hasta) {
        if (desde > hasta) { // manejo defensivo
            int tmp = desde; desde = hasta; hasta = tmp;
        }
        int rango = hasta - desde + 1;
        int valor = (int) (Math.random() * rango) + desde;
        return valor;
    }
    // PLANTILLA PARA TI:
    // public static int aleatorioPar(int desde, int hasta) {
    //     // Genera números hasta obtener uno par.
    // }

    /* ============================================================= */
    /* 2. IMPRIMIR UN ARRAY                                          */
    /* ============================================================= */
    /**
     * ? ENUNCIADO: imprimirArray(int[] v) muestra todos los elementos separados por espacio.
     * * EXPLICACIÓN: Recorremos con for-each. Añadimos salto final para terminar la línea.
     * * DETALLE: Método tipo procedimiento (void), efecto secundario: salida por consola.
     * ! PARA TI: Crea imprimirArrayInvertido(int[] v) que muestre el array desde el último al primero.
     */
    public static void imprimirArray(int[] v) {
        if (v == null) { System.out.println("(array null)"); return; }
        for (int n : v) System.out.print(n + " ");
        System.out.println();
    }
    // PLANTILLA PARA TI:
    // public static void imprimirArrayInvertido(int[] v) {
    // }

    /* ============================================================= */
    /* 3. ARRAY ALEATORIO DE N ENTEROS                               */
    /* ============================================================= */
    /**
     * ? ENUNCIADO: arrayAleatorioSimple(int n) crea un array de longitud n con valores aleatorios 1..99.
     * * EXPLICACIÓN: Reservamos array y completamos cada posición con aleatorio(1,99).
     * * DETALLE: Complejidad O(n). Si n <= 0 retornamos array vacío.
     * ! PARA TI: Implementa arrayAleatorioRango(int n, int min, int max) que permita configurar el rango.
     */
    public static int[] arrayAleatorioSimple(int n) {
        if (n <= 0) return new int[0];
        int[] v = new int[n];
        for (int i = 0; i < v.length; i++) v[i] = aleatorio(1, 99);
        return v;
    }
    // PLANTILLA PARA TI:
    // public static int[] arrayAleatorioRango(int n, int min, int max) {
    // }

    /* ============================================================= */
    /* 4. BUSCAR SI UN VALOR ESTÁ EN EL ARRAY                        */
    /* ============================================================= */
    /**
     * ? ENUNCIADO: contieneValor(int valor, int[] v) devuelve true si 'valor' aparece al menos una vez en v.
     * * EXPLICACIÓN: Recorremos secuencialmente; detenemos la búsqueda al encontrar coincidencia.
     * * DETALLE: Complejidad peor caso O(n). Para arrays muy grandes considerar búsqueda binaria si está ordenado.
     * ! PARA TI: Implementa contarOcurrencias(int valor, int[] v) que devuelva cuántas veces aparece.
     */
    public static boolean contieneValor(int valor, int[] v) {
        if (v == null) return false;
        int i = 0;
        boolean encontrado = false;
        while (!encontrado && i < v.length) {
            if (v[i] == valor) {
                encontrado = true;
            }
            i++;
        }
        return encontrado;
    }
    // PLANTILLA PARA TI:
    // public static int contarOcurrencias(int valor, int[] v) {
    // }

    /* ============================================================= */
    /* 5. ÍNDICE DE PRIMERA OCURRENCIA                               */
    /* ============================================================= */
    /**
     * ? ENUNCIADO: indicePrimeraOcurrencia(int valor, int[] v) devuelve el índice donde aparece la PRIMERA vez (o -1).
     * * EXPLICACIÓN: Similar al anterior, pero guardamos índice cuando encontramos y salimos del bucle.
     * * DETALLE: Devuelve -1 si no está. Complejidad O(n).
     * ! PARA TI: Implementa indiceUltimaOcurrencia(int valor, int[] v) buscando la última posición.
     */
    public static int indicePrimeraOcurrencia(int valor, int[] v) {
        if (v == null) return -1;
        int i = 0;
        boolean encontrado = false;
        while (!encontrado && i < v.length) {
            if (v[i] == valor) {
                encontrado = true;
            } else {
                i++;
            }
        }
        return encontrado ? i : -1;
    }
    // PLANTILLA PARA TI:
    // public static int indiceUltimaOcurrencia(int valor, int[] v) {
    // }

    /* ============================================================= */
    /* 6. REUTILIZAR LÓGICA (WRAPPER)                                */
    /* ============================================================= */
    /**
     * ? ENUNCIADO: contieneValorForma2(int valor, int[] v) usa indicePrimeraOcurrencia para no duplicar lógica.
     * * EXPLICACIÓN: Wrapper; si el índice es >=0 significa que existe.
     * * DETALLE: Mejora mantenibilidad: cambios en búsqueda solo se hacen en un sitio.
     * ! PARA TI: Implementa contieneValorBinario(int valor, int[] v) asumiendo que v está ORDENADO (búsqueda binaria).
     */
    public static boolean contieneValorForma2(int valor, int[] v) {
        return indicePrimeraOcurrencia(valor, v) >= 0;
    }
    // PLANTILLA PARA TI:
    // public static boolean contieneValorBinario(int valor, int[] v) {
    // }

    /* ============================================================= */
    /* 7. APARECE N VECES                                            */
    /* ============================================================= */
    /**
     * ? ENUNCIADO: apareceNVeces(int valor, int vecesObjetivo, int[] v) devuelve true si 'valor' aparece EXACTAMENTE 'vecesObjetivo'.
     * * EXPLICACIÓN: Recorremos y contamos. Si el contador supera 'vecesObjetivo' podemos parar (optimización ligera).
     * * DETALLE: Complejidad O(n). Mejora: parar cuando count > vecesObjetivo.
     * ! PARA TI: Implementa apareceAlMenosNVezes(int valor, int n, int[] v) que evalúe si aparece n o más veces.
     */
    public static boolean apareceNVeces(int valor, int vecesObjetivo, int[] v) {
        if (v == null || vecesObjetivo < 0) return false;
        int count = 0;
        for (int x : v) {
            if (x == valor) {
                count++;
                if (count > vecesObjetivo) break; // ya no es exactamente
            }
        }
        return count == vecesObjetivo;
    }
    // PLANTILLA PARA TI:
    // public static boolean apareceAlMenosNVezes(int valor, int n, int[] v) {
    // }

    /* ============================================================= */
    /* 8. COMPARAR ARRAYS (MISMA LONGITUD)                           */
    /* ============================================================= */
    /**
     * ? ENUNCIADO: compararArraysIguales(int[] a, int[] b) devuelve true si ambos tienen misma longitud y todos sus elementos iguales.
     * * EXPLICACIÓN: Primero comprobamos longitud; luego comparamos posición a posición.
     * * DETALLE: Complejidad O(n). Reemplazable por Arrays.equals(a,b) pero aquí lo hacemos manualmente para aprender.
     * ! PARA TI: Implementa compararArraysIgnorandoOrden(int[] a, int[] b) (mismos elementos sin importar posiciones).
     */
    public static boolean compararArraysIguales(int[] a, int[] b) {
        if (a == null || b == null) return false;
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }
    // PLANTILLA PARA TI:
    // public static boolean compararArraysIgnorandoOrden(int[] a, int[] b) {
    // }

    /* ============================================================= */
    /* 9. COMPARACIÓN AVANZADA CON PADDING DE CEROS                  */
    /* ============================================================= */
    /**
     * ? ENUNCIADO: compararConPaddingCeros(int[] a, int[] b) considera iguales si las partes comunes coinciden y
     *              el sobrante del más largo son SOLO ceros. Ej: [3,2,1] == [3,2,1,0,0]
     * * EXPLICACIÓN: Recorremos la longitud del menor comprobando igualdad; luego verificamos cola del mayor.
     * * DETALLE: Útil cuando tratamos arrays que representan datos con relleno. Complejidad O(n).
     * ! PARA TI: Implementa compararConValorDeRelleno(int[] a, int[] b, int relleno) generalizando el valor de padding.
     */
    public static boolean compararConPaddingCeros(int[] a, int[] b) {
        if (a == null || b == null) return false;
        int lenMenor = Math.min(a.length, b.length);
        int lenMayor = Math.max(a.length, b.length);
        // Revisar parte común
        for (int i = 0; i < lenMenor; i++) {
            if (a[i] != b[i]) return false;
        }
        // Si longitudes iguales terminamos
        if (a.length == b.length) return true;
        // Revisar cola del mayor
        int[] mayor = a.length > b.length ? a : b;
        for (int i = lenMenor; i < lenMayor; i++) {
            if (mayor[i] != 0) return false;
        }
        return true;
    }
    // PLANTILLA PARA TI:
    // public static boolean compararConValorDeRelleno(int[] a, int[] b, int relleno) {
    // }

    /* ============================================================= */
    /* 10. COMPACTAR VALOR (MOVER AL FINAL)                          */
    /* ============================================================= */
    /**
     * ? ENUNCIADO: compactarValorAlFinal(int[] v, int valor) mueve todas las apariciones de 'valor' al FINAL (manteniendo orden de los demás).
     * * EXPLICACIÓN: Dos fases lógicas en una pasada: copiamos los que NO son 'valor' al frente usando índice libre; rellenamos resto con 'valor'.
     * * DETALLE: Algoritmo in-place O(n). Ejemplo: [2,0,5,0,7] -> compactar 0 -> [2,5,7,0,0].
     * ! PARA TI: Implementa compactarValoresAlFinal(int[] v, int[] valores) que mueva UN CONJUNTO de valores al final.
     */
    public static void compactarValorAlFinal(int[] v, int valor) {
        if (v == null) return;
        int libre = 0;
        for (int i = 0; i < v.length; i++) {
            if (v[i] != valor) {
                v[libre++] = v[i];
            }
        }
        while (libre < v.length) v[libre++] = valor;
    }
    // PLANTILLA PARA TI:
    // public static void compactarValoresAlFinal(int[] v, int[] valores) {
    // }

    /* ============================================================= */
    /* 11. ELIMINAR REPETIDOS (ÚNICOS)                               */
    /* ============================================================= */
    /**
     * ? ENUNCIADO: eliminarRepetidos(int[] v) devuelve nuevo array sólo con valores únicos conservando orden de primera aparición.
     * * EXPLICACIÓN: Usamos array temporal; cada nuevo valor se verifica contra los ya guardados. count lleva cuántos únicos.
     * * DETALLE: Complejidad O(n^2) en peor caso (sin estructuras auxiliares). Mejora: usar HashSet para O(n) si se permite.
     * ! PARA TI: Implementa eliminarRepetidosOrden(int[] v) usando Arrays.sort primero y luego filtrando adyacentes.
     */
    public static int[] eliminarRepetidos(int[] v) {
        if (v == null) return new int[0];
        int[] temp = new int[v.length];
        int count = 0;
        for (int x : v) {
            boolean repetido = false;
            for (int j = 0; j < count; j++) {
                if (temp[j] == x) { repetido = true; break; }
            }
            if (!repetido) temp[count++] = x;
        }
        return Arrays.copyOf(temp, count);
    }
    // PLANTILLA PARA TI:
    // public static int[] eliminarRepetidosOrden(int[] v) {
    // }

    /* ============================================================= */
    /* 12. COMPROBAR SI ARRAY ESTÁ ORDENADO                          */
    /* ============================================================= */
    /**
     * ? ENUNCIADO: estaOrdenadoEstricto(int[] v) devuelve true si cada elemento es <= siguiente (orden no descendente).
     * * EXPLICACIÓN: Comparamos v[i] con v[i+1]; si encontramos v[i] > v[i+1] no está ordenado.
     * * DETALLE: O(n). Orden "no descendente" permite iguales. Para estrictamente creciente usar > en vez de >=.
     * ! PARA TI: Implementa estaOrdenadoDescendente(int[] v) que compruebe orden de mayor a menor.
     */
    public static boolean estaOrdenadoEstricto(int[] v) {
        if (v == null || v.length < 2) return true;
        for (int i = 0; i < v.length - 1; i++) {
            if (v[i] > v[i + 1]) return false;
        }
        return true;
    }
    // PLANTILLA PARA TI:
    // public static boolean estaOrdenadoDescendente(int[] v) {
    // }

    /* ============================================================= */
    /* FIN GUÍA                                                      */
    /* ============================================================= */
}
