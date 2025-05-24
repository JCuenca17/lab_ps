import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;

public class AreaRectanguloTestHamcrest {

    @Test
    public void testPositiveValues() {
        assertThat("Base: 5.0, Altura: 4.0 debe ser 20.0",
                AreaRectangulo.calcularAreaRectangulo(5.0, 4.0),
                is(equalTo(20.0)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeValues() {
        AreaRectangulo.calcularAreaRectangulo(-5.0, -4.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPositiveAndNegativeValues() {
        AreaRectangulo.calcularAreaRectangulo(5.0, -3.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testZeroValues() {
        AreaRectangulo.calcularAreaRectangulo(0.0, 0.0);
    }

    @Test
    public void testDecimalValues() {
        assertThat("Base: 2.0, Altura: 3.5 debe ser 7.0",
                AreaRectangulo.calcularAreaRectangulo(2.0, 3.5),
                is(equalTo(7.0)));
    }

    @Test
    public void testVeryLargeValues() {
        assertThat("Base: 1_000_000.0, Altura: 2_000_000.0 debe ser 2e12",
                AreaRectangulo.calcularAreaRectangulo(1_000_000.0, 2_000_000.0),
                is(equalTo(2_000_000_000_000.0)));
    }

    @Test
    public void testVerySmallValues() {
        assertThat("Base: 1e-3, Altura: 2e-3 debe ser 2e-6",
                AreaRectangulo.calcularAreaRectangulo(0.001, 0.002),
                is(equalTo(0.000002)));
    }
}
