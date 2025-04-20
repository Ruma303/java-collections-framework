package lessons.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {

		// --- Creazione stream

		// Creazione stream da collezione
		List<Number> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		Stream<Number> streamFromCollection = numbers.stream();

		// Stream da array
		String[] array = new String[] { "a", "b", "c" };
		Stream<String> streamFromArray = Arrays.stream(array);

		// Stream da valori
		Stream<Object> streamOfValues = Stream.of(true, 2, "three");

		// Stream infinito
		Stream<Integer> infiniteStream = Stream.iterate(0, i -> i + 1);

		// --- Metodi di modifica
		System.out.println("\nMetodi di modifica:");

		// Stream con limitazione
		Stream<Integer> limitedStream = infiniteStream.limit(10);

		// Stream con skip
		Stream<Integer> skippedStream = limitedStream.skip(5);

		// Stream con filtraggio
		Stream<Integer> filteredStream = skippedStream.filter(i -> i % 2 == 0);

		// Stream con mapping
		Stream<Integer> mappedStream = filteredStream.map(i -> i * 2);

		// Stream con ordinamento
		Stream<Integer> sortedStream = mappedStream.sorted();

		// Stream con riduzione
		Optional<Integer> reducedStream = sortedStream.reduce((a, b) -> a + b);
		
		// Stream distinct
		Stream<Integer> distinctStream = Stream.of(1, 2, 2, 3, 3, 3, 4, 4, 4, 4).distinct();

		// --- Metodi di consumo
		System.out.println("\nMetodi di consumo:");

		// Stream che raccoglie elementi in una collazione
		Set<Integer> set = (Set<Integer>) Stream.iterate(0, i -> i + 1) // Creazione stream infinito
				.limit(20) // Limitazione a 20 elementi
				.distinct() // Eliminazione dei duplicati
				.map(n -> n * 2) // Moltiplicazione per 2
				.sorted() // Ordinamento crescente
				.filter(i -> i % 2 == 0) // Filtraggio dei numeri pari
				.skip(3) // Salto dei primi tre elementi
				.collect(Collectors.toSet()); // Raccolta in un set

		set.forEach(System.out::println); // Stampa ogni elemento del set

		// Conteggio degli elementi
		long size = Stream.of(1, 2, 3, 4).count(); 
		System.out.println("Numero di elementi mappedStream: " + size);

		// Stampa del risultato
		System.out.println("Risultato compresso:");
		reducedStream.ifPresent(System.out::println);

		// Stream con ricerca
		Optional<Integer> foundStream = Stream.of(1, 2, 3, 4, 5)
				.filter(i -> i > 3).findAny();
		foundStream.ifPresent(System.out::println); // Stampa il risultato

	}
}
