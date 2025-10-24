public class QuickSort {

    public static void quickSort(int[] A, int low, int high) {
        if (low < high) {
            int pi = particion(A, low, high);
            quickSort(A, low, pi - 1);
            quickSort(A, pi + 1, high);
        }
    }

    // funcion para colocar el pivote en su posicion correcta
    private static int particion(int[] A, int low, int high) {
        int pivote = A[high]; // elegir el último elemento como pivote
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (A[j] <= pivote) {
                i++;
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }

        int temp = A[i + 1];
        A[i + 1] = A[high];
        A[high] = temp;

        return i + 1;
    }

    // metodo para imprimir el arreglo
    public static void mostrar(int[] A) {
        for (int num : A) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] datos = {8, 3, 1, 7, 0, 10, 2};
        System.out.println("Arreglo original:");
        mostrar(datos);

        quickSort(datos, 0, datos.length - 1);

        System.out.println("arreglo ordenado con Quick Sort:");
        mostrar(datos);
    }
}
