import static org.junit.Assert.*;
import org.junit.Test;

public class AreaRectanguloTestJUnit4 {

    @Test
    public void testPositiveValues() {
        double base = 5.0, altura = 4.0;
        assertEquals("Base: " + base + ", Altura: " + altura + " debe ser 20.0", 20.0,
                AreaRectangulo.calcularAreaRectangulo(base, altura), 0.0001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeValues() {
        AreaRectangulo.calcularAreaRectangulo(-5.0, -3.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPositiveAndNegativeValues() {
        AreaRectangulo.calcularAreaRectangulo(5.0, -3.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testZeroValues() {
        AreaRectangulo.calcularAreaRectangulo(0, 0);
    }

    @Test
    public void testDecimalValues() {
        double base = 2.5, altura = 4.1;
        assertEquals("Base: " + base + ", Altura: " + altura + " debe ser 10.25", 10.25,
                AreaRectangulo.calcularAreaRectangulo(base, altura), 0.0001);
    }

    @Test
    public void testVeryLargeValues() {
        double base = 1e9, altura = 2e9;
        assertEquals("Base: " + base + ", Altura: " + altura + " debe ser " + (base * altura),
                base * altura, AreaRectangulo.calcularAreaRectangulo(base, altura), 1e14);
    }

    @Test
    public void testVerySmallValues() {
        double base = 1e-9, altura = 2e-9;
        assertEquals("Base: " + base + ", Altura: " + altura + " debe ser " + (base * altura),
                base * altura, AreaRectangulo.calcularAreaRectangulo(base, altura), 1e-22);
    }
}
