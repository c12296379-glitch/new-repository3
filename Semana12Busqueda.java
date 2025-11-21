public class Semana12Busqueda {

    //  BÚSQUEDA LINEAL
    public static int busquedaLineal(int[] lista, int objetivo) {
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] == objetivo) {
                return i;
            }
        }
        return -1;
    }


    //  BÚSQUEDA BINARIA (requiere lista ordenada)
 
    public static int busquedaBinaria(int[] lista, int objetivo) {
        int izquierda = 0;
        int derecha = lista.length - 1;

        while (izquierda <= derecha) {
            int medio = (izquierda + derecha) / 2;

            if (lista[medio] == objetivo) {
                return medio;
            } else if (lista[medio] < objetivo) {
                izquierda = medio + 1;
            } else {
                derecha = medio - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        // Creamos una lista grande: 1 a 1 millón
        int tamaño = 1_000_000;
        int[] lista = new int[tamaño];
        
        for (int i = 0; i < tamaño; i++) {
            lista[i] = i + 1;
        }

        int objetivo = 999_999;

        System.out.println("=== COMPARACIÓN DE BÚSQUEDA LINEAL VS BINARIA ===\n");

        // BÚSQUEDA LINEAL 
        long inicio = System.currentTimeMillis();
        int resultadoLineal = busquedaLineal(lista, objetivo);
        long fin = System.currentTimeMillis();
        long tiempoLineal = fin - inicio;

        System.out.println("Búsqueda Lineal → índice: " + resultadoLineal +
                ", tiempo: " + tiempoLineal + " ms");

        //BÚSQUEDA BINARIA
        inicio = System.currentTimeMillis();
        int resultadoBinaria = busquedaBinaria(lista, objetivo);
        fin = System.currentTimeMillis();
        long tiempoBinaria = fin - inicio;

        System.out.println("Búsqueda Binaria → índice: " + resultadoBinaria +
                ", tiempo: " + tiempoBinaria + " ms\n");

        System.out.println("Conclusión:");
        System.out.println("La búsqueda binaria es MUCHO más rápida en listas grandes.");
    }
}
