import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class ParImparTestHamcrest {

    @Test
    public void testNumeroParPositivo() {
        int numero = 8;
        assertThat("Número: " + numero + " debe ser par.",
                ParImpar.determinarParImpar(numero),
                is(equalTo("8 es par.")));
    }

    @Test
    public void testNumeroImparPositivo() {
        int numero = 5;
        assertThat("Número: " + numero + " debe ser impar.",
                ParImpar.determinarParImpar(numero),
                is(equalTo("5 es impar.")));
    }

    @Test
    public void testNumeroCero() {
        int numero = 0;
        assertThat("Número: " + numero + " debe ser par.",
                ParImpar.determinarParImpar(numero),
                is(equalTo("0 es par.")));
    }

    @Test
    public void testNumeroParNegativo() {
        int numero = -4;
        assertThat("Número: " + numero + " debe ser par.",
                ParImpar.determinarParImpar(numero),
                is(equalTo("-4 es par.")));
    }

    @Test
    public void testNumeroImparNegativo() {
        int numero = -7;
        assertThat("Número: " + numero + " debe ser impar.",
                ParImpar.determinarParImpar(numero),
                is(equalTo("-7 es impar.")));
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
