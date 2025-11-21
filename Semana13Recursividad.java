public class Semana13Recursividad {

    //  1. Recursividad: Factorial

    public static int factorial(int n) {
        if (n == 0 || n == 1) {     // Caso base
            return 1;
        }
        return n * factorial(n - 1);   // Llamada recursiva
    }

    //  2. Recursividad: Suma de números 1..n

    public static int sumaRecursiva(int n) {
        if (n == 0) {               // Caso base
            return 0;
        }
        return n + sumaRecursiva(n - 1);   // Llamada recursiva
    }


  
    //  3. Recursividad Indirecta
    //     A llama a B y B llama a A

    public static void metodoA(int x) {
        if (x <= 0) {
            System.out.println("Fin A");
            return;
        }
        System.out.println("A llamando a B con x=" + x);
        metodoB(x - 1);
    }

    public static void metodoB(int x) {
        if (x <= 0) {
            System.out.println("Fin B");
            return;
        }
        System.out.println("B llamando a A con x=" + x);
        metodoA(x - 2);
    }


    //  4. BACKTRACKING: Resolver un laberinto

    // 1 = camino posible
    // 0 = pared
    public static int[][] laberinto = {
            {1, 0, 1, 1},
            {1, 1, 1, 0},
            {0, 1, 0, 1},
            {1, 1, 1, 1}
    };

    public static int[][] solucion = new int[4][4];

    public static boolean resolverLaberinto(int fila, int col) {

        // Caso base: llegada a la meta (última celda)
        if (fila == 3 && col == 3) {
            solucion[fila][col] = 1;
            return true;
        }

        // Validar posición
        if (esValido(fila, col)) {
            solucion[fila][col] = 1; // marcar camino

            // Arriba
            if (resolverLaberinto(fila - 1, col)) return true;

            // Abajo
            if (resolverLaberinto(fila + 1, col)) return true;

            // Izquierda
            if (resolverLaberinto(fila, col - 1)) return true;

            // Derecha
            if (resolverLaberinto(fila, col + 1)) return true;

            // Si ninguna funcionó → BACKTRACK
            solucion[fila][col] = 0;
        }

        return false;
    }

    public static boolean esValido(int fila, int col) {
        return fila >= 0 && fila < 4 &&
               col >= 0 && col < 4 &&
               laberinto[fila][col] == 1 &&
               solucion[fila][col] == 0;
    }


    //  MAIN

    public static void main(String[] args) {

        System.out.println("=== RECURSIVIDAD: FACTORIAL ===");
        System.out.println("Factorial de 5: " + factorial(5));

        System.out.println("\n=== RECURSIVIDAD: SUMA ===");
        System.out.println("Suma 1..10: " + sumaRecursiva(10));

        System.out.println("\n=== RECURSIVIDAD INDIRECTa ===");
        metodoA(5);

        System.out.println("\n=== BACKTRACKING: LABERINTO ===");
        if (resolverLaberinto(0, 0)) {
            System.out.println("Solución encontrada:");
            mostrarMatriz(solucion);
        } else {
            System.out.println("No hay solución.");
        }
    }

    public static void mostrarMatriz(int[][] matriz) {
        for (int[] fila : matriz) {
            for (int val : fila) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}

