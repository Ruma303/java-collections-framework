package lessons.collection.list;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        // List
        List<String> list = List.of("B", "C");

        System.out.println(list.toString());

        // ArrayListClass
        List<String> list2 = new ArrayList(list);

        list2.add(0, "A");
        list2.add("D");
        list2.addAll(Arrays.asList("E", "F", "G"));
        System.out.println(list2.toString());

        System.out.println(list2.get(2));
        list2.set(1, "Z");
        System.out.println("Elemento in posizione 2 aggiornato: " + list2.get(1));

        Object first = list2.indexOf(list2.getFirst());
        System.out.println("Posizione primo elemento: " + first);

        Object last = list2.lastIndexOf(list2);
        System.out.println("Posizione ultimo elemento: " + last);

        List<String> firstThreeCharacters = list2.subList(0, 2);
        Iterator<String> it = list2.iterator();
        while (it.hasNext()) {
            System.out.print("\t" + it.next());
        }


        // LinkedList
        LinkedList<String> names = new LinkedList<>();
        names.add("Alice");      // [Alice]
        names.add("Bob");        // [Alice, Bob]
        names.addFirst("Zack"); // [Zack, Alice, Bob]
        names.addLast("Eve");   // [Zack, Alice, Bob, Eve]
        names.add(2, "Charlie"); // [Zack, Alice, Charlie, Bob, Eve]

        String firstName = names.getFirst(); // Zack
        String lastName = names.getLast();   // Eve
        String second = names.get(1);    // Alice

        for (String name : names) {
            System.out.println(name);
        }

        names.removeFirst();  // Rimuove Zack
        names.removeLast();   // Rimuove Eve
        names.remove(1);      // Rimuove Charlie

        boolean containsAlice = names.contains("Alice"); // true
        System.out.println("Esiste alice? " + containsAlice);

        names.forEach(System.out::println);

        // Vector
        Integer num = 10;
        List<Integer> copies =Collections.nCopies(5, num);
        Vector<Number> numbers = new Vector<>();
        numbers.add(num);

        System.out.println("\nVettori");
        for (Integer i : copies) {
            System.out.println(i);
        }


        // Stack
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("\nStack"); // 30
        System.out.println(stack.pop()); // 30


        // Queue
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(10);
        queue.offer(20);
        queue.offer(30);

        System.out.println("\nQueue"); // 30
        System.out.println(queue.poll()); // 10
    }
}
