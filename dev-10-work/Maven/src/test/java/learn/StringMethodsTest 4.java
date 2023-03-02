package learn;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringMethodsTest {

    @Test
    void countDigits(String value) {
        int actual = StringMethods.countDigits(null);
        // A null string should return 0 counted digits.
        assertEquals(0, actual);

        actual = StringMethods.countDigits("");
        // An empty string should return 0 counted digits.
        assertEquals(0, actual);

        actual = StringMethods.countDigits("There are no digits in this string.");
        // A string without digits should return 0 counted digits.
        assertEquals(0, actual);


        actual = StringMethods.countDigits("5");
        // The string "5" should return 1 counted digit.
        assertEquals(0, actual);


        actual = StringMethods.countDigits("There are 12 sandwiches.");
        // "There are 12 sandwiches." should return 2 counted digits.
        assertEquals(0, actual);
    }
}