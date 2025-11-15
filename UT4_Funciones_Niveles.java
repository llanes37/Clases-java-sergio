/*
 * ******************************************************************************************
 *                                   📚 UT4 – FUNCIONES POR NIVELES
 * ──────────────────────────────────────────────────────────────────────────────
 * Guía didáctica larga con ENUNCIADOS y EXPLICACIONES dentro de comentarios.
 * No hay menús ni mensajes didácticos en pantalla: el aprendizaje está en
 * los COMENTARIOS del código. Puedes descomentar llamadas en main() para
 * hacer pruebas si lo deseas, pero por defecto no imprime nada.
 *
 * Estructura de niveles (según la foto):
 *   NIVEL 2 → Suma, Mayor, Área triángulo, Es par, Factorial
 *   NIVEL 3 → Combinación: esPositivo + procedimiento, Menú con opciones,
 *              Promedio de notas (+ procedimiento), Conversión de temperatura
 *   NIVEL 4 → Calculadora modular, Números primos, Adivina el número,
 *              Gestor de alumnos
 *
 * En cada ejercicio encontrarás:
 *   - ENUNCIADO: lo que se pide.
 *   - EXPLICACIÓN: guía conceptual y de implementación.
 *   - CÓDIGO BASE: función/procedimiento listo para usar o extender.
 *   - PARA TI: mini‑reto o mejora inmediata (con plantilla comentada).
 * ******************************************************************************************
 */

// (Sin imports obligatorios; puedes usar java.util.Random si pruebas el juego)

public class UT4_Funciones_Niveles {

    /* ==================================================================== */
    /*                                MAIN                                  */
    /* ==================================================================== */
    public static void main(String[] args) {
        // Sugerencia: descomenta las pruebas que quieras ejecutar.
        // System.out.println(suma(3, 4));
        // System.out.println(mayor(9, 2));
        // System.out.println(areaTriangulo(10, 5));
        // System.out.println(esPar(12));
        // System.out.println(factorial(5));
        // System.out.println(promedio(new double[]{5, 7.5, 9}));
        // System.out.println(fahrenheit(25));
        // System.out.println(esPrimo(29));
        // int[] primos = primosHasta(30);
        // for (int p : primos) System.out.print(p + " ");
    }

    /* ==================================================================== */
    /*                               NIVEL 2                                */
    /* ==================================================================== */
    /*
     * 6) SUMA DE DOS NÚMEROS
     * ENUNCIADO: Escribe una función suma(int a, int b) que devuelva la suma.
     * EXPLICACIÓN: recibe dos enteros por parámetro y retorna a+b. Es pura (sin efectos secundarios).
     * PARA TI: añade una sobrecarga suma(double, double) y compara resultados con int.
     */

    /* Implementaciones Nivel 2 */
    /**
     * ENUNCIADO (Nivel 2 · Ej. 6)
     *  Crear una función suma(int a, int b) que devuelva la suma.
     * EXPLICACIÓN
     *  Recibe dos enteros y retorna a + b. Es una función pura: no modifica estado externo.
     * NOTA
     *  Con valores muy grandes puede ocurrir overflow del tipo int.
     * PARA TI
     *  Implementa una sobrecarga suma(double x, double y) y compárala con la versión int.
     */
    public static int suma(int a, int b) {
        int resultado = a + b; // cálculo directo
        return resultado;
    }
    // EJERCICIO (plantilla):
    // double suma(double x, double y) { return x + y; }

