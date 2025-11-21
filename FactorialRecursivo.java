public class FactorialRecursivo {

    public static int factorial(int n) {
        // Caso base
        if (n == 0 || n == 1) {
            return 1;
        } 
        // Caso recursivo
        else {
            return n * factorial(n - 1);
        }
    }

    public static void main(String[] args) {
        int numero = 5;
        System.out.println("Factorial de " + numero + " = " + factorial(numero));
    }
}
