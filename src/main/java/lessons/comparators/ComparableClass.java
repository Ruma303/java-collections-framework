package lessons.comparators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Country implements Comparable<Country> {
    public String name;
    public int population;

    public Country(String name, int population) {
        this.name = name;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }

    // Ordinamento naturale per popolazione
//    @Override
//    public int compareTo(Country country){
//        return Integer.compare(this.population, country.population);
//    }

    @Override
    public int compareTo(Country country) {
        return String.CASE_INSENSITIVE_ORDER.compare(this.name, country.name);
    }

    @Override
    public String toString() {
        return this.getName() + " con una popolazione di: " + this.getPopulation() + " persone";
    }
}

public class ComparableClass {

    public static void main(String[] args) {
        List<Country> countries = new ArrayList<Country>(Arrays.asList(
                new Country("Spain", 47329981),
                new Country("Italy", 60317116),
                new Country("Germany", 81305856),
                new Country("France", 67391582)
        ));

         // Uso di Comparable
        System.out.println("Nazioni ordinate per popolazione: ");

        //Collections.sort(countries);
        // Oppure
        countries.sort(null); // null ⇒ usa Comparable

        int i = 0;
        for (Country country : countries) {
            System.out.println("\t" + (i++) + ": " + country.toString());
        }
    }
}
