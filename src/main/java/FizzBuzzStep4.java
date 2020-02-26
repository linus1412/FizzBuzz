import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;
import static java.util.stream.IntStream.rangeClosed;

public class FizzBuzzStep4 {

    public static String forRange(int from, int to) {

        List<Object> elements = rangeClosed(from, to).mapToObj(number -> {
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

        final String fizzBuzz = elements.stream()
            .map(Object::toString)
            .collect(joining(" "));


        final Map<String, Long> counts = elements.stream()
            .collect(groupingBy(o -> o instanceof String ? o.toString() : "integer", counting()));

        return String.format("%s %s %s %s %s %s", fizzBuzz,
            total(counts, "fizz"),
            total(counts, "buzz"),
            total(counts, "fizzbuzz"),
            total(counts, "lucky"),
            total(counts, "integer")
        );

    }

    private static String total(Map<String, Long> counts, String name) {
        return String.format("%s: %d", name, counts.get(name));
    }

}
