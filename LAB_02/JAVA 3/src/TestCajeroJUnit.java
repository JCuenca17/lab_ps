import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class TestCajeroJUnit {
    private CajeroAutomatico cajero;

    @Before
    public void setUp() {
        cajero = new CajeroAutomatico(1000.00);
    }

    // 1. Consultar saldo [Opción 1] Se mostrará el saldo
    @Test
    public void testConsultarSaldo() {
        cajero.consultarSaldo(); // No hay aserción directa, pero podemos verificar el estado
        assertEquals(1000.00, cajero.getSaldo(), 0.001);
    }

    // 2. Depositar 400 [Opción 2; 400] Se deposita 400
    @Test
    public void testDepositar400() {
        cajero.depositar(400);
        assertEquals(1400.00, cajero.getSaldo(), 0.001);
    }

    // 3. Retirar 100 [Opción 3; 100] Se retira 100
    @Test
    public void testRetirar100() {
        cajero.retirar(100);
        assertEquals(900.00, cajero.getSaldo(), 0.001);
    }

    // 4. Retirar 5000 [Opción 3; 5000] Error, se informa de fondos insuficientes
    @Test(expected = IllegalArgumentException.class)
    public void testRetirar5000FondosInsuficientes() {
        cajero.retirar(5000);
    }

    // 5. Depositar un número negativo [Opción 2; -200] Error, pedirá un número positivo
    @Test(expected = IllegalArgumentException.class)
    public void testDepositarNumeroNegativo() {
        cajero.depositar(-200);
    }

    // 6. Ingresar depósito cómo cadena de texto [Opción 2, "dos mil"] Error
    @Test(expected = NumberFormatException.class)
    public void testDepositarCadenaTexto() throws Exception {
        cajero.procesarDeposito("dos mil");
    }

    // 7. Ingresar depósito con decimales con coma [Opción 2, 500,5] Error
    @Test(expected = NumberFormatException.class)
    public void testDepositarConComaDecimal() throws Exception {
        cajero.procesarDeposito("500,5");
    }

    // 8. Ingresar decimales en el depósito, formato correcto [Opción 2, 500.5] Se deposita
    @Test
    public void testDepositarDecimalesCorrecto() {
        cajero.depositar(500.5);
        assertEquals(1500.5, cajero.getSaldo(), 0.001);
    }

    // 9. Retirar cantidad de 0 [Opción 3, 0] Error, se pide un número positivo
    @Test(expected = IllegalArgumentException.class)
    public void testRetirarCero() {
        cajero.retirar(0);
    }

    // 10. Depositar cantidad de 0 [Opción 2, 0] Error, se pide un número positivo
    @Test(expected = IllegalArgumentException.class)
    public void testDepositarCero() {
        cajero.depositar(0);
    }
}