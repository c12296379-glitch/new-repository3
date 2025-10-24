public class ShellSort {

    public static void shellSort(int[] A) {
        int n = A.length;
        int h = 1;

     // secuencia de incrementos: 1, 4, 13, 40, ...
        while (h < n / 3) {
            h = 3 * h + 1;
        }

        // Ordenar usando los incrementos
        while (h >= 1) {
            for (int i = h; i < n; i++) {
                int j = i;
                int temp = A[i];
                while (j >= h && A[j - h] > temp) {
                    A[j] = A[j - h];
                    j -= h;
                }
                A[j] = temp;
            }
            h = h / 3; // reducir el incremento
        }
    }

    // metodo para imprimir el arreglo
    public static void mostrar(int[] A) {
        for (int num : A) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] datos = {38, 27, 43, 3, 9, 82, 10};
        System.out.println("Arreglo original:");
        mostrar(datos);

        shellSort(datos);

        System.out.println("arreglo ordenado con Shell Sort:");
        mostrar(datos);
    }
}
