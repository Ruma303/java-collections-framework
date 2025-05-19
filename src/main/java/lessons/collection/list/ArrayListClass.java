package lessons.collection.list;

import java.util.Collections;
import java.util.List;

public class ArrayListClass {
	public static void main(String[] args) {
		List<Integer> numeri = new java.util.ArrayList<>();
		numeri.add(5);
		numeri.add(1);
		numeri.add(10);
		numeri.add(3);

		// Ordinamento della lista
		Collections.sort(numeri);
		System.out.println("Lista ordinata: " + numeri);

		// Ordinamento decrescente tramite
		// Collections.reverse(numeri); // oppure
		// Collections.sort(numeri, Comparator.reverseOrder());
		System.out.println("Lista ordinata in modo decrescente: " + numeri);

		// Ricerca binaria dell'elemento 3
		int indice = Collections.binarySearch(numeri, 3);
		System.out.println("Indice dell'elemento 3: " + indice);

		// Trova l'elemento massimo
		int max = Collections.max(numeri);
		System.out.println("Elemento massimo: " + max);

		// Trova l'elemento minimo
		int min = Collections.min(numeri);
		System.out.println("Elemento minimo: " + min);

		// Mescolamento casuale della lista
		Collections.shuffle(numeri);
		System.out.println("Lista mescolata: " + numeri);

		// Copia di una lista in un'altra
		List<Integer> dest = new java.util.ArrayList<>(Collections.nCopies(numeri.size(), 0));
		Collections.copy(dest, numeri);
		System.out.println("Lista copiata: " + dest);

		// Riempimento della lista con il valore 0
		Collections.fill(numeri, 0);
		System.out.println("Lista riempita con 0: " + numeri);
	}
}