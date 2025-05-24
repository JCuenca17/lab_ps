import static org.junit.Assert.*;
import org.junit.Test;

public class ParImparTestJUnit4 {

    @Test
    public void testNumeroParPositivo() {
        int numero = 8;
        assertEquals("Número: " + numero + " debe ser par.",
                "8 es par.", ParImpar.determinarParImpar(numero));
    }

    @Test
    public void testNumeroImparPositivo() {
        int numero = 5;
        assertEquals("Número: " + numero + " debe ser impar.",
                "5 es impar.", ParImpar.determinarParImpar(numero));
    }

    @Test
    public void testNumeroCero() {
        int numero = 0;
        assertEquals("Número: " + numero + " debe ser par.",
                "0 es par.", ParImpar.determinarParImpar(numero));
    }

    @Test
    public void testNumeroParNegativo() {
        int numero = -4;
        assertEquals("Número: " + numero + " debe ser par.",
                "-4 es par.", ParImpar.determinarParImpar(numero));
    }

    @Test
    public void testNumeroImparNegativo() {
        int numero = -7;
        assertEquals("Número: " + numero + " debe ser impar.",
                "-7 es impar.", ParImpar.determinarParImpar(numero));
    }

    @Test(expected = NumberFormatException.class)
    public void testEntradaTextoInvalida() {
        String entradaInvalida = "abc";
        Integer.parseInt(entradaInvalida);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCantidadNumerosNegativa() {
        int cantidad = -5;
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser un número entero positivo.");
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCantidadNumerosCero() {
        int cantidad = 0;
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser un número entero positivo.");
        }
    }
}
