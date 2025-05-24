import org.junit.Test;
import org.junit.Before;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.fail;

public class TestCajeroHamcrest {
    private CajeroAutomatico cajero;

    @Before
    public void setUp() {
        cajero = new CajeroAutomatico(1000.00);
    }

    // 1. Consultar saldo [Opción 1] Se mostrará el saldo
    @Test
    public void testConsultarSaldo() {
        cajero.consultarSaldo();
        assertThat(cajero.getSaldo(), equalTo(1000.00));
    }

    // 2. Depositar 400 [Opción 2; 400] Se deposita 400
    @Test
    public void testDepositar400() {
        cajero.depositar(400);
        assertThat(cajero.getSaldo(), equalTo(1400.00));
    }

    // 3. Retirar 100 [Opción 3; 100] Se retira 100
    @Test
    public void testRetirar100() {
        cajero.retirar(100);
        assertThat(cajero.getSaldo(), equalTo(900.00));
    }

    // 4. Retirar 5000 [Opción 3; 5000] Error, se informa de fondos insuficientes
    @Test
    public void testRetirar5000FondosInsuficientes() {
        try {
            cajero.retirar(5000);
            fail("Debería haber lanzado una excepción");
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), containsString("Fondos insuficientes"));
        }
    }

    // 5. Depositar un número negativo [Opción 2; -200] Error, pedirá un número positivo
    @Test
    public void testDepositarNumeroNegativo() {
        try {
            cajero.depositar(-200);
            fail("Debería haber lanzado una excepción");
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), containsString("El monto debe ser positivo"));
        }
    }

    // 6. Ingresar depósito cómo cadena de texto [Opción 2, "dos mil"] Error
    @Test
    public void testDepositarCadenaTexto() {
        try {
            cajero.procesarDeposito("dos mil");
            fail("Debería haber lanzado una excepción");
        } catch (NumberFormatException e) {
            assertThat(e.getMessage(), containsString("no numérica"));
        }
    }

    // 7. Ingresar depósito con decimales con coma [Opción 2, 500,5] Error
    @Test
    public void testDepositarConComaDecimal() {
        try {
            cajero.procesarDeposito("500,5");
            fail("Debería haber lanzado una excepción");
        } catch (NumberFormatException e) {
            assertThat(e.getMessage(), containsString("no numérica"));
        }
    }

    // 8. Ingresar decimales en el depósito, formato correcto [Opción 2, 500.5] Se deposita
    @Test
    public void testDepositarDecimalesCorrecto() {
        cajero.depositar(500.5);
        assertThat(cajero.getSaldo(), equalTo(1500.5));
    }

    // 9. Retirar cantidad de 0 [Opción 3, 0] Error, se pide un número positivo
    @Test
    public void testRetirarCero() {
        try {
            cajero.retirar(0);
            fail("Debería haber lanzado una excepción");
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), containsString("El monto debe ser positivo"));
        }
    }

    // 10. Depositar cantidad de 0 [Opción 2, 0] Error, se pide un número positivo
    @Test
    public void testDepositarCero() {
        try {
            cajero.depositar(0);
            fail("Debería haber lanzado una excepción");
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), containsString("El monto debe ser positivo"));
        }
    }
}