import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static class Actividad {
        int inicio;
        int fin;
        int indice;

        Actividad(int inicio, int fin, int indice) {
            this.inicio = inicio;
            this.fin = fin;
            this.indice = indice;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {

            int N = sc.nextInt();

            Actividad[] actividades = new Actividad[N];

            for (int i = 0; i < N; i++) {
                int inicio = sc.nextInt();
                int fin = sc.nextInt();

                actividades[i] = new Actividad(inicio, fin, i);
            }

            // Ordenar actividades por hora de inicio
            Arrays.sort(actividades, (a, b) ->
                Integer.compare(a.inicio, b.inicio)
            );

            char[] respuesta = new char[N];

            int finC = 0;
            int finJ = 0;

            boolean posible = true;

            for (int i = 0; i < N; i++) {

                Actividad actual = actividades[i];

                if (actual.inicio >= finC) {
                    respuesta[actual.indice] = 'C';
                    finC = actual.fin;
                }
                else if (actual.inicio >= finJ) {
                    respuesta[actual.indice] = 'J';
                    finJ = actual.fin;
                }
                else {
                    posible = false;
                    break;
                }
            }

            System.out.print("Case #" + t + ": ");

            if (posible) {
                System.out.println(new String(respuesta));
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }

        sc.close();
    }
}
