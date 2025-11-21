/******************************************************************************************
 *  Curso de Programacion en Java - Autor: Joaquin Rodriguez Llanes
 *  Unidad 8: Arrays + Strings (Version para el Alumno)
 *  Practica guiada para rellenar con soluciones propias siguiendo el estilo del curso.
 *
 *  Leyenda Better Comments para este archivo:
 *      // ?  Dato extra o contexto teorico
 *      // *  Paso guiado que debes seguir
 *      // !  Aviso importante o recordatorio
 *      // TODO (Alumno)  Trabajo que debes completar
 *      // Reto extra    Desafio opcional para subir de nivel
 ******************************************************************************************/

import java.util.Arrays;
import java.util.Scanner;

public class UT8_ArraysYStrings_Alumno {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("\n== MENU PRACTICAS UNIDAD 8 (ALUMNO) ==");
            System.out.println("1  - [Lv.0] Demo de array fijo (sin Scanner)");
            System.out.println("2  - [Lv.1] Captura basica de palabras");
            System.out.println("3  - [Lv.2] Filtro de palabras que inician con vocal");
            System.out.println("4  - [Lv.3] Clasificar palabras segun longitud");
            System.out.println("5  - [Lv.4] Buscador lineal dentro de un array");
            System.out.println("6  - [Lv.4] Contar repeticiones en una frase");
            System.out.println("7  - [Lv.5] Split + trim para limpiar entradas");
            System.out.println("8  - [Lv.6] Ordenar alfabeticamente y analizar extremos");
            System.out.println("9  - [Lv.7] Construir frases con String.join");
            System.out.println("10 - [Lv.8] Matriz 3x3 de palabras");
            System.out.println("0  - Salir");
            System.out.print("Elige una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> practicaDemoFijo();
                case 2 -> practicaCapturaBasica(sc);
                case 3 -> practicaVocales(sc);
                case 4 -> practicaLongitudes(sc);
                case 5 -> practicaBuscador(sc);
                case 6 -> practicaContador(sc);
                case 7 -> practicaSplit(sc);
                case 8 -> practicaOrdenar(sc);
                case 9 -> practicaJoin(sc);
                case 10 -> practicaMatriz(sc);
                case 0 -> System.out.println("Saliendo del modo practica...");
                default -> System.out.println("Opcion no valida, intenta de nuevo.");
            }
        } while (opcion != 0);

        sc.close();
    }

    private static void practicaDemoFijo() {
        System.out.println("\n[Lv.0] Demo teorica con un array ya inicializado");

        String[] demoPalabras = {"sol", "luz", "cielo", "codigo"};
        System.out.println("Array de ejemplo: " + Arrays.toString(demoPalabras));

        // ? Objetivo: Calentamiento rapido solo observando como se guardan los datos.
        // * Paso 1: Identifica el numero de posiciones del array (length).
        // * Paso 2: Localiza el elemento central y cambialo por otra palabra.
        // TODO (Alumno): Imprime el primer y el ultimo elemento usando sus indices.
        // TODO (Alumno): Sustituye demoPalabras[2] por una palabra inventada y vuelve a imprimir todo el array.
        // TODO (Alumno): Usa un bucle foreach para mostrar cada palabra precedida de su numero de letras.
        // Reto extra: Crea un segundo array demoNumeros con edades y relaciona cada edad con cada palabra.
    }

    private static void practicaCapturaBasica(Scanner sc) {
        System.out.println("\n[Lv.1] Captura de palabras usando Scanner y for");

        String[] palabras = new String[4];

        // ? Objetivo: Practicar lectura con nextLine y repaso del bucle for clasico.
        // * Paso 1: Recorre el array y guarda en cada posicion la palabra que escriba el usuario.
        // * Paso 2: Muestra el array completo con Arrays.toString.
        // TODO (Alumno): Completa el bucle for para pedir 4 palabras y guardarlas en `palabras`.
        for (int i = 0; i < palabras.length; i++) {
            // TODO (Alumno): Pide "Palabra i:" y asigna sc.nextLine() al indice correspondiente.
        }
        // TODO (Alumno): Imprime el array completo.
        // TODO (Alumno): Usa un segundo bucle para imprimir "Posicion X -> palabra".
        // Reto extra: Pregunta al usuario si quiere cambiar alguna palabra (por indice) y actualiza el array.
    }

    private static void practicaVocales(Scanner sc) {
        System.out.println("\n[Lv.2] Array de cinco palabras y filtro por vocal inicial");

        String[] palabras = new String[5];

        // ? Objetivo: Reforzar condicionales evaluando el primer caracter de cada palabra.
        // ! Recuerda limpiar el buffer antes if usas nextInt en otra parte del programa.
        // * Paso 1: Rellena el array con 5 palabras.
        // * Paso 2: Recorre el array, transforma el primer caracter a minuscula y comprueba si es vocal.
        // * Paso 3: Cuenta cuantas palabras empiezan por vocal y cuantas no.
        // TODO (Alumno): Pide las 5 palabras al usuario (usa un for o while).
        // TODO (Alumno): Usa char primeraLetra = palabra.toLowerCase().charAt(0);
        // TODO (Alumno): Muestra solo aquellas que empiecen por a, e, i, o, u.
        // TODO (Alumno): Al final imprime "Total con vocal: X" y "Total sin vocal: Y".
        // Reto extra: Guarda las palabras que NO empiezan por vocal en un segundo array auxiliar.
    }

    private static void practicaLongitudes(Scanner sc) {
        System.out.println("\n[Lv.3] Clasificar palabras segun longitud");

        System.out.print("Cuantas palabras vas a ingresar? ");
        int cantidad = sc.nextInt();
        sc.nextLine();

        String[] palabras = new String[cantidad];
        System.out.print("Longitud minima para considerar una palabra 'larga': ");
        int longitudMinima = sc.nextInt();
        sc.nextLine();

        // ? Objetivo: Separar palabras largas de cortas y sumar la cantidad de caracteres total.
        // * Paso 1: Llena el array `palabras` con la cantidad indicada.
        // * Paso 2: Recorre y clasifica en funcion de longitudMinima.
        // * Paso 3: Calcula la suma total de caracteres de todas las palabras.
        // TODO (Alumno): Completa la captura de datos en el array.
        // TODO (Alumno): Guarda en strings separados (o arrays auxiliares) las palabras largas/cortas.
        // TODO (Alumno): Muestra ejemplo: "Largas (>= X): [ ... ]" y "Cortas (< X): [ ... ]".
        // TODO (Alumno): Calcula `int totalLetras` y muestralo.
        // Reto extra: Encuentra la palabra exacta con mayor cantidad de letras y la mas corta.
    }

    private static void practicaBuscador(Scanner sc) {
        System.out.println("\n[Lv.4] Buscador lineal dentro de un array");

        String[] biblioteca = new String[8];

        // ? Objetivo: Practicar la busqueda secuencial y el uso de equalsIgnoreCase.
        // * Paso 1: Rellena el array pidiendo 8 titulos (libros, series o pelis).
        // * Paso 2: Pregunta por el titulo a buscar y recorre el array.
        // * Paso 3: Si lo encuentras, muestra la posicion. Si no, ofrece agregarlo.
        // TODO (Alumno): Completa la carga de datos para el array `biblioteca`.
        // TODO (Alumno): Declara boolean encontrado = false e int indiceEncontrado = -1.
        // TODO (Alumno): Si encuentras coincidencia, rompe el bucle y muestra el resultado.
        // TODO (Alumno): Si no existe, pregunta "¿Deseas guardarlo en la ultima posicion? (s/n)" y actualiza.
        // Reto extra: Permite al usuario buscar varias veces sin volver al menu principal.
    }

    private static void practicaContador(Scanner sc) {
        System.out.println("\n[Lv.4] Contar repeticiones de una palabra en una frase");

        System.out.print("Escribe una frase: ");
        String frase = sc.nextLine();
        System.out.print("Que palabra quieres contar? ");
        String objetivo = sc.nextLine();

        // ? Objetivo: Practicar split, comparaciones ignorando mayusculas y contadores.
        // * Paso 1: Pasar tanto la frase como la palabra objetivo a minusculas (o mayusculas).
        // * Paso 2: Usar split(" ") para separar por espacios.
        // * Paso 3: Recorrer el array y contar coincidencias.
        // TODO (Alumno): Normaliza la frase con fraseLower = frase.toLowerCase().
        // TODO (Alumno): Muestra cuantas veces aparece la palabra buscada.
        // TODO (Alumno): Guarda los indices (posiciones del array resultante) donde la encontraste.
        // Reto extra: Usa indexOf en un while para localizar la posicion exacta dentro de la frase completa.
    }

    private static void practicaSplit(Scanner sc) {
        System.out.println("\n[Lv.5] Trabajando con split y trim");

        System.out.print("Escribe varios elementos separados por comas: ");
        String lista = sc.nextLine();

        String[] elementos = lista.split(",");

        // ? Objetivo: Limpiar espacios innecesarios y filtrar segun condicion.
        // * Paso 1: Recorre `elementos` y aplica trim() para eliminar espacios.
        // * Paso 2: Guarda el primer y ultimo elemento validos.
        // * Paso 3: Crea una coleccion nueva solo con los elementos que contienen la letra 'a'.
        // TODO (Alumno): Normaliza cada valor con trim y sobrescribelo en el array original.
        // TODO (Alumno): Muestra "Primero:" y "Ultimo:" usando indices 0 y length - 1.
        // TODO (Alumno): Construye un nuevo array (o usa ArrayList) con los elementos que contienen 'a'.
        // TODO (Alumno): Convierte ese nuevo array en texto con Arrays.toString o String.join.
        // Reto extra: Permite elegir la letra de filtrado en lugar de dejarla fija en 'a'.
    }

    private static void practicaOrdenar(Scanner sc) {
        System.out.println("\n[Lv.6] Ordenar palabras y mostrar extremos");

        System.out.print("Cuantas palabras vas a ordenar? ");
        int total = sc.nextInt();
        sc.nextLine();

        String[] palabras = new String[total];

        // ? Objetivo: Pon en practica Arrays.sort y analiza las palabras mas pequenas/grandes.
        // * Paso 1: Captura `total` palabras.
        // * Paso 2: Ordena el array con Arrays.sort(palabras).
        // * Paso 3: Identifica la primera y ultima palabra alfabeticamente.
        // * Paso 4: Encuentra la palabra con mas letras y la de menos letras.
        // TODO (Alumno): Implementa la captura y el sort.
        // TODO (Alumno): Despues del sort, imprime palabras[0] y palabras[total - 1].
        // TODO (Alumno): Usa un bucle para medir longitud de cada palabra y guardar la mas larga/corta.
        // Reto extra: Crea un segundo array ordenado de forma descendente sin usar un sort adicional.
    }

    private static void practicaJoin(Scanner sc) {
        System.out.println("\n[Lv.7] Construir frases con String.join");

        String[] palabrasDisponibles = {
            "sol", "luna", "mar", "montana", "bosque", "rio", "nube", "viento"
        };

        System.out.println("Palabras disponibles: " + Arrays.toString(palabrasDisponibles));

        // ? Objetivo: Practicar seleccion por indice y union de Strings.
        // * Paso 1: Pregunta cuantas palabras quiere usar el usuario.
        // * Paso 2: Permite elegir indices validos y construye una nueva lista.
        // * Paso 3: Usa String.join(" ", nuevaLista) para formar la frase final.
        // TODO (Alumno): Controla que el indice este entre 0 y palabrasDisponibles.length - 1.
        // TODO (Alumno): Guarda la seleccion en un nuevo array `seleccionadas`.
        // TODO (Alumno): Muestra la frase original, en mayusculas y en minusculas.
        // Reto extra: Invierte el orden de la frase y comprueba si es igual a la original (palindromo de palabras).
    }

    private static void practicaMatriz(Scanner sc) {
        System.out.println("\n[Lv.8] Matriz 3x3 de palabras");

        String[][] tablero = new String[3][3];

        // ? Objetivo: Combinar arrays bidimensionales con busqueda.
        // * Paso 1: Rellena la matriz pidiendo palabras fila por fila.
        // * Paso 2: Muestra el tablero en formato cuadrado.
        // * Paso 3: Extrae la diagonal principal en un array unidimensional.
        // * Paso 4: Busca una palabra concreta indicando fila y columna.
        // TODO (Alumno): Imprime "Fila X, Columna Y" al pedir cada palabra.
        // TODO (Alumno): Usa dos bucles for para mostrar el tablero como una cuadricula.
        // TODO (Alumno): Guarda tablero[i][i] dentro de un array diagonal[].
        // TODO (Alumno): Pregunta por una palabra a buscar y muestra su ubicacion si existe.
        // Reto extra: Sustituye automaticamente por "***" todas las palabras que empiecen por "a" y vuelve a imprimir.
    }
}
