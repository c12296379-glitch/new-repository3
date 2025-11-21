public class LaberintoBacktracking {

    // 0 = camino, 1 = pared
    static int[][] laberinto = {
        {0, 0, 1, 0},
        {1, 0, 1, 0},
        {0, 0, 0, 0},
        {1, 1, 1, 0}
    };

    // Matriz para marcar la solución
    static int[][] solucion = new int[4][4];

    public static boolean resolver(int x, int y) {
        
        // Si llega a la meta (3,3)
        if (x == 3 && y == 3) {
            solucion[x][y] = 1;
            return true;
        }

        // Verificar que no se salga del mapa
        if (x < 0 || y < 0 || x >= 4 || y >= 4) {
            return false;
        }

        // Si es pared o ya fue visitado
        if (laberinto[x][y] == 1 || solucion[x][y] == 1) {
            return false;
        }

        // Marcar el camino actual
        solucion[x][y] = 1;

        // Intentar mover abajo
        if (resolver(x + 1, y)) return true;

        // Derecha
        if (resolver(x, y + 1)) return true;

        // Arriba
        if (resolver(x - 1, y)) return true;

        // Izquierda
        if (resolver(x, y - 1)) return true;

        // Si nada funciona → retroceder (BACKTRACKING)
        solucion[x][y] = 0;
        return false;
    }

    public static void main(String[] args) {

        if (resolver(0, 0)) {
            System.out.println("Camino encontrado:");
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    System.out.print(solucion[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("No hay solución");
        }
    }
}
