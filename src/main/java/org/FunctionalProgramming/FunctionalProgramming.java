package org.FunctionalProgramming;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FunctionalProgramming {
    public String outputByOddIndex(List<String> names) {
        String filteredNames = IntStream.range(0, names.size())
                .filter(i -> i % 2 == 0)
                .mapToObj(i -> (i + 1) + ". " + names.get(i))
                .collect(Collectors.joining(", "));
        return filteredNames + ".";
    }

    public List<String> sort(List<String> list) {
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

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        T[] firstArray = (T[]) first.toArray();
        T[] secondArray = (T[]) second.toArray();
        int length = Math.min(firstArray.length, secondArray.length);
        return Stream.iterate(0, i -> i < length, i -> i + 1)
                .flatMap(i -> Stream.of(firstArray[i], secondArray[i]));
    }
}
