import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FizzBuzzStep3Test {

    @Test
    public void fizBuzzTest() {
        String fizzBuzz = FizzBuzzStep3.forRange(1, 20);
        assertThat(fizzBuzz, is("1 2 lucky 4 buzz fizz 7 8 fizz buzz 11 fizz lucky 14 fizzbuzz 16 17 fizz 19 buzz fizz: 4 buzz: 3 fizzbuzz: 1 lucky: 2 integer: 10"));
    }

}
