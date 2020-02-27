import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static java.lang.String.format;
import static java.util.stream.Collectors.*;
import static java.util.stream.IntStream.rangeClosed;

public class FizzBuzzStep4 {

    public static String forRange(int from, int to) {

        final var fizzBuzzElements = convertNumbersToFizzBuzzElements(from, to);
        final var elementCounts = elementCounts(fizzBuzzElements);

        return format("%s %s %s %s %s %s", fizzBuzzString(fizzBuzzElements),
            total(elementCounts, "fizz"),
            total(elementCounts, "buzz"),
            total(elementCounts, "fizzbuzz"),
            total(elementCounts, "lucky"),
            total(elementCounts, "integer")
        );

    }

    private static Map<String, Long> elementCounts(List<Object> fizzBuzzElements) {
        return fizzBuzzElements.stream()
            .collect(groupingBy(elementName(), counting()));
    }

    private static Function<Object, String> elementName() {
        return o -> o instanceof String ? o.toString() : "integer";
    }

    private static List<Object> convertNumbersToFizzBuzzElements(int from, int to) {
        return rangeClosed(from, to).mapToObj(number -> {
            if (("" + number).contains("3")) {
                return "lucky";
            } else if (number % 3 == 0 && number % 5 == 0) {
                return "fizzbuzz";
            } else if (number % 3 == 0) {
                return "fizz";
            } else if (number % 5 == 0) {
                return "buzz";
            } else return number;
        }).collect(toList());
    }

    private static String fizzBuzzString(List<Object> elements) {
        return elements.stream()
            .map(Object::toString)
            .collect(joining(" "));
    }

    private static String total(Map<String, Long> counts, String name) {
        return format("%s: %d", name, counts.get(name));
    }

}
