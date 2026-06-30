import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class TestMain {

    @Test
    public void testFormatDate() {
        // Get the Class object for the Main class
        Class<?> mainClass = Main.class;

        // Find the formatDate method
        Method formatDateMethod = null;
        try
        {
            formatDateMethod = mainClass.getDeclaredMethod("formatDate", int.class, int.class, int.class);
        } catch (NoSuchMethodException e)
        {
            fail("Method named formatDate with three int parameters not found.");
        }

        // Invoke the method using reflection (since it's static)
        String result = null;
        try
        {
            result = (String) formatDateMethod.invoke(null, 3, 5, 1965);
        } catch (IllegalAccessException e)
        {
            fail("formatDate is not public.");
        } catch (InvocationTargetException e)
        {
            fail("An error occurred calling formatDate: " + e.getMessage());
        }
        assertEquals("03/05/1965", result);
    }

    @Test
    public void testFormatCard() {
        try {
            // Get the Class object for the Main class
            Class<?> mainClass = Main.class;

            // Find the formatCard method
            Method formatCardMethod = mainClass.getDeclaredMethod(
                    "formatCard",
                    String.class, String.class, String.class, String.class,
                    String.class, String.class, char.class, String.class,
                    String.class, String.class, String.class
            );

            // Invoke the method using reflection
            String result = (String) formatCardMethod.invoke(
                    null,
                    "CHAPETON-LAMAS", "NERY", "C09", "SRC9876543210",
                    "Guatemala", "None", 'M', "012-004-789",
                    "01 JAN 1970", "02/02/2020", "02/02/2022"
            );

            // Define the expected card string
            String expectedCard = 
            "╔══════════════════════════════════════════════════════════════════════╗\n" +
            "║           UNITED STATES OF AMERICA                                   ║\n" +
            "║                               EMPLOYMENT AUTHORIZATION CARD          ║\n" +
            "║                         Surname                                      ║\n" +
            "║                         CHAPETON-LAMAS                               ║\n" +
            "║    .----.    .----.     Given Name                                   ║\n" +
            "║   (  --  \\  /  --  )    NERY                                         ║\n" +
            "║          |  |           USCIS#         Category       Card#          ║\n" +
            "║         _/  \\_          012-004-789    C09            SRC9876543210  ║\n" +
            "║        (_    _)         Country of Birth                             ║\n" +
            "║     ,    `--`    ,      Guatemala                                    ║\n" +
            "║     \\'-.______.-'/      Terms and Conditions                         ║\n" +
            "║      \\          /       None                                         ║\n" +
            "║       '.--..--.'        Date of Birth  Sex                           ║\n" +
            "║         `\"\"\"\"\"`         01 JAN 1970    M                             ║\n" +
            "║                         Valid From:    02/02/2020                    ║\n" +
            "║                         Card Expires:  02/02/2022                    ║\n" +
            "║   ascii art by: jgs     NOT VALID FOR REENTRY TO U.S.                ║\n" +
            "╚══════════════════════════════════════════════════════════════════════╝";

            // Assert that the result matches the expected card string
            assertEquals(expectedCard, result);
        } catch (NoSuchMethodException e)
        {
            fail("Method named formatCard with correct number and order of parameters not found.");
        } catch (IllegalAccessException e)
        {
            fail("formatCard is not public.");
        } catch (InvocationTargetException e)
        {
            fail("An error occurred calling formatCard: " + e.getMessage());
        }
    }
}