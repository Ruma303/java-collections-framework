package lessons.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParallelStreams {

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Alice", 23),
                new Person("Bob", 17),
                new Person("Charlie", 19),
                new Person("David", 25),
                new Person("Eve", 30)
        );

        // Uso di parallelStream()
        List<String> adultNamesParallelStream = people.parallelStream()
            .filter(person -> person.getAge() >= 18)
            .map(Person::getName)
            .map(String::toUpperCase)
            .sorted()
            .collect(Collectors.toList());

        System.out.println("ParallelStream Output: " + adultNamesParallelStream);
        
        // Uso di stream().parallel()
        List<String> adultNamesParallelMethod = people.stream()
            .parallel()
            .filter(person -> person.getAge() >= 18)
            .map(Person::getName)
            .map(String::toUpperCase)
            .sorted()
            .collect(Collectors.toList());

        System.out.println("Stream().parallel() Output: " + adultNamesParallelMethod);
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
