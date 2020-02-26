import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FizzBuzzStep1Test {

    @Test
    public void fizBuzzTest() {
        String fizzBuzz = FizzBuzzStep1.forRange(1, 20);
        assertThat(fizzBuzz, is("1 2 fizz 4 buzz fizz 7 8 fizz buzz 11 fizz 13 14 fizzbuzz 16 17 fizz 19 buzz"));
    }

}
