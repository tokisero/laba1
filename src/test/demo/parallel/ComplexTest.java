package test.demo.parallel;

import demo.parallel.Complex;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ComplexTest {
    private static final double DELTA = 1e-15;

    @Test
    public void testPlus() {
        Complex a = new Complex(1, 2);
        Complex b = new Complex(3, 4);
        a.plus(b);
        assertEquals(4.0, a.re, DELTA);
        assertEquals(6.0, a.im, DELTA);
    }

    @Test
    public void testTimes() {
        Complex a = new Complex(1, 2);
        Complex b = new Complex(3, 4);
        a.times(b);
        assertEquals(-5.0, a.re, DELTA);  // (1*3 - 2*4) = -5
        assertEquals(10.0, a.im, DELTA);  // (1*4 + 2*3) = 10
    }

    @Test
    public void testMinus() {
        Complex a = new Complex(1, 2);
        Complex b = new Complex(3, 4);
        a.minus(b);
        assertEquals(-2.0, a.re, DELTA);
        assertEquals(-2.0, a.im, DELTA);
    }

    @Test
    public void testDivide() {
        Complex a = new Complex(1, 2);
        Complex b = new Complex(3, 4);
        a.divide(b);
        assertEquals(11.0 / 25, a.re, DELTA);  // 0.44
        assertEquals(2.0 / 25, a.im, DELTA);   // 0.08
    }

    @Test
    public void testDivideByZero() {
        Complex a = new Complex(1, 2);
        Complex b = new Complex(0, 0);
        a.divide(b);
        assertEquals(0.0, a.re, DELTA);
        assertEquals(0.0, a.im, DELTA);
    }
}