import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.rangeClosed;

public class FizzBuzzStep3 {

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

        return fizzBuzz + " fizz: " + count(elements, o -> o.equals("fizz")) +
            " buzz: " + count(elements, o -> o.equals("buzz")) +
            " fizzbuzz: " + count(elements, o -> o.equals("fizzbuzz")) +
            " lucky: " + count(elements, o -> o.equals("lucky")) +
            " integer: " + count(elements, o -> o instanceof Integer);

    }

    private static long count(List<Object> elements, Predicate<Object> predicate) {
        return elements.stream().filter(predicate).count();
    }

}
