import static java.util.stream.Collectors.joining;
import static java.util.stream.IntStream.rangeClosed;

public class FizzBuzzStep2 {

    public static String forRange(int from, int to) {

        return rangeClosed(from, to).mapToObj(number -> {
            if (("" + number).contains("3")) {
                return "lucky";
            } else if (number % 3 == 0 && number % 5 == 0) {
                return "fizzbuzz";
            } else if (number % 3 == 0) {
                return "fizz";
            } else if (number % 5 == 0) {
                return "buzz";
            } else return "" + number;
        }).collect(joining(" "));

    }

}
