import org.junit.jupiter.api.Test;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

public class EmailValidationTest {

    @Test
    public void testEmailValidation() {

        String regex = "^[A-Za-z0-9.+]+@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*\\.[A-Za-z]{2,}$";

        Pattern pattern = Pattern.compile(regex);

        assertTrue(pattern.matcher("test@example.com").matches());
        assertTrue(pattern.matcher("test@stu.vistula.edu.pl").matches());

        assertFalse(pattern.matcher("test@examplecom").matches());
        assertFalse(pattern.matcher("test@vistula..pl").matches());
    }
}
