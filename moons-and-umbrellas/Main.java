import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {

            long X = sc.nextLong();
            long Y = sc.nextLong();
            String S = sc.next();

            long INF = Long.MAX_VALUE / 4;

            long costoC = INF;
            long costoJ = INF;

            if (S.charAt(0) == 'C' || S.charAt(0) == '?') {
                costoC = 0;
            }

            if (S.charAt(0) == 'J' || S.charAt(0) == '?') {
                costoJ = 0;
            }

            for (int i = 1; i < S.length(); i++) {

                char actual = S.charAt(i);

                long nuevoC = INF;
                long nuevoJ = INF;

                if (actual == 'C' || actual == '?') {
                    nuevoC = Math.min(costoC, costoJ + Y);
                }

                // Si el carácter actual puede ser J
                if (actual == 'J' || actual == '?') {
                    nuevoJ = Math.min(costoJ, costoC + X);
                }

                costoC = nuevoC;
                costoJ = nuevoJ;
            }

            long respuesta = Math.min(costoC, costoJ);

            System.out.println("Case #" + t + ": " + respuesta);
        }

        sc.close();
    }
}
