package org.FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
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