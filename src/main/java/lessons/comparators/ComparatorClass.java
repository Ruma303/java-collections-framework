package lessons.comparators;

import java.util.*;

class Persona {
    private String nome;
    private int eta;

    public Persona(String nome, int eta) {
        this.nome = nome;
        this.eta = eta;
    }

    public int getEta() {
        return eta;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return nome + " (" + eta + ")";
    }
}

// Ordinamenti personalizzati
class OrdinaPerNome implements Comparator<Persona> {
    @Override
    public int compare(Persona p1, Persona p2) {
        return p1.getNome().compareTo(p2.getNome());
    }
}

class OrdinaPerEta implements Comparator<Persona> {
    @Override
    public int compare(Persona p1, Persona p2) {
        return Integer.compare(p1.getEta(), p2.getEta());
    }
}

// Ordinamenti anche combinati
class OrdinaPerEtaENome implements Comparator<Persona> {
    @Override
    public int compare(Persona p1, Persona p2) {
        int byAge = Integer.compare(p1.getEta(), p2.getEta());
        return (byAge != 0) ? byAge : p1.getNome().compareTo(p2.getNome());
    }
}

public class ComparatorClass {
    public static void main(String[] args) {
        List<Persona> persone1 = new ArrayList<>();
        persone1.add(new Persona("Mario", 30));
        persone1.add(new Persona("Andrea", 30));
        persone1.add(new Persona("Anna", 25));
        persone1.add(new Persona("Tiziana", 35));
        persone1.add(new Persona("Luca", 35));

        // Altre liste indipendenti inizializzate
        List<Persona> persone2 = new ArrayList<>(persone1);
        List<Persona> persone3 = new ArrayList<>(persone1);
        List<Persona> persone4 = new ArrayList<>(persone1);
        List<Persona> persone5 = new ArrayList<>(persone1);
        List<Persona> persone6 = new ArrayList<>(persone1);

        // Ordinamento per nome usando un Comparator
        System.out.println("\nOrdinamento per nome");
        Collections.sort(persone1, new OrdinaPerNome());
        for (Persona p : persone1) {
            System.out.println(p);
        }

        // oppure
        System.out.println("\nOrdinamento per età");
        persone2.sort(new OrdinaPerEta());
        for (Persona p : persone2) {
            System.out.println(p);
        }

        // oppure
        System.out.println("\nOrdinamento per età oppure nome");
        persone3.sort(new OrdinaPerEtaENome());
        for (Persona p : persone3) {
            System.out.println(p);
        }


        // Comparatore inline con classi anonime
        persone1.sort(new Comparator<Persona>() {
            @Override
            public int compare(Persona p1, Persona p2) {
                return p1.getNome().compareTo(p2.getNome());
            }
        });
        persone4.sort(new OrdinaPerEta());


        // Comparator Lamba
        persone5.sort((p1, p2) -> p1.getNome().compareTo(p2.getNome()));
        System.out.println("\nOrdinamento inline per nome:");
        persone5.forEach(System.out::println);


        // Esempi con stream()
        System.out.println("\nOrdinamento inline per età e nome:");
        persone6.stream()
                .sorted(
                    Comparator.comparingInt(Persona::getEta)
                    .thenComparing(Persona::getNome))
                .forEach(System.out::println);
    }
}
