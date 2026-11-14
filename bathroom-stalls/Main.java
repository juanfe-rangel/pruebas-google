import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int caso = 1; caso <= T; caso++) {

            long N = sc.nextLong();
            long K = sc.nextLong();

            // Guarda el número de espacios disponibles de cada tamaño
            TreeMap<Long, Long> espacios = new TreeMap<>(Collections.reverseOrder());

            // Inicialmente existe un único espacio de tamaño N
            espacios.put(N, 1L);

            long max = 0;
            long min = 0;

            while (true) {

                // Obtener el espacio vacío más grande
                long tamano = espacios.firstKey();

                // Cantidad de espacios que tienen ese tamaño
                long cantidad = espacios.get(tamano);

                espacios.remove(tamano);

                // Dividir el espacio en los dos nuevos segmentos
                long izquierda = (tamano - 1) / 2;
                long derecha = tamano / 2;

                // Si la última persona está dentro de este grupo
                if (K <= cantidad) {

                    max = Math.max(izquierda, derecha);
                    min = Math.min(izquierda, derecha);

                    break;
                }

                K -= cantidad;

                // Agregar los nuevos espacios al mapa
                espacios.put(
                    derecha,
                    espacios.getOrDefault(derecha, 0L) + cantidad
                );

                espacios.put(
                    izquierda,
                    espacios.getOrDefault(izquierda, 0L) + cantidad
                );
            }

            System.out.println(
                "Case #" + caso + ": " + max + " " + min
            );
        }

        sc.close();
    }
}
