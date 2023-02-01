import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Exercise01Test {

    @Test
    void add() {
        assertEquals(2, Exercise01.add(1, 1));
        assertEquals(0, Exercise01.add(112, -112));
        assertEquals(-256, Exercise01.add(-206, -50));
        assertEquals(256, Exercise01.add(150, 106));
        assertEquals(17, Exercise01.add(10, 7));
        assertEquals(-5, Exercise01.add(300, -305));
    }

    @Test
    void subtract() {
        assertEquals(0, Exercise01.subtract(10, 10));
        assertEquals(5, Exercise01.subtract(10, 5));
        assertEquals(-15, Exercise01.subtract(10, 25));
        assertEquals(100000, Exercise01.subtract(100001, 1));
        assertEquals(-200, Exercise01.subtract(50, 250));
        assertEquals(13, Exercise01.subtract(40, 27));
    }

    @Test
    public void testMultiply() {
        assertEquals(6, Exercise01.multiply(2, 3));
        assertEquals(16, Exercise01.multiply(4, 4));
        assertEquals(36, Exercise01.multiply(12, 3));
        assertEquals(56, Exercise01.multiply(8, 7));
        assertEquals(66, Exercise01.multiply(11, 6));
        assertEquals(96, Exercise01.multiply(12, 8));
    }

    @Test
    public void testDivide() {
        assertEquals(1, Exercise01.divide(3, 3));
        assertEquals(3, Exercise01.divide(21, 7));
        assertEquals(5, Exercise01.divide(15, 3));
        assertEquals(7, Exercise01.divide(21, 3));
        assertEquals(9, Exercise01.divide(27, 3));
        assertEquals(11, Exercise01.divide(33, 3));
    }
}