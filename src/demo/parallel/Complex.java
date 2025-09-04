/**
 * Complex number abstraction
 * @author Konstantin Bulenkov
 */
package demo.parallel;

/**
 * Complex number implementation
 */
public class Complex {
    /**
     * Real part
     */
    public double re;

    /**
     * Imaginary part
     */
    public double im;

    /**
     * Constructor for complex number
     * @param re real part
     * @param im imaginary part
     */
    public Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    /**
     * Addition operation.
     * @param b summand
     * @return this Complex object whose value is (this + b)
     */
    public Complex plus(Complex b) {
        re += b.re;
        im += b.im;
        return this;
    }

    /**
     * Multiplication operation
     * @param b multiplier
     * @return this Complex object whose value is (this * b)
     */
    public Complex times(Complex b) {
        final double real = re * b.re - im * b.im;
        final double imag = re * b.im + im * b.re;
        re = real;
        im = imag;
        return this;
    }

    /**
     * Squared length of the complex number
     * @return squared length
     */
    public double lengthSQ() {
        return re * re + im * im;
    }

    /**
     * Scale operation (multiply by a real number)
     * @param scalar the scaling factor
     * @return this Complex object whose value is (this * scalar)
     */
    public Complex scale(double scalar) {
        re *= scalar;
        im *= scalar;
        return this;
    }

    /**
     * Reciprocal operation (1/z)
     * @return this Complex object whose value is (1/this)
     */
    public Complex reciprocal() {
        double scale = re * re + im * im;
        if (scale == 0) {
            re = 0;  // Handle division by zero
            im = 0;
        } else {
            re = re / scale;
            im = -im / scale;
        }
        return this;
    }
}