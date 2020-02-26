import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FizzBuzzStep2Test {

    @Test
    public void fizBuzzTest() {
        String fizzBuzz = FizzBuzzStep2.forRange(1, 20);
        assertThat(fizzBuzz, is("1 2 lucky 4 buzz fizz 7 8 fizz buzz 11 fizz lucky 14 fizzbuzz 16 17 fizz 19 buzz"));
    }

}
