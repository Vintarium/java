import com.example.vintilov.ValidationSystem.ValidationFailedException;
import com.example.vintilov.ValidationSystem.ValidationSystem;
import org.junit.Test;

import static org.junit.Assert.*;

public class ValidationSystemTest {

    @Test
    public void testValidateInt () throws ValidationFailedException {
        ValidationSystem.validate(1);
        ValidationSystem.validate(5);
        ValidationSystem.validate(10);
    }

    @Test (expected = ValidationFailedException.class)
    public void testValidateIntFail () throws ValidationFailedException {
        ValidationSystem.validate(11);
    }

    @Test (expected = ValidationFailedException.class)
    public void testValidateIntFails2 () throws ValidationFailedException {
        ValidationSystem.validate(0);
    }

    @Test
    public void testValidateString () throws ValidationFailedException {
        ValidationSystem.validate("Hello");
        ValidationSystem.validate("Hello world, abc");
    }

    @Test (expected = ValidationFailedException.class)
    public void testValidateStringFails() throws ValidationFailedException {
        ValidationSystem.validate("hello");
    }

    @Test(expected = ValidationFailedException.class)
    public void testValidateStringFails2() throws ValidationFailedException {
        ValidationSystem.validate(" ");
    }


}