    /**
     * ENUNCIADO (Nivel 2 · Ej. 7)
     *  Función mayor(int a, int b) que devuelva el mayor de los dos.
     * EXPLICACIÓN
     *  Comparamos con if/else para mejorar claridad y evitar operador ternario.
     * PARA TI
     *  Crea mayor(int a, int b, int c) reutilizando esta función.
     */
    public static int mayor(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b; // si son iguales devuelve b indistintamente
        }
    }
    // EJERCICIO (plantilla):
    // int mayor(int a, int b, int c) { return mayor(mayor(a, b), c); }

    /**
     * ENUNCIADO (Nivel 2 · Ej. 8)
     *  areaTriangulo(double base, double altura) que devuelva su área.
     * EXPLICACIÓN
     *  Fórmula (base * altura) / 2. Tipo double para soportar decimales.
     * NOTA
     *  Puedes validar que base > 0 y altura > 0.
     * PARA TI
     *  Implementa areaCirculo(double r) = Math.PI * r * r (valida r > 0).
     */
    public static double areaTriangulo(double base, double altura) {
        double area = (base * altura) / 2.0;
        return area;
    }
    // EJERCICIO (plantilla):
    // double areaCirculo(double r) { if (r < 0) return -1; return Math.PI * r * r; }

    /**
     * ENUNCIADO (Nivel 2 · Ej. 9)
     *  esPar(int n) que devuelva true si el número es par.
     * EXPLICACIÓN
     *  Un número es par si n % 2 == 0.
     * PARA TI
     *  Implementa esImpar(int n) devolviendo !esPar(n).
     */
    public static boolean esPar(int n) {
        return n % 2 == 0;
    }
    // EJERCICIO (plantilla):
    // boolean esImpar(int n) { return !esPar(n); }

    /**
     * ENUNCIADO (Nivel 2 · Ej. 10)
     *  factorial(int n) que devuelva el factorial del número.
     * EXPLICACIÓN
     *  Caso base n == 0 -> 1; caso recursivo n * factorial(n-1).
     * NOTA
     *  Para n grande puede producir overflow o StackOverflowError.
     * PARA TI
     *  Implementa factorialIterativo(int n) usando un bucle.
     */
    public static long factorial(int n) {
        if (n < 0) {
            return -1; // error para negativos
        }
        if (n == 0) {
            return 1; // caso base
        }
        long resultado = n * factorial(n - 1);
        return resultado;
    }
    // EJERCICIO (plantilla):
    // long factorialIterativo(int n) {
    //     if (n < 0) return -1;
    //     long res = 1;
    //     for (int i = 2; i <= n; i++) res *= i;
    //     return res;
    // }

    // (sin recorrido automático: priorizamos comentarios sobre salidas)

    /* RETOS EXTRA NIVEL 2 (para seguir practicando)
     *  - Añade suma(long, long) y observa límites de tipo.
     *  - Implementa mayor(double, double) tratando el caso de igualdad.
     *  - Valida que base y altura sean > 0 en areaTriangulo.
     *  - Crea esMultiplo(int a, int b) y reutilízalo en esPar.
     *  - Implementa factorialIterativo(int n) y detecta overflow cuando el resultado sea negativo.
     */

    /* ==================================================================== */
    /*                               NIVEL 3                                */
    /* ==================================================================== */
    /*
     * 11) COMPROBACIÓN DE NÚMEROS
     * ENUNCIADO: Crea una función esPositivo(int n) que devuelve true si n>0.
     *            Luego, crea un procedimiento (void) mostrarPositividad(int n)
     *            que use esa función para decidir el mensaje a mostrar.
     * EXPLICACIÓN: separamos cálculo (boolean) de presentación (void).
     * PARA TI: añade esNegativo(int n) y refactoriza mostrarPositividad.
     *
     * 12) MENÚ CON OPCIONES
     * ENUNCIADO: Crea un pequeño menú que permita elegir entre sumar, restar,
     *            multiplicar o dividir. Cada operación será una función.
     * NOTA: Aquí dejamos plantillas de funciones. El menú queda como pseudocódigo
     *       en comentarios para no usar la consola en esta guía.
     *
     * 13) PROMEDIO DE NOTAS
     * ENUNCIADO: función promedio(double[] notas) que devuelve la media.
     *            Procedimiento mostrarPromedio(double[] notas) que indique si
     *            la persona aprueba o no (>=5).
     * PARA TI: implementa notaMaxima(double[] notas) y úsala para informar
     *          también de la mejor nota.
     *
     * 14) CONVERSIÓN DE TEMPERATURA
     * ENUNCIADO: crea funciones aCelsius(double f) y aFahrenheit(double c).
     * PARA TI: añade celsiusAKelvin(double) y kelvinACelsius(double).
     */

    /* Implementaciones Nivel 3 */
    // ? ENUNCIADO (Nivel 3 · Ej. 11): esPositivo(int n) que devuelve true si n>0.
    // * EXPLICACIÓN: Devuelve un boolean simple; se puede componer en otros métodos.
    /** Devuelve true si n es estrictamente mayor que 0. */
    public static boolean esPositivo(int n) { return n > 0; }
    // ? ENUNCIADO (Nivel 3 · Ej. 11): mostrarResultado(int n) que use esPositivo() y muestre mensaje.
    // * EXPLICACIÓN: Procedimiento (void) que reutiliza la función de comprobación.
    public static void mostrarResultado(int n) {
        // Procedimiento de ejemplo: imprime un mensaje simple sin colores.
        if (esPositivo(n)) System.out.println(n + " es positivo.");
        else if (n == 0) System.out.println("Es cero.");
        else System.out.println(n + " es negativo.");
    }
    // ? ENUNCIADO (Nivel 3 · Ej. 12): Funciones para sumar, restar, multiplicar y dividir.
    // * EXPLICACIÓN: Cada operación como función independiente permite crear un menú externo fácilmente.
    /**
     * ENUNCIADO (Nivel 3 · Ej. 12) restar(int a, int b).
     * EXPLICACIÓN: Operación aritmética básica.
     */
    public static int restar(int a, int b) {
        return a - b;
    }
    /**
     * ENUNCIADO (Nivel 3 · Ej. 12) multiplicar(int a, int b).
     * EXPLICACIÓN: Puede causar overflow si los números son grandes.
     */
    public static int multiplicar(int a, int b) {
        return a * b;
    }
    /**
     * ENUNCIADO (Nivel 3 · Ej. 12) dividir(int a, int b).
     * EXPLICACIÓN: Si b es 0 devolvemos Double.NaN para indicar error aritmético.
     * PARA TI: Lanza una excepción personalizada si b==0.
     */
    public static double dividir(int a, int b) {
        if (b == 0) {
            return Double.NaN;
        }
        double resultado = (double) a / b;
        return resultado;
    }

    // Pseudocódigo sugerido para el MENÚ (no ejecuta, sólo guía):
    // void menuOperaciones() {
    //   leer opción 1..4
    //   switch(op): llamar a suma/resta/multiplicación/división
    // }

    // ? ENUNCIADO (Nivel 3 · Ej. 13): promedio(double[] notas) que devuelva la media.
    // * EXPLICACIÓN: Suma todos los valores y divide entre el tamaño; si está vacío, retorna 0.
    /** Calcula la media aritmética de un array de doubles. */
    public static double promedio(double[] notas) {
        if (notas.length == 0) return 0;
        double suma = 0;
        for (double n : notas) suma += n;
        return suma / notas.length;
    }
    // ? ENUNCIADO (Nivel 3 · Ej. 13): Procedimiento mostrarPromedio(...) que indique si aprueba.
    // * EXPLICACIÓN: Mantén cálculo y presentación separados; facilita pruebas y reutilización.
    public static void mostrarPromedio(double[] notas) {
        double media = promedio(notas);
        System.out.printf("Media = %.2f%n", media);
        System.out.println(media >= 5.0 ? "Aprobado" : "Suspenso");
    }
    // ? ENUNCIADO (Nivel 3 · Ej. 14): Conversión de temperatura: a Celsius y a Fahrenheit.
    // * EXPLICACIÓN: Fórmulas directas, trabajan con double.
    /** Fahrenheit → Celsius. */
    public static double celsius(double f) { return (f - 32) * 5 / 9; }
    /** Celsius → Fahrenheit. */
    public static double fahrenheit(double c) { return c * 9 / 5 + 32; }
    // PARA TI (plantillas):
    // double celsiusAKelvin(double c) { return c + 273.15; }
    // double kelvinACelsius(double k) { return k - 273.15; }

    /* RETOS EXTRA NIVEL 3
     *  - Extrae la impresión del menú a un método imprimirMenuArit().
     *  - Crea dividirSeguro(int a, int b) con Optional<Double>.
     *  - Añade redondeo a 2 decimales en promedio usando Math.round.
     *  - Implementa evaluarNota(double n): "Excelente", "Bien", "Insuficiente".
     *  - Añade conversiones a Kelvin y crea mostrarTodasConversiones().
     */

    /* ==================================================================== */
    /*                               NIVEL 4                                */
    /* ==================================================================== */
    /*
     * 15) CALCULADORA MODULAR
     * ENUNCIADO: Crea una aplicación con funciones sumar, restar, multiplicar,
     *            dividir y un procedimiento menu() que las use según la opción.
     * NOTA: aquí nos quedamos con las funciones; el menú lo dejas como práctica.
     * PARA TI: añade raizCuadrada(double n) con validación n>=0.
     *
     * 16) NÚMEROS PRIMOS
     * ENUNCIADO: Implementa esPrimo(int n) y un procedimiento/función que
     *            muestre o devuelva todos los primos del 1 al 100.
     * EXPLICACIÓN: a efectos didácticos devolvemos un array con todos los primos
     *              hasta un límite para poder testear sin imprimir.
     *
     * 17) ADIVINA EL NÚMERO
     * ENUNCIADO: procedimiento principal del juego y función comparar(int guess,
     *            int secreto) que indique si el número es mayor, menor o igual.
     * NOTA: dejamos sólo la función comparar; el juego completo es un buen reto.
     *
     * 18) GESTOR DE ALUMNOS
     * ENUNCIADO: pedir datos de varios alumnos y funciones para calcular sus
     *            medias y determinar quién aprueba.
     * EXPLICACIÓN: incluimos funciones puras (sin imprimir) para facilitar tests.
     */

    /* Implementaciones Nivel 4 reutilizan funciones previas */
    // PARA TI (plantilla de menú):
    // void menu() {
    //   mostrar opciones; leer opción; llamar a la función correspondiente
    // }

    // ? ENUNCIADO (Nivel 4 · Ej. 16): esPrimo(int n) que devuelva true/false.
    // * EXPLICACIÓN: Prueba de divisores hasta √n, saltando pares para optimizar.
    public static boolean esPrimo(int n) {
        if (n <= 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        if (n % 2 == 0) {
            return false;
        }
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    // ? ENUNCIADO (Nivel 4 · Ej. 16): Listar todos los primos hasta un límite N.
    // * EXPLICACIÓN: Recorre [2..N], usa esPrimo y guarda en un array resultado.
    // ! PARA TI: Cambia a una implementación por Criba de Eratóstenes y compara tiempos.
    /** Devuelve un array con todos los primos en [1..limite]. */
    public static int[] primosHasta(int limite) {
        if (limite < 2) {
            return new int[0];
        }
        int count = 0;
        for (int i = 2; i <= limite; i++) {
            if (esPrimo(i)) {
                count++;
            }
        }
        int[] primos = new int[count];
        int idx = 0;
        for (int i = 2; i <= limite; i++) {
            if (esPrimo(i)) {
                primos[idx++] = i;
            }
        }
        return primos;
    }

    // ? ENUNCIADO (Nivel 4 · Ej. 17): comparar(int guess, int secreto) para el juego Adivina.
    // * EXPLICACIÓN: Devuelve 0 si acierta, -1 si guess<secreto, 1 si guess>secreto.
    // ! PARA TI: Implementa el bucle del juego con límite de intentos y mensajes.
    /** Compara intento con secreto. */
    private static int comparar(int adivinado, int secreto) {
        if (adivinado == secreto) {
            return 0;
        }
        if (adivinado < secreto) {
            return -1;
        }
        return 1;
    }
    // PARA TI (plantilla del juego):
    // void jugarAdivina() {
    //   int secreto = new Random().nextInt(100) + 1;
    //   while(intentos) { leer guess; int r = comparar(guess, secreto); ... }
    // }

    // ? ENUNCIADO (Nivel 4 · Ej. 18): Calcular media por alumno y decidir si aprueba.
    // * EXPLICACIÓN: Funciones puras para calcular; separa de la entrada/salida.
    /** Media de un alumno reutilizando promedio. */
    private static double mediaAlumno(double[] notas) { return promedio(notas); }
    /** Condición de aprobado configurable. */
    private static boolean aprueba(double media) { return media >= 5.0; }
    /**
     * Gestor simple de alumnos: pide nombres y notas, calcula medias y muestra resultado.
     * Buenas prácticas: separar entrada de datos, cálculo y salida para testear mejor.
     */
    /* RETOS EXTRA NIVEL 4
     *  - Calculadora: integra potencia y raíz, y prepara un menú limpio.
     *  - Adivina: limita intentos y guarda cuántos usó el jugador.
     *  - Primos: genera lista hasta N y compara con el método de Eratóstenes.
     *  - Gestor: calcula media global y porcentaje de aprobados del curso.
     */
}
