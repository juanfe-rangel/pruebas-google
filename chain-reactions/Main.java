import java.util.*;

public class Main {

    static List<Integer>[] hijos;
    static long[] F;
    static long respuesta;

    static long dfs(int nodo) {

        // Si no tiene hijos, devuelve su propia diversión
        if (hijos[nodo].isEmpty()) {
            return F[nodo];
        }

        long suma = 0;
        long minimo = Long.MAX_VALUE;

        // Procesar todos sus hijos
        for (int hijo : hijos[nodo]) {

            long valor = dfs(hijo);

            suma += valor;
            minimo = Math.min(minimo, valor);
        }

        respuesta += suma - minimo;

        return Math.max(F[nodo], minimo);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int caso = 1; caso <= T; caso++) {

            int N = sc.nextInt();

            F = new long[N + 1];
            hijos = new ArrayList[N + 1];

            for (int i = 1; i <= N; i++) {
                F[i] = sc.nextLong();
                hijos[i] = new ArrayList<>();
            }

            hijos[0] = new ArrayList<>();

            // Construir el árbol
            for (int i = 1; i <= N; i++) {
                int padre = sc.nextInt();
                hijos[padre].add(i);
            }

            respuesta = 0;

            // Procesar todos los iniciadores desde el nodo virtual 0
            for (int hijo : hijos[0]) {
                respuesta += dfs(hijo);
            }

            System.out.println("Case #" + caso + ": " + respuesta);
        }

        sc.close();
    }
}
