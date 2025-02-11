import java.util.scanner;

public class Esercizio {
    private static Random random = new Random();
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int n, coppie, cornici, i, j, k;
        boolean trovato;

        System.out.println("Inserisci il numero di listelli: ");
        n = input.nextInt();
        int[] listelli = new int[n];

        for (i = 0; i <= n - 1; i++) {
            listelli[i] = random.nextInt(7) + 4;
            System.out.println(listelli[i]);
        }
        trovato = false;
        coppie = 0;
        while (n >= 2 && trovato) {
            trovato = false;
            for (i = 0; i <= n - 2; i++) {
                for (j = i + 1; j <= n - 1; j++) {
                    if (listelli[i] == listelli[j]) {
                        n = rimuoviElemento(listelli, n, i);
                        n = rimuoviElemento(listelli, n, j);
                        trovato = true;
                        coppie = coppie + 1;
                        i = 0;
                    }
                }
            }
        }
        cornici = (double) coppie / 2;
        System.out.println("Ha fabbricato " + cornici + " cornici");
    }
    
    public static int rimuoviElemento(int[] vettore, int dimensione, int posizione) {
        int i;

        dimensione = dimensione - 1;
        for (i = posizione; i <= dimensione - 1; i++) {
            vettore[i] = vettore[i + 1];
        }
        
        return dimensione;
    }
}
