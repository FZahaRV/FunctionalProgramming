package org.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class FunctionalProgramming {
    public String outputByOddIndex(List<String> names) {
         String filteredNames =  IntStream.range(0, names.size())
                .filter(i -> i % 2 == 0)
                .mapToObj(i -> (i + 1) + ". " + names.get(i))
                .collect(Collectors.joining(", "));
        return filteredNames + ".";
    }

    public List<String> sort(List<String> list){
        return list.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

    }
    public String sortNumbers(String[] numbers) {
        return Arrays.stream(String.join(" ", numbers)
                .replace(", ", " ")
                .split(" "))
                .sorted()
                .collect(Collectors.joining(", "));

    }
    public static Stream<Long> randomizer(long a, long c, long m) {
        long seed = System.currentTimeMillis() * -1;
        UnaryOperator<Long> generator = n -> (a * n + c) % m;
        return Stream.iterate(seed, generator).skip(1);
    }
    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second){
        T[] firstArray = (T[]) first.toArray();
        T[] secondArray = (T[]) second.toArray();
        int length = Math.min(firstArray.length, secondArray.length);
        return Stream.iterate(0, i -> i < length, i -> i + 1)
                .flatMap(i -> Stream.of(firstArray[i], secondArray[i]));
    }
}
public class Main {
    public static void main(String[] args) {
        FunctionalProgramming functionalProgramming = new FunctionalProgramming();
        List<String> names = Arrays.asList("John", "Bill", "Alex", "Lee", "Sam", "Elizabeth");
        String[] numbers = {"1, 2, 0", "4, 5"};
        Stream<Integer> first = Stream.of(1, 2, 3, 4);
        Stream<Integer> second = Stream.of(5, 6, 7, 8, 9);
        System.out.println("Task 1\n" + functionalProgramming.outputByOddIndex(names));
        System.out.println("Task 2\n" + functionalProgramming.sort(names));
        System.out.println("Task 3\n" + functionalProgramming.sortNumbers(numbers));
        Stream<Long> stream = FunctionalProgramming.randomizer(25214903917L, 11L, 2^48);
        List<Long> task4 = stream.limit(10).collect(Collectors.toList());
        List<Integer> task5 = FunctionalProgramming.zip(first, second).collect(Collectors.toList());
        System.out.println("Task 4\n" + task4 + "\nTask 5\n" + task5);
    }

